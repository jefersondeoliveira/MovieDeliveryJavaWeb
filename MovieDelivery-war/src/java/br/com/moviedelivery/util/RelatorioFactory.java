/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.moviedelivery.util;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 *
 * @author Naruto
 */
public class RelatorioFactory {
    
    private static Connection getConexao() {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/moviedelivery", "root", "");
        } catch (Exception e) {
            System.out.println(e);
        }
        return conexao;
    }

    public static void Relatorios(String relatorio) {
        FacesContext context = FacesContext.getCurrentInstance(); 
        try {
            HttpServletResponse response = (HttpServletResponse) context
                    .getExternalContext().getResponse();
            InputStream reportStream = context.getExternalContext().getResourceAsStream(relatorio);
            response.setContentType("application/pdf");
            try (ServletOutputStream servletOutputStream = response.getOutputStream()) {
                Map<String, Object> map = new HashMap<>();
                JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream, map, getConexao());
                servletOutputStream.flush();
            }
        } catch (JRException | IOException e) {
            e.printStackTrace();
        } finally {
            context.responseComplete();
        }
    }
}