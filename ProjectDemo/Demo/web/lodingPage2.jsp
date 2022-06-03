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

    <title>主页</title>


    <style>

        .Head{
            width: 100%;
            background-color:#368AA2;
        }
        .high{
            width: 75%;
            height: 10px;
            margin: auto;
        }
        .font-size-m{
            font-size: 40px;
            color:white;
            font-family: 宋体, serif;
            text-align: center;
            /*text-shadow:0 0 10px #69e0ff,0 0 20px #69e0ff,0 0 40px #69e0ff;*/
        }

        .font-size-s{
            font-size: 35px;
            color: #368AA2;
            font-family: 宋体, serif;
        }
        .font-size-s:hover{
            text-shadow:0 0 10px #FAF1AB,0 0 20px #FEF0A0,0 0 40px #F9F3DC;
            margin-left: 10px;
            color: #301800;
        }


        .Page-end{
            color: white;
            text-align: center;

        }


        .border-red{
            border-color: red;
        }
        .color-red{
            color: red;
        }

        .name-high{
            font-size: 50px;
            text-shadow:0 0 10px #69e0ff,0 0 20px #69e0ff,0 0 40px #69e0ff;
            border: 0;
            padding: 0;
        }


        .PiFu-jin{
            background-image: url("png/PiFu/1.png");
        }

        /*父字体*/
        .head-font-size{
            font-size: 25px;
        }
        /*子字体*/
        .head-font-color{
            color: #0D6EFD;
        }
        .head-font-family{
            font-family: 宋体,Serif;
        }
        .head-font-high:hover{
            text-shadow:0 0 10px #69e0ff,0 0 20px #69e0ff,0 0 40px #69e0ff;
        }

        /*父字体*/
        .tools-font-size{
            font-size: 20px;
        }
        /*子字体*/
        .tools-font-color{
            color: black;
        }
        .tools-font-family{
            font-family: 宋体,Serif;
        }
        .tools-font-high:hover{
            text-shadow:0 0 10px #FAF1AB,0 0 20px #FEF0A0,0 0 40px #F9F3DC;
            color: #301800;
        }
    </style>
</head>
<body>



<!--页首-->

<nav class="navbar navbar-expand-lg">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <div class="col gy-3 head-font-size">
                <svg xmlns="http://www.w3.org/2000/svg" width="52" height="52" fill="currentColor" class="bi bi-github" viewBox="0 0 16 16">
                    <path d="M8 0C3.58 0 0 3.58 0 8c0 3.54 2.29 6.53 5.47 7.59.4.07.55-.17.55-.38 0-.19-.01-.82-.01-1.49-2.01.37-2.53-.49-2.69-.94-.09-.23-.48-.94-.82-1.13-.28-.15-.68-.52-.01-.53.63-.01 1.08.58 1.23.82.72 1.21 1.87.87 2.33.66.07-.52.28-.87.51-1.07-1.78-.2-3.64-.89-3.64-3.95 0-.87.31-1.59.82-2.15-.08-.2-.36-1.02.08-2.12 0 0 .67-.21 2.2.82.64-.18 1.32-.27 2-.27.68 0 1.36.09 2 .27 1.53-1.04 2.2-.82 2.2-.82.44 1.1.16 1.92.08 2.12.51.56.82 1.27.82 2.15 0 3.07-1.87 3.75-3.65 3.95.29.25.54.73.54 1.48 0 1.07-.01 1.93-.01 2.2 0 .21.15.46.55.38A8.012 8.012 0 0 0 16 8c0-4.42-3.58-8-8-8z"/>
                </svg>
            </div>
        </a>
        <a class="navbar-brand" href="#">
            <div class="col gy-3">
                <div class="col text-nowrap head-font-size">
                    欢迎你，冒险者
                </div>
                <div class="col head-font-size">
                    duanshuheng.top
                </div>
            </div>
        </a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#yichu" aria-controls="yichu" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon head-font-size text-nowrap">展开</span>
        </button>
        <div class="collapse navbar-collapse" id="yichu">
            <form class="d-flex m-3">
                <input class="form-control me-2" type="search" placeholder="内容" aria-label="Search">
                <button class="btn btn-outline-success text-nowrap head-font-size" type="submit">搜索</button>
            </form>
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <div class="col head-font-size text-nowrap m-3" id="h1">
                        查看论坛
                    </div>
                </li>
                <li class="nav-item">
                    <div class="col head-font-size text-nowrap m-3" id="h2">
                        下载环境
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <div class="col head-font-size text-nowrap m-3" id="h3">
                        抽卡!
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <div class="col head-font-size text-nowrap m-3" id="h4">
                        书恒的过往作品
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <div class="col head-font-size text-nowrap m-3" id="h5">
                        看动漫
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <div class="col head-font-size text-nowrap m-3" id="h6">
                        开源项目
                    </div>
                </li>
