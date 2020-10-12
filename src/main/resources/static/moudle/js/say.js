/*******

var pn = 0;
var pageNum = 5 ;
var flag = true;
var tmp = 0 ;

$(function(){
	pn = 1 ;
	getData();
});
$("#mood").addClass("active");
	//ajax获取数据
function getData(){
	var load = $("<i id='loading' class=\"am-icon-spinner am-icon-pulse am-icon-lg\"></i>");
	if(flag){
		load.appendTo(".msgCon");
		$.ajax({
			url:"moreSay",
			data:"&pn="+pn+"&pageNum="+pageNum ,
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
	$("#sayCount").text(data.total);
	if(data.length==0){
		flag = false ;
		$(".msgCon").append("<p style='padding-top:10px;'><img src=\"moudle/mood/images/kl_thumb.gif\" title=\"[可怜]\">暂时没有更多留言了... ...</p>");
	}

	pn = pn +1 ;
	console.log(data);
	$.each(data,function(index,item){
		/*<div class='msgBox'  th:each="msge, modStat : ${msgList}" th:class="'msgBox  bg-'">
		<div class="headUrl">
				<img th:src='${msge.msgUtx}' width='50' height='50'/>
					<div>
						<span class="title" th:text="${msge.msgUname}">标题</span>
						<span class="time" th:text="${msge.msgTime}">2019-01-01</span>
					</div>
					<a th:id="${msge.id}" class="huifu" title="回复"><i class="am-icon-comment "></i>（<span >0</span>）</a>
		</div>
		<div class='msgTxt' th:utext="${msge.msgContent}">
			<p th:utext="${msge.msgContent}"></p>11<img src="moudle/mood/images/laugh.gif" title="[哈哈]">
		</div>
		
		<div class='msgBox-huifu' th:each="msgchild , msgcStat : ${msge.children}" >
			<div class="headUrl-huifu">
					<img th:src='${msgchild.msgUtx}' width='50' height='50'/>
						<div>
							<span class="title-huifu" th:text="${msgchild.msgUname}">标题</span>
							<span class="time-huifu" th:text="${msgchild.msgTime}">2019-01-01</span>
						</div>
			</div>
			<div class='msgTxt-huifu' th:utext="${msgchild.msgContent}">
				
			</div>
			</div>
			
	 </div>*/
	 
    	var src = item.msgUtx ;
		var imgDom = $("<img></img>").attr("src",src).attr("alt",'头像').attr("width","50").attr("height","50");
		/*
		<a th:id="${msge.id}" class="like-huifu" title="喜欢"><i class="am-icon-heart "></i>（<span>0</span>）</a>
		<a th:id="${msge.id}" class="huifu" title="回复"><i class="am-icon-comment "></i>（<span>0</span>）</a>
		*/
		var likes =  $("<span></span>").append(item.msgLike).attr("id","like_count"+item.id);
		var heart = $("<i></li>").addClass("am-icon-heart");
		var azanDom = $("<a></a>").addClass("like-huifu").attr("title","赞").append(heart).attr("id",item.id);//.append("（").append(likes).append("）");
		var len = item.children.length;
		
		var pinglun =  $("<span></span>").append(len).attr("id","like_count"+item.id);
		var comment = $("<i></li>").addClass("11am-icon-comment").append("[回复]");
		var ahuifuDom = $("<a></a>").addClass(" huifu").attr("title","回复").append(comment).attr("id",item.id).append("（").append(pinglun).append("）");
		
		var clss = len > 0 ? 'am-icon-chevron-down' : 'am-icon-chevron-right';
		var opcl = $("<i></li>").addClass(clss);
		var shouqi = $("<a></a>").addClass("open-close").attr("title","展开/收起").append(opcl).attr("id",item.id);
		//shouqi.click(function(e){
			//openCloseHandle(item.id, opcl, e);
		//});
		
		var titleDom = $("<span></span>").append(item.msgUname).addClass("title");
		var timeDom = $("<span></span>").append(item.msgTime).addClass("time");
		var headTitleTD = $("<div></div>").append(titleDom).append(timeDom);
		
		var headDivDom = $("<div></div>").addClass("headUrl").append(imgDom).append(headTitleTD).append(azanDom).append(likes).append(ahuifuDom).append(shouqi);
		
		var msgTxtDom = $("<div></div>").addClass("msgTxt").append(item.msgContent);
		var moodDiv = $("<div></div>").addClass("msgBox").addClass(" bg-");
		
		moodDiv.append(headDivDom).append(msgTxtDom);
		
		var opclDom = $("<div></div>").addClass("child-pinlun-"+item.id);
		var children = item.children;
		$.each(children,function(index,child){
			
			var srcHf = child.msgUtx ;
			var imgHfDom = $("<img></img>").attr("src",srcHf).attr("alt",'头像').attr("width","30").attr("height","30");
			
			var likes =  $("<span></span>").append("（").append(child.msgLike).append("）").attr("id","like_count"+child.id);
			var zanheart = $("<i></li>").addClass("am-icon-heart");
			var azanHfDom = $("<a></a>").addClass("like-huifu").attr("title","赞").append(zanheart).attr("id",child.id).append(likes);
			
			var comment2 = $("<i></li>").addClass("am-icon-comment");
			var ahuifuDom2 = $("<a></a>").addClass(" huifu").attr("title","回复").append(comment2).attr("id",item.id);
			
			var title = $("<span></span>").append(child.msgUname).addClass("title-huifu");
			var time = $("<span></span>").append(child.msgTime).addClass("time-huifu");
			var headTitle = $("<div></div>").append(title).append(time);
			
			var headDiv = $("<div></div>").addClass("headUrl-huifu").append(imgHfDom).append(headTitle).append(azanHfDom).append(ahuifuDom2);
			
			
			var msgTxtHuifuDom = $("<div></div>").addClass("msgTxt-huifu").append(child.msgContent);
			
			var huifu = $("<div></div>").addClass("msgBox-huifu").addClass(" bg-");
			huifu.append(headDiv).append(msgTxtHuifuDom);
			opclDom.append(huifu);
			
		});
		moodDiv.append(opclDom);
		moodDiv.appendTo(".msgCon");
	});
}

