# 跨域
- 一、后台
```
response.setHeader("Access-Control-Allow-Origin", "*");
```
- 二、设置dataType="jsonp"
  
  这种需要后台返回的数据以jsonp形式，请求访问成功但会进入error，待解决