$(function(){
	/*
	$('.jcarousel').jcarouselAutoscroll({
            autostart: true;
    });
*/

        $('.box, .box-lista').hover(function(){
			$(this).find('.box-detalhes').stop(false,true).show()
		}, function(){
			$(this).find('.box-detalhes').stop(false,true).hide()
	});
	$('#menu-content li').hover(function(){
			$(this).find('.submenu').stop(false,true).show()
		}, function(){
			$(this).find('.submenu').stop(false,true).hide()
	});


})