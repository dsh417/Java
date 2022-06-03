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

    <title>开源项目</title>


    <div class="accordion" id="accordionExample">
        <div class="accordion-item">
            <h2 class="accordion-header" id="headingOne">
                <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                    三层架构项目
                </button>
            </h2>
            <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                <div class="accordion-body">
                    <strong>以JDK17标准库和Tomcat10搭建的三层架构web项目，用于学习使用，有需求可下载。写于2022年4月28日22:27:36
                        <a type="button" class="btn btn-primary" id="down1">下载</a>
                    </strong>

                </div>
            </div>
        </div>
        <div class="accordion-item">
            <h2 class="accordion-header" id="headingTwo">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                    等待..
                </button>
            </h2>
            <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
                <div class="accordion-body">
                    <strong>等待..</strong>
                </div>
            </div>
        </div>
        <div class="accordion-item">
            <h2 class="accordion-header" id="headingThree">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                    等待..
                </button>
            </h2>
            <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
                <div class="accordion-body">
                    <strong>等待..</strong>
                </div>
            </div>
        </div>
    </div>



<script>

    $("#down1").on("click", function(){
        let att=parent.document.getElementById("appellation");
        location.href=encodeURI("kaiyuan.servlet?app=${att}");
        $
    });

    var down1="down/kaiyuan.zip";
    $("#down1").attr({"href":down1});


</script>


</head>
</html>