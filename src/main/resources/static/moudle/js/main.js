var pn = 1;
var pageNum = 5 ;
var flag = true;
$(function () {
	//$("#blog-nav-fix").hide('slow');
	
	changeMargin();
	//监听浏览器宽度的改变
    window.onresize = function(){
        changeMargin();
    };
    
    function changeMargin(){
        //获取元素距离屏幕左边的距离
        var divLeft = $('#toTop').offset().left;
        //获取网页可见区域宽度
        var docWidth = document.body.clientWidth;
        if(docWidth <= 600){
        	/*$("#blog-nav-fix").parent().remove("am-topbar-fixed-top");
        	$("#blog-nav-fix").hide('slow');
        	$("#blog-nav").show('slow');*/
        	//$("#countInfo").hide('slow');
        }else{
        	
        	/*$("#blog-nav-fix").show('slow');*/
        	/*$("#blog-nav").hide();*/
        }
        //console.log(docWidth);
    }
    
	//http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/scrollbar_themes_demo.html
	 $("#blog").mCustomScrollbar({
		 	//mouseWheelPixels:100,
			theme:"minimal-dark", //light,minimal-dark,light-2,dark-2,minimal,dark,light-thick,inset-dark
			callbacks:{
				onCreate: function(){
					//console.log(' onCreate');
				},
				onScrollStart: function(){
					//console.log("滚动开始的内容......");
				},
				onScroll:function(){
					//console.log("滚动结束的内容......");
					back_up_show();
					//listenNav();
				},
				whileScrolling: function(){
					//console.log("正在滚动的内容......");
					//checkNav();
				},
				onTotalScrollBack: function(){
					//console.log("滚动完成时调用的函数和内容滚动回到开头......");
				},
				onTotalScroll: function(){
					//console.log("......"+200);
					
					water();
					getData();
				}
			}
	 });
	 
	 $("#blog").mCustomScrollbar("scrollTo","last",{ callback:true });
	 
	 
	  $(window).scroll(function(){  
		  //console.log( " $(window).scrollTop() :" + $(window).scrollTop());
          if ($(window).scrollTop()>20){    
              $("#back-to-top").fadeIn(1000);    
          }    
          else    
          {    
              $("#back-to-top").fadeOut(1000);    
          }    
      });    

	  function back_up_show(){
		  var topSize = $('#topbgImg').offset().top;
		  //console.log( " back_up_show :" + topSize);
		  if (topSize < -300){    
              $("#back-to-top").fadeIn(1000);    
          } else {    
              $("#back-to-top").fadeOut(1000);    
          }   
	  }
      //当点击跳转链接后，回到页面顶部位置    
      $("#back-to-top, #toTop").click(function(e){    
    	  e.preventDefault();
          //$('body').animate({top:"0px"},1000);    
    	  $("body,html").mCustomScrollbar("scrollTo","top");
          return false;    
      });
      
     
      initHtmlSetting();
      
      
	/* $(window).bind('scroll',function(){show()});
	 
	 function show(){
	      if($(window).scrollTop()+$(window).height()>=$(document).height()){
	    	  getData();
	       }
	 }*/
 
});


/*
window.onscroll = function () {
	if (getScrollTop() + getClientHeight() == getScrollHeight()) {
		alert("到达底部,再次滚动将会加载更多数据");
		//$("#ul-list").append($('<li>' + '新文章' + '</li>'));
		getData();
	}
}*/
//获取滚动条当前的位置
function getScrollTop() {
	var scrollTop = 0;
	if (document.documentElement && document.documentElement.scrollTop) {
		scrollTop = document.documentElement.scrollTop;
	}
	else if (document.body) {
		scrollTop = document.body.scrollTop;
	}
	return scrollTop;
}

//获取当前可是范围的高度
function getClientHeight() {
	var clientHeight = 0;
	if (document.body.clientHeight && document.documentElement.clientHeight) {
		clientHeight = Math.min(document.body.clientHeight, document.documentElement.clientHeight);
	}
	else {
		clientHeight = Math.max(document.body.clientHeight, document.documentElement.clientHeight);
	}
	return clientHeight;
}

//获取文档完整的高度
function getScrollHeight() {
	return Math.max(document.body.scrollHeight, document.documentElement.scrollHeight);
}
	//ajax获取数据
