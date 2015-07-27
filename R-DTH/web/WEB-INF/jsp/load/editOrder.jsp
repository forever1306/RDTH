<%-- 
    Document   : editOrder
    Created on : Jun 20, 2015, 3:46:13 PM
    Author     : Minh-IT
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
    componentHandler.upgradeAllRegistered();
</script>
<form:form commandName="order" action="${pageContext.request.contextPath}/admin/orderManager/process.html" method="post">
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:input path="oderId" cssClass="mdl-textfield__input" readonly="true"/>
        <label class="mdl-textfield__label">Order ID</label>
    </div>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:input path="orderPaymentDate" cssClass="mdl-textfield__input" readonly="true"/>
        <label class="mdl-textfield__label">Payment Date</label>
    </div>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:input path="orderExpiredDate" cssClass="mdl-textfield__input" readonly="true"/>
        <label class="mdl-textfield__label">Expired Date</label>
    </div>
        <hr/>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <form:input path="customer.customerId" cssClass="mdl-textfield__input" readonly="true"/>
        <label class="mdl-textfield__label">Customer ID</label>
    </div>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <input type="text" value="${customer.cusName}" class="mdl-textfield__input" readonly="readonly"/>
        <label class="mdl-textfield__label">Customer Name</label>
    </div>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <input type="text" value="${customer.bankCardNumber}" class="mdl-textfield__input" readonly="readonly"/>
        <label class="mdl-textfield__label">Bank Card</label>
    </div>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <input type="text" value="${customer.endDate}" class="mdl-textfield__input" readonly="readonly"/>
        <label class="mdl-textfield__label">End Date</label>
    </div>
    <p>Status</p>
        <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="sttActive">
        <form:radiobutton path="status" id="sttActive" cssClass="mdl-radio__button" value="1" />
        <span class="mdl-radio__label">Processed</span>
    </label>
    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="sttNonActive">
        <form:radiobutton path="status" id="sttNonActive" cssClass="mdl-radio__button" value="0" />
        <span class="mdl-radio__label">Pendding</span>
    </label>
    <p>Package: </p>
    <div class="scroll">
        <c:set var="pay" value="0"/>
        <c:forEach items="${order.oderDetails}" var="orderDetail">
            <a>${orderDetail.packages.packageName}</a>
            <c:set var="pay" value="${(pay + orderDetail.price)* month}"/>
        </c:forEach>
    </div>
        <p>Payment money: <fmt:formatNumber type="currency" value="${pay}"/></p>
    <hr/>
    <input type="submit" value="Update" class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored"/>
</form:form>
