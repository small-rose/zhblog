var pn = 1;
var pageNum = 5 ;
var flag = true;
var tmp = 0 ;
var totalPage = 0;
	//ajax获取数据
function getData(tmpPn){
	pn = tmpPn;
	var load = $("<i id='loading' class=\"am-icon-spinner am-icon-pulse am-icon-lg\"></i>");
	console.log('getData ....');
	if(flag){
		load.appendTo(".msgCon");
		$.ajax({
			url:"moremood",
			data:"&pn="+tmpPn+"&pageNum="+pageNum ,
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
	totalPage = result.extend.pageInfo.pages;
	if(data.length==0){
		flag = false ;
		$(".msgCon").append("<p style='padding-top:10px;'>暂时没有更多内容了... ...</p>");
	}
	$(".msgCon").empty();
	$("#totalPage").text(totalPage);
	$("#currPage").text(pn);
	//console.log(data);
	$.each(data,function(index,item){
		
    	var src = 'moudle/mood/images/tx_zxc.png' ;
		var imgDom = $("<img></img>").attr("src",src).attr("alt",'头像');
		
		var likes =  $("<span></span>").append(item.moodLike).attr("id","like_count");
		var heartIcon = $("<i></li>").addClass("am-icon-heart").addClass("heart-bg")
		var azanDom = $("<a></a>").addClass(" like").attr("title","喜欢").append(heartIcon).attr("id",item.id)
		azanDom.append("（").append(likes).append("）");
		
		var updateIcon = $("<i></li>").addClass("am-icon-edit");
		var updateDom = $("<a></a>").addClass(" update update-bg").attr("title","修改").append(updateIcon).append("修改").attr("id",item.id);
		
		var delIcon = $("<i></li>").addClass("am-icon-remove");
		var delDom = $("<a></a>").addClass("del del-bg").attr("title","删除").append(delIcon).append("删除").attr("id",item.id);

		var titleDom = $("<span></span>").append(item.moodTitle).addClass("title");
		var timeDom = $("<span></span>").append(item.moodDate).addClass("time");
		var headTitleTD = $("<div></div>").append(titleDom).append(timeDom);
		
		var headDivDom = $("<div></div>").addClass("headUrl").append(imgDom).append(headTitleTD).append(azanDom).append(updateDom).append(delDom);
		
		var msgTxtDom = $("<div></div>").addClass("msgTxt").append(item.moodContent);
		var x = getX();
		
		for(var i = 0;i<5; i++){
			if(tmp != x){
				tmp = x ;
				break ;
			}else{
				x = getX();
			}
		}
		var moodDiv = $("<div></div>").addClass("msgBox").addClass(" bg-"+x);
		
		moodDiv.append(headDivDom).append(msgTxtDom);
		
		moodDiv.appendTo(".msgCon");
	});
}

$("body").on('click', '.like', function () {
	var id = $(this).attr('id');
	console.log(id);
	$.ajax({
		url:"likemood/"+id,
		data:null ,
		type:"GET",
		dataType: 'json',
        success:function(result){
        	if(result.success){
        		//将返回值动态加载，动态生成标签。
        		handLike(result);
           	 	
        	}else{
        		
        	}
       },
       error: function (XMLHttpRequest, textStatus, errorThown) {
             alert("请求失败！");
       }
   });
})

function handLike(result){
	var data = result.extend.object;
	//console.log(data.moodLike);
	$("#like_count").text(data.moodLike);
}


//1页面加载完成后发ajax
$(function(){
	
	getData(1);
	
});


$("#mood_refresh").click(function(){
	window.location.reload(true);
});

$("#query_handle").click(function(){
	to_page(1);
});

$("#query_delete_all").click(function(){
	$("#queryForm")[0].reset();
	$("#queryMoodTitle").val("");
	$("#queryMoodContent").val("");
});


var tmpSize = 5 ;
$(document).on("change",".page_size_change",function(){
	var p1 =$(this).children('option:selected').val();//这就是selected的值 
	if(p1!=tmpSize){
		tmpSize = p1;
		to_page(1);
	}
});

function getQueryForm(){
	var query = "";
	var title = $("#queryMoodTitle").val();
	var content = $("#queryMoodContent").val();
	if(title!=null && title!=""){
		query += "&moodTitle="+title ;
	}
	if(content!=null && content!=""){
		query += "&moodContent="+content ;
	}
	return query ;
}
$("#mood").addClass("active");
//从缓存中获取数据并渲染
var msgBoxList = JSON.parse(window.localStorage.getItem('msgBoxList')) || [];
innerHTMl(msgBoxList);

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

//点击发表按扭，发表内容
$("span.submit").click(function () {
	let txt = $(".message").html(); //获取输入框内容
	if (!txt) {
		$('.message').focus(); //自动获取焦点
		return;
	}
	let obj = {
		msg: txt
	}
	msgBoxList.unshift(obj) //添加到数组里
	window.localStorage.setItem('msgBoxList', JSON.stringify(msgBoxList)) //将数据保存到缓存
	
	add_handle();
	
	//innerHTMl([obj]) //渲染当前输入框内容
	//$('.message').html('') // 清空输入框

});

//保存
function add_handle(){
	var moodTitle = $("#moodTitle").val();
	var moodContent = $(".message").html();
	var params = {'moodTitle':moodTitle, 'moodContent':moodContent };
	$.ajax({
		url:"savemood",
		data: params ,
		type:"POST",
		dataType: 'json',
		contentType:"application/json;chartset=utf-8",
        scriptCharset:'utf-8',
        success:function(result){
        	if(result.success){
        		//将返回值动态加载，动态生成标签。
        		AlertModal("success",result.msg);
        		getData(1);
        	}else{
        		AlertModal("error",result.msg);
        	}
        	clearBox(); // 清空输入框
       },
       error: function (XMLHttpRequest, textStatus, errorThown) {
             alert("请求失败！");
       }
   });
}

//删除当前数据
 $("body").on('click', '.del', function () {
	var name = $(this).parent("div").find("span:eq(0)").text();
	//console.log(name);
	if(confirm("确认删除 心情【"+name+" 】吗?")){
		var mid = $(this).attr("id");
		del_handle(mid);
		
		let index = $(this).parent().parent().index();
		msgBoxList.splice(index, 1)
		window.localStorage.setItem('msgBoxList', JSON.stringify(msgBoxList)) //将数据保存到缓存
		$(this).parent().parent().remove();
	}
});
 
function del_handle(mid){
	$.ajax({
		url:"delMood/"+mid,
		data:null ,
		type:"DELETE",
		dataType: 'json',
        success:function(result){
        	if(result.success){
        		//将返回值动态加载，动态生成标签。
        		AlertModal("success",result.msg);
        		getData(1);
        	}else{
        		AlertModal("error",result.msg);
        	}
       },
       error: function (XMLHttpRequest, textStatus, errorThown) {
             alert("请求失败！");
       }
   });
}

//渲染html
function innerHTMl(List) {
	var x = getX();
	var times =getTime();
	List = List || []
	List.forEach(item => {
		var str =
			`<div class='msgBox bg-${x}' >
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

function clearBox(){
	$("#moodTitle").val('');
	$('.message').html('');
}
$("body").on('click', '#prev-page', function(){
	 if(pn==1){
		 return false;
	 }
	 pn = pn -1;
	 getData(pn);
	 $('#blog').animate({top:"0px"},1000);
});
 
$("body").on('click', '#next-page', function(){
	 if(pn==totalPage){
		 return false;
	 }
	 pn = pn + 1;
	 getData(pn);
});

$("body").on('click', '#first-page', function(){
	 if(pn==1){
		 return false;
	 }
	 getData(1);
});

$("body").on('click', '#last-page', function(){
	 if(pn==totalPage){
		 return false;
	 }
	 getData(totalPage);
});

$("body").on('click', '.update', function(){
	 var id = $(this).attr("id");
	 
});
 