<%--                <li class="nav-item align-items-center">--%>
<%--                    <div class="dropdown m-3">--%>
<%--                        <a class="btn dropdown-toggle head-font-size text-nowrap" href="#" role="button" id="My" data-bs-toggle="dropdown" aria-expanded="false" style="background-color: #368AA2">--%>
<%--                            <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">--%>
<%--                                <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>--%>
<%--                                <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>--%>
<%--                            </svg>--%>
<%--                            我的--%>
<%--                        </a>--%>

<%--                        <ul class="dropdown-menu" aria-labelledby="My">--%>
<%--                            <a class="dropdown-item" href="#">--%>
<%--                                <svg xmlns="http://www.w3.org/2000/svg" width="26" height="26" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">--%>
<%--                                    <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>--%>
<%--                                </svg>--%>
<%--                                个人资料--%>
<%--                            </a>--%>

<%--                            <a class="dropdown-item" href="#">--%>
<%--                                <svg xmlns="http://www.w3.org/2000/svg" width="26" height="26" fill="currentColor" class="bi bi-book-half" viewBox="0 0 16 16">--%>
<%--                                    <path d="M8.5 2.687c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492V2.687zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783z"/>--%>
<%--                                </svg>--%>
<%--                                我的创作--%>
<%--                            </a>--%>
<%--                            <a class="dropdown-item" href="#">--%>
<%--                                <svg xmlns="http://www.w3.org/2000/svg" width="26" height="26" fill="currentColor" class="bi bi-people-fill" viewBox="0 0 16 16">--%>
<%--                                    <path d="M7 14s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1H7zm4-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>--%>
<%--                                    <path fill-rule="evenodd" d="M5.216 14A2.238 2.238 0 0 1 5 13c0-1.355.68-2.75 1.936-3.72A6.325 6.325 0 0 0 5 9c-4 0-5 3-5 4s1 1 1 1h4.216z"/>--%>
<%--                                    <path d="M4.5 8a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5z"/>--%>
<%--                                </svg>--%>
<%--                                好友--%>
<%--                            </a>--%>
<%--                            <li><hr class="dropdown-divider"></li>--%>
<%--                            <li><a class="dropdown-item" href="#">--%>
<%--                                <svg xmlns="http://www.w3.org/2000/svg" width="26" height="26" fill="currentColor" class="bi bi-mortarboard-fill" viewBox="0 0 16 16">--%>
<%--                                    <path d="M8.211 2.047a.5.5 0 0 0-.422 0l-7.5 3.5a.5.5 0 0 0 .025.917l7.5 3a.5.5 0 0 0 .372 0L14 7.14V13a1 1 0 0 0-1 1v2h3v-2a1 1 0 0 0-1-1V6.739l.686-.275a.5.5 0 0 0 .025-.917l-7.5-3.5Z"/>--%>
<%--                                    <path d="M4.176 9.032a.5.5 0 0 0-.656.327l-.5 1.7a.5.5 0 0 0 .294.605l4.5 1.8a.5.5 0 0 0 .372 0l4.5-1.8a.5.5 0 0 0 .294-.605l-.5-1.7a.5.5 0 0 0-.656-.327L8 10.466 4.176 9.032Z"/>--%>
<%--                                </svg>--%>
<%--                                礼遇--%>
<%--                            </a></li>--%>
<%--                            <li><hr class="dropdown-divider"></li>--%>
<%--                            <li><a class="dropdown-item" href="#">--%>
<%--                                <svg xmlns="http://www.w3.org/2000/svg" width="26" height="26" fill="currentColor" class="bi bi-wrench" viewBox="0 0 16 16">--%>
<%--                                    <path d="M.102 2.223A3.004 3.004 0 0 0 3.78 5.897l6.341 6.252A3.003 3.003 0 0 0 13 16a3 3 0 1 0-.851-5.878L5.897 3.781A3.004 3.004 0 0 0 2.223.1l2.141 2.142L4 4l-1.757.364L.102 2.223zm13.37 9.019.528.026.287.445.445.287.026.529L15 13l-.242.471-.026.529-.445.287-.287.445-.529.026L13 15l-.471-.242-.529-.026-.287-.445-.445-.287-.026-.529L11 13l.242-.471.026-.529.445-.287.287-.445.529-.026L13 11l.471.242z"/>--%>
<%--                                </svg>--%>
<%--                                修改密码--%>
<%--                            </a></li>--%>
<%--                            <li><a class="dropdown-item" href="#">--%>
<%--                                <svg xmlns="http://www.w3.org/2000/svg" width="26" height="26" fill="currentColor" class="bi bi-box-arrow-right" viewBox="0 0 16 16">--%>
<%--                                    <path fill-rule="evenodd" d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"/>--%>
<%--                                    <path fill-rule="evenodd" d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>--%>
<%--                                </svg>--%>
<%--                                退出登录--%>
<%--                            </a></li>--%>
<%--                        </ul>--%>
<%--                    </div>--%>
<%--                </li>--%>
            </ul>
        </div>
    </div>
