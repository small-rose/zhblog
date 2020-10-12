(function ($) {
	
	$.extend({
		tipsBox: function (options) {
			options = $.extend({
				obj: null,  //jq对象，要在那个html标签上显示
				str: "+1",  //字符串，要显示的内容;也可以传一段html，如: "<b style='font-family:Microsoft YaHei;'>+1</b>"
				startSize: "12px",  //动画开始的文字大小
				endSize: "30px",    //动画结束的文字大小
				interval: 600,  //动画时间间隔
				color: "red",    //文字颜色
				callback: function () { 
					
				}    //回调函数
			}, options);
			$("body").append("<span class='num'>" + options.str + "</span>");
			var box = $(".num");
			var left = options.obj.offset().left + options.obj.width() / 2;
			var top = options.obj.offset().top - options.obj.height();
			box.css({
				"position": "absolute",
				"left": left + "px",
				"top": top + "px",
				"z-index": 9999,
				"font-size": options.startSize,
				"line-height": options.endSize,
				"color": options.color
			});
			box.animate({
				"font-size": options.endSize,
				"opacity": "0",
				"top": top - parseInt(options.endSize) + "px"
			}, options.interval, function () {
				box.remove();
				options.callback();
			});
		}
	});
})(jQuery);
  

String.prototype.endWith = function(endStr){
    var d=this.length-endStr.length;
    return (d>=0&&this.lastIndexOf(endStr)==d);
};

function niceIn(prop){
	prop.find('i').addClass('niceIn');
	setTimeout(function(){
		prop.find('i').removeClass('niceIn');	
	},1000);		
}
var pn =1 , pageNum = 5;

