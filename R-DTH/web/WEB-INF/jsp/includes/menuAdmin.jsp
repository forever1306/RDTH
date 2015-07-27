<%-- 
    Document   : menuAdmin
    Created on : Jun 14, 2015, 12:23:18 AM
    Author     : Minh-IT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<span class="mdl-layout-title">Welcome ${pageContext.request.userPrincipal.name}</span>
<nav class="mdl-navigation">
    <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/admin/packageManager.html">Package Manager</a>
    <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/admin/chanelManager.html">Chanel Manager</a>
    <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/admin/customerManager.html">Customer Manager</a>
    <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/admin/distributorManager.html">Distributor Manager</a>
    <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/admin/FAQManager.html">FAQ Manager</a>
    <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/admin/orderManager.html">Order Manager</a>
    <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/admin/feedbackManager.html">Feedback Manager</a>
    <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/admin/logout">Logout</a>
</nav>

