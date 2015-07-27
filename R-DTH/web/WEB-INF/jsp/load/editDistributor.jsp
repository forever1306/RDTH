<%-- 
    Document   : editDistributor
    Created on : Jun 18, 2015, 11:31:58 AM
    Author     : Minh-IT
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script>
    componentHandler.upgradeAllRegistered();
</script>
<form:form commandName="distributor" action="${pageContext.request.contextPath}/admin/distributorManager/process.html" method="post">
    <form:hidden path="distributorId"/>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:input path="disName" cssClass="mdl-textfield__input" id="sp" required="true"/>
        <label class="mdl-textfield__label" for="sp">Distributor Name</label>
    </div>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:textarea path="disAddress"  cssClass="mdl-textfield__input" id="sp" required="true"/>
        <label class="mdl-textfield__label" for="sp">Distributor Address</label>
    </div>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:input path="disEmail" cssClass="mdl-textfield__input" id="sp" required="true" type="email"/>
        <label class="mdl-textfield__label" for="sp">Distributor Email</label>
    </div>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:input path="disPhone"  cssClass="mdl-textfield__input" id="sp" required="true" type="number"/>
        <label class="mdl-textfield__label" for="sp">Distributor Phone</label>
    </div>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:input path="username"  cssClass="mdl-textfield__input" id="sp" required="true"/>
        <label class="mdl-textfield__label" for="sp">Distributor Username</label>
    </div>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:input path="password"  cssClass="mdl-textfield__input" id="sp" required="true"/>
        <label class="mdl-textfield__label" for="sp">Distributor Password</label>
    </div>
    <p>Distributor Status</p>
    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="sttActive">
        <form:radiobutton path="status" id="sttActive" cssClass="mdl-radio__button" value="1"/>
        <span class="mdl-radio__label">Active</span>
    </label>
    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="sttNonActive">
        <form:radiobutton path="status" id="sttNonActive" cssClass="mdl-radio__button" value="0" />
        <span class="mdl-radio__label">Non-Active</span>
    </label>
    <hr/>
    <p>
        <input type="submit" value="Update" name="action" class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored"/>
        <input type="submit" value="Add" name="action" class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored"/>
        <input type="submit" value="Delete" name="action" onclick="return confirm('Are you sure?');" class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored"/>
    </p>
</form:form>