$("body").on('click', '.huifu', function () {
	
	$("#qq-1").remove();
	/*
	var a= document.getElementById("qq-1");
	//console.log(a);
	if(a !=undefined || a !=null){
		$("#qq-1").remove();
		return ;
	}*/
	
	var id = $(this).attr('id');
	var msgBox  = $(this).parent().next();
	//var domdiv = $("<div>111</div>").addClass("huifu-message");
	var name = $(this).prev().prev().find("span:first").text();
	//console.log("name = "+name);
	var isNotparent = $(this).parent().hasClass("headUrl-huifu");
	//console.log(isNotparent);
	var tmpBox ;
	var cstr = '';
	if(isNotparent){
		cstr = '-1'
		tmpBox = getHuifuBox(id, name,cstr);
	}else{
		tmpBox = getHuifuBox(id, name,cstr);
	}
	
	msgBox.after(tmpBox);
	
	setTimeout(function () {
		addEvent(cstr);
	}, 1000);
})

function handLike(result){
	var data = result.extend.object;
	//console.log(data.moodLike);
	$("#like_count").text(data.moodLike);
}

function getRandNum(){
	var x = getX();
	for(var i = 0;i<5; i++){
		if(tmp != x){
			tmp = x ;
			break ;
		}else{
			x = getX();
		}
	}
	return x ;
}

$("#touxiang img").click(function(){
	var cur = $(this);
	//console.log(cur);
	var imgs = $(this).parent().children();//"img   .current-check"
	//console.log(imgs[0]);
	$.each(imgs,function(index,item){
		//console.log(item);
		if(cur != item){
			$(item).removeClass("current-check");
		}
	});
	$(this).addClass("current-check");
	$("#utx").val( $(this).attr("src"));
});

$("#say").addClass("active");
//从缓存中获取数据并渲染
var msgBoxList = JSON.parse(window.localStorage.getItem('msgBoxList')) || [];
//innerHTMl(msgBoxList);

