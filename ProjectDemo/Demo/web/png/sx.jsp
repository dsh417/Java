<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/1/18
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--Bootstrap5-->
    <link href="../bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <script src="../bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>

    <!--Jquery-->
    <script src="../jquery/jquery-3.5.1.min.js"></script>

    <!--字体-->
    <link href="../font/font.css" rel="stylesheet" crossorigin="anonymous">

    <!--图片-->
    <link href="../png/png.css" rel="stylesheet" crossorigin="anonymous">
    <title></title>
</head>
<style>
    .card-1{
        width: 9%;
        height: 70%;
        border-radius: 100px;
        padding: 0;
        background:#adb5bd;
        position: absolute;
    }
    .page{
        height: 1000px;
        width: 2000px;
        background: #2c3034;
        padding-top: 5%;
        padding-bottom: 5%;
        padding-left: 0.5%;
        padding-right: 0.5%;
    }
</style>
<body>

<div class="page" id="cj">
    <div class="card-1" id="c0"></div>
    <div class="card-1" id="c1"></div>
    <div class="card-1" id="c2"></div>
    <div class="card-1" id="c3"></div>
    <div class="card-1" id="c4"></div>
    <div class="card-1" id="c5"></div>
    <div class="card-1" id="c6"></div>
    <div class="card-1" id="c7"></div>
    <div class="card-1" id="c8"></div>
    <div class="card-1" id="c9"></div>
</div>


