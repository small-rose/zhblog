var pn = 1;
var pageNum = 10 ;
var flag = true;
var tmp = 0 ;

$("#MOOD").addClass("am-active");
	//ajax获取数据
function getData(){
	var load = $("<i id='loading' class=\"am-icon-spinner am-icon-pulse am-icon-lg\"></i>");
	
	if(flag){
		load.appendTo(".msgCon");
		$.ajax({
			url:"moremood",
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

	if(data.length==0){
		flag = false ;
		$(".msgCon").append("<p style='padding-top:10px;'>暂时没有更多内容了... ...</p>");
	}
	pn = pn +1 ;
	console.log(data);
	$.each(data,function(index,item){
		
    	var src = 'moudle/mood/images/tx_zxc.png' ;
		var imgDom = $("<img></img>").attr("src",src).attr("alt",'头像');
		
		var likes =  $("<span></span>").append(item.moodLike).attr("id","like_count");
		var heartIcon = $("<i></li>").addClass("am-icon-heart").addClass("heart-bg")
		var azanDom = $("<a></a>").addClass(" like").attr("title","喜欢").append(heartIcon).attr("id",item.id);
	
		//azanDom.append("（").append(likes).append("）");
		
		var titleDom = $("<span></span>").append(item.moodTitle).addClass("title");
		var timeDom = $("<span></span>").append(item.moodDate).addClass("time");
		var headTitleTD = $("<div></div>").append(titleDom).append(timeDom);
		
		var headDivDom = $("<div></div>").addClass("headUrl").append(imgDom).append(headTitleTD).append(azanDom).append(likes);
		
		var msgTxtDom = $("<div></div>").addClass("msgTxt").append(item.moodContent);
		var x = getRandNum();
		//console.log("tmp = "+tmp+" , x"+x);
		var moodDiv = $("<div></div>").addClass("msgBox  vcard  avatar").addClass(" bg-"+x);
		
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
           	 	$("#blog").mCustomScrollbar("update");
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
	$("#like_count"+data.id).text(data.moodLike);
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