/*
function getData(){
	var load = $("<i id='loading' class=\"am-icon-spinner am-icon-pulse am-icon-lg\"></i>");
	
	if(flag){
		 
		$.ajax({
			url:" ",
			data:"&isDraft=1&pn="+pn+"&pageNum="+pageNum ,
			type:"GET",
			dataType: 'json',
	        success:function(result){
	            //将返回值动态加载，动态生成标签。
	        	 $("#loading").remove();
	        	 build_data_table(result);
	        	 $("#blog").mCustomScrollbar("update");
	        	 
	       },
	       error: function (XMLHttpRequest, textStatus, errorThown) {
	             alert("加载失败！");
	       }
	   });
	}
	
}

function build_data_table(result){
	var data = result.extend.pageInfo.list;

 	
}
*/

function checkNav(){
	var topSize = $('#blog-nav').offset().top;
	var x = $("#mCSB_1_dragger_vertical").css("top");
	x=x.replace("px","");
	x = Number(x);
	console.log(topSize  +" ----- "+x);
	if(x>11){
		/*if(topSize < 0 && !$('#blog-nav').hasClass("navbar-fixed-top")){
			$('#blog-nav').addClass("navbar-fixed-top").addClass("am-topbar-inverse special-nav navbar-transparent");
		}*/
		var copy = $('#copy-blog-nav');
		//console.log(copy.length);
		if(topSize < 0 && copy.length <1 ){
			var newnav = $('#blog-nav').clone();
			newnav.attr("id","copy-blog-nav").addClass("navbar-fixed-top").addClass("am-topbar-inverse special-nav navbar-transparent");
			$("#blog-nav").after(newnav);
		}
		$("#back-to-top").fadeIn(1000);    
	}else{
		//$('#blog-nav').removeClass("navbar-fixed-top").removeClass("am-topbar-inverse special-nav navbar-transparent");
		
		$('#copy-blog-nav').removeClass("navbar-fixed-top").removeClass("am-topbar-inverse special-nav navbar-transparent");
		$('#copy-blog-nav').remove();
		
		$("#back-to-top").fadeOut(1000);  
	}
}

function water(){

}

//存储数据
function settingItem(key, value){
	//console.log("add data key : "+key +" , value :"+value);
	window.localStorage.setItem(key, value);
}
//获取数据
function getItemValue(key){
	return window.localStorage.getItem(key);
}

function removeItem(keys){
	$.each(keys ,function(index,item){
		window.localStorage.removeItem(item);
	});
}

var current = "bg_lantian";
function initHtmlSetting(i){
	var font = getItemValue('font');
	font = ( font==null || font==undefined	) ? '' : font ;
	var fs = getItemValue('font-size');
	//console.log("store fs ---"+fs);
	if(undefined == fs || null == fs ){
		fs = "14px";
	}	
	font +=  fs;
	
	var fm = getItemValue('font-family');
	//console.log("store  fm----:"+fm);
	if(undefined == fm || null == fm){
		fm = " Lucida Grande,Tahoma,Helvetica,Arial,Verdana, 'Microsoft JhengHei' ";
	}else{
		fm = " Lucida Grande,Arial,Tahoma,Helvetica,Verdana,"+fm;
	}
	//console.log("fm:"+fm);
	font +=  fm;
	//console.log("font  :"+font);
	$("body").css({"font": font});
	
	var bgFollow = getItemValue("bgFollow");
	if(bgFollow==1){
		$(".bgFollow").attr("checked", true);
	}else{
		$(".bgFollow").attr("checked", false);
	}
	
	var bg = getItemValue("background-color");
	if(undefined == bg || null == fm){
		bg = "#fff";
	}
	//console.log("store bg"+bg);
	$(".blog-title span").css({"background-color": bg});
	$("body").css({"background-color": bg});
	
	if(i==0){$("body").css({"background-color": "#fff"});}
	
	var imgclass = getItemValue("topImgClass");
	if(undefined == imgclass || null == imgclass){
		imgclass = "bg_fengche_0";
	}
	console.log("current"+imgclass);
	topBgRemove();
	$("#topbgImg").removeClass(current);
	$("#topbgImg").addClass(imgclass);
}

$(document).on("click", ".webSetting",function(e){

    initModal();
});

//自定义字体大小
$(document).on("click", "#setTable  .fontSizeBtn",function(e){
	$.each($("#setTable  .fontSizeBtn"), function(index, item){
		$(this).removeClass("active");
	});
	$(this).addClass("active");
	var val = $(this).val();
	settingItem("font-size", val);
	initHtmlSetting();
});

