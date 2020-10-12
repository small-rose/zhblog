var pn = 1;
var pageNum = $("#pageSize").val() ;
var flag = true;

$("#FIRST").addClass("am-active");
//ajax获取数据
function getData(){
	var typId = $("#tpId").val();
	console.log("tpId :" +typId);
	var load = $("<i id='loading' class=\"am-icon-spinner am-icon-pulse am-icon-lg\"></i>");
	var liDom = $("<li></li>").attr("id","prev-page").addClass("am-pagination-prev").append(load);
	pn = pn +1 ;
	if(flag){
		liDom.appendTo("#loadPag");
		$.ajax({
			url:"moreTypeArticle",
			data:"&pn="+pn+"&pageNum="+pageNum+"&typeId="+typId ,
			type:"GET",
			dataType: 'json',
	        success:function(result){
	            //将返回值动态加载，动态生成标签。
	        	 $("#prev-page").remove();
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
		var liDom = $("<li></li>").attr("id","prev-page").addClass("am-pagination-prev").append("<p>暂无更多...</p>");
		$("#loadPag").append(liDom);
	}
	
	console.log(data);
	$.each(data,function(index,item){
		console.log(item);
		var path = item.image!=null ? item.image.picLocalAddress: "1" ;
    	var src = path + item.image.picName ;
		var imgDom = $("<img></img>").addClass("am-u-sm-12").attr("src",src).attr("alt",item.image.picName);;
		var imageDiv = $("<div ></div>").addClass("am-u-lg-5 am-u-md-12 am-u-sm-12 blog-entry-img leftImg").append(imgDom);
		
		var userIcon = $("<i></i>").addClass("am-icon am-icon-user author-color");
		var spanAuthor = $("<span></span>").append($("<a></a>").append('').append(userIcon).append('&nbsp;').addClass("blog-color ").append(item.articleAuthor).append("&nbsp;"));
		
		var typeIcon = $("<i></i>").addClass("am-icon am-icon-flag type-color");
		var spanType = $("<span></span>").append(typeIcon).append(item.typeName).addClass("font-yahei");
		
		var calendarIcon = $("<i></i>").addClass("am-icon am-icon-calendar rili-color");
		var spanTime = $("<span></span>").append(calendarIcon).append(item.publishDate).addClass("font-yahei");
		
		var title = item.articleTitle;
		//console.log(title.length);
		title += title ;
		title = title.length>20 ? title.substring(0,20)+'...' :title;
		var kw = $("<span></span>").addClass("keyWorld").append("标印");
		var h1Title = $("<h3></h3>").append(kw).append($("<a></a>").attr("href",'view?id='+item.id).attr("title", "点击阅读详细内容").append(title));
		var artTabloid = item.articleTabloid;
		artTabloid = artTabloid.length>84 ? artTabloid.substring(0,84)+'...' :title;
		var pDom = $("<p></p>").append(artTabloid);
		
		var likeIcon = $("<i></i>").addClass("am-icon am-icon-thumbs-up thumbs-up-color");
		var likeYesTD = $("<span></span>").append(likeIcon).append("点赞").append("(").append(item.likeYes).append(")").addClass("font-yahei f_r");;
		
		var hitIcon = $("<i></i>").addClass("am-icon am-icon-eye author-color");
		var articleHitsTD = $("<span></span>").append(hitIcon).append("浏览").append("(").append(item.articleHits).append(")").addClass("font-yahei f_r");
		
		var comIcon = $("<i></i>").addClass("am-icon am-icon-comment author-color");
		//暂无评论
		var comTD = $("<span></span>").append(comIcon).append("评论").append("(").append('0').append(")").addClass("font-yahei f_r");

		var artDiv = $("<div ></div>").addClass("am-u-lg-7 am-u-md-12 am-u-sm-12 blog-entry-text wenziLeft");
		artDiv.append(h1Title).append(pDom);
		
		
		var viewArtDiv = $("<div ></div>").addClass("view-art");
		viewArtDiv.append(spanType).append(spanTime);
		viewArtDiv.append(likeYesTD).append(articleHitsTD).append(comTD);
		artDiv.append(viewArtDiv);
		/*
		<div class="view-art">
        <span class="font-yahei"><i class="am-icon am-icon-flag type-color"></i><span>前端技术</span>&nbsp;</span>
        <span class="font-yahei"><i class="am-icon am-icon-calendar rili-color"></i><span>2018-03-18</span></span>
        
        <span class="font-yahei f_r"><i class="am-icon am-icon-thumbs-up thumbs-up-color"></i>点赞 (<span>0</span>) </span>
        <span class="font-yahei f_r"><i class="am-icon am-icon-eye author-color"></i>浏览 (<span>0</span>)</span>
        <span class="font-yahei f_r"><i class="am-icon am-icon-comment author-color"></i>评论 (<span>0</span>)</span>
        
        <!-- <span class="font-yahei f_r"><i class="am-icon am-icon-thumbs-down thumbs-down-color" ></i>[<span th:text="${ newart.likeNo }"></span>] </span> -->
        </div>
        */
		var articleDom =$("<article></article>").addClass("am-g blog-entry-article blog-entry-article-border ");
		
		articleDom.append(imageDiv).append(artDiv).appendTo("#artlist");
	});
};

$("#next-page").click(function(){
	getData();
});