</body>
    <script>
        var len_card_col=200;
        var len_card_move=400;
        var CardID=0;

        for (let i = 0; i < 10; i++) {
            let domid="c"+i;
            let dom=document.getElementById(domid);
            let lenINT=(i*len_card_col)+len_card_move;
            dom.style.marginLeft=lenINT + "px";
            dom.style.opacity='0.0';
        }


        function AddIllustrationOne(dom,n){
            switch (n){
                case 1:{
                    dom.innerHTML+="<div style='padding:35%;position: absolute;margin-top: -300px;'><img style='width: 100%;margin-left: -31%;position: absolute' alt='加载失败' src='ShuXing/feng.png'/></div>";
                    break;
                }
                case 2:{
                    dom.innerHTML+="<div style='padding:35%;position: absolute;margin-top: -300px;'><img style='width: 100%;margin-left: -31%;position: absolute' alt='加载失败' src='ShuXing/feng.png'/></div>";
                    break;
                }
                    case 3:{
                    dom.innerHTML+="<div style='padding:35%;position: absolute;margin-top: -300px;'><img style='width: 100%;margin-left: -31%;position: absolute' alt='加载失败' src='ShuXing/feng.png'/></div>";
                    break;
                }
                case 4:{
                    dom.innerHTML+="<div style='padding:35%;position: absolute;margin-top: -300px;'><img style='width: 100%;margin-left: -31%;position: absolute' alt='加载失败' src='ShuXing/feng.png'/></div>";
                    break;
                }
                case 5:{
                    dom.innerHTML+="<div style='padding:35%;position: absolute;margin-top: -300px;'><img style='width: 100%;margin-left: -31%;position: absolute' alt='加载失败' src='ShuXing/feng.png'/></div>";
                    break;
                }
                case 6:{
                    dom.innerHTML+="<div style='padding:35%;position: absolute;margin-top: -300px;'><img style='width: 100%;margin-left: -31%;position: absolute' alt='加载失败' src='ShuXing/feng.png'/></div>";
                    break;
                }
            }

        }
        function AddIllustrationTwo(dom){
            dom.innerHTML+="<div style='margin-top: 210%;height: 20%;padding: 10%'><img style='width: 100%' src='TouXiang/ls.png' alt='加载失败'/></div>";
            dom.innerHTML+="<div style='margin-top: 10%;height: 20%;padding: 10%'><img style='width: 100%' src='TouXiang/ddly.png' alt='加载失败'/></div>";
        }
        function AddIllustrationThree(dom){
            dom.innerHTML+="<svg style=\"color: #FFCB36;position: absolute;margin-top: 365%;margin-left: -95%;\" xmlns=\"http://www.w3.org/2000/svg\" width=\"36\" height=\"36\" fill=\"currentColor\" class=\"bi bi-star-fill\" viewBox=\"0 0 16 16\"> <path d=\"M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z\"/> </svg>"
            dom.innerHTML+="<svg style=\"color: #FFCB36;position: absolute;margin-top: 365%;margin-left: -75%;\" xmlns=\"http://www.w3.org/2000/svg\" width=\"36\" height=\"36\" fill=\"currentColor\" class=\"bi bi-star-fill\" viewBox=\"0 0 16 16\"> <path d=\"M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z\"/> </svg>"
            dom.innerHTML+="<svg style=\"color: #FFCB36;position: absolute;margin-top: 365%;margin-left: -55%;\" xmlns=\"http://www.w3.org/2000/svg\" width=\"36\" height=\"36\" fill=\"currentColor\" class=\"bi bi-star-fill\" viewBox=\"0 0 16 16\"> <path d=\"M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z\"/> </svg>"
            dom.innerHTML+="<svg style=\"color: #FFCB36;position: absolute;margin-top: 365%;margin-left: -35%;\" xmlns=\"http://www.w3.org/2000/svg\" width=\"36\" height=\"36\" fill=\"currentColor\" class=\"bi bi-star-fill\" viewBox=\"0 0 16 16\"> <path d=\"M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z\"/> </svg>"
            dom.innerHTML+="<svg style=\"color: #FFCB36;position: absolute;margin-top: 365%;margin-left: -15%;\" xmlns=\"http://www.w3.org/2000/svg\" width=\"36\" height=\"36\" fill=\"currentColor\" class=\"bi bi-star-fill\" viewBox=\"0 0 16 16\"> <path d=\"M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z\"/> </svg>"

<%--            <%--%>
<%--                for (int i = 0; i < 5; i++) {--%>
<%--            %>--%>
<%--                     dom.innerHTML+="<svg style=\"color: #FFCB36;position: absolute;margin-top: 365%;margin-left: -100%;\" xmlns=\"http://www.w3.org/2000/svg\" width=\"36\" height=\"36\" fill=\"currentColor\" class=\"bi bi-star-fill\" viewBox=\"0 0 16 16\"> <path d=\"M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z\"/> </svg>"--%>
<%--                <%--%>
<%--                    }--%>
<%--                %>--%>
        }


        function AddLiHui(dom){
            dom.innerHTML+="<img style='padding: 5px;border-radius: 100px;opacity:0.7;object-fit: cover;width: 180px;height: 770px' src='LiHui/wd.png'  alt='加载失败'/>";
        }

        function AddOPA(dom){
            let opa=parseFloat(dom.style.opacity)+0.02;
            if(dom.id==='c1'){
                console.log(opa);
            }
            if(opa>=0.0 && opa<=1.0){
                dom.style.opacity=opa.toString();
            }else {
                dom.style.opacity='1.00';
            }

        }

        function MoveSmall(dom,len){
            let long=parseInt(dom.style.marginLeft.toString());
            long=long-len;
            dom.style.marginLeft=(long+'px');
        }

        function Move(dom){
            let temp=0;
            let MoveTime=setInterval(
                function (){
                    let len;
                    if(temp<10){
                        len=15;
                    }else{
                        if(temp<40){
                            len=8;
                        }else {
                            len=1;
                        }
                    }

                    AddOPA(dom);
                    MoveSmall(dom,len);
                    temp++;
                    if(temp>=50){
                        clearInterval(MoveTime);
                    }
                }
                ,8
            )
        }

        var ck=setInterval(
            function (){
                let domid="c"+CardID;
                let dom=document.getElementById(domid);
                AddLiHui(dom);
                AddIllustrationOne(dom,3);
                AddIllustrationThree(dom);
                // setTimeout(function (){
                //     AddIllustrationOne(dom,3);
                //     AddIllustrationThree(dom);
                // },1000)


                Move(dom);

                CardID++;
                if(CardID>=10){
                    clearInterval(ck);
                }
            }
            ,45)


    </script>
</html>