$(function () {
	
	$("#likeBtn").click(function () {
		$.tipsBox({
			obj: $(this),
			str: "+1",
			callback: function () {
				addLike('', 1, 'a');
			}
		});
		niceIn($(this));
	});
	
	$("#NolikeBtn").click(function () {
		$.tipsBox({
			obj: $(this),
			str: "+1",
			callback: function () {
				addLike('', 0, 'a');
			}
		});
		niceIn($(this));
	});
	//$("#cmtPagination")
	
	
	$("#commentBtn").click(function(){
		var artId = $("#aid").val();
		var cmtUtx = $("#touxiang").attr("src");
		var cmtName = $("#cmtName").val();
		var cmtEmail = $("#cmtEmail").val();
		var cmtWebUrl = $("#cmtWebUrl").val();
		/*var cmtContent = $("#cmtContent").val();
		console.log(cmtContent);
		*/
		var cmtContent = editor.txt.html();
		//console.log(cmtContent);
		if($.trim(cmtName)==''){  $("#cmtName").focus(); return false;}
		if($.trim(cmtEmail)==''){  $("#cmtEmail").focus(); return false;}
		if($.trim(cmtContent)==''){  $("#cmtContent").focus(); return false; }
		var param = {'articleId' : artId, 'cmtUtx':cmtUtx, 'cmtUname' : cmtName, 'cmtUemail' : cmtEmail, 'cmtWebUrl' : cmtWebUrl
				, 'cmtContent' : cmtContent};
		save(param);
		clearForm();
	});
	
	
	$('.content').flexText();
	
	$('.comment-show').on('click','.pl-hf',function(){
		var pid = $(this).attr("id");
		var text = $(this).text();
		
		//console.log("pid:"+pid +" ,text："+text);
		if(text=='回复'){
			 $(this).text('取消回复');
		}else{
			$(this).text('回复');
		}
        //获取回复人的名字
        var fhName = $(this).parents('.date-dz-right').parents('.date-dz').siblings('.pl-text').find('.comment-size-name').html();
        //回复@
        var fhN = '回复@'+fhName+'：';
        
        //var fhHtml = '<div class="hf-con pull-left"> <textarea class="content comment-input hf-input" placeholder="" onkeyup="keyUP(this)"></textarea> <a href="javascript:;" class="hf-pl">评论</a></div>';
        var fhHtml = `<div class="hf-con pull-left">
        	 <img id="touxiang-1" src="moudle/say/images/tx_kt_9.jpg" width="25" height="25" />
        	 <div class="touxiang-list-1">
					<div class="big-toux-1"><img /></div> 
				     <ul> 
				      <li><img src="moudle/say/images/tx_kt_1.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_kt_2.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_kt_3.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_kt_4.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_kt_5.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_kt_6.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_kt_7.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_kt_8.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_kt_9.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_kt_10.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_kt_11.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_kt_12.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_kt_13.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_kt_14.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_kt_15.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_kt_16.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_kt_17.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_kt_18.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_kt_19.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_kt_20.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_gl_1.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_gl_2.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_gl_3.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_gl_4.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_gl_5.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_gl_6.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_gl_7.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_gl_8.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_gl_9.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_gl_10.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_dw_.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_dw_1.jpg" width="25px" height="25px" title=""></li> 
				      <li><img src="moudle/say/images/tx_dw_2.jpg" width="25px" height="25px" title=""></li> 
				     </ul>
				    </div>
        	 <input type="hidden" id="utx-1" class="am-input-sm hui-input" value='moudle/say/images/tx_kt_1.jpg'>
        	 <input type="hidden" id="pid-1" class="am-input-sm hui-input" value='${pid}'>
        	 <input type="text" id="cmtName-1" class="am-input-sm hui-input" placeholder="名字(必填)">
        	 <input type="email" id="cmtEmail-1"  class="am-input-sm hui-input" placeholder="邮箱(必填)">
        	 <input type="text" id="cmtWebUrl-1"  class="am-input-sm hui-input" placeholder="网站">
        	
        	<div id="cmtContent-1" contenteditable="true" class="content comment-input hf-input">${fhN}</div>
        	<div class="But"> 
			    <img src="moudle/mood/images/bba_thumb.gif" class="bq"> 
			    <!--face begin--> 
			    <div class="face"> 
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
        	<a href="javascript:;" class="hf-pl">回复评论</a>
        	</div>`;
        //显示回复
        if($(this).is('.hf-con-block')){
            $(this).parents('.date-dz-right').parents('.date-dz').append(fhHtml);
            $(this).removeClass('hf-con-block');
            $('.content').flexText();
            $(this).parents('.date-dz-right').siblings('.hf-con').find('.pre').css('padding','6px 15px');
            //console.log($(this).parents('.date-dz-right').siblings('.hf-con').find('.pre'))
            //input框自动聚焦
            //$(this).parents('.date-dz-right').siblings('.hf-con').find('.hf-input').val('').focus().html(fhN);
            $(this).parents('.date-dz-right').siblings('.hf-con').find('.hf-input').val('').html(fhN);
        }else {
            $(this).addClass('hf-con-block');
            $(this).parents('.date-dz-right').siblings('.hf-con').remove();
        }
        addHuiFu();
    });
	
	//getData();
	buildCommentData(1);
	
	$("#touxiang").click(function(e){
		$(".touxiang-list").slideDown(); //慢慢向下展开
		e.stopPropagation(); //阻止冒泡事件
	});

	//在桌面任意地方点击，关闭表情框
	$(document).click(function () {
		$(".touxiang-list").slideUp(); //慢慢向上收
	});
		
	//点击小图标时，添加功能
	$(".touxiang-list ul li").click(function () {
		let simg = $(this).find("img").clone();
		$("#utx").val(simg.attr("src"));
		$("#touxiang").attr("src" ,simg.attr("src"));
	});

	$(".touxiang-list li").mouseover(function(){
		let simg = $(this).find("img").clone();
		simg.attr("width","").attr("height","");
		
		$(".big-toux img").attr("src",simg.attr("src"));
		$(".big-toux").css({"display": "block"});
	});

	$(".touxiang-list li").mouseout(function(){
		$(".big-toux").css({"display":"none"});
	});
 
});

function getData(){}

