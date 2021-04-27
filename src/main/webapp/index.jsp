<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
index.jsp
<h2>this is my first rest project</h2>

<hr />
<h2>文件上传</h2>

<form method="post" action="fileUpload/blog" enctype="multipart/form-data">
    上传文件：
    <input type="file" name="upload" /> <br />
    <input type="submit" value="上传">
</form>
</body>
</html>
