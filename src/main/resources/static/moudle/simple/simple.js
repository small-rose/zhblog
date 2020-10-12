window.onload = function() {

	var oUl = document.getElementById('nav');
	var aLi = oUl.children;// 获取第一级菜单的四个子标签

	for (i = 0; i < aLi.length; i++) {

		aLi[i].onmouseover = function() {

			this.children[1].style.display = 'block';

		};

		aLi[i].onmouseout = function() {

			this.children[1].style.display = 'none';

		};

	}

};