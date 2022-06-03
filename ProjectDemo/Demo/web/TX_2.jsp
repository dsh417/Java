<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="jquery/jquery-3.5.1.min.js"></script>
</head>
<body>
    <div id="content" style="position:fixed;top:0;left:0;width:100%;height:100%;z-index:0;"></div>
    <div style="width: 200px;height: 200px;background-color: white;z-index:1">

    </div>
</body>
    <script>
        $('#content').load("TX_1.jsp");
    </script>
</html>
