<%--
  Created by IntelliJ IDEA.
  User: homolo
  Date: 19-4-17
  Time: 上午11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件</title>
</head>
<body>
<form method="post" action="" enctype="multipart/form-data">
    选择一个文件:
    <input type="file" name="uploadFile"/>
    <br/><br/>
    <input type="submit" onclick="upload" value="上传"/>
</form>
</body>
<script>
    function upload() {
        $.ajax({
            url: "api/upload",
            method: "post",
            success: function (data) {

            }
        })
    }

</script>
</html>
