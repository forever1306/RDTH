<%-- 
    Document   : editOrderProduct
    Created on : Jul 7, 2015, 2:09:50 PM
    Author     : Minh-IT
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script>
    componentHandler.upgradeAllRegistered();
</script>
<form:form commandName="req" action="${pageContext.request.contextPath}/distributor/orderProduct/process.html" method="post">
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <input type="text" name="seri" class="mdl-textfield__input"/>
        <label class="mdl-textfield__label">Serial</label>
    </div>
    <form:hidden path="id.productId"/>
    <form:hidden path="id.customerId"/>
    <form:hidden path="id.serial"/>
    <form:hidden path="price"/>
    <input type="submit" value="Update" class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent mdl-js-ripple-effect"/>
</form:form>
