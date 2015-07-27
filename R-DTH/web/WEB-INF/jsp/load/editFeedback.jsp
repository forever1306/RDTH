<%-- 
    Document   : editFeedback
    Created on : Jun 27, 2015, 3:22:26 PM
    Author     : Minh-IT
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script>
    componentHandler.upgradeAllRegistered();
</script>
<form:form commandName="feed" action="${pageContext.request.contextPath}/admin/feedbackManager/process.html" method="post">
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:input path="feedTitle" readonly="true" cssClass="mdl-textfield__input"/>
        <label class="mdl-textfield__label">Feedback title</label>
    </div>
    <br/>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:textarea path="feedContent" readonly="true" cssClass="mdl-textfield__input"/>
        <label class="mdl-textfield__label">Feedback Content</label>
    </div>
    <br/>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:textarea path="feedReply" cssClass="mdl-textfield__input" required="true"/>
        <label class="mdl-textfield__label">Feedback Reply</label>
    </div>
    <form:hidden path="customer.customerId"/>
    <form:hidden path="feedId"/>
    <form:hidden path="feedDate"/>
    <p>
        <input type="submit" value="Reply" class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored"/>
    </p>
</form:form>