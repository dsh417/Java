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

    <title>论坛</title>

    <script>
        var down1="down/idea.zip";
        var down2="down/jdk-17_windows-x64_bin.exe";
        var down3="down/apache-tomcat-10.0.14.zip";
        var down4="down/mysql-installer-web-community-8.0.27.1.msi";
        var down5="down/mysql-connector-java-8.0.27.jar";
        var down6="down/bootstrap5.zip";
        var down7="down/jquery-3.5.1.min.js.zip";
        var down8="down/EditPlus.zip";
        var down9="down/InstantEyedropper.zip";
        var down10="down/must.zip";
        var down11="down/all.zip";
    </script>
</head>

<body>

<nav id="navbar-example2" class="navbar navbar-light bg-light px-3">
    <a class="navbar-brand" href="#">快速搭建环境</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#tools" aria-controls="tools" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon tools-font-size text-nowrap"></span>
    </button>
    <div class="collapse navbar-collapse" id="tools">
        <ul class="nav nav-pills">
            <li class="nav-item">
                <a class="nav-link" href="#down1">开发环境</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#down6">依赖库</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#down8">小工具</a>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">快速下载</a>
                <ul class="dropdown-menu dropdown-menu-end">
                    <li><a class="dropdown-item" href="#down1">idea 2021</a></li>
                    <li><a class="dropdown-item" href="#down2">JDK 1.7.1</a></li>
                    <li><a class="dropdown-item" href="#down3">Tomcat 10</a></li>
                    <li><a class="dropdown-item" href="#down4">MySQL 8.26.1</a></li>
                    <li><hr class="dropdown-divider"></li>
                    <li><a class="dropdown-item" href="#down5">MySQL 驱动包</a></li>
                    <li><hr class="dropdown-divider"></li>
                    <li><a class="dropdown-item" href="#down6">Bootstrap 5.1</a></li>
                    <li><a class="dropdown-item" href="#down7">Jquery 3.5.1</a></li>
                    <li><hr class="dropdown-divider"></li>
                    <li><a class="dropdown-item" href="#down8">Firefox(火狐浏览器)</a></li>
                    <li><a class="dropdown-item" href="#down9">Edit Pluas</a></li>
                    <li><a class="dropdown-item" href="#down10">InstantEyedropper</a></li>
                    <li><hr class="dropdown-divider"></li>
                    <li><a class="dropdown-item" href="#down11">下载必要环境</a></li>
                    <li><hr class="dropdown-divider"></li>
                    <li><a class="dropdown-item" href="#down12">全部下载</a></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>
