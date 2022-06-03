<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="jquery/jquery-3.5.1.min.js"></script>
</head>
<body>
<div class="container">
    <h1>Mountain Star Zlatibor</h1>
    <p>Zlatibor is a mountain of exceptional beauty whose special geographical properties have made this mountain a real gem of western Serbia.</p>
    <a href="#">Learn more</a>
</div>

<div class="blank"></div>

<div class="container second">
    <div class="item">
        <div class="img img-first"></div>
        <div class="card">
            <h3>Rock climbing</h3>
            <p>The goal is to reach the summit of a formation or the endpoint of a usually pre-defined route without falling</p>
            <a href="#">Learn more</a>
        </div>
    </div>
    <div class="item">
        <div class="img img-second"></div>
        <div class="card">
            <h3>Caving</h3>
            <p>Exploring underground through networks of tunnels and passageways, which can be natural or artificial.</p>
            <a href="#">Learn more</a>
        </div>
    </div>
    <div class="item">
        <div class="img img-third"></div>
        <div class="card">
            <h3>Parachuting</h3>
            <p>Jumping from an aeroplane and falling through the air before opening your parachute.</p>
            <a href="#">Learn more</a>
        </div>
    </div>
</div>

<div class="blank"></div>
</body>
<style>
    @import url('https://fonts.googleapis.com/css2?family=Red+Hat+Text:wght@400;700&display=swap');

    :root{
        --color: #333;
    }

    body {
        font-family: 'Red Hat Text', sans-serif;
    }

    .container {
        text-align: center;
        color: var(--color);
        width: 100%;
        min-height: 100vh;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        background-image: url(https://images.unsplash.com/photo-1519120944692-1a8d8cfc107f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=872&q=80);
        background-size: cover;
        background-position: center;

        /*  this is where the magic happens:  */
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

    .blank,
    .other {
        width: 100%;
        min-height: 60vh;
        background-color: var(--color);
    }

    .second {
        background-image:url(https://images.unsplash.com/photo-1514496959998-c01c40915c5f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1740&q=80);
        background-attachment: fixed;
        height: 1200px;
    }

    h3 {
        font-weight: 700;
        font-size: 1.6rem;
        margin-top: 1em;
    }

    .card > a {
        margin-bottom: 2em;
    }

    .item {
        display: flex;
        max-width: 320px;
        background-color: white;;
        flex-direction: column;
        align-items: center;
        border-radius: .5em;
        -webkit-box-shadow: 0px 29px 38px -15px rgba(0,0,0,0.43);
        -moz-box-shadow: 0px 29px 38px -15px rgba(0,0,0,0.43);
        box-shadow: 0px 29px 38px -15px rgba(0,0,0,0.43);
    }

    .img {
        width: 90%;
        height: 200px;
        background-color: lightgrey;
        background-size: cover;
        background-position: center;
        margin-top: 20px;
        border-radius: .3em;;
    }

    .img-first {
        background-image: url(https://images.unsplash.com/photo-1522163182402-834f871fd851?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1606&q=80);
    }

    .img-second {
        background-image: url(https://images.unsplash.com/photo-1628746404106-4d3843b231b3?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8Y2F2aW5nfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=900&q=60);
    }

    .img-third {
        background-image: url(https://images.unsplash.com/photo-1632853073412-782bf0279d65?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80);
    }

    .second {
        flex-direction: row;
        gap: 1.6em;
    }

</style>
<script>

</script>
</html>