function buildCommentData(pn){
	var artId = $("#aid").val();
	$.ajax({
		url:"moreCmt",
		data:"&artId="+artId+"&pn="+pn+"&pageNum="+pageNum ,
		type:"GET",
		dataType: 'json',
	    success:function(result){
	          // 将返回值动态加载，动态生成标签。
	    	 clear_table();
	    	 var total = result.extend.pageInfo.total ;
	    	 console.log(total);
	    	 if(total > 0){
	    		 build_data_table(result);
		      	 build_data_Pagination(result);
	    	 }else{
	    		 //$("#noComment").hide();
	    	 }
	      	 
	         $("#blog").mCustomScrollbar("update");
	    },
	    error: function (XMLHttpRequest, textStatus, errorThown) {
	         alert("加载失败！");
	    }
	});
}

function addLike(id, s, tpye){
	if(tpye=='a'){
		var aId = $("#aid").val();
		$.ajax({
			url:"addArtLike",
			type:"POST",
			dataType: 'json',
			data: JSON.stringify({'id' : aId, 'isLike' : s}),
			contentType: "application/json;charset=UTF-8",
			cache:false,
			success:function(result){
				if(result.success){
					var obj = result.extend.object;
					//console.log(obj);
					$("#likeYes").text(obj.likeYes);
					$("#likeNo").text(obj.likeNo);
				}else{
					AlertModal("error",result.msg);
				}
			}
		});
	}else{
		$.ajax({
			url:"addPLlike",
			type:"POST",
			dataType: 'json',
			data: JSON.stringify({'id' : id, 'isLike' : s}),
			contentType: "application/json;charset=UTF-8",
			cache:false,
			success:function(result){
				if(result.success){
					var obj = result.extend.object;
					console.log("id:"+id);
					console.log(obj);
					$("#zan-"+id).text(obj.likeYes);
					$("#cai-"+id).text(obj.likeNo);
				}else{
					AlertModal("error",result.msg);
				}
			}
		});
	}
}

function keyUP(t){
    var len = $(t).val().length;
    if(len > 139){
        $(t).val($(t).val().substring(0,140));
    }
}

function clear_table(){
	$("#commentShow").empty();
	$("#cmtPagination").empty();
}

