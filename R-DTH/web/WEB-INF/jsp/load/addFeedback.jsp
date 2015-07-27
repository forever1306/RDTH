<%-- 
    Document   : addFeedback
    Created on : Jul 9, 2015, 9:00:39 AM
    Author     : Minh-IT
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form action="${pageContext.request.contextPath}/customer/feedback/process.html" commandName="feed" method="post">
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:input path="feedTitle" cssClass="mdl-textfield__input" id="sp"  required="true"/>
        <label class="mdl-textfield__label" for="sp">Title</label>
    </div>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:textarea path="feedContent" cssClass="mdl-textfield__input" id="sp"  required="true"/>
        <label class="mdl-textfield__label" for="sp">Content</label>
    </div>
    <input type="submit" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect" value="Send"/>
</form:form>