//点击小图片，显示表情
$(".bq").click(function (e) {
	$(".face").slideDown(); //慢慢向下展开
	e.stopPropagation(); //阻止冒泡事件
});

//在桌面任意地方点击，关闭表情框
$(document).click(function () {
	$(".face").slideUp(); //慢慢向上收
});

//点击小图标时，添加功能
$(".face ul li").click(function () {
	let simg = $(this).find("img").clone();
	$(".message").append(simg); //将表情添加到输入框
});

function clearInfo(){
	$('#utx').val("");
	$('#uname').val("");
	$('#uemail').val("");
	$('.message').html('') // 清空输入框
}
//点击发表按扭，发表内容
$("span.submit").click(function () {
	var utx = $("#utx").val();
	if(utx==""){
		AlertModal("warning","请选择头像！");
		return ;
	}
	var uname = $("#uname").val();
	if(uname==""){
		$('#uname').focus();
		AlertModal("warning","请填写昵称！");
		return ;
	}
	var email = $("#uemail").val();
	if(email==""){
		$('#uemail').focus();
		AlertModal("warning","请填写邮件！");
		return ;
	}else{
		var re = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/; 
	    if (!re.test(email)) {
	    	$('#uemail').focus();
			AlertModal("warning","请填写正确的邮件！");
			return ;
	    }
	}
	let txt = $(".message").html(); //获取输入框内容
	if (!txt) {
		AlertModal("warning","尚未写留言内容！");
		$('.message').focus(); //自动获取焦点
		return;
	}
	let obj = {
		msg: txt
	}
	//msgBoxList.unshift(obj) //添加到数组里
	//window.localStorage.setItem('msgBoxList', JSON.stringify(msgBoxList)) //将数据保存到缓存
	//innerHTMl([obj]) //渲染当前输入框内容
	submitSay(utx, uname, email, txt);
	clearInfo();

});

//删除当前数据
$("body").on('click', '.del', function () {
	let index = $(this).parent().parent().index();
	msgBoxList.splice(index, 1)
	window.localStorage.setItem('msgBoxList', JSON.stringify(msgBoxList)) //将数据保存到缓存
	$(this).parent().parent().remove();
})

$("#qq .message").click(function(){
	var ct = $(".message").html();
	if("来都来了，不说点什么吗？"==ct){
		$(".message").empty();
	}
});
//渲染html
function innerHTMl(List) {
	
	var times =getTime();
	List = List || []
	List.forEach(item => {
		//var x = getRandNum();
		var str =
			`<div class='msgBox bg-' >
				<div class="headUrl">
					<img src='moudle/mood/images/tx_zxc.png' width='50' height='50'/>
					<div>
						<span class="title">游客心情</span>
						<span class="time">${times}</span>
					</div>
					<a class="del">删除</a>
				</div>
				<div class='msgTxt'>
					${item.msg}
				</div>
			</div>`
		$(".msgCon").prepend(str);
	})
}

function submitSay(utx, uname, email, txt){
	var data ={'msgUtx':utx ,'msgUname':uname, 'msgUemail':email, 'msgContent':txt};
	$.ajax({
		url:"saveMessage",
		data:data ,
		type:"post",
		dataType: 'json',
        success:function(result){
        	if(result.success){
        		//将返回值动态加载，动态生成标签。
        		addCount(result);
           	 	$("#blog").mCustomScrollbar("update");
           	 	AlertModal("success",result.msg);
        	}else{
        		AlertModal("error",result.msg);
        	}
        },
        error: function (XMLHttpRequest, textStatus, errorThown) {
             alert("请求失败！");
        }
	});
}
//留言之后追加到第一条留言
function addCount(result){
	var data = result.extend.object;
	var msgcount = result.extend.msgcount;
	$("#sayCount").text(msgcount);
	var sayBox = getSayShowTemp(data);
	var msgBox = $(".msgCon .msgBox").first();
	//console.log(msgBox);
	msgBox.before(sayBox);
}