<div data-bs-spy="scroll" data-bs-target="#navbar-example2" data-bs-offset="0" tabindex="0">

    <div class="card text-center border-success m-md-3">
        <div class="row">
            <div class="col-2">
                <img src="DownImg/idea.png" alt="加载失败" width="128" height="128">
            </div>
            <div class="col-8">
                <div class=" card-body">
                    <h4 id="down1">IDE</h4>
                    <h5 class="card-title">IDEA 2021</h5>
                    <p class="card-text">使用idea2021进行java开发，解压后即可运行。</p>
                </div>
            </div>
            <div class="col">
                <a href="#" id="d1" class="btn btn-success position-absolute top-50 end-0 translate-middle-y" style="border-radius: 20px">下载idea</a>
            </div>
        </div>
    </div>
    <div class="card text-center border-success m-md-3">
        <div class="row">
            <div class="col-2">
                <img src="DownImg/java.png" alt="加载失败" width="128" height="128">
            </div>
            <div class="col-8">
                <div class=" card-body">
                    <h4 id="down2">JKD</h4>
                    <h5 class="card-title">JDK 17</h5>
                    <p class="card-text">使用标准库java17进行开发，如果您之前使用的是其他版本的JDK，请不要忘记在IDE中更换版本</p>
                </div>
            </div>
            <div class="col">
                <a href="#" id="d2" class="btn btn-success position-absolute top-50 end-0 translate-middle-y" style="border-radius: 20px">下载JDK17</a>
            </div>
        </div>
    </div>
    <div class="card text-center border-success m-md-3">
        <div class="row">
            <div class="col-2">
                <img src="DownImg/tomcat.png" alt="加载失败" width="128" height="91">
            </div>
            <div class="col-8">
                <div class=" card-body">
                    <h4 id="down3">服务器</h4>
                    <h5 class="card-title">Tomcat 10</h5>
                    <p class="card-text">使用Tomcat 10进行开发，使用时要导入其lib下server包</p>
                </div>
            </div>
            <div class="col">
                <a href="#" id="d3" class="btn btn-success position-absolute top-50 end-0 translate-middle-y" style="border-radius: 20px">Tomcat 10</a>
            </div>
        </div>
    </div>
    <div class="card text-center border-success m-md-3">
        <div class="row">
            <div class="col-2">
                <img src="DownImg/mysql.png" alt="加载失败" width="192" height="128">
            </div>
            <div class="col-8">
                <div class=" card-body">
                    <h4 id="down4">数据库</h4>
                    <h5 class="card-title">MySQL 8.0.27</h5>
                    <p class="card-text">使用关系型数据库MySQL开发，这里提供Windows的安装软件</p>
                </div>
            </div>
            <div class="col">
                <a href="#" id="d4" class="btn btn-success position-absolute top-50 end-0 translate-middle-y" style="border-radius: 20px">下载MySQL 8</a>
            </div>
        </div>
    </div>

    <div class="card text-center border-success m-md-3">
        <div class="row">
            <div class="col-2">
                <img src="DownImg/mysql.png" alt="加载失败" width="192" height="128">
            </div>
            <div class="col-8">
                <div class=" card-body">
                    <h4 id="down5">MySQL驱动</h4>
                    <h5 class="card-title">mysql-connector-java-8.0.27</h5>
                    <p class="card-text">这里提供java的mysql驱动程序，导入到工程中即可</p>
                </div>
            </div>
            <div class="col">
                <a href="#" id="d5" class="btn btn-success position-absolute top-50 end-0 translate-middle-y" style="border-radius: 20px">下载MySQL驱动</a>
            </div>
        </div>
    </div>
    <div class="card text-center border-primary m-md-3">
        <div class="row">
            <div class="col-2">
                <img class="overflow-scroll" src="DownImg/Bootstrap.png" alt="加载失败" width="198" height="256">
            </div>
            <div class="col-8">
                <div class=" card-body">
                    <h4 id="down6">Bootstrap 5框架</h4>
                    <h5 class="card-title">Bootstrap 5.1.3</h5>
                    <p class="card-text">前端大量使用Bootstrap进行开发，将下列代码粘贴到Head标签内即可使用，建议下载后本地导入</p>
                    <div class="input-group mb-3">
                        <button class="btn btn-outline-secondary" type="button" onclick="copyUrl1()">复制</button>
                        <input type="text" value='<meta charset="utf-8"><meta name="viewport" content="width=device-width, initial-scale=1">'
                               class="form-control" placeholder="" id="bootstrap1" aria-label="Example text with button addon" aria-describedby="button-addon1">
                    </div>
                    <div class="toast">
                        <div class="toast-header">
                            <strong class="me-auto">复制成功1/2</strong>
                            <button type="button" class="btn-close" data-bs-dismiss="toast"></button>
                        </div>
                        <div class="toast-body">
                            <h5>粘贴进网页Head标签内即可使用</h5>
                        </div>
                    </div>
                    <div class="input-group mb-3">
                        <button class="btn btn-outline-secondary" type="button" onclick="copyUrl2()">复制</button>
                        <input type="text" value='<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rTTiRUKnSWaDu2FjhzWFl8/JuUZMlplyWE/djenb2LoKqkgLGfEGfSrL7XDLoB1M" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-Nj1D6pu2WnJojj+67GiU9ZFNwbl7bUWX5Kj5MS22C8bGjllemM9pvQyvj14zJb58" crossorigin="anonymous"></script>'
                               class="form-control" placeholder="" id="bootstrap2"  aria-label="Example text with button addon" aria-describedby="button-addon1">
                    </div>
                    <div class="toast">
                        <div class="toast-header">
                            <strong class="me-auto">复制成功2/2</strong>
                            <button type="button" class="btn-close" data-bs-dismiss="toast"></button>
                        </div>
                        <div class="toast-body">
                            <h5>粘贴进网页Head标签内即可使用</h5>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col">
                <a href="#" id="d6" class="btn btn-primary position-absolute top-50 end-0 translate-middle-y" style="border-radius: 20px">下载Bootstrap5</a>
            </div>
        </div>
    </div>
    <div class="card text-center border-primary m-md-3">
        <div class="row">
            <div class="col-2 align-items-center">
                <img src="DownImg/jquery.png" alt="加载失败" width="225" height="128">
            </div>
            <div class="col-8">
                <div class=" card-body">
                    <h4 id="down7">Jquery</h4>
                    <h5 class="card-title">Jquery 3.5.1</h5>
                    <p class="card-text">Jquery在前端中依然很重要，将下列代码粘贴到Head标签内即可使用，建议下载后本地导入</p>
                    <div class="input-group mb-3">
                        <button class="btn btn-outline-secondary" type="button" onclick="copyUrl3()">复制</button>
                        <input type="text" value='<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>'
                               class="form-control" placeholder="" id="jquery" aria-label="Example text with button addon" aria-describedby="button-addon1">
                    </div>
                    <div class="toast">
                        <div class="toast-header">
                            <strong class="me-auto">复制成功</strong>
                            <button type="button" class="btn-close" data-bs-dismiss="toast"></button>
                        </div>
                        <div class="toast-body">
                            <h5>粘贴进网页Head标签内即可使用</h5>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col">
                <a href="#" id="d7" class="btn btn-primary position-absolute top-50 end-0 translate-middle-y" style="border-radius: 20px">下载Jquery3.5.1</a>
            </div>
        </div>
    </div>
    <div class="card text-center border-info m-md-3">
        <div class="row">
            <div class="col-2">
                <img src="DownImg/firefox.png" alt="加载失败" width="128" height="128">
            </div>
            <div class="col-8">
                <div class=" card-body">
                    <h4 id="down8">浏览器</h4>
                    <h5 class="card-title">FireFox</h5>
                    <p class="card-text">如果习惯中文查看器推荐使用FireFox，这里提供的链接是指向官网的</p>
                </div>
            </div>
            <div class="col">
                <a href="https://download-ssl.firefox.com.cn/releases-sha2/stub/official/zh-CN/Firefox-latest.exe" class="btn btn-info position-absolute top-50 end-0 translate-middle-y" style="border-radius: 20px">官网下载FireFox</a>
            </div>
        </div>
    </div>
    <div class="card text-center border-info m-md-3">
        <div class="row">
            <div class="col-2">
                <img src="DownImg/editpuls.png" alt="加载失败" width="200" height="128">
            </div>
            <div class="col-8">
                <div class=" card-body">
                    <h4 id="down9">文件编辑器</h4>
                    <h5 class="card-title">Edit Plus</h5>
                    <p class="card-text">这是一个轻量级、高效、简洁的文件编辑器，或许会给予你很多帮助</p>
                </div>
            </div>
            <div class="col">
                <a href="#" id="d8" class="btn btn-info position-absolute top-50 end-0 translate-middle-y" style="border-radius: 20px">下载Edit Plus</a>
            </div>
        </div>
    </div>
    <div class="card text-center border-info m-md-3">
        <div class="row">
            <div class="col-2">
                <img src="DownImg/InstantEyedropper.png" alt="加载失败" width="128" height="128">
            </div>
            <div class="col-8">
                <div class=" card-body">
                    <h4 id="down10">取色器</h4>
                    <h5 class="card-title">InstantEyedropper</h5>
                    <p class="card-text">这是一个轻量级、简洁的取色器，可以快速取到屏幕上任何格式的颜色代码。</p>
                </div>
            </div>
            <div class="col">
                <a href="#" id="d9" class="btn btn-info position-absolute top-50 end-0 translate-middle-y" style="border-radius: 20px">InstantEyedropper</a>
            </div>
        </div>
    </div>


    <div class="card text-center border-danger m-md-3">
        <div class="row">
            <div class="col-2">
            </div>
            <div class="col-8">
                <div class=" card-body">
                    <h4 id="down11">必要环境</h4>
                    <h5 class="card-title">快速在新的电脑上安装必须的环境</h5>
                    <p class="card-text">一键下载必要的环境，内容包括：IDEA 2021，JDK 17，Tomcat 10，MySQL 8，MySQL驱动，Bootstrap 5，Jquery 3.5</p>
                </div>
            </div>
            <div class="col">
                <a href="#" id="d10" class="btn btn-danger position-absolute top-50 end-0 translate-middle-y" style="border-radius: 20px">一键下载</a>
            </div>
        </div>
    </div>

    <div class="card text-center border-dark m-md-3">
        <div class="row">
            <div class="col-2">
            </div>
            <div class="col-8">
                <div class=" card-body">
                    <h4 id="down12">全部下载</h4>
                    <h5 class="card-title">在新的电脑上部署完整的开发环境</h5>
                    <p class="card-text">一键下载以上所有环境</p>
                </div>
            </div>
            <div class="col">
                <a href="#" id="d11" class="btn btn-dark position-absolute top-50 end-0 translate-middle-y" style="border-radius: 20px">全部下载</a>
            </div>
        </div>
    </div>
