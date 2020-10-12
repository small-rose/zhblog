var oldValue = "";
var myblur = function(){};
var totalCate = 1;
$(function () {

	initPicData();
	
	var isedit = false;
	
	//$(".checkbox").click(function() {
		//alert("check???");
		//var obj = $(this).next();
		//var check = obj.prop("checked");
		//console.log(obj);
		//$(obj).prop("checked",!check);
	//});
	
	$('h4').dblclick(function(){
	     // 取消上次延时未执行的方法
	    //clearTimeout(TimeFn);
	    //双击事件的执行代码
		var obj = $(this);
		var inputDom = $(this).parent().children('input');
		var imageId = inputDom.val();
		console.log(imageId);

		var css = {
		    'height': '30px',
		    'margin': '0px 0px 0px -3px',
		    'padding': '0px 0px'
		};
		var nameNode = $("<input/>").attr("id","tmpEdit").attr("type","text").val(obj.text()).css(css).focus(function () {
			hanleClickDo = null;
		}).blur(function () {
			var value = $.trim($(this).val());
			
			if ( value!= undefined && value!='undefined' && value != "") {
				//obj.html(value);
				reName(imageId,value,obj);
				myblur = function(){};
			}else{
				$("#tmpEdit").focus();
				return false;
			}
			//console.log('blur- ' + value);
		});
		oldValue = obj.text();
		obj.html(nameNode);
		isedit = true;
		//console.log(obj);
		myblur = function(){
			$(document).click(function(){
    
				var value = $("#tmpEdit").val();
				//reName(value)
				if ( value!= undefined && value!='undefined' && value != "") {
					//obj.html(imageId, value);
					reName(imageId, value, obj)
					myblur = function(){};
				}else{
					$("#tmpEdit").focus();
					return false;
				}
				//console.log('myblur-' + edit);
				//reName(value);
			});
		}
	});
	
	$("#img_refresh").click(function() {
		window.location.reload(true);
	});
	$("#img_upload").click(function() {
		getPicateList();
		$("#upModal").modal({
			backdrop:"static"
		});
	});
	
	//保存上传
	$("#save_btn").click(function(){
		$("#img").fileinput("upload");
	});
	
	
	$("#img_remove").click(function() {

		var data = $("input:checkbox:checked");
		var id = "";
		var picName="";
		$.each(data,function(index,item){
			  //window.alert("你选了："+ data.length+"个，其中有："+$(this).attr("id"));
			id += $(this).attr("id")+",";
			picName += $(this).attr("name")+",";
		});
		if(id==""){
			AlertModal("warning","请选勾选要删除的图片");
			return false;
		}
		if(confirm("确认删除【"+picName+" 】吗?")){
			//console.log(data);
			picHandle(id);
		}
		
	});
	
	setTimeout(function () {
		var viewer = new Viewer(document.getElementById('myTabContent'));
	}, 5000);
	

});

function getPicateList(){
	$.ajax({
		url:"picateList",
		data: null ,
		type:"POST",
		dataType: 'json',
        success:function(result){
        	var data = result.extend.list;
        	
        	$("#input_picate_id").empty();
			$("#input_picate_id").append($("<option value=\"\">请选择图片类型</option>)"));
			$.each(data,function(){
				var optionEl = $("<option ></option>").append(this.picCateName+" - "+this.id).attr("value",this.id);
				$("#input_picate_id").append(optionEl);
			});
			
        },
        error: function (XMLHttpRequest, textStatus, errorThown) {
             alert("加载失败！");
        }
   });
}


function reName(imageId, value, obj){
	var pid = imageId;
	var picName = value;
	$.ajax({
		url:"rename",
		data:{'id' : pid, 'picName' : picName},
		type:"post",
		success:function(result){
			if(result.success){
				AlertModal("success",result.msg);
				obj.html(value);
			}else{
				AlertModal("error",result.msg);
				obj.html(oldValue);
			}
			oldValue = "";
		}
	});
}

function picHandle(id){
	$.ajax({
		url:"delImage/"+id,
		data: null ,
		type:"DELETE",
		dataType: 'json',
        success:function(result){
        	if(result.success){
				AlertModal("success",result.msg);
				initPicData();
			}else{
				AlertModal("error",result.msg);
			}
        },
        error: function (XMLHttpRequest, textStatus, errorThown) {
             alert("加载失败！");
        }
   });
}