function addEvent(cstr){
	//点击小图片，显示表情
	$(".bq-1"+cstr).click(function (e) {
		$(".face-1"+cstr).slideDown(); //慢慢向下展开
		e.stopPropagation(); //阻止冒泡事件
	});

	//在桌面任意地方点击，关闭表情框
	$(document).click(function () {
		$(".face-1"+cstr).slideUp(); //慢慢向上收
	});

	//点击小图标时，添加功能
	$(".face-1"+cstr+" ul li").click(function () {
		let simg = $(this).find("img").clone();
		$(".huifu-message"+cstr).append(simg); //将表情添加到输入框
	});
	
	$("#touxiang-1 img").click(function(){
		var cur = $(this);
		//console.log(cur);
		var imgs = $(this).parent().children();//"img   .current-check"
		//console.log(imgs[0]);
		$.each(imgs,function(index,item){
			//console.log(item);
			if(cur != item){
				$(item).removeClass("current-check");
			}
		});
		$(this).addClass("current-check");
		$("#utx-1").val( $(this).attr("src"));
	});
	
	$(".quxiao"+cstr).click(function(){
		$(".tmp-hui-fu").remove();
	});
	
	$(".huifuSub"+cstr).click(function(){
		var pid = $(this).attr("id");
		var utx = $("#utx-1").val();
		if(utx==""){
			AlertModal("warning","请选择评论头像！");
			return ;
		}
		var uname = $("#uname-1").val();
		if(uname==""){
			AlertModal("warning","请填写评论昵称！");
			$('#uname-1').focus();
			return ;
		}
		var email = $("#uemail-1").val();
		if(email==""){
			AlertModal("warning","请填写评论邮件！");
			$('#uemail-1').focus();
			return ;
		}else{
			var re = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/; 
		    if (!re.test(email)) {
		    	$('#uemail-1').focus();
				AlertModal("warning","请填写正确的邮件！");
				return ;
		    }
		}
		let txt = $(".huifu-message"+cstr).html(); //获取输入框内容
		console.log(txt.length);
		
		if (txt.length<9) {
			AlertModal("warning","尚未写评论内容！");
			$('.huifu-message'+cstr).focus(); //自动获取焦点
			return;
		}
		
		submitHuiFu(pid,utx, uname, email, txt);
	});
}

function submitHuiFu(pid, utx, uname, email, txt){
	var data ={'parentId':pid, 'msgUtx':utx ,'msgUname':uname, 'msgUemail':email, 'msgContent':txt};
	console.log(data);

	$.ajax({
		url:"saveMessage",
		data:data ,
		type:"post",
		dataType: 'json',
        success:function(result){
        	if(result.success){
        		//将返回值动态加载，动态生成标签。
        		addHuiFuCount(pid, result);
           	 	$("#blog").mCustomScrollbar("update");
           	 	AlertModal("success",result.msg);
        	}else{
        		AlertModal("error",result.msg);
        	}
        },
        error: function (XMLHttpRequest, textStatus, errorThown) {
             alert("请求失败！");
        }
	});
}

function addHuiFuCount(pid, result){
	var data = result.extend.object;
	var msgcount = result.extend.msgcount;
	$(".tmp-hui-fu").remove();
	var huifuTmp ; 
	//添加回复节点
	var leng = $(".child-pinlun-"+ pid+"  .msgBox-huifu").length;
	//console.log(leng);
	if(leng>1){
		huifuTmp = getHuiFuShowTemp(pid, data);
		$(".child-pinlun-"+ pid+" .msgBox-huifu").first().before(huifuTmp);
	}else{
		huifuTmp = getHuiFuShowTemp(pid, data);
		$(".child-pinlun-"+ pid).append(huifuTmp);
	}
	var pl =  $(".child-pinlun-"+ pid).parent().find(".huifu span").text();
	//console.log("pl :"+pl);
	$(".child-pinlun-"+ pid).parent().find(".huifu span").text(Number(pl)+1);
}

