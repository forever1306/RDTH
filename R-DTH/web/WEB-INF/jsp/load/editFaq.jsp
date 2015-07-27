<%-- 
    Document   : editFaq
    Created on : Jun 19, 2015, 2:39:53 PM
    Author     : Minh-IT
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script>
    componentHandler.upgradeAllRegistered();
</script>
<form:form commandName="FAQ" action="${pageContext.request.contextPath}/admin/FAQManager/process.html" method="post">
    <form:hidden path="faqId"/>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:textarea path="faqQestion" cssClass="mdl-textfield__input" required="true"/>
        <label class="mdl-textfield__label">FAQ Question</label>
    </div>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:textarea path="faqAnswer" cssClass="mdl-textfield__input" required="true"/>
        <label class="mdl-textfield__label">FAQ Answer</label>
    </div>
    <p>FAQ Status</p>
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
        <input type="submit" value="Update" name="action" class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored"/>
        <input type="submit" value="Add" name="action" class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored"/>
        <input type="submit" value="Delete" name="action" class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored"  onclick="return confirm('Are you sure?');"/>
    </p>
</form:form>
