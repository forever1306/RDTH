<%-- 
    Document   : login
    Created on : Jun 12, 2015, 1:54:17 PM
    Author     : Minh-IT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="login">
    <div class="invalid">
        <span>${error}</span>
    </div>
    
    <div class="bodyLogin">
        <form action="${pageContext.request.contextPath}/distributor/loginProcess" method="post">
            <p>UserName:</p> 
            <input type="text" name="username"/><br/>
            <p>Password</p>
            <input type="password" name="password"/>
            <br/>
            <input type="submit" value="Login"/>
        </form>
    </div>
</div>

