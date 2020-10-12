

$(function() {
  $('#log-form').validator({
    onValid: function(validity) {
      $(validity.field).closest('.am-input-group').find('.am-alert').hide();
    },

    onInValid: function(validity) {
      var $field = $(validity.field);
      var $group = $field.closest('.am-input-group');
      var $alert = $group.find('.am-alert');
      // 使用自定义的提示信息 或 插件内置的提示信息
      var msg = $field.data('validationMessage') || this.getValidationMessage(validity);

      if (!$alert.length) {
          $alert = $('<div class="log-alert am-alert am-alert-danger am-radius"></div>').hide().
          appendTo($group);
      }

      $alert.html(msg).show();
    }
  });
  
  login.initPage();
  
});

 
var login = {
	//初始化页面跳转，为了防止从iframe跳转到login页面直接在iframe中显示login页面
	initPage : function() {
		//alert(location.href);
		if(window.top != window.self){
			top.location.href = location.href;
		}
	},
}

$(document).on("click", "#loginBtn" ,function(){
	var name = $("#doc-vld-email-2-1").val();
	var pass = $("#upass").val();
	if(name=="" || name.length==0 || pass=="" || pass.length==0){
		return ;
	}else{
		var code = $("#code").val();
		loginAjax(name, pass,code);
	}
});

function loginAjax(name, pass,code){
	$.ajax({
		url: "ajaxLogin",
		data: JSON.stringify({"uname":name ,"upass":pass, "code":code}),
		type:"post",
		dataType :"json",
		contentType: "application/json;charset=UTF-8",
		cache : false,
		success:function(result){
			console.log(result);
			if(result.success){
				AlertModal("success",result.msg);
				window.location.href = "adminIndex";	
			}else{
				AlertModal("error",result.msg);
			}
		},
		error:function(responseText,status,error){
			console.log(status);
			console.log(responseText);
			console.log(error);
			alert("请求或处理出错！");
		}
	});
}

//获取验证码
function getVerify(obj){
 	obj.src = "getVerify?"+Math.random();
}