//自定义字体样式	
$(document).on("click", "#setTable  .fontFmlBtn",function(e){
	$.each($("#setTable  .fontFmlBtn"), function(index, item){
		$(this).removeClass("active");
	});
	$(this).addClass("active");
	var val = $(this).val();
	settingItem("font-family", val);
	initHtmlSetting();
});

//自定义背景色
$(document).on("click", "#setTable  .webBg",function(e){
	if(getItemValue("bgFollow")==1){
		alert("如需自定义背景色，请先关闭背景色自适应！");
		return ;
	}
	$.each($("#setTable  .webBg"), function(index, item){
		$(this).removeClass("active");
	});
	$(this).addClass("active");
	var val = $(this).val();
	settingItem("background-color", val);
	initHtmlSetting();
});

//恢复默认样式
$(document).on("click", "#resetting",function(e){
	localStorage.removeItem("key");
	removeItem(["font-size","font-family","background-color","topImgClass"]);
	settingItem("bgFollow", 1);
	initHtmlSetting(0);
});

//自选颜色
$(document).on("change","#colorPic",function(e){
	var col = $(this).val();
	col = "#"+col ;
	var p = $(this).parent();
	console.log( p );
	$(this).parent().val(col);
	$(this).parent().css({"background-color": "'"+col+"'"});
	
	settingItem("background-color", col);
	initHtmlSetting();
});		
		
function initModal(){
	var fs = getItemValue('font-size');
	if(undefined != fs){
		$("#setTable  .fontSizeBtn").removeClass("active");
		console.log("initM fs -----" + $("#setTable  .fontSizeBtn[value='"+fs+"']"));
		$("#setTable  .fontSizeBtn[value='"+fs+"']").addClass("active");
	}
	var fm = getItemValue('font-family');
	if(undefined != fm){
		$("#setTable  .fontFmlBtn").removeClass("active");
		console.log("initM fm -----" + $("#setTable  .fontFmlBtn[value='"+fm+"']"));
		$("#setTable  .fontFmlBtn[value='"+fm+"']").addClass("active");
	}
	var bg = getItemValue("background-color");
	if(undefined != bg){
		$("#setTable  .webBg").removeClass("active");
		console.log("initM fm -----" + $("#setTable  .webBg[value='"+bg+"']"));
		$("#setTable  .webBg[value='"+bg+"']").addClass("active");
	}
	var bgFollow = getItemValue("bgFollow");
	console.log("initModal bgFollow: "+bgFollow);
	if(bgFollow==1){
		$(".bgFollow").attr("checked", "checked");
	}else{
		$(".bgFollow").attr("checked",  false);
	}
	
	var topCls  = getItemValue("topImgClass");
	if(undefined != topCls){
		//console.log(topCls);
		$("#setBgTable  .bg_div ").removeClass("checked");
		$("#setBgTable  .bg_div[id='"+topCls+"']").addClass("checked");
	}
}



var colArr = ['#e1eba0','#e75d59','#91a3ea','#c5e8ac', '#e0b1bf','#70a76c','#5bacf2','#ebbb35'];

//主题设置
$(document).on("click", "#setBgTable  div",function(e){
	var scl = $(this).attr("id");
	if(current==scl){
		//return ;//避免重复执行
	}
	
	$.each($("#setBgTable  div"), function(index, item){
		$(this).removeClass("checked");
	});
	$(this).addClass("checked");
	
	console.log("scl:"+scl );
	console.log("current: "+current );
	
	if(current!=null){ $("#topbgImg").removeClass(current) } ;
	current = scl;
	$("#topbgImg").addClass(scl+"");
	settingItem("topImgClass", scl);
	
	var bgFollow = getItemValue("bgFollow");
	if(bgFollow==1){
		var index = current.slice(-1);
		//console.log(index);
		settingItem("background-color", colArr[index]);
		$("body").css({"background-color": colArr[index]});
		$(".blog-title span").css({"background-color": colArr[index]});
	}
	
});

$(document).on("click", ".bgFollow",function(e){
	
	$(this).attr("checked", $(this).prop("checked"));
	
	if($(this).prop("checked")){
		settingItem("bgFollow", 1);
	}else{
		settingItem("bgFollow", 0);
	}
	console.log("更新  bgFollow:"+ getItemValue("bgFollow"));
});

//________________搜索___________________

