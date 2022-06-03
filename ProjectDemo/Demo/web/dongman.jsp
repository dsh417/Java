<%@ page import="java.util.List" %>
<%@ page import="java.util.Properties" %>
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

    <title>动漫</title>




    <a>输入秘钥以获得权限验证</a>
    <div class="input-group">

        <input id="getid" type="text" class="form-control" aria-label="输入秘钥以获得权限验证" value="">
        <button type="button" class="btn btn-outline-secondary" onclick="fun()">提交秘钥</button>
        <button type="button" class="btn btn-outline-secondary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">
            <span class="visually-hidden">输入</span>
        </button>
        <ul class="dropdown-menu dropdown-menu-end">
            <li><a class="dropdown-item" href="#">联系QQ：3011629520获得秘钥</a></li>
            <li><a class="dropdown-item" href="#">等待..</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">等待..</a></li>
        </ul>
    </div>





    <script>


        function fun(){
            let key=$("#getid").val();
            location.href=encodeURI("AjaxDongman.servlet?key=${key}");
        }


</script>


</head>
</html>