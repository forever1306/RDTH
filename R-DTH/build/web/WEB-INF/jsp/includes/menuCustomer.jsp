<%-- 
    Document   : menuAdmin
    Created on : Jun 14, 2015, 12:23:18 AM
    Author     : Minh-IT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <span class="mdl-layout-title">Welcome ${pageContext.request.userPrincipal.name}</span>
        <nav class="mdl-navigation">
            <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/viewPackage.html">View Package</a>
            <c:if test="${not empty pageContext.request.userPrincipal}">
                <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/customer/packagesCustomer.html">My Packages</a>    
                <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/customer/payment.html">Payment</a>    
                <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/customer/changepassword.html">Change password</a>
                <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/customer/feedback.html">Feedback</a>
                <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/logout">Logout</a>
            </c:if>
            <c:if test="${empty pageContext.request.userPrincipal}">
                <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/customer/login.html">Login</a>
            </c:if>
        </nav>
    </body>
</html>
