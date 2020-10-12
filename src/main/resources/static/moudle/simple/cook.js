/*
cookie：每一个cookie就是一个string类型的值；
        当用户访问 web 页面时，他的名字可以记录在 cookie 中。
        当浏览器从服务器上请求 web 页面时， 属于该页面的 cookie 会被添加到该请求中。服务端通过这种方式来获取用户的信息

一个页面的可以保存多个cookie （每一个登陆者保存的信息就是一个cookie）

********cookie不适用来做存储值以及传值
*/



    /**
     * 设置cookie
     * @param cname  每一个cookie的名称
     * @param cvalue  cookie的值为cvalue
     * @param exdays  cookie 的过期时间 exdays
     */
    function setCookie(cname, cvalue, exdays) {
        let d = new Date();
        d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
        let expires = "expires=" + d.toUTCString();
        document.cookie = cname + "=" + cvalue + "; " + expires;
    }

    /**
     * 获取cookie
     * @param cname 通过cookie的名称获取哪一个cookie
     * @returns {string}
     */
    function getCookie(cname) {
        let name = cname + "=";
        let ca = document.cookie.split(';');
        for (var i = 0; i < ca.length; i++) {
            let c = ca[i].trim();
            if (c.indexOf(name) == 0) {
                return c.substring(name.length, c.length);
            }
        }
        return "";
    }

    /**
     * 检查cookie是否存在
     * @param cookieName cookie名称
     */
    function checkCookie(cookieName) {
        var user = getCookie(cookieName);
        if (user != "") {
            //alert("欢迎 " + user + " 再次访问");
        }
        else {
            //user = prompt("请输入你的名字:", "");
            if (user != "" && user != null) {
                setCookie(cookieName, user, 30);
            }
        }
    }