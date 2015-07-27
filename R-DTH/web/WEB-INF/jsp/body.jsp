<%-- 
    Document   : body
    Created on : Jun 13, 2015, 3:15:14 PM
    Author     : Minh-IT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="${pageContext.request.contextPath}/css/js/jquery-2.1.4.js"></script>
        <script src="${pageContext.request.contextPath}/css/js/jquery-ui.js"></script>
        <link href='${pageContext.request.contextPath}/css/style.css' rel="stylesheet">
        <link href='${pageContext.request.contextPath}/css/jquery-ui.css' rel="stylesheet">
        <!-- Material Design Lite -->
        <script src="https://storage.googleapis.com/code.getmdl.io/1.0.0/material.min.js"></script>
        <link rel="stylesheet" href="https://storage.googleapis.com/code.getmdl.io/1.0.0/material.indigo-pink.min.css">
        <!-- Material Design icon font -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <script>
            $(document).ready(function () {
                $('.viewmain').hide().show("puff", 1000);
            })
        </script>
        <title>${title}</title>
    </head>
    <body>

        <div class="head">
            <div class="logo">
                <img src="${pageContext.request.contextPath}/css/images/dishtv.png"/>
            </div>
            <p>
                <img src="${pageContext.request.contextPath}/css/images/logocenter.png"/>
            </p>
        </div>
        <ul class="allItem">
            <li class="item">
                <a href="${pageContext.request.contextPath}">Home</a>
            </li>

            <li class="item">
                <a href="${pageContext.request.contextPath}/viewPackage.html">Package</a>
            </li>
            <li class="item">
                <a href="${pageContext.request.contextPath}/register.html">Register</a>
            </li>
            <li class="item">
                <a href="${pageContext.request.contextPath}/FAQViews.html">FAQ</a>
            </li>
            <li class="item">
                <a href="#">About us</a>
            </li>
        </ul>

        <div class="menuleft">
            <tiles:insertAttribute name="menuLeft" ignore="true"></tiles:insertAttribute>
            </div>
            <div class="viewmain">
                <div class="bodyView">
                <tiles:insertAttribute name="content" ignore="true"></tiles:insertAttribute>
            </div>
        </div>
        <div id="footer">
            <div class="textfooter">
                <p style="color: #b200ff">Call us book</p>
                <p style="font-family: 'Times New Roman'; font-size: 0.8em;">19001999</p>
            </div>
            <div class="textfooter">
                <p style="color: #b200ff">Find us</p>
                <p style="font-family: 'Times New Roman'; font-size: 0.8em;">19 Nguyen Trai-Thanh Xuan-Ha Noi</p>
            </div>
            <div class="textfooter">
                <p style="color: #b200ff">Email us</p>
                <p style="font-family: 'Times New Roman'; font-size: 0.8em;">info@minh-it.com</p>
            </div>
        </div>

    </body>
</html>