</div>



</body>

<script>
    <!--tip-->
    function copyUrl1()
    {
        var Url1=document.getElementById("bootstrap1");
        Url1.select();
        document.execCommand("Copy");
        let toastElList = [].slice.call($(".toast:eq(0)").select());
        let toastList = toastElList.map(function(toastEl) {
            return new bootstrap.Toast(toastEl)
        })
        toastList.forEach(toast => toast.show())
        setTimeout(function (){
            toastList.forEach(toast => toast.hide())
        },3000)
    }
    function copyUrl2()
    {
        var Url2=document.getElementById("bootstrap2");
        Url2.select();
        document.execCommand("Copy");
        let toastElList = [].slice.call($(".toast:eq(1)").select());
        let toastList = toastElList.map(function(toastEl) {
            return new bootstrap.Toast(toastEl)
        })
        toastList.forEach(toast => toast.show())
        setTimeout(function (){
            toastList.forEach(toast => toast.hide())
        },3000)
    }
    function copyUrl3()
    {
        var Url2=document.getElementById("jquery");
        Url2.select();
        document.execCommand("Copy");
        let toastElList = [].slice.call($(".toast:eq(2)").select());
        let toastList = toastElList.map(function(toastEl) {
            return new bootstrap.Toast(toastEl)
        })
        toastList.forEach(toast => toast.show())
        setTimeout(function (){
            toastList.forEach(toast => toast.hide())
        },3000)
    }


    <!--Down-->
    $("#d1").attr({"href":down1});
    $("#d2").attr({"href":down2});
    $("#d3").attr({"href":down3});
    $("#d4").attr({"href":down4});
    $("#d5").attr({"href":down5});
    $("#d6").attr({"href":down6});
    $("#d7").attr({"href":down7});
    $("#d8").attr({"href":down8});
    $("#d9").attr({"href":down9});
    $("#d10").attr({"href":down10});
    $("#d11").attr({"href":down11});




    $("div").css({"font-family":"新宋体"});
    $("p").css({"font-family":"新宋体"});

    $("#addmassege").on("click",function (){
        var appellation=$("#appellation",parent.document).val();
        console.log(appellation);
        let some=$("#input").val();
        let date=new Date();
        let time=date.toLocaleString().toString();
        if(appellation==""){
            alert("请登录后再回复");
            return;
        }

        if(some==""){
            $("#input").addClass("is-invalid");
            return;
        }
        $("#input").removeClass("is-invalid");

        if(some.length>1024){
            alert("回复过长，不能大于1024byte");
            return;
        }

        $.ajax({
            url:"message.servlet",
            data:{'appellation':appellation, 'some':some,'time':time},
            type:"post",
            success:function (){
                parent.document.getElementById("talk").setAttribute("src","gettalk.servlet");
                // parent.location.replace("loding.servlet");

            }
        });

        // parent.location.replace("loding.servlet");
    });

</script>
</html>

