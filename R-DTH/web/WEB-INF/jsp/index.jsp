
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<style>
    .card-1.mdl-card {
        margin-left: 10%;
        width: 40%;
        display: inline-block;
    }
    .card-1> .mdl-card__title {
        color: #fff;
        height: 250px;
        background: url('${pageContext.request.contextPath}/css/images/vnplus.jpg') center / cover;
    }

    .card-1 > .mdl-card__menu {
        color: #fff;
    }

    .card-2.mdl-card {
        display: inline-block;
        width: 25%;
        margin-left: 1%;
        margin-top: 1%;
    }
    .card-2> .mdl-card__title {
        color: #fff;
        height: 250px;
        background: url('${pageContext.request.contextPath}/css/images/mtv.jpg') center / cover;
    }
    .card-2 > .mdl-card__menu {
        color: #fff;
    }

    .card-3.mdl-card {
        margin-left: 10%;
        margin-top: 10px;
        width: 66%;
        display: inline-block;
    }
    .card-3> .mdl-card__title {
        color: #fff;
        height: 250px;
        background: url('${pageContext.request.contextPath}/css/images/film3.jpg') center / cover;
    }

    .card-3 > .mdl-card__menu {
        color: #fff;
    }

    .card-5.mdl-card {
        margin-left: 10%;
        margin-top: 10px;
        width: 66%;
        display: inline-block;
    }
    .card-5> .mdl-card__title {
        color: #fff;
        height: 250px;
        background: url('${pageContext.request.contextPath}/css/images/banner4.jpg') center / cover;
    }

</style>
<!--Card 5-->
<div class="mdl-card mdl-shadow--2dp card-5">
    <div class="mdl-card__title">
        <h2 class="mdl-card__title-text">HD+</h2>
    </div>
    <div class="mdl-card__supporting-text">
        For those who don't have time to watch TV
    </div>
    <div class="mdl-card__actions mdl-card--border">
        <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
            Get Started
        </a>
    </div>

</div>
<!--END Card 5-->
<div class="mdl-card mdl-shadow--2dp card-1">
    <div class="mdl-card__title">
        <h2 class="mdl-card__title-text">VN Plus</h2>
    </div>
    <div class="mdl-card__supporting-text">
        For those who don't have time to watch TV
    </div>
    <div class="mdl-card__actions mdl-card--border">
        <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
            Get Started
        </a>
    </div>
    <div class="mdl-card__menu">
        <button class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect" id="mn">
            <i class="material-icons">share</i>
        </button>
        <ul class="mdl-menu mdl-menu--bottom-right mdl-js-menu mdl-js-ripple-effect"
            for="mn">
            <li class="mdl-menu__item">Facebook</li>
            <li class="mdl-menu__item">Twitter</li>
            <li class="mdl-menu__item">Zing vn</li>
        </ul>
    </div>
</div>
<div class="mdl-card mdl-shadow--2dp card-2">
    <div class="mdl-card__title">
        <h2 class="mdl-card__title-text">MTV</h2>
    </div>
    <div class="mdl-card__supporting-text">
        For those who don't have time to watch TV
    </div>
    <div class="mdl-card__actions mdl-card--border">
        <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
            Get Started
        </a>
    </div>
</div>

<div class="mdl-card mdl-shadow--2dp card-3">
    <div class="mdl-card__title">
        <h2 class="mdl-card__title-text">HD+</h2>
    </div>
    <div class="mdl-card__supporting-text">
        For those who don't have time to watch TV
    </div>
    <div class="mdl-card__actions mdl-card--border">
        <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
            Get Started
        </a>
    </div>
    <div class="btAdd">
        <button class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored addfeed" onclick="location='${pageContext.request.contextPath}/register.html'">
            <i class="material-icons">add</i>
        </button>
    </div>
</div>
