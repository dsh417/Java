
<%@ page import="java.util.List" %>
<%@ page import="entity.UserTalk" %>
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

</head>


<%--<!--遮罩层-->--%>
<%--<div id="box">--%>
<%--    <div>--%>

<%--    </div>--%>
<%--</div>--%>
<body>
<div style="width: 95%">
    <div class="row">
        <div class="card" style="width: 100%;">
            <div>论坛</div>
            <div class="card-body">
                <h5 class="card-title">留下您的留言</h5>
                <p class="card-text">关于抽卡的体验和想法请留下您宝贵的意见，这将对我们建设网站提供很大的帮助</p>
                <button type="button" class="btn btn-outline-dark"  data-bs-toggle="modal" data-bs-target="#mymessage">回复</button>
            </div>
        </div>

        <%
            List<UserTalk> talks= (List<UserTalk>) request.getAttribute("talk");
            if(talks!=null){
                for(UserTalk talk : talks){
        %>
        <div class="card" style="width: 100%;">
            <div><%=talk.getTid()%>楼</div>
            <div class="card-body">
                <h5 class="card-title"><%=talk.getAppellation()%></h5>
                <p class="card-text"><%=talk.getSome()%></p>
                <p class="card-text text-end"><%=talk.getTime()%></p>
            </div>
        </div>
        <%
                }
            }
        %>
    </div>
    <div class="modal fade" id="mymessage" tabindex="-1" aria-labelledby="mymessageLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">

                <div class="modal-header">
                    <h5 class="modal-title" id="mymessageLabel" style="font-size: 30px;font-family: 宋体,serif">篆刻留言</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>


                <div class="modal-body">

                    <div class="form-floating">
                        <textarea class="form-control" placeholder="Leave a comment here" id="input" style="height: 200px"></textarea>
                        <label for="input">落笔生花</label>
                    </div>

                </div>
                <div class="modal-footer">
                    <div class="d-grid gap-2 col-5 mx-auto">
                        <button type="button" class="btn btn-outline-success" id="addmassege">确定</button>
                    </div>
                    <div class="d-grid gap-2 col-5 mx-auto">
                        <button type="button" class="btn btn-outline-dark" data-bs-dismiss="modal">取消</button>
                    </div>


                </div>

            </div>
        </div>
    </div>


</div>

</body>
<%--<style>--%>
<%--    #box{--%>
<%--        position: fixed;--%>
<%--        top: 0;--%>
<%--        right: 0;--%>
<%--        bottom: 0;--%>
<%--        left: 0;--%>
<%--        background-color: rgba(221, 221, 221, 0.5);--%>
<%--    }--%>

<%--    #box div{--%>
<%--        width: 30%;--%>
<%--        height: 300px;--%>
<%--        position: absolute;--%>
<%--        top: 50%;--%>
<%--        left: 50%;--%>
<%--        -webkit-transform: translate(-50%, -50%);--%>
<%--        transform: translate(-50%, -50%);--%>
<%--        padding: 20px;--%>
<%--        background: #ffffff;--%>
<%--        border-radius: 10px;--%>
<%--        text-align: right;--%>
<%--    }--%>

<%--</style>--%>
<script>
    $("div").css({"font-family":"新宋体"});
    $("p").css({"font-family":"新宋体"});

    $("#addmassege").on("click",function (){
        var appellation=$("#appellation",parent.document).val();
        console.log(appellation);
        let some=$("#input").val();
        let date=new Date();
        let time=date.toLocaleString().toString();
        if(appellation==""||appellation==null){
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



        <%--location=encodeURI("message.servlet?appellation=${appellation}&some=${some}&time=${time}");--%>
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