function build_data_table(result){
	var pageInfo = result.extend.pageInfo;
	//console.log(pageInfo);
	var data = result.extend.pageInfo.list;
	var pageNum = result.extend.pageInfo.pageNum;
	var pageSize = result.extend.pageInfo.pageSize;
	var total = result.extend.pageInfo.total;
	$("#cmtCount").text(result.extend.cmtCount);
	var lou = Number(total) - Number(pageSize * Number(pageNum-1));
	var idArr = [];
	$.each(data,function(index,item){
		/*
	<div class="comment-show-con clearfix" th:each="cmt ,iterStat : ${article.commentList}">
        <div class="comment-show-con-img pull-left"><img src="moudle/say/images/tx_dw_.jpg" alt="" width="48" height="48"></div>
        <div class="comment-show-con-list pull-left clearfix">
            <div class="pl-text clearfix">
                <a href="#" class="comment-size-name" th:text="${cmt.cmtUname}">张三 : </a>
                <span class="my-pl-con">&nbsp; <span th:text="${cmt.cmtContent}"></span></span>
            </div>
            <div class="date-dz">
                <span class="date-dz-left pull-left comment-time" th:text="${cmt.cmtDate}">2017-5-2 11:11:39</span>
                <div class="date-dz-right pull-right comment-pl-block">
                    <!-- <a href="javascript:;" class="removeBlock">删除</a> -->
                    <a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a>
                    <span class="pull-left date-dz-line">|</span>
                    <a href="javascript:;" class="date-dz-z pull-left"><i class="date-dz-z-click-red"></i>赞 (<i class="z-num"><span th:text="${cmt.likeYes}"></span></i>)</a>
                </div>
            </div>
            <div class="hf-list-con"></div>
        </div>
    </div>
		*/
		var toux = ( item.cmtUtx==null || item.cmtUtx=='') ? "moudle/say/images/tx_dw_.jpg" : item.cmtUtx ;
		var imgDom = $("<img />").attr("src",toux).attr("width","48").attr("height","48");
		var leftDom = $("<div></div>").addClass("comment-show-con-img pull-left").append(imgDom);
		
		var aDom = $("<a></a>").addClass("comment-size-name").append(item.cmtUname);
		var spanDom = $("<span></span>").addClass("my-pl-con").append(item.cmtContent);
		
		//console.log("lou : "+lou);
		var louNumSp =  $("<span></span>").addClass("lou-con").append("#").append(lou).append("楼#  ");
		var touxDiv = $("<div></div>").addClass("pl-text clearfix").append(louNumSp).append(aDom).append(" : ").append(spanDom);
		var listDom = $("<div></div>").addClass("comment-show-con-list pull-left clearfix").append(touxDiv);
		
		var spanTime = $("<span></span>").addClass("date-dz-left pull-left comment-time").append(item.cmtDate);
		
		var aHuiFu = $("<a></a>").addClass("date-dz-pl pl-hf hf-con-block pull-left").append("回复").attr("href","javascript:;").attr("id",item.id);
		var line = $("<span></span>").addClass("pull-left date-dz-line").append("|");
		
		//var iz1 = $("<i ></i>").addClass("am-icon-heart-o");
		var iz1 = $("<span ></span>").addClass("glyphicon glyphicon-thumbs-up");
		var zan = $("<a></a>").addClass("date-dz-z pull-left zan-cai").append(iz1).append("赞 (").append($("<span></span>").attr("id","zan-"+item.id).append(item.likeYes)).append(") ");//.css('padding','0 0 0 10px');
		zan.attr("id",item.id);
		zan.click(function(){
			addPinLunLike(zan,item.id, 1);
		});
		
		var iz2 = $("<span ></span>").addClass("glyphicon glyphicon-thumbs-down");
		var cai = $("<a></a>").addClass("date-dz-z pull-left zan-cai").append(iz2).append(" 踩 (").append($("<span></span>").attr("id","cai-"+item.id).append(item.likeNo)).append(") ");//.css('padding','0 0 0 10px');
		cai.attr("id",item.id);
		cai.click(function(){
			addPinLunLike(cai,item.id, 0);
		});
		
		var rightDom = $("<div></div>").addClass("date-dz-right pull-right comment-pl-block");
		rightDom.append(aHuiFu).append(line).append(zan).append(cai);
			
		var dateDz =  $("<div></div>").addClass("date-dz").append(spanTime).append(rightDom);
		var listConDz =  $("<div></div>").addClass("hf-list-con");
		//console.log(item.children);
		
		$.each(item.children, function(index,childItem){
			var hfpl = huifupinLun(childItem.id,childItem.cmtUtx,childItem.cmtUname, item.id, item.cmtUname, childItem.cmtContent, childItem.likeYes, childItem.likeNo);
			//console.log(hfpl);
			idArr.push(childItem.id);
			listConDz.append(hfpl);
		});
		
		listDom.append(touxDiv).append(dateDz).append(listConDz) ;
		
		var showOnDom = $("<div></div>").addClass("comment-show-con clearfix");
		showOnDom.append(leftDom).append(listDom);
		
		$("#commentShow").append(showOnDom).append(showOnClearDom);
		lou--;
	});
	
	var showOnClearDom = $("<div></div>").addClass("comment-show-con clearfix");
	$("#commentShow").append(showOnClearDom);
	
	 addHfPlEvent(idArr);
}

