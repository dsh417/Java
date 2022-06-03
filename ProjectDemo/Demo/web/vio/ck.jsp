<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/1/18
  Time: 2:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body style="margin: 0">

<div>

    <video autoplay><source src="gacha.mp4"></video>

</div>



</body>
<script>
    setTimeout(
        function (){
            parent.$("#show").html('<iframe id="talk" width="2100px" height="1100px" src="png/sx.jsp"></iframe>');
        },6000)
</script>
</html>