</nav>

<!--主页面-->
<div class="container-fluid">
    <!--页中-->
    <div class="row">

        <div class="col-2">
            <!--选择功能-->
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <div class="row tools-font-size">

                    <div class="col-1">
                        <svg xmlns="http://www.w3.org/2000/svg" width="15" height="15" fill="currentColor" class="bi bi-diamond-half" viewBox="0 0 16 16">
                            <path d="M9.05.435c-.58-.58-1.52-.58-2.1 0L.436 6.95c-.58.58-.58 1.519 0 2.098l6.516 6.516c.58.58 1.519.58 2.098 0l6.516-6.516c.58-.58.58-1.519 0-2.098L9.05.435zM8 .989c.127 0 .253.049.35.145l6.516 6.516a.495.495 0 0 1 0 .7L8.35 14.866a.493.493 0 0 1-.35.145V.989z"/>
                        </svg>
                    </div>

                    <%
                        User user= (User) request.getAttribute("Appellation");
                        if(user==null){
                    %>
                    <div class="col-9 text-nowrap" data-bs-toggle="modal" data-bs-target="#loding">
                        登录
                    </div>
                    <%
                    }else{
                    %>
                    <input class="col-9 text-nowrap" id="appellation" readonly="readonly" value="<%=user.getUser()%>" style="border: 0">
                    <%
                        }
                    %>

                </div>
                <div class="row tools-font-size">
                    <div class="col-1">
                        <svg xmlns="http://www.w3.org/2000/svg" width="15" height="15" fill="currentColor" class="bi bi-diamond-half" viewBox="0 0 16 16">
                            <path d="M9.05.435c-.58-.58-1.52-.58-2.1 0L.436 6.95c-.58.58-.58 1.519 0 2.098l6.516 6.516c.58.58 1.519.58 2.098 0l6.516-6.516c.58-.58.58-1.519 0-2.098L9.05.435zM8 .989c.127 0 .253.049.35.145l6.516 6.516a.495.495 0 0 1 0 .7L8.35 14.866a.493.493 0 0 1-.35.145V.989z"/>
                        </svg>
                    </div>
                    <div class="col-9 text-nowrap" data-bs-toggle="modal" data-bs-target="#regist">
                        注册
                    </div>

                </div>
                <div class="row tools-font-size">
                    <div class="col-1">
                        <svg xmlns="http://www.w3.org/2000/svg" width="15" height="15" fill="currentColor" class="bi bi-diamond-half" viewBox="0 0 16 16">
                            <path d="M9.05.435c-.58-.58-1.52-.58-2.1 0L.436 6.95c-.58.58-.58 1.519 0 2.098l6.516 6.516c.58.58 1.519.58 2.098 0l6.516-6.516c.58-.58.58-1.519 0-2.098L9.05.435zM8 .989c.127 0 .253.049.35.145l6.516 6.516a.495.495 0 0 1 0 .7L8.35 14.866a.493.493 0 0 1-.35.145V.989z"/>
                        </svg>
                    </div>
                    <div class="col-9 gy-1 text-nowrap">
                        认证
                    </div>

                </div>
            </ul>

        </div>
        <div class="col-8" id="show">
            <iframe id="talk" width="100%" height="1000px" src="gettalk.servlet"></iframe>
        </div>

    </div>




    <!-- 登录 -->
    <div class="modal fade" id="loding" tabindex="-1" aria-labelledby="lodingLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <form method="post" action="loding.servlet">
                    <div class="modal-header">
                        <h5 class="modal-title" id="lodingLabel" style="font-size: 30px;font-family: 宋体,serif">登录账号</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>


                    <div class="modal-body">

                        <div class="mb-3">
                            <label for="lodinguser" class="form-label">账号登录</label>
                            <input name="user" class="form-control" id="lodinguser" aria-describedby="emailHelp">
                            <div id="emailHelp" class="form-text">请登录您的账号</div>
                        </div>
                        <div class="mb-3">
                            <label for="lodingpass" class="form-label">密码</label>
                            <input name="pass" type="password" class="form-control" id="lodingpass">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <div class="d-grid gap-2 col-5 mx-auto">
                            <button type="submit" class="btn btn-outline-success">登录</button>
                        </div>
                        <div class="d-grid gap-2 col-5 mx-auto">
                            <button type="button" class="btn btn-outline-dark" data-bs-dismiss="modal">取消</button>
                        </div>


                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- 注册 -->
    <div class="modal fade" id="regist" tabindex="-1" aria-labelledby="registLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <form method="post" action="regist.min.servlet" onsubmit="return registcheck()">
                    <div class="modal-header">
                        <h5 class="modal-title" id="registLabel" style="font-size: 30px;font-family: 宋体,serif">你好，新的冒险者</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>


                    <div class="modal-body">

                        <div class="mb-3">
                            <label for="registuser" class="form-label">注册账号</label>
                            <input name="user" class="form-control" id="registuser" aria-describedby="userHelp">
                            <div id="userhelp" class="form-text">请输入30位以内的用户名</div>
                        </div>
                        <div class="mb-3">
                            <label for="registapp" class="form-label">昵称</label>
                            <input class="form-control" id="registapp" name="appellation">
                            <div id="apphelp" class="form-text color-red"></div>
                        </div>
                        <div class="mb-3">
                            <label for="registpass" class="form-label">密码</label>
                            <input name="pass" type="password" class="form-control" id="registpass">
                            <div id="passhelp" class="form-text color-red"></div>
                        </div>
                        <div class="mb-3">
                            <label for="registpass2" class="form-label">确认密码</label>
                            <input type="password" class="form-control" id="registpass2">
                            <div id="pass2help" class="form-text color-red"></div>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <div class="d-grid gap-2 col-5 mx-auto">
                            <button type="submit" class="btn btn-outline-success" id="registbtn">注册</button>
                        </div>
                        <div class="d-grid gap-2 col-5 mx-auto">
                            <button type="button" class="btn btn-outline-dark" data-bs-dismiss="modal">取消</button>
                        </div>


                    </div>
                </form>
            </div>
        </div>
    </div>


