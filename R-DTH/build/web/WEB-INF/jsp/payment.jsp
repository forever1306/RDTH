<%-- 
    Document   : payment
    Created on : Jul 16, 2015, 4:17:26 PM
    Author     : Minh-IT
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
    $(document).ready(function () {
        $('button.pay').on('click', function () {
            if ($('input#month').val() > 10) {
                alert('Input month < 10');
                return false;
            }
            $.ajax({
                url: '${pageContext.request.contextPath}/customer/payment/process.html',
                type: 'get',
                data: {month: $('#month').val()},
                success: function (data) {
                    $('table').append(data);
                }
            })
        })
        $('input#month').on('change', function () {
            var sum=$('input#sum').val();
            var month=$(this).val();
            $('span#mn').text(sum*month);
        })
    })
</script>
<style>
    .tb{
        width: 40%;
    }
</style>
<input type="hidden" value="${sum}" id="sum"/>
<table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp tb" align="center">
    <thead>
        <tr>
            <th>Package Name</th>
            <th>Package Price</th>
            <th>Quantity</th>
        </tr>
    </thead>
    <tbody>
        <c:set var="ex"/>
        <c:forEach items="${listDetail}" var="dt">
            <tr>
                <td>${dt.packages.packageName}</td>
                <td>${dt.price}</td>
                <td>${dt.quantity}</td>
                <c:set var="ex" value="${dt.order.orderExpiredDate}"/>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="3" style="text-align: center;"><b>Expired Date: </b><fmt:formatDate value="${ex}" pattern="MM/dd/yyyy"/></td>
        </tr>
        <tr>
            <td>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"   style="width: 50px;">
                    <input type="text" class="mdl-textfield__input" maxlength="2" pattern="^\d+" value="1" id="month"/>
                    <label class="mdl-textfield__label">Month</label>
                    <span class="mdl-textfield__error">Input is not a number!</span>
                </div>
            </td>
    
            <td><b>Payment money:</b> $<span id="mn">${sum}</span></td>
            <td><b><button class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect pay">Payment</button></td>
        </tr>
    </tbody>
</table>
