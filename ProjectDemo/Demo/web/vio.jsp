<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="jquery/jquery-3.5.1.min.js"></script>
    <!--Bootstrap5-->
    <link href="bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <script src="bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</head>
<body>


<div class="container1">
    <h1> 月がきれい （月色真美）</h1>
    <p>恋爱，校园，青春</p>
    <a type="button" class="btn btn-lg btn-secondary" href="#show">立刻观看</a>

</div>

<div class="container">

    <a href="yuesezhenmei/y1.jsp" id="1" type="button" class="btn btn-outline-secondary">第1番</a>
    <a href="yuesezhenmei/y2.jsp" id="2" type="button" class="btn btn-outline-secondary">第2番</a>
    <a href="yuesezhenmei/y3.jsp" id="3" type="button" class="btn btn-outline-secondary">第3番</a>
    <a href="yuesezhenmei/y4.jsp" id="4" type="button" class="btn btn-outline-secondary">第4番</a>
    <a href="yuesezhenmei/y5.jsp" id="5" type="button" class="btn btn-outline-secondary">第5番</a>
    <a href="yuesezhenmei/y6.jsp" id="6" type="button" class="btn btn-outline-secondary">第6番</a>
    <a href="yuesezhenmei/y7.jsp" id="7" type="button" class="btn btn-outline-secondary">第7番</a>
    <a href="yuesezhenmei/y8.jsp" id="8" type="button" class="btn btn-outline-secondary">第8番</a>
    <a href="yuesezhenmei/y9.jsp" id="9" type="button" class="btn btn-outline-secondary">第9番</a>
    <a href="yuesezhenmei/y10.jsp" id="10" type="button" class="btn btn-outline-secondary">第10番</a>
    <a href="yuesezhenmei/y11.jsp" id="11" type="button" class="btn btn-outline-secondary">第11番</a>
    <a href="yuesezhenmei/y12.jsp" id="12" type="button" class="btn btn-outline-secondary">第12番</a>
</div>
<div id="show" style="height: 300px">

</div>
</body>
<style>

    :root{
        --color: #333;
    }

    body {
        font-family: 'Red Hat Text', sans-serif;
    }

    .container1 {
        text-align: center;
        color: var(--color);
        width: 100%;
        min-height: 100vh;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        background-image: url(jpg/yuese1.jpg);
        background-size: cover;
        background-position: center;
        background-attachment: fixed;
    }

    h1 {
        font-weight: 700;
        font-size: 3rem;
    }

    p {
        max-width: 52ch;
        line-height: 1.5;
        padding: 1em;
    }

    a {
        display: inline-block;
        padding: 1em 3.5em;
        background-color: var(--color);
        color: white;
        text-decoration: none;
        text-transform: uppercase;
        border-radius: 0.3em;
        font-weight: 700;
        letter-spacing: .5px;
        font-size: .875rem;
    }

    h3 {
        font-weight: 700;
        font-size: 1.6rem;
        margin-top: 1em;
    }

    .card > a {
        margin-bottom: 2em;
    }

</style>

</html>