function build_data_Pagination(result){
	var pageNum = result.extend.pageInfo.pageNum;
	var pageSize = result.extend.pageInfo.pageSize;
	/*
		<ul class="am-pagination-comment  ">
		<li><span class="am-badge  am-badge-primary am-radius">首页</span></li>
		<li><span class="am-badge  am-radius">上一页</span></li>
		<li><span class="am-badge  am-badge-secondary am-radius">1</span></li>
		<li><span class="am-badge  am-radius">2</span></li>
		<li><span class="am-badge  am-radius">3</span></li>
		<li><span class="am-badge  am-radius">4</span></li>
		<li><span class="am-badge  am-radius">5</span></li>
		<li>...</li>
		<li><span class="am-badge  am-radius">下一页</span></li>
		<li><span class="am-badge  am-badge-primary am-radius">末页</span></li>
	</ul>
	*/
	var pageInfo = result.extend.pageInfo ;
	
	var ulObj = $("<ul></ul>").addClass("am-pagination-comment ");
	//首页
	var firstsp = $("<span></span>").append("首页").addClass("am-badge  am-badge-primary am-radius");
	var firstli = $("<li></li>").append(firstsp);
	//前一页
	var preli = $("<li></li>").append($("<span></span>").append("上一页").addClass("am-badge  am-radius"));
	if(!pageInfo.hasPreviousPage){
		firstli.addClass("disabled");
		preli.addClass("disabled");
	}else{
		firstli.click(function(){
			buildCommentData(1);
		});
		preli.click(function(){
			buildCommentData(pageInfo.pageNum-1);
		});
	}
	//后一页
	var nextli = $("<li></li>").append($("<span></span>").append("下一页").addClass("am-badge  am-radius"));
	//末页
	var lastli = $("<li></li>").append($("<span></span>").append("末页").addClass("am-badge am-badge-primary  am-radius"));
	if(!pageInfo.hasNextPage){
		nextli.addClass("disabled");
		lastli.addClass("disabled");
	}else{
		nextli.click(function(){
			buildCommentData(pageInfo.pageNum+1);
		});
		lastli.click(function(){
			buildCommentData(pageInfo.pages);
		});
	}
	
	//组装
	ulObj.append(firstli).append(preli);
	var pages = result.extend.pageInfo.navigatepageNums;
	console.log("pages:"+pages);
	$.each(pages,function(index,item){
		var sp = $("<span></span>").append(item).addClass("am-badge  am-radius");
		
		if(item==pageInfo.pageNum){
			sp.addClass("am-badge-primary");
		}
		var numli = $("<li></li>").append(sp);
		
		numli.click(function(){
			buildCommentData(item);
		});
		ulObj.append(numli);
	});
	ulObj.append(nextli).append(lastli);
	//把ul放入div元素
	var navEle = $("#cmtPagination").append(ulObj);
	
	addPaginationEvent();
}

function addPaginationEvent(){
	$("#cmtPagination li span ").hover(function(){
		$(this).addClass("am-badge-secondary");
	},function(){
		$(this).removeClass("am-badge-secondary");
	});
}

function addHuiFu(){

	$(".hf-pl").click(function(){
		var artId = $("#aid").val();
		var parentId = $("#pid-1").val();
		var cmtUtx = $("#utx-1").val();
		var cmtName = $("#cmtName-1").val();
		var cmtEmail = $("#cmtEmail-1").val();
		var cmtWebUrl = $("#cmtWebUrl-1").val();
		var cmtContent = $("#cmtContent-1").html();
		if($.trim(cmtName)==''){  $("#cmtName-1").focus(); return false;}
		if($.trim(cmtEmail)==''){  $("#cmtEmail-1").focus(); return false;}
		if($.trim(cmtContent)==''){  $("#cmtContent-1").focus(); return false; }
		
		var param = {'articleId' : artId, 'cmtUtx':cmtUtx, 'cmtUname' : cmtName, 'cmtUemail' : cmtEmail, 'cmtWebUrl' : cmtWebUrl
				, 'cmtContent' : cmtContent,'parentId':parentId };
		save(param);
	});
	
	$("#touxiang-1").click(function(e){
		$(".touxiang-list-1").slideDown(); //慢慢向下展开
		e.stopPropagation(); //阻止冒泡事件
	});

	//在桌面任意地方点击，关闭表情框
	$(document).click(function () {
		$(".touxiang-list-1").slideUp(); //慢慢向上收
	});
		
	//点击小图标时，添加功能
	$(".touxiang-list-1 ul li").click(function () {
		let simg = $(this).find("img").clone();
		$("#utx-1").val(simg.attr("src"));
		$("#touxiang-1").attr("src" ,simg.attr("src"));
	});

	$(".touxiang-list-1 li").mouseover(function(){
		let simg = $(this).find("img").clone();
		simg.attr("width","").attr("height","");
		
		$(".big-toux-1 img").attr("src",simg.attr("src"));
		$(".big-toux-1").css({"display": "block"});
	});

	$(".touxiang-list-1 li").mouseout(function(){
		$(".big-toux-1").css({"display":"none"});
	});
	
	//-------------表情---------------------
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
		$("#cmtContent-1").append(simg); //将表情添加到输入框
	});
}

