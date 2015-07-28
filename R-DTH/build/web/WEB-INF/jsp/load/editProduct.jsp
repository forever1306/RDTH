<%-- 
    Document   : editProduct
    Created on : Jun 27, 2015, 2:18:50 PM
    Author     : Minh-IT
--%>

<script>
    componentHandler.upgradeAllRegistered();
</script>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form commandName="product" action="${pageContext.request.contextPath}/distributor/productManager/process.html" method="post">
    <form:hidden path="productId"/>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:input path="productName" cssClass="mdl-textfield__input" required="true"/>
        <label class="mdl-textfield__label" for="sp">Product Name</label>
    </div>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:input path="productPrice" cssClass="mdl-textfield__input" required="true"/>
        <label class="mdl-textfield__label" for="sp">Product Price</label>
    </div>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:input path="type" cssClass="mdl-textfield__input"  required="true" type="digits"/>
        <label class="mdl-textfield__label" for="sp">Product Type</label>
    </div>
    <form:hidden path="distributor.distributorId" />
    <p>
        <input type="submit" value="Update" name="action" class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent mdl-js-ripple-effect"/>
        <input type="submit" value="Add" name="action" class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent mdl-js-ripple-effect"/>
        <input type="submit" value="Delete" name="action" onclick="return confirm('Are you sure?');" class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent mdl-js-ripple-effect"/>
    </p>
</form:form>
