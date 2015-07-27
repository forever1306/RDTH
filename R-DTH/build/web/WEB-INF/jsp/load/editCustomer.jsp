<%-- 
    Document   : editCustomer
    Created on : Jun 14, 2015, 8:02:48 PM
    Author     : Minh-IT
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script>
    componentHandler.upgradeAllRegistered();
</script>
<form:form action="${pageContext.request.contextPath}/admin/customerManager/process.html" commandName="customer" method="post">
    <form:hidden path="customerId"/>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:input path="cusName" readonly="true" cssClass="mdl-textfield__input" />
        <label class="mdl-textfield__label" for="sp">Customer Name</label>
    </div>
    <br/>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:password path="password" cssClass="mdl-textfield__input" showPassword="true"/>
        <label class="mdl-textfield__label" for="sp">Password</label>
    </div>
    <br/>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:textarea path="address" readonly="true" cssClass="mdl-textfield__input"/>
        <label class="mdl-textfield__label" for="sp">Address</label>
    </div>
    <p>Status</p>
    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="sttActive">
        <form:radiobutton path="status" id="sttActive" cssClass="mdl-radio__button" value="1" />
        <span class="mdl-radio__label">Active</span>
    </label>
    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="sttNonActive">
        <form:radiobutton path="status" id="sttNonActive" cssClass="mdl-radio__button" value="0" />
        <span class="mdl-radio__label">Non-Active</span>
    </label>

    <hr/>
    <p>
        <input type="submit" value="Update" name="action"  class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent mdl-js-ripple-effect"/>
        <input type="submit" value="Delete" name="action"  class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent mdl-js-ripple-effect" onclick="return confirm('Are you sure?');"/>
    </p>
</form:form>
