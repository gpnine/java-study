<%--
  Created by IntelliJ IDEA.
  User: ChengLin Zhu
  Date: 19-1-9
  Time: 下午5:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="login_container"></div>
<a href="login.jsp">帐号登录</a>
</body>
<script src="http://g.alicdn.com/dingding/dinglogin/0.0.5/ddLogin.js"></script>
<script>
    /*
    * 解释一下goto参数，参考以下例子：
    * var url = encodeURIComponent('http://localhost.me/index.php?test=1&aa=2');
    * var goto = encodeURIComponent('https://oapi.dingtalk.com/connect/oauth2/sns_authorize?appid=appid&response_type=code&scope=snsapi_login&state=STATE&redirect_uri='+url)
    */
    var appid = 'dingoavmpchp8ecm7tibsx';
    var redirect_uri = 'http://127.0.0.1:8086/user/login';
    var url = 'https://oapi.dingtalk.com/connect/oauth2/sns_authorize?appid=' + appid +
        '&response_type=code&scope=snsapi_login&state=STATE&redirect_uri=' + redirect_uri;
    console.log(url);
    var goto = encodeURIComponent(url);
    var obj = DDLogin({
        id: "login_container",//这里需要你在自己的页面定义一个HTML标签并设置id，例如<div id="login_container"></div>或<span id="login_container"></span>
        goto: goto, //请参考注释里的方式
        style: "border:none;background-color:#FFFFFF;",
        width: "365",
        height: "400"
    });

    var hanndleMessage = function (event) {
        var origin = event.origin;
        console.log("origin", event.origin);
        if (origin === "https://login.dingtalk.com") { //判断是否来自ddLogin扫码事件。
            var loginTmpCode = event.data; //拿到loginTmpCode后就可以在这里构造跳转链接进行跳转了
            console.log("loginTmpCode", loginTmpCode);
            window.location.href = url + "&loginTmpCode=" + loginTmpCode;
        }
    };
    if (typeof window.addEventListener != 'undefined') {
        window.addEventListener('message', hanndleMessage, false);
    } else if (typeof window.attachEvent != 'undefined') {
        window.attachEvent('onmessage', hanndleMessage);
    }
</script>
</html>