var domain = window.location.host;
var url = "http://"+domain ;
let kwList = JSON.parse(window.localStorage.getItem('kwList')) || [];
var kwIndex = 0 ;
$(document).on("click", "#webSetting3",function(e){
	kwList = JSON.parse(window.localStorage.getItem('kwList'));
	initHistory(kwList);
});

//搜索 回车
$('#keyWord_pc').on('keypress',function(event){ 
    if(event.keyCode == 13) {
    	searchFunc();
    }  
});
//搜索
$(document).on("click", "#searchBtn",function(e){
	searchFunc();
});

function searchFunc(){
	var kw = $('#keyWord_pc').val();
	if(kw==null || kw==''){
 	   $('#keyWord_pc').focus();
 	   return ;
    }
	console.log("数组值"+kw+",索引：" +kwList.length);
	let obj = { keyword: kw };
	kwIndex = kwList.unshift(obj);
	console.log("数组长度：" +kwIndex);
    window.localStorage.setItem('kwList', JSON.stringify(kwList));
    console.log("search：" +url);
	window.location.href = url +"/search?key="+kw;
}

function initHistory(List){
	$("#searchDiv").empty();
	for (var i = 0; i < List.length; i++) {  
		var item = List[i];
		let str =
			`<li class='hisDiv'>
				<a href="${url}?key=${item.keyword}" index="${i}">${item.keyword}</a><i class="am-icon-close delHis"></i>
			</li>`;
		$("#searchDiv").append(str);
	};
}
//清空历史
$(document).on("click", "#clearHis",function(e){
	kwIndex = 0;
	window.localStorage.setItem('kwList',JSON.stringify([]));
	kwList = JSON.parse(window.localStorage.getItem('kwList'));
	initHistory(kwList);
});

$(document).on("click", "#searchDiv i",function(e){
	var tmpId = $(this).prev().attr("index");
	console.log("tmpId"+tmpId);
	kwList.splice(tmpId, 1);
	window.localStorage.setItem('kwList',JSON.stringify(kwList));
	kwList = JSON.parse(window.localStorage.getItem('kwList'));
	initHistory(kwList);
});

//滚动事件【咱注释】
var last_scroll_position = 0;
function listenNav(){
	
    var new_scroll_position;
    var header = $("#blog-nav-fix");

	
	var topSize = $('#topbgImg').offset().top;
	new_scroll_position = topSize;
	
	console.log("topSize "+topSize+" ,last_scroll_position : "+last_scroll_position +"   , new_scroll_position:"+new_scroll_position);
	var cha = new_scroll_position -last_scroll_position ;
	
		//last_scroll_position = window.scrollY;
	      console.log("last_scroll_position : "+last_scroll_position +"    cha:"+cha);
	      // Scrolling down
	      if (new_scroll_position < last_scroll_position && cha <= 0) {
	    	//document.getElementById("blog-nav-fix").classList.remove("slideDown");
	    	//document.getElementById("blog-nav-fix").classList.add("slideUp");

	    	header.parent().removeClass(" slideDown");
	    	header.parent().addClass(" slideUp");
	    	
	      // Scrolling up
	      } else if (new_scroll_position > last_scroll_position && cha >0 ) {
	    	  //document.getElementById("blog-nav-fix").parent().classList.remove("slideUp");
	    	  //document.getElementById("blog-nav-fix").parent().classList.add("slideDown");
	    	  
	    	  header.parent().removeClass("slideUp");
		      header.parent().addClass("slideDown");
	      }
	      
	last_scroll_position = new_scroll_position;
      
	//console.log("last_scroll_position : "+last_scroll_position +"    new_scroll_position:"+new_scroll_position);
}

function topBgRemove(){
	var topImg = $("#topbgImg");
	topImg.hasClass("bg_child_1") ? topImg.removeClass("bg_child_1") : '';
	topImg.hasClass("bg_girl_2") ? topImg.removeClass("bg_girl_2") : '';
	topImg.hasClass("bg_shanshui_3") ? topImg.removeClass("bg_shanshui_3") : '';
	topImg.hasClass("bg_fen_4") ? topImg.removeClass("bg_fen_4") : '';
	topImg.hasClass("bg_chun_5") ? topImg.removeClass("bg_chun_5") : '';
	topImg.hasClass("bg_danlan_6") ? topImg.removeClass("bg_danlan_6") : '';
	topImg.hasClass("bg_fengye_7") ? topImg.removeClass("bg_fengye_7") : '';
}