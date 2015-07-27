<%-- 
    Document   : register
    Created on : Jul 2, 2015, 8:04:22 AM
    Author     : Minh-IT
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script>
    $(function () {
        $('#endDate').datepicker();
    })
</script>
<form:form commandName="customer" method="post" action="${pageContext.request.contextPath}/register/process.html">
    <div class="title">
        <p>Register</p>
    </div>
    <div class="bgDiv">
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
            <input type="text" name="cusName" class="mdl-textfield__input" required="true" id="sp"/>
            <label class="mdl-textfield__label" for="sp">Name</label>
            
        </div>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
            <form:input path="phone" cssClass="mdl-textfield__input" required="true" type="number" id="sp"/>
            <label class="mdl-textfield__label" for="sp">Phone</label>
        </div>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
            <form:input path="email" cssClass="mdl-textfield__input" id="sp" type="email" required="true"/>
            <label class="mdl-textfield__label" for="sp">Email</label>  
        </div>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
            <form:textarea path="address" cssClass="mdl-textfield__input" required="true" id="sp"/>
            <label class="mdl-textfield__label" for="sp">Address</label>
        </div>
        <form:hidden path="status"/>
        <hr/>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
            <form:input path="username" cssClass="mdl-textfield__input"  required="true" id="sp"/>
            <label class="mdl-textfield__label" for="sp">User Name</label>
        </div>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
            <form:password path="password" cssClass="mdl-textfield__input"  required="true" id="sp"/>
            <label class="mdl-textfield__label" for="sp">Password</label>
        </div>
        <hr/>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
            <form:input path="bankCardNumber" cssClass="mdl-textfield__input" required="true" id="sp" type="number"/>
            <label class="mdl-textfield__label" for="sp">Card Number</label>
        </div>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
            <form:input path="endDate" cssClass="mdl-textfield__input" required="true"/>
            <label class="mdl-textfield__label" for="sp">End Date</label>
        </div>
        <hr/>
        <input type="submit" value="Register" class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored"/>
        <input type="reset" value="Reset" class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent mdl-js-ripple-effect"/>
    </div>
</form:form>
