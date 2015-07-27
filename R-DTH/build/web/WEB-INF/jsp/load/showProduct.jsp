<%-- 
    Document   : showProduct
    Created on : Jun 30, 2015, 3:27:16 PM
    Author     : Minh-IT
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>
    label{
        color: white;
    }
</style>
<form:form commandName="requirement">
    <form:radiobuttons path="product" items="${listProduct}" itemLabel="productName" itemValue="productId"/>
</form:form>
