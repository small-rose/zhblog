/*  Author: Asif Mughal
 *   URL: https://www.codehim.com
 *   License: MIT License
 *   Copyright (c) 2018 - Asif Mughal
 */
/* File: demo-only.js */
$(function() {
	/* Demo only */
	var jSide = $(".menu-container, .menu-head, .menubar");
	$(".menu-position").on('change', function() {
		$(jSide).not(".menubar").addClass($(this).val());
		$(".j-pos").html('jSidePosition: "position-right",');
		if ($(this).val() == 'position-left') {
			$(jSide).removeClass("position-right");
			$(".j-pos").html('jSidePosition: "position-left",');
			$(".menu-trigger").removeClass("right").addClass("left");
		} else {
			$(jSide).removeClass("position-left");
			$(".menu-trigger").removeClass("left").addClass("right");
		}
	});
	$(".bg-color").on('change', function() {
		var color = $(this).val();
		$(jSide).css({
			'background' : color,
		});
		$(".bg-color-input").val(color);
	});
	$(".bg-color-input").on('input', function() {
		$(jSide).css({
			'background' : $(this).val(),
		});
	});
	$("#set-top").change(function() {
		$(".menubar").addClass("sticky");
		$(".j-sticky").html("jSideSticky: true,");
	});
	$("#set-st").change(function() {
		$(".menubar").removeClass("sticky");
		$(".j-sticky").html("jSideSticky: false,");
	});
	$(".theme-tray span").click(
			function() {
				var skin = $(this).attr("class");
				$(".menubar").attr('class', skin).addClass("menubar sticky");
				$(".menu-container").attr('class', skin).addClass(
						"menu-container position-left");
				$(".menu-head").attr('class', skin).addClass(
						"menu-head position-left");
				var newcode = 'jSideSkin:' + '\"' + skin + '\",';
				$(".j-skin").html(newcode);
			});
	
	var i=0;
	$(".menu-container li").click(function(){
		var has = $(this).hasClass("has-sub");
		if(has){
			return;
		}
		let name = $(this).text();
		let headerHtml = $("header").prop('outerHTML');
		var html = "<span>"+name+"</span>";
		if(headerHtml.indexOf(html) == -1){
			$("header").append();
		}
		let tmpId = "#tab-"+i ;
		var data = $("#myTab > li");
		$.each(data,function(index,item){
			item.remove("active");
		});
		let liDom = $("<li></li>").addClass("active").append($("<a></a>").attr("href",tmpId).attr("data-toggle","tab"));
		$("#myTab").append(liDom);
		
		var data = $("#myTabContent > active");
		$.each(data,function(index,item){
			item.remove("active");
		});
		
		let iframe = $("<iframe></iframe").attr("src","http://www.baidu.com");
		let conDiv = $("<div></div>").addClass("row col-sm-12 modal-body").css({"padding-top": "15px"}).append(iframe);
		let contDom = $("<div></div>").addClass("tab-pane fade in active").attr("id",tmpId).append(conDiv);
		$("#myTabContent").append(contDom);
	});
});