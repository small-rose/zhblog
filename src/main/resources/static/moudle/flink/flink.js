let localSrc ;
function getData(){
}
$(function(){

	$(".plus-square-left").click(function(){
		addLink();
	});
	
	$(".plus-square-right").click(function(){
		addLink();
	});
	
	$("#input_Linktx").blur(function(){
		var url = $(this).val();
		if(url==""){
			return ;
		}
		$("#linkTx").attr("src",url);
	});
	
	$("#save_btn").click(function(){
		subLink();
	});
	
	localSrc = $("#linkTx").attr("src");
});

function addLink(){
	clear_model();
	$("#addModalLabel").text("申请友链");

	//弹出模态框
	$("#addModal").modal({
		backdrop:"static"
	});
}

function clear_model(){
	$("#input_Linktx").val();
	$("#input_LinkName").val();
	$("#input_LinkUrl").val();
	$("#linkTx").attr("src",localSrc);
}

function subLink(){
	var tx = $("#input_Linktx").val();
	if($.trim(tx) ==""){
		show_validate_msg("#input_Linktx","error","头像输入不正确！")
	}
	var name = $("#input_LinkName").val();
	if($.trim(name) ==""){
		show_validate_msg("#input_Linktx","error","网站名称输入不正确！")
	}
	var url = $("#input_LinkUrl").val();
	if($.trim(url) ==""){
		show_validate_msg("#input_Linktx","error","网站URL输入不正确！")
	}
	
	var param ={ 'linkUrl' : url ,'linkName':name, 'linkTx':tx} ;
	$.ajax({
		url:"saveLink",
		type:"post",
		contentType:'application/json;charset=utf-8',
		data:JSON.stringify(param),
		cache : false,
		success:function(result){
			if(result.success){
				AlertModal("success",result.msg);
				//员工保存成功1.要关闭模态框，2来到最后一页
				$('#addModal').modal('hide');
			}else{
				AlertModal("error",result.msg);
			}
		},
		error:function(data,type, err){
	         console.log("ajax错误类型："+type);
	         console.log(err);
			 AlertModal("error",err);
		}
	});
}

function show_validate_msg(ele,status,msg){
	//清除当前元素校验状态
	$(ele).parent().removeClass("has-error has-success");
	$(ele).next("span").text("");
	if("error"==status){
		$(ele).parent().addClass("has-error");
		$(ele).next("span").text(msg);
		return false;
	}else if("success"==status){
		$(ele).parent().addClass("has-success");
		$(ele).next("span").text(msg);
	}
}