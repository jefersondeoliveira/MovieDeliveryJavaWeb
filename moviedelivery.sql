/*
Navicat MySQL Data Transfer

Source Server         : Local
Source Server Version : 50516
Source Host           : localhost:3306
Source Database       : moviedelivery

Target Server Type    : MYSQL
Target Server Version : 50516
File Encoding         : 65001

Date: 2014-05-22 18:56:34
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `administrador`
-- ----------------------------
DROP TABLE IF EXISTS `administrador`;
CREATE TABLE `administrador` (
  `email` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `idPessoa` int(11) NOT NULL,
  PRIMARY KEY (`idPessoa`),
  CONSTRAINT `FK_ADMINISTRADOR_idPessoa` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`idPessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of administrador
-- ----------------------------

-- ----------------------------
-- Table structure for `categoria`
-- ----------------------------
DROP TABLE IF EXISTS `categoria`;
CREATE TABLE `categoria` (
  `idCategoria` smallint(6) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of categoria
-- ----------------------------
INSERT INTO `categoria` VALUES ('8', 'Aventura');
INSERT INTO `categoria` VALUES ('9', 'Comédias');
INSERT INTO `categoria` VALUES ('11', 'Dramas');
INSERT INTO `categoria` VALUES ('12', 'Ficção');
INSERT INTO `categoria` VALUES ('14', 'Romances');
INSERT INTO `categoria` VALUES ('15', ' Suspenses');
INSERT INTO `categoria` VALUES ('16', '    Terror');

-- ----------------------------
-- Table structure for `midia`
-- ----------------------------
DROP TABLE IF EXISTS `midia`;
CREATE TABLE `midia` (
  `idMidia` int(11) NOT NULL AUTO_INCREMENT,
  `duracao` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `sinopse` varchar(255) NOT NULL,
  `tituloMidia` varchar(255) NOT NULL,
  `idCategoria` smallint(6) NOT NULL,
  PRIMARY KEY (`idMidia`),
  KEY `FK_MIDIA_idCategoria` (`idCategoria`),
  CONSTRAINT `FK_MIDIA_idCategoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of midia
-- ----------------------------
INSERT INTO `midia` VALUES ('6', '103', '1', 'Quando um ex-policial fugitivo amaça se jogar do alto de um prédio, a psicóloga Lydia Anderson acha que a situação é mais suspeita do que parece', 'A Beira Do Abismo', '8');
INSERT INTO `midia` VALUES ('7', '97', '2', 'Um caracol obcecado por velocidade sonha em se tornar o maior piloto do mundo e tem a chance de realizar seu desejo quando um acidente o deixa superveloz', 'Turbo', '9');
INSERT INTO `midia` VALUES ('8', '99', '3', 'Um terremoto destrói a caverna de uma família pré-histórica excêntrica, e eles são forçados a viajar por terras desconhecidas em busca de um novo lar.', 'Os Croods', '9');
INSERT INTO `midia` VALUES ('9', '96', '1', 'Um advogado londrino vai a uma comunidade remota, onde enfrenta uma ameaça sobrenatural: a Mulher de Preto, dedicada à vingança da morte de seu filho', 'A mulher de preto', '15');
INSERT INTO `midia` VALUES ('10', '132', '4', 'O clássico jogo de tabuleiro batalha naval é transportado para a telona nesta aventura oceânica para defender o planeta Terra de uma misteriosa frota inimiga', 'Battleship: A Batalha dos Mares', '12');
INSERT INTO `midia` VALUES ('11', '112', '2', 'Do roteirista e diretor J.J. Abrams, esta é a história sobrenatural de seis jovens que testemunham algo incrível enquanto estão gravando um filme com uma câmera Super 8', 'Super 8', '11');
INSERT INTO `midia` VALUES ('12', '95', '3', 'Quando sua família muda de Berlim para a Polônia, menino faz amizade com garoto que vive do outro lado da cerca, sem saber que ele é um prisioneiro judeu', 'O menino do pijama listrado', '11');
INSERT INTO `midia` VALUES ('13', '52', '1', 'O comediante de stand-up Fábio Porchat fala com humor de temas do dia a dia, como telemarketing, aviões e banheiros.', 'Fábio Porchat: Fora do Normal', '9');
INSERT INTO `midia` VALUES ('14', '119', '2', 'Neste ágil filme de ação, dois policiais de Miami estão na cola de um talentoso ladrão que roubou um carregamento de heroína no valor de 100 milhões de dólares.', 'Bad Boys', '8');
INSERT INTO `midia` VALUES ('15', '112', '1', 'Para tentar conseguir reduzir a pena de 30 anos do filho, um pai se disfarça para capturar um violento traficante de drogas.', 'O Acordo', '8');
INSERT INTO `midia` VALUES ('16', '117', '1', 'Ao fingir para sua namorada que é um pai de família divorciado, Danny acaba recrutando sua funcionária e os filhos dela para se passarem por sua família.', 'Esposa de mentirinha', '14');
INSERT INTO `midia` VALUES ('17', '139', '2', 'Representantes da Igreja Católica convocam um simbologista para contra-atacar uma sociedade secreta que retaliação para antigas perseguições do Vaticano.', 'Anjos e demônios', '15');
INSERT INTO `midia` VALUES ('18', '95', '1', 'Uma garota tímida vai à reunião de família do namorado e precisa lutar com eles quando uma gangue de vândalos mascarados invade a festa', 'Você é o próximo', '16');
INSERT INTO `midia` VALUES ('19', '101', '1', 'Uma equipe militar terá que combater zumbis carnívoros, cães assassinos mutantes e as mortais defesas de um computador antes que um vírus terrível extermine a humanidade', 'Resident Evil - O hóspede maldito', '16');
INSERT INTO `midia` VALUES ('20', '88', '2', 'Uma onda de assassinatos leva Andy, um garoto de 6 anos, a concluir que seu boneco Chucky é o responsável. Mas sua mãe e a polícia não são facilmente convencidas.', 'Brinquedo assassino', '16');
INSERT INTO `midia` VALUES ('21', '126', '3', 'Após uma tempestade castigar uma pequena cidade, os residentes descobrem que brumas malévolas pairam sobre suas casas, matando todos que saírem para a rua', 'O nevoeiro', '15');
INSERT INTO `midia` VALUES ('22', '93', '5', 'Uma intuição e a falta de fundos do laboratório de um professor de geologia o fazem partir para a Islândia em busca de um portal para o centro da Terra', 'Viagem ao Centro da Terra', '12');
INSERT INTO `midia` VALUES ('23', '104', '6', 'Dois aficionados por ficção científica querem descobrir o que se encontra na infame Área 51 em Nevada e acabam encontrando um alienígena em fuga', 'Paul - O alien fugitivo', '12');
INSERT INTO `midia` VALUES ('24', '88', '2', 'Nesta sequência recheada de ação, o “transportador” Frank Martin é implicado no sequestro do filho de um policial para quem ele foi contratado como motorista', 'Carga explosiva 2', '8');
INSERT INTO `midia` VALUES ('25', '113', '2', 'Depois de anos de segregação e trabalho forçado, uma raça de alienígenas adere a um movimento de resistência comandando por um agente traidor', 'Distrito 9', '12');
INSERT INTO `midia` VALUES ('26', '104', '2', 'Aang faz uma jornada em que encontra criaturas mágicas e poderosos amigos, mas só ele pode acabar com o antigo conflito entre as quatro nações: Ar, Água, Terra e Fogo', ' Último Mestre do Ar', '12');
INSERT INTO `midia` VALUES ('27', '119', '1', 'Um dedicado bombeiro vê seu casamento ameaçado, mas quando a esperança parece estar no fim, seu religioso pai entra em ação', 'À prova de fogo', '14');
INSERT INTO `midia` VALUES ('28', '108', '1', 'Os “amigos coloridos” Emma e Adam vivem felizes em sua relação aberta... até que algo irritante chamado sentimento acaba se tornando parte da equação', 'Sexo Sem Compromisso', '14');
INSERT INTO `midia` VALUES ('29', '92', '1', 'Depois de perder a garota dos sonhos, Anderson aceita o desafio de pedir a mão da primeira mulher que vir: uma garçonete carente que aceita sem hesitar', 'O prazer da sua companhia', '14');
INSERT INTO `midia` VALUES ('30', '97', '1', 'Quando o aparelho de uma sismologista acusa anormalidades, operários descobrem minhocas gigantes carnívoras que sugam suas presas para o subsolo', 'O ataque dos vermes malditos', '16');
INSERT INTO `midia` VALUES ('31', '126', '2', 'O desespero de Rose para salvar sua filha de uma doença terminal as leva à Silent Hill, um mundo de trevas que logo consome a menina', 'Terror em Silent Hill', '16');
INSERT INTO `midia` VALUES ('32', '122', '2', 'Cinquenta anos depois que uma cápsula do tempo foi enterrada em escola local, professor examina seu conteúdo e descobre que muitas previsões eram verdadeiras', 'Presságio', '15');
INSERT INTO `midia` VALUES ('33', '96', '2', 'Um programa de TV é comandado por um âncora chovinista com intenções de provar sua teoria de relacionamento entre casais no segmento chamado \"A Verdade Nua e Crua.\"', 'A verdade nua e crua', '14');
INSERT INTO `midia` VALUES ('34', '158', '3', 'Um pai divorciado não hesita em entrar em ação e fazer tudo para salvar sua família quando uma série de desastres naturais ameaça destruir o mundo.', '2012', '12');
INSERT INTO `midia` VALUES ('35', '109', '1', 'Quando fica sabendo que está correndo o risco de perder seu visto e ser deportada, uma editora força seu assistente a casar-se com ela.', ' A proposta', '14');
INSERT INTO `midia` VALUES ('36', '99', '2', 'Daniel e Kristi recebem um recém-nascido e uma presença demoníaca começa a aterrorizá-los, destruindo seu mundo perfeito e transformando-o num pesadelo inescapável', 'Atividade Paranormal 2', '15');
INSERT INTO `midia` VALUES ('37', '97', '3', 'O tempo do colégio já passou, e Jim e Michelle vão se casar. Agora cabe a Stifler preparar a melhor despedida de solteiro de todos os tempos', 'American Pie 3 - O casamento', '9');
INSERT INTO `midia` VALUES ('38', '84', '1', 'O repórter cazaque Borat viaja aos EUA para fazer uma reportagem sobre “o melhor país do mundo”. E também para conhecer e se casar com a gata Pamela Anderson', 'Borat', '9');
INSERT INTO `midia` VALUES ('39', '95', '2', 'Quando sua família muda de Berlim para a Polônia, menino faz amizade com garoto que vive do outro lado da cerca, sem saber que ele é um prisioneiro judeu', 'O menino do pijama listrado', '11');
INSERT INTO `midia` VALUES ('40', '129', '1', 'Este sóbrio drama retrata a vida em uma favela do Rio de Janeiro, com fama de ser uma das partes mais perigosas da cidade maravilhosa.', 'Cidade de Deus', '11');
INSERT INTO `midia` VALUES ('41', '129', '2', 'A história de Carl Brashear, o primeiro negro do Exército dos Estados Unidos, e do homem que o treinou', 'Homens de honra', '11');
INSERT INTO `midia` VALUES ('42', '97', '3', 'O apocalipse zumbi não dá trégua. Alice vai parar em um suposto santuário em Los Angeles que pode acabar sendo uma armadilha mortal', 'Resident Evil 4 ', '16');
INSERT INTO `midia` VALUES ('44', '128', '1', 'Um grupo de jovens monitores de acampamento desperta a ira do maníaco assassino mascarado Jason Voorhees, nesta refilmagem do clássico do terror', 'Sexta-feira 13', '16');
INSERT INTO `midia` VALUES ('45', '102', '1', 'Um funcionário de zoológico azarado no amor conta suas desventuras românticas para os animais. As criaturas dão conselhos a ele para conquistar o coração da amada', 'Zookeeper', '9');
INSERT INTO `midia` VALUES ('46', '90', '1', 'Quando o inventor Flint Lockwood faz chover, os moradores de Boca da Maré finalmente conseguem comer. Mas o pior ainda está por vir', 'Tá chovendo hamburguer', '9');
INSERT INTO `midia` VALUES ('47', '93', '1', 'Will Smith é Hancock, um super-herói falido forçado a contratar um especialista em relações públicas para ajudá-lo a refazer sua imagem.', 'Hancock2008', '8');
INSERT INTO `midia` VALUES ('48', '128', '2', 'Um decadente ex-lutador vira agente e reata a relação com seu filho para transformar um velho robô em um poderoso participante do Mundial de Boxe para Robôs', 'Gigantes de aço', '8');
INSERT INTO `midia` VALUES ('49', '105', '3', 'Os funcionários de um condomínio exclusivo de Nova York descobrem que seu chefe limpou suas contas de aposentadoria. Esse empréstimo não vai ficar assim.', 'Roubo nas Alturas', '8');

-- ----------------------------
-- Table structure for `midiatipomidia`
-- ----------------------------
DROP TABLE IF EXISTS `midiatipomidia`;
CREATE TABLE `midiatipomidia` (
  `idTipoMidia` smallint(6) NOT NULL,
  `idMidia` int(11) NOT NULL,
  PRIMARY KEY (`idTipoMidia`,`idMidia`),
  KEY `FK_MidiaTipoMidia_idMidia` (`idMidia`),
  CONSTRAINT `FK_MidiaTipoMidia_idTipoMidia` FOREIGN KEY (`idTipoMidia`) REFERENCES `tipomidia` (`idTipoMidia`),
  CONSTRAINT `FK_MidiaTipoMidia_idMidia` FOREIGN KEY (`idMidia`) REFERENCES `midia` (`idMidia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of midiatipomidia
-- ----------------------------
INSERT INTO `midiatipomidia` VALUES ('1', '6');
INSERT INTO `midiatipomidia` VALUES ('1', '7');
INSERT INTO `midiatipomidia` VALUES ('2', '7');
INSERT INTO `midiatipomidia` VALUES ('1', '8');
INSERT INTO `midiatipomidia` VALUES ('2', '8');
INSERT INTO `midiatipomidia` VALUES ('1', '9');
INSERT INTO `midiatipomidia` VALUES ('1', '10');
INSERT INTO `midiatipomidia` VALUES ('2', '10');
INSERT INTO `midiatipomidia` VALUES ('3', '10');
INSERT INTO `midiatipomidia` VALUES ('2', '11');
INSERT INTO `midiatipomidia` VALUES ('1', '12');
INSERT INTO `midiatipomidia` VALUES ('2', '13');
INSERT INTO `midiatipomidia` VALUES ('1', '14');
INSERT INTO `midiatipomidia` VALUES ('1', '15');
INSERT INTO `midiatipomidia` VALUES ('1', '16');
INSERT INTO `midiatipomidia` VALUES ('1', '17');
INSERT INTO `midiatipomidia` VALUES ('2', '17');
INSERT INTO `midiatipomidia` VALUES ('1', '18');
INSERT INTO `midiatipomidia` VALUES ('1', '19');
INSERT INTO `midiatipomidia` VALUES ('4', '20');
INSERT INTO `midiatipomidia` VALUES ('1', '21');
INSERT INTO `midiatipomidia` VALUES ('4', '21');
INSERT INTO `midiatipomidia` VALUES ('1', '22');
INSERT INTO `midiatipomidia` VALUES ('2', '22');
INSERT INTO `midiatipomidia` VALUES ('3', '22');
INSERT INTO `midiatipomidia` VALUES ('1', '23');
INSERT INTO `midiatipomidia` VALUES ('2', '23');
INSERT INTO `midiatipomidia` VALUES ('3', '23');
INSERT INTO `midiatipomidia` VALUES ('1', '24');
INSERT INTO `midiatipomidia` VALUES ('1', '25');
INSERT INTO `midiatipomidia` VALUES ('2', '25');
INSERT INTO `midiatipomidia` VALUES ('1', '26');
INSERT INTO `midiatipomidia` VALUES ('2', '26');
INSERT INTO `midiatipomidia` VALUES ('1', '27');
INSERT INTO `midiatipomidia` VALUES ('1', '28');
INSERT INTO `midiatipomidia` VALUES ('3', '29');
INSERT INTO `midiatipomidia` VALUES ('4', '30');
INSERT INTO `midiatipomidia` VALUES ('1', '31');
INSERT INTO `midiatipomidia` VALUES ('1', '32');
INSERT INTO `midiatipomidia` VALUES ('2', '32');
INSERT INTO `midiatipomidia` VALUES ('1', '33');
INSERT INTO `midiatipomidia` VALUES ('1', '34');
INSERT INTO `midiatipomidia` VALUES ('2', '34');
INSERT INTO `midiatipomidia` VALUES ('1', '35');
INSERT INTO `midiatipomidia` VALUES ('1', '36');
INSERT INTO `midiatipomidia` VALUES ('1', '37');
INSERT INTO `midiatipomidia` VALUES ('1', '38');
INSERT INTO `midiatipomidia` VALUES ('2', '39');
INSERT INTO `midiatipomidia` VALUES ('1', '40');
INSERT INTO `midiatipomidia` VALUES ('1', '41');
INSERT INTO `midiatipomidia` VALUES ('1', '42');
INSERT INTO `midiatipomidia` VALUES ('2', '42');
INSERT INTO `midiatipomidia` VALUES ('1', '44');
INSERT INTO `midiatipomidia` VALUES ('1', '45');
INSERT INTO `midiatipomidia` VALUES ('1', '46');
INSERT INTO `midiatipomidia` VALUES ('2', '47');
INSERT INTO `midiatipomidia` VALUES ('1', '48');
INSERT INTO `midiatipomidia` VALUES ('1', '49');
INSERT INTO `midiatipomidia` VALUES ('2', '49');
INSERT INTO `midiatipomidia` VALUES ('3', '49');

-- ----------------------------
-- Table structure for `pessoa`
-- ----------------------------
DROP TABLE IF EXISTS `pessoa`;
CREATE TABLE `pessoa` (
  `idPessoa` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`idPessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of pessoa
-- ----------------------------

-- ----------------------------
-- Table structure for `tipomidia`
-- ----------------------------
DROP TABLE IF EXISTS `tipomidia`;
CREATE TABLE `tipomidia` (
  `idTipoMidia` smallint(6) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  PRIMARY KEY (`idTipoMidia`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tipomidia
-- ----------------------------
INSERT INTO `tipomidia` VALUES ('1', 'DVD');
INSERT INTO `tipomidia` VALUES ('2', 'Blu-Ray');
INSERT INTO `tipomidia` VALUES ('3', '4K');
INSERT INTO `tipomidia` VALUES ('4', 'VHS');