$("body").on('click', '.open-close', function (e) {
	var aId = $(this).attr("id");
	var icon = $(this).find("i");
	if(icon.hasClass("am-icon-chevron-down")){
		$(".child-pinlun-"+aId).slideUp(); //慢慢向上收起
		e.stopPropagation(); //阻止冒泡事件
		icon.removeClass("am-icon-chevron-down");
		icon.addClass("am-icon-chevron-right");
	}else{
		$(".child-pinlun-"+aId).slideDown(); //慢慢向下展开
		e.stopPropagation(); //阻止冒泡事件
		icon.removeClass("am-icon-chevron-right");
		icon.addClass("am-icon-chevron-down");
	}
}).trigger("click");

function openCloseHandle(aId, icon,e){
	//console.log(icon);
	if(icon.hasClass("am-icon-chevron-down")){
		$(".child-pinlun-"+aId).slideUp(1000); //慢慢向上收起
		icon.removeClass("am-icon-chevron-down");
		icon.addClass("am-icon-chevron-right");
		return false;
	}else{
		$(".child-pinlun-"+aId).slideDown(1000); //慢慢向下展开
		e.stopPropagation(); //阻止冒泡事件
		icon.removeClass("am-icon-chevron-right");
		icon.addClass("am-icon-chevron-down");
		return false;
	}
}
function  getSayShowTemp(msge){
	var sayBox = 
		`<div class='msgBox' >
			<div class="headUrl">
					<img src='${msge.msgUtx}' width='50' height='50'/>
						<div>
							<span class="title">${msge.msgUname}</span>
							<span class="time" >${msge.msgTime}</span>
						</div>
						<a id="${msge.id}" class="like-huifu" title="喜欢"><i class="am-icon-heart "></i>（<span>0</span>）</a>
						<a id="${msge.id}" class="huifu" title="回复"><i class="am-icon-comment "></i>（<span>0</span>）</a>
						<a id="${msge.id}" class="open-close" title="展开/收起"><i class="am-icon-chevron-right" ></i></a>
			</div>
			<div class='msgTxt' >
				${msge.msgContent}
			</div>
			<div class="${'child-pinlun-'+ msge.id}" >
			
			</div>
		 </div>`
	return sayBox;
}

function  getHuiFuShowTemp(pid, msgchild){
	var huifu = 
			`<div class='msgBox-huifu' >
				<div class="headUrl-huifu">
					<img src='${msgchild.msgUtx}' width='50' height='50'/>
						<div>
							<span class="title-huifu">${msgchild.msgUname}</span>
							<span class="time-huifu" >${msgchild.msgTime}</span>
						</div>
						<a id="${msgchild.id}" class="like-huifu" title="喜欢"><i class="am-icon-heart "></i>（<span >0</span>）</a>
						<a id="${pid}" class="huifu" title="回复"><i class="am-icon-comment "></i></a>
				</div>
				<div class='msgTxt-huifu'  >
				${msgchild.msgContent}
				</div>
			</div>`
	return huifu;
}