$("#img").fileinput({
	deleteUrl: '',
    uploadUrl:"uploadImg", //接受请求地址
    uploadAsync : true, //默认异步上传
    showUpload : true, //是否显示上传按钮,跟随文本框的那个
    showRemove : true, //显示移除按钮,跟随文本框的那个
    showCaption : true,//是否显示标题,就是那个文本框
    showPreview : true, //是否显示预览,不写默认为true
    dropZoneEnabled : false,//是否显示拖拽区域，默认不写为true，但是会占用很大区域
    browseOnZoneClick: true,
    showBrowse: true,
    maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
    //minFileCount: 0,
    'theme': 'explorer',
    maxFileCount : 10, //表示允许同时上传的最大文件个数
    enctype : 'multipart/form-data',
    validateInitialCount : true,
    previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
    msgFilesTooMany : "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
    allowedFileTypes : [ 'image' ],//配置允许文件上传的类型
    //allowedPreviewTypes : [ 'image' ],//配置所有的被预览文件类型
    //allowedPreviewMimeTypes : [ 'jpg', 'png', 'gif' ],//控制被预览的所有mime类型
    //overwriteInitial: false,
    language : 'zh',
    uploadExtraData:function (previewId, index) { 
    	var picateId = $("#input_picate_id option:selected").val();
  	    console.log(index+" , previewId = " +previewId);//传参
    	    var data = {
                "picateId": picateId,      //此处自定义传参
            };
            return data;
    }
})
//异步上传返回结果处理
$('#img').on('fileerror', function(event, data, msg) {
    console.log("fileerror");
    console.log(data);
});
//异步上传返回结果处理
$("#img").on("fileuploaded", function(event, data, previewId, index) {
	  var success = data.response.success;
	  if(success){
		  var list = data.response.result;
		  var picCate = data.response.picCate;
		  console.log(list);
		  addImage(picCate, list);
		  AlertModal("success", "上传图片成功！");
		  $("#upModal").modal('hide');
	  }else{
		  AlertModal("error", "上传图片失败！");
	  }
	  //追加图片展示 可以是多个图片
});

//上传前
$('#img').on('filepreupload', function(event, data, previewId, index) {
    console.log("filepreupload");
    var form = data.form, 
    files = data.files, 
    extra = data.extra,
    response = data.response, 
    reader = data.reader;
    console.log('文件正在上传');
});


function initPicData(){
	
	$.ajax({
		url:"picateAjax",
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
		/*
		<li th:each="picate, pcStat : ${picalist}" th:class="${pcStat.index==0} ? active: ''">
		<a th:id="${picate.id}" th:href="${'#' + picate.picCateCode}" data-toggle="tab" th:text="${picate.picCateName}"> 博客信息</a>
		</li>*/

		var aDom = $("<a></a>").attr("href","#"+item.picCateCode).attr("data-toggle","tab").append(item.picCateName);
		var liDiv = $("<li ></li>");
		if(index==0){
			liDiv.addClass("active")
		}
		liDiv.append(aDom).appendTo("#myTab");
		initContent(item, item.id);
	});
}
function initContent(item, cateId){
	$.ajax({
		url:"piclist/"+cateId,
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
		//$("#artlist").append("<p>该类别暂时没有图片... ...</p>");
	}
	
	var ulDom = $("<ul ></ul>").addClass("box").attr("id","image");
	
	$.each(data,function(index,item){

		var input = $("<input></input>").addClass("checkbox").attr("type","checkbox").attr("id",item.id).attr("name",item.picName);
		input.click(function(){
			inputClickEvent(input,item.id);
		});
		var src = item.picLocalAddress + item.picName;
		var img = $("<img/>").attr("width","200").attr("height","160").attr("alt",item.picName).attr("src",src);
		var h4 = $("<h4></h4>").append(item.picName);
		var liDom = $("<li></li>").append(input).append(img).append(item.picName);
		
		ulDom.append(liDom);
	});
	var div3Dom = $("<div ></div>").addClass("container").append(ulDom);
	var formDom = $("<form ></form>").addClass("form-horizontal").attr("onsubmit","return false");
	var div2Dom = $("<div ></div>").addClass("row col-sm-12 modal-body");
	
	var divDom = $("<div ></div>").addClass("tab-pane fade in").attr("id",cateitem.picCateCode);
	if(cateitem.id==0){
		divDom.addClass("active")
	}
	divDom.append(div2Dom).append(formDom).append(div3Dom).appendTo("#myTabContent");
}

function inputClickEvent(input, id){
	var check = input.prop("checked")
	input.attr("checked",check);
}

function addImage(picCate, data){
	var id = picCate.picCateCode;
	var ulbox = $("#myTabContent").find("div#"+id).find("ul.box");
	console.log(ulbox);
	
	$.each(data,function(index,item){

		var input = $("<input></input>").addClass("checkbox").attr("type","checkbox").attr("id",item.id).attr("name",item.picName);
		input.click(function(){
			inputClickEvent(input,item.id);
		});
		var src = item.picLocalAddress + item.picName;
		var img = $("<img/>").attr("width","200").attr("height","160").attr("alt",item.picName).attr("src",src);
		var h4 = $("<h4></h4>").append(item.picName);
		var liDom = $("<li></li>").append(input).append(img).append(item.picName);
		
		ulbox.first().before(liDom);
	});
}