</div>

<!--页尾-->
<div class="container-fluid">
    <div id="end">苏ICP备2022001065号-1</div>
</div>



</body>


<script>

    <!--遮罩层-->


    <!--切换页面-->
    $("#h1").on("click",function (){
        $("#show").html('<iframe id="talk" width="100%" height="1000px" src="gettalk.servlet"></iframe>');
    });
    $("#h2").on("click",function (){
        $("#show").html('<iframe id="talk" width="100%" height="1000px" src="Down.jsp"</iframe>');
    });
    $("#h3").on("click",function (){
        $("#show").html('<iframe id="talk" width="2100px" height="1100px" src="vio/ck.jsp"</iframe>');
    });
    $("#h4").on("click",function (){
        location.href="old/data.html";
    });
    $("#h5").on("click",function (){
        $("#show").html('<iframe id="talk" width="100%" height="1000px" src="dongman.jsp"</iframe>');
    });
    $("#h6").on("click",function (){
        $("#show").html('<iframe id="talk" width="100%" height="1000px" src="kaiyuan.jsp"</iframe>');
    });

    <!--表单验证-->
    function registcheck(){
        let user=$("#registuser").val();
        let app=$("#registapp").val();
        let pass1=$("#registpass").val();
        let pass2=$("#registpass2").val();

        if(user==""){
            $("#registuser").addClass("border-red")
            $("#userhelp").html("账号不能为空").css({"color":"red"});
            return false;
        }else{
            $("#registuser").removeClass("border-red")
            $("#userhelp").html("").css({"color":"black"});
        }
        if(app==""){
            $("#registapp").addClass("border-red");
            $("#apphelp").html("昵称不能为空");
            return false;
        }else{
            $("#registapp").removeClass("border-red");
            $("#apphelp").html("");
        }


        if(pass1==""){
            $("#registpass").addClass("border-red");
            $("#passhelp").html("密码不能为空");
            return false;
        }else{
            $("#registpass").removeClass("border-red");
            $("#passhelp").html("");
        }
        if(pass2==""){
            $("#registpass2").addClass("border-red");
            $("#pass2help").html("确认密码不能为空");
            return false;
        }else{
            $("#registpass2").removeClass("border-red");
            $("#pass2help").html("");
        }
        if(pass1!=pass2){
            $("#registpass").addClass("border-red");
            $("#registpass2").addClass("border-red");
            $("#pass2help").html("两次输入的密码不一样");
            return false;
        }else{
            $("#registpass").removeClass("border-red");
            $("#registpass2").removeClass("border-red");
            $("#pass2help").html("");
        }
        return true;
    }


    <!--ajax-->
    $("#registuser").blur(function (){
        var user=$(this).val();
        if(user==""){
            return;
        }
        $("#registbtn").addClass("disabled");
        $.ajax({
            url:"AjaxRegist.servlet",
            data:{"user":user},
            type:"post",
            success:function(message){
                if(message){
                    $("#userhelp").text("账号可用").css({"color":"black"});
                    $("#registbtn").removeClass("disabled");
                }else {
                    $("#userhelp").text("账号不可用").css({"color":"red"});
                }
            }
        });

    });


    <!--特效-->

    <!--特效-页面-->
    $(".head-font-size").addClass("head-font-color").addClass("head-font-family").addClass("head-font-high");
    $(".tools-font-size").addClass("tools-font-color").addClass("tools-font-family").addClass("tools-font-high");
    // $(".head-font-size").addClass("head-font-family").addClass("head-font-high");
    // $(".tools-font-size").addClass("tools-font-family").addClass("tools-font-high");

    // $(".navbar:first").css({"background-color": "#368AA2"})
    // $(".navbar:first").addClass("PiFu-jin");

    // $(".dropdown ul").css({"background-color": "white"});
    // $(".dropdown ul").addClass("PiFu-jin");
    // $("#My").addClass("PiFu-jin");

    <!--特效-页尾-->
    // $("#end").addClass("PiFu-jin").addClass("Page-end");
    $("#end").addClass("Page-end");


    <!--特效-动态-->
    $(".dropdown ul a")
        .css({"color":"#FDE8A0"})
        .css({"font-size":"20px"})
        .css({"font-family":"宋体"})
        .hover(
            function (){
                $(this).css({"color": "#white"});
            }
            ,
            function (){
                $(this).css({"color": "#FDE8A0"});
            }
        );

</script>

</html>