function getHuifuBox(pid,name,isparent){
	var box = 
		`<div class="tmp-hui-fu" id="qq-1" style="boder-color:black;">
		  <form id="say-1" class="form-horizontal" onsubmit="return false"> 
		    <div class="form-group">
			    <!-- <label for="input_blogTitle" class="col-sm-2 control-label"></label> -->
			    <input type="hidden" name="utx-1" class="form-control" id="utx-1" value=""/>
				<div id="touxiang-1" class="col-sm-12">
					<img alt="" width="35" height="35" src="moudle/say/images/0.png">
					<img alt="" width="35" height="35" src="moudle/say/images/1.png">
					<img alt="" width="35" height="35" src="moudle/say/images/2.png">
					<img alt="" width="35" height="35" src="moudle/say/images/3.png">
					<img alt="" width="35" height="35" src="moudle/say/images/4.png">
					<img alt="" width="35" height="35" src="moudle/say/images/5.png">
					<img alt="" width="35" height="35" src="moudle/say/images/6.png">
					<img alt="" width="35" height="35" src="moudle/say/images/7.png">
					<img alt="" width="35" height="35" src="moudle/say/images/8.png">
					<img alt="" width="35" height="35" src="moudle/say/images/9.png">
				</div>
			</div>
		   <div class="form-group input-group-sm">
				<!-- <label for="input_blogTitle" class="col-sm-2 control-label">昵称</label> -->
				<div class="col-sm-5">
				&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class="form-control" id="uname-1"  placeholder="昵称" data-toggle="tooltip" title="昵称" >&nbsp;
				</div>
				<div class="col-sm-5">
				&nbsp;&nbsp;<input type="text" class="form-control" id="uemail-1" placeholder="邮箱" data-toggle="tooltip" title="邮箱" >
				</div>
			</div>
			
		   <div class="form-group">
				<div class="huifu-message${isparent}" contenteditable="true">回复：@${name}：</div> 
			   	<div class="But-1${isparent}"> 
			    <img src="moudle/mood/images/bba_thumb.gif" class="bq-1${isparent}"> 
			    <span class="huifuSub${isparent}" id="${pid}">回复</span><span class="quxiao${isparent}" >取消</span>
			    <!--face begin--> 
			    <div class="face-1${isparent}"> 
			     <ul> 
			      <li><img src="moudle/mood/images/smilea_thumb.gif" title="呵呵]"></li> 
			      <li><img src="moudle/mood/images/tootha_thumb.gif" title="嘻嘻]"></li> 
			      <li><img src="moudle/mood/images/laugh.gif" title="[哈哈]"></li> 
			      <li><img src="moudle/mood/images/tza_thumb.gif" title="[可爱]"></li> 
			      <li><img src="moudle/mood/images/kl_thumb.gif" title="[可怜]"></li> 
			      <li><img src="moudle/mood/images/kbsa_thumb.gif" title="[挖鼻屎]"></li> 
			      <li><img src="moudle/mood/images/cj_thumb.gif" title="[吃惊]"></li> 
			      <li><img src="moudle/mood/images/shamea_thumb.gif" title="[害羞]"></li> 
			      <li><img src="moudle/mood/images/zy_thumb.gif" title="[挤眼]"></li> 
			      <li><img src="moudle/mood/images/bz_thumb.gif" title="[闭嘴]"></li> 
			      <li><img src="moudle/mood/images/bs2_thumb.gif" title="[鄙视]"></li> 
			      <li><img src="moudle/mood/images/lovea_thumb.gif" title="[爱你]"></li> 
			      <li><img src="moudle/mood/images/sada_thumb.gif" title="[泪]"></li> 
			      <li><img src="moudle/mood/images/heia_thumb.gif" title="[偷笑]"></li> 
			      <li><img src="moudle/mood/images/qq_thumb.gif" title="[亲亲]"></li> 
			      <li><img src="moudle/mood/images/sb_thumb.gif" title="[生病]"></li> 
			      <li><img src="moudle/mood/images/mb_thumb.gif" title="[太开心]"></li> 
			      <li><img src="moudle/mood/images/ldln_thumb.gif" title="[懒得理你]"></li> 
			      <li><img src="moudle/mood/images/yhh_thumb.gif" title="[右哼哼]"></li> 
			      <li><img src="moudle/mood/images/zhh_thumb.gif" title="[左哼哼]"></li> 
			      <li><img src="moudle/mood/images/x_thumb.gif" title="[嘘]"></li> 
			      <li><img src="moudle/mood/images/cry.gif" title="[衰]"></li> 
			      <li><img src="moudle/mood/images/wq_thumb.gif" title="[委屈]"></li> 
			      <li><img src="moudle/mood/images/t_thumb.gif" title="[吐]"></li> 
			      <li><img src="moudle/mood/images/k_thumb.gif" title="[打哈气]"></li> 
			      <li><img src="moudle/mood/images/bba_thumb.gif" title="[抱抱]"></li> 
			      <li><img src="moudle/mood/images/angrya_thumb.gif" title="[怒]"></li> 
			      <li><img src="moudle/mood/images/yw_thumb.gif" title="[疑问]"></li> 
			      <li><img src="moudle/mood/images/cza_thumb.gif" title="[馋嘴]"></li> 
			      <li><img src="moudle/mood/images/88_thumb.gif" title="[拜拜]"></li> 
			      <li><img src="moudle/mood/images/sk_thumb.gif" title="[思考]"></li> 
			      <li><img src="moudle/mood/images/sweata_thumb.gif" title="[汗]"></li> 
			      <li><img src="moudle/mood/images/sleepya_thumb.gif" title="[困]"></li> 
			      <li><img src="moudle/mood/images/sleepa_thumb.gif" title="[睡觉]"></li> 
			      <li><img src="moudle/mood/images/money_thumb.gif" title="[钱]"></li> 
			      <li><img src="moudle/mood/images/sw_thumb.gif" title="[失望]"></li> 
			      <li><img src="moudle/mood/images/cool_thumb.gif" title="[酷]"></li> 
			      <li><img src="moudle/mood/images/hsa_thumb.gif" title="[花心]"></li> 
			      <li><img src="moudle/mood/images/hatea_thumb.gif" title="[哼]"></li> 
			      <li><img src="moudle/mood/images/gza_thumb.gif" title="[鼓掌]"></li> 
			      <li><img src="moudle/mood/images/dizzya_thumb.gif" title="[晕]"></li> 
			      <li><img src="moudle/mood/images/bs_thumb.gif" title="[悲伤]"></li> 
			      <li><img src="moudle/mood/images/crazya_thumb.gif" title="[抓狂]"></li> 
			      <li><img src="moudle/mood/images/h_thumb.gif" title="[黑线]"></li> 
			      <li><img src="moudle/mood/images/yx_thumb.gif" title="[阴险]"></li> 
			      <li><img src="moudle/mood/images/nm_thumb.gif" title="[怒骂]"></li> 
			      <li><img src="moudle/mood/images/hearta_thumb.gif" title="[心]"></li> 
			      <li><img src="moudle/mood/images/unheart.gif" title="[伤心]"></li> 
			      <li><img src="moudle/mood/images/pig.gif" title="[猪头]"></li> 
			      <li><img src="moudle/mood/images/ok_thumb.gif" title="[ok]"></li> 
			      <li><img src="moudle/mood/images/ye_thumb.gif" title="[耶]"></li> 
			      <li><img src="moudle/mood/images/good_thumb.gif" title="[good]"></li> 
			      <li><img src="moudle/mood/images/no_thumb.gif" title="[不要]"></li> 
			      <li><img src="moudle/mood/images/z2_thumb.gif" title="[赞]"></li> 
			      <li><img src="moudle/mood/images/come_thumb.gif" title="[来]"></li> 
			      <li><img src="moudle/mood/images/sad_thumb.gif" title="[弱]"></li> 
			      <li><img src="moudle/mood/images/lazu_thumb.gif" title="[蜡烛]"></li> 
			      <li><img src="moudle/mood/images/clock_thumb.gif" title="[钟]"></li> 
			      <li><img src="moudle/mood/images/cake.gif" title="[蛋糕]"></li> 
			      <li><img src="moudle/mood/images/m_thumb.gif" title="[话筒]"></li> 
			      <li><img src="moudle/mood/images/weijin_thumb.gif" title="[围脖]"></li> 
			      <li><img src="moudle/mood/images/lxhzhuanfa_thumb.gif" title="[转发]"></li> 
			      <li><img src="moudle/mood/images/lxhluguo_thumb.gif" title="[路过这儿]"></li> 
			      <li><img src="moudle/mood/images/bofubianlian_thumb.gif" title="[bofu变脸]"></li> 
			      <li><img src="moudle/mood/images/gbzkun_thumb.gif" title="[gbz困]"></li> 
			      <li><img src="moudle/mood/images/boboshengmenqi_thumb.gif" title="[生闷气]"></li> 
			      <li><img src="moudle/mood/images/chn_buyaoya_thumb.gif" title="[不要啊]"></li> 
			      <li><img src="moudle/mood/images/daxiongleibenxiong_thumb.gif" title="[dx泪奔]"></li> 
			      <li><img src="moudle/mood/images/cat_yunqizhong_thumb.gif" title="[运气中]"></li> 
			      <li><img src="moudle/mood/images/youqian_thumb.gif" title="[有钱]"></li> 
			     </ul> 
			    </div> 
			    <!--face end--> 
			   </div> 
			    
			</div> 
	    </form></div> `
		return box;
}

*****/