function save(param){
	console.log(param);
	$.ajax({
		url:"saveComment",
		type:"POST",
		dataType:"json",
		data: JSON.stringify(param),
		contentType: "application/json;charset=UTF-8",
		cache:false,
		success:function(result){
			if(result.success){
				//AlertModal("success",result.msg);
				buildCommentData(1);
			}else{
				AlertModal("error",result.msg);
			}
		}
	});
}

function clearForm(){
	$("#cmtName").val('');
	$("#cmtEmail").val('');
	$("#cmtWebUrl").val('');
	editor.txt.clear();
}

function huifupinLun(id, tx, name, pid, pName, cmtContent, likeYes, likeNo){
	var tmptx = ( tx!=null && tx!='') ? tx :'moudle/say/images/tx_kt_9.jpg';
	
	var hfpl = `<div class="all-pl-con">
				
				<div class="pl-text hfpl-text clearfix">
					<img src="${tmptx}" width="35" height="35" />
					<a href="#" class="comment-size-name">${name}</a>
					<span class="my-pl-con">回复@<a href="#" class="atName">${pName} </a> : ${cmtContent}</span></div>
					<div class="date-dz"> 
						<span class="date-dz-left pull-left comment-time">2019-5-2 23:24:31</span> 
						<div class="date-dz-right date-dz-right-huifu pull-right comment-pl-block"> 
						<a href="javascript:;" class="removeBlock">删除</a> 
						<a href="javascript:;" class="date-dz-pl pl-hf pull-left hf-con-block" id="${pid}">回复</a> 
						<span class="pull-left date-dz-line  date-dz-line-1">|</span> 
						<a id="hf-zan-${id}"href="javascript:;" class="date-dz-z pull-left  zan-cai"><span class="glyphicon glyphicon-thumbs-up zan-cai"></span>赞 (<span id="zan-${id}">${likeYes}</span>)</a> 
						<a id="hf-cai-${id}"href="javascript:;" class="date-dz-z pull-left  zan-cai"><span class="glyphicon glyphicon-thumbs-down zan-cai"></span>踩 (<span id="cai-${id}">${likeNo}</span>)</a> 
					</div> 
				</div>
				</div>`;
	return hfpl;
}

function addPinLunLike(obj ,id , n ){
	
	console.log("id"+id);
	$.tipsBox({
		obj: obj,
		str: "+1",
		callback: function () {
			addLike(id, n, 'c');
		}
	});
	niceIn(obj);
}

function addHfPlEvent(idArr){
	idArr.forEach(function (id, index) {
		$("#hf-zan-"+ id).click(function(){
			addPinLunLike($("#hf-zan-"+ id), id, 1);
		});
		$("#hf-cai-"+ id).click(function(){
			addPinLunLike($("#hf-cai-"+ id), id, 0);
		});
	});
}


$("#daShang").mouseover(function(){
	$(".daShang_pay").css({"display": "block"});
});

$("#daShang").mouseout(function(){
	$(".daShang_pay").css({"display":"none"});
});