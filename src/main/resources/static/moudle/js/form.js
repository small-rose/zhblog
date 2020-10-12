//定义serializeObject方法，序列化表单
	$.fn.serializeObject = function() {
		var o = {};
		var a = this.serializeArray();
		$.each(a, function() {
			if (o[this.name]) {
				if (!o[this.name].push) {
					o[this.name] = [ o[this.name] ];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});
		return o;
	};
	
	//创建一个转化的方法
	 function getFormData(formId){

	     if(formId){
	    	
	        //首先获取表单的序列化数组
	        var arr = $(formId).serializeArray();
	        if(arr && arr.length > 0){
	        	var obj = {};//创建一个空的对象 以便装数组数据
	          $.each(arr,function(index,it){//index为数组的下标 it为数组对应的数据对象 
	        	  if (obj[this.name] !== undefined) {
	        		  if (!obj[this.name].push) {
	        			  obj[this.name] = [obj[this.name]];
	        		  }
	        		  obj[this.name].push(this.value || '');
	        	  } else {
	        		  obj[this.name] = this.value || '';
	        	  }
	          });
	          console.log(obj);
	          return obj ; // 返回已经拼装好的对象
	        }
	     }
	     return {};//如果不存在此id则传出一个空的对象
	 }	