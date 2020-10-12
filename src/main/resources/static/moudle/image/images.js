var oldValue = "";
var myblur = function(){};
var totalCate = 1;
$(function () {

	$("#IMAGE").addClass("am-active");
	
	initPicData();

	$("#img_refresh").click(function() {
		window.location.reload(true);
	});
	
	$("#myTab li").click(function() {
		var aDom = $(this).find("a");
		var id = aDom.attr("id");
		console.log(id);
		picHandle(id);
	});
	
	/**
	  图片查看插件
	 
	setTimeout(function () {
		var viewer = new Viewer(document.getElementById('myTabContent'));
	}, 1000);
	*/
});

function initPicData(){
	
	$.ajax({
		url:"stagepicateAjax",
		data: null ,
		type:"POST",
		dataType: 'json',
        success:function(result){
        	 build_data_tab(result);
       },
       error: function (XMLHttpRequest, textStatus, errorThown) {
             alert("加载失败！");
       }
   });
}

function build_data_tab(result){
	var data = result.extend.pageInfo.list;
	
	if(data.length==0){
		flag = false ;
		//$("#artlist").append("<p>该类别暂时没有图片... ...</p>");
	}
	$.each(data,function(index,item){

		var aDom = $("<a></a>").attr("href","#"+item.picCateCode).attr("data-toggle","tab").append(item.picCateName);
		var liDiv = $("<li ></li>").addClass(" ");/** left-cate */
		if(index==0){
			liDiv.addClass("active")
		}
		liDiv.append(aDom).appendTo("#myTab");
		initContent(item, item.id);
	});
}

function initContent(item, cateId){
	$.ajax({
		url:"stagepiclist/"+cateId,
		data: null ,
		type:"POST",
		dataType: 'json',
        success:function(result){
        	 build_data_Content(item, result);
       },
       error: function (XMLHttpRequest, textStatus, errorThown) {
             alert("加载失败！");
       }
   });
}
function build_data_Content(cateitem,result){
	var data = result.extend.pageInfo.list;
	
	if(data.length==0){
		flag = false ;
	}
	
	var ulDom = $("<ul ></ul>").addClass("box am-tabs-nav am-cf").attr("id","image");
	
	$.each(data,function(index,item){

		var fig = $("<figure data-am-widget=\"figure\" class=\"am am-figure am-figure-default \"   data-am-figure=\"{  pureview: 'true' }\"></figcaption>");
		var note = $("<figcaption class=\"am-figure-capition-btm\"></figcaption>").append(item.picName);
        
          
		var src = item.picLocalAddress + item.picName;
		var img = $("<img/>").attr("width","200").attr("height","160").attr("alt",item.picName).attr("src",src);
		img.addClass("show-img ");// am-img-thumbnail
		var h4 = $("<h4></h4>").append(item.picName);
		//var liDom = $("<li></li>").append(img).append(item.picName);
		
		fig.append(img).append(note);
		var liDom = $("<li></li>").append(fig) ;
		
		ulDom.append(liDom);
	});
	//var div3Dom = $("<div ></div>").append(ulDom);//.addClass("container")
	//var formDom = $("<form ></form>").addClass("form-horizontal").attr("onsubmit","return false");
	var div2Dom = $("<div ></div>").addClass("row col-sm-12 modal-body").append(ulDom);;
	
	var divDom = $("<div ></div>").addClass("tab-pane fade in").attr("id",cateitem.picCateCode);
	if(cateitem.id==0){
		divDom.addClass("active")
	}
	divDom.append(div2Dom).appendTo("#myTabContent"); //.append(formDom).append(div3Dom)
}

function getData(){}