<%-- 
    Document   : packagesCustomer
    Created on : Jul 15, 2015, 9:55:41 PM
    Author     : Minh-IT
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
    $(document).ready(function () {
        $('button.del').on('click', function () {
            if (confirm('Are you sure?')) {
                $.ajax({
                    url: '${pageContext.request.contextPath}/customer/packagesCustomer/delete/' + $(this).attr('itemid') + '.html',
                    type: 'get',
                    success: function (data) {
                        $('.allPackage').append(data);
                    }
                })
            }
        })
    })
</script>
<style>
    .card-event.mdl-card {
        width: 25%;
        height: 25%;
        background: #3E4EB8;
        display: inline-block;
    }
    .card-event > .mdl-card__actions {
        border-color: rgba(255, 255, 255, 0.2);
    }
    .card-event > .mdl-card__title,
    .card-event > .mdl-card__actions > .mdl-button {
        color: #fff;
    }
</style>
<div class="allPackage">
    <c:forEach items="${listOrderDetail}" var="orderDetail">
        <div class="mdl-card mdl-shadow--2dp card-event">
            <div class="mdl-card__actions mdl-card--border">
                <span>${orderDetail.packages.packageName}</span>
            </div>
            <div class="mdl-card__title mdl-card--expand">
                <h4>
                    <span><fmt:formatNumber type="currency" value="${orderDetail.price}"/>/month</span>
                </h4>
            </div>
            <div class="mdl-card__title mdl-card--expand">
                <p style="text-align: right;">Quantity: ${orderDetail.quantity}</p>
            </div>
            <div class="mdl-card__actions mdl-card--border">
                <button class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect del" itemid="${orderDetail.packages.packageId}">Delete</button>
            </div>
        </div>

    </c:forEach>
</div>
