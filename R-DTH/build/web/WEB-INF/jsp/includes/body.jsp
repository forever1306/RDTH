<%-- 
    Document   : body
    Created on : Jun 13, 2015, 3:15:14 PM
    Author     : Minh-IT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
        <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <script src="https://storage.googleapis.com/code.getmdl.io/1.0.0/material.min.js"></script>
        <script src="http://cdn.jsdelivr.net/jquery.validation/1.14.0/jquery.validate.min.js"></script>        
        <link href='${pageContext.request.contextPath}/css/style.css' rel="stylesheet">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <link rel="stylesheet" href="https://storage.googleapis.com/code.getmdl.io/1.0.0/material.indigo-pink.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico">
        <!--        <script>
                    $(document).ready(function () {
                        $('.page-content').hide().show("drop", 1000);
                    })
                </script>-->
        <title>${title}</title>
    </head>
    <body>
        <fmt:setLocale value="en_US" scope="session"/>
        <!-- Always shows a header, even in smaller screens. -->
        <div class="mdl-layout mdl-js-layout mdl-layout--overlay-drawer-button">
            <header class="mdl-layout__header mdl-layout__header--waterfall">
                <div class="mdl-layout__header-row">
                    <!-- Title -->
                    <span class="mdl-layout-title">${title}</span>
                    <!-- Add spacer, to align navigation to the right -->
                    <div class="mdl-layout-spacer"></div>

                </div>
                <div class="mdl-layout__header-row">

                    <!-- Add spacer, to align navigation to the right -->
                    <div class="mdl-layout-spacer"></div>
                    <nav class="mdl-navigation">
                        <a class="mdl-navigation__link" href="${pageContext.request.contextPath}">Home</a>
                        <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/viewPackage.html">Package</a>
                        <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/register.html">Register</a>
                        <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/FAQViews.html">FAQ</a>
                        <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/aboutus.html">About us</a>
                    </nav>
                </div>
            </header>
            <div class="mdl-layout__drawer">
                <tiles:insertAttribute name="menuLeft" ignore="true"/>
            </div>
            <main class="mdl-layout__content">
                <div class="page-content">
                    <tiles:insertAttribute name="content" ignore="true"/>
                </div>
                <footer class="mdl-mega-footer">
                    <div class="mdl-mega-footer--middle-section">
                        <div class="mdl-mega-footer--drop-down-section">
                            <h1 class="mdl-mega-footer--heading">Features</h1>
                            <ul class="mdl-mega-footer--link-list">
                                <li><a href="${pageContext.request.contextPath}/about.html">About</a></li>
                                <li><a href="${pageContext.request.contextPath}/viewPackage.html">Pick Package</a></li>
                                <li><a href="${pageContext.request.contextPath}/register.html">Register</a></li>
                            </ul>
                        </div>
                        <div class="mdl-mega-footer--drop-down-section">
                            <h1 class="mdl-mega-footer--heading">FAQ</h1>
                            <ul class="mdl-mega-footer--link-list">
                                <li><a href="${pageContext.request.contextPath}/feedback.html">Feedback</a></li>
                            </ul>
                        </div>
                    </div>
                </footer>
            </main>

        </div>
    </body>
</html>
