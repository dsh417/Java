<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.UserObj" %>
<%@ page import="entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--Bootstrap5-->
    <link href="bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <script src="bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>

    <!--Jquery-->
    <script src="jquery/jquery-3.5.1.min.js"></script>

    <!--字体-->
    <link href="font/font.css" rel="stylesheet" crossorigin="anonymous">

    <!--图片-->
    <link href="png/png.css" rel="stylesheet" crossorigin="anonymous">

    <title>控制台</title>

    <style>
        .Page{
            width: 1000px;
            height: 2000px;
        }
    </style>
</head>
<body>
    <div class="Page">

            <div class="alert alert-light" role="alert" style="padding: 0">
                <!--显示表格-->
                <table class="table table-striped table-hover">
                    <th>uid</th>
                    <th>user</th>
                    <th>pass</th>
                    <th>gold</th>
                    <th>time</th>
                    <th>attennum</th>
                    <th>extnum</th>
                    <th>Apllellation</th>
                    <%
                        List<User> list= (List<User>) request.getAttribute("UserList");
                        for(User user:list){
                    %>
                    <tr>
                        <td><%=user.getUid()%></td>
                        <td><%=user.getUser()%></td>
                        <td><%=user.getPass()%></td>
                        <td><%=user.getGold()%></td>
                        <td><%=user.getTime()%></td>
                        <td><%=user.getAttennum()%></td>
                        <td><%=user.getExtnum()%></td>
                        <td><%=user.getAppellation()%></td>
                    </tr>
                    <%
                        }
                    %>
                </table>
            </div>


    </div>

</body>


</html>

