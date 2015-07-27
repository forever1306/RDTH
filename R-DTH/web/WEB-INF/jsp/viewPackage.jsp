<%-- 
    Document   : viewPackage
    Created on : Jun 28, 2015, 2:13:43 PM
    Author     : Minh-IT
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
    $(document).ready(function () {
        $('.see').on('click', function () {
            $.ajax({
                url: '${pageContext.request.contextPath}/viewPackage/viewChanel/' + $(this).attr('itemid') + '.html',
                type: 'get',
                success: function (data) {
                    $('div popup').empty();
                    $('div .popup').hide().html(data).show('clip','fast');
                }
            })
        })
        $('.pick').on('click', function () {
            $.ajax({
                url: '${pageContext.request.contextPath}/viewPackage/pickPackage/' + $(this).attr('itemid') + '.html',
                type: 'get',
                success: function (data) {
                    $('div popup').empty();
                    $('div .popup').hide().html(data).show('clip', 'fast');
                }
            })
        })
    });
    $(document).mouseup(function (e) {
        if (!$('.popup').is(e.target) && $('.popup').has(e.target).length === 0) {
            $('div .popup').hide('clip', 'fast');
        }
    });
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
    <c:forEach items="${listPackage}" var="package">
        <div class="mdl-card mdl-shadow--2dp card-event">
            <div class="mdl-card__actions mdl-card--border">
                <span>${package.packageName}</span>
            </div>
            <div class="mdl-card__title mdl-card--expand">
                <h4>
                    <span><fmt:formatNumber type="currency" value="${package.packagePrice*package.packageMonth}"/>/${package.packageMonth} month</span>
                </h4>
            </div>
            <div class="mdl-card__actions mdl-card--border">
                <c:if test="${pageContext.request.userPrincipal!=null}">
                    <button class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored pick" itemid="${package.packageId}" style="position: absolute;bottom: 25px;right: 5px;">
                        <i class="material-icons">add</i>
                    </button>
                </c:if>
                <c:if test="${null or empty pageContext.request.userPrincipal}">
                    <button class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored" itemid="${package.packageId}" style="position: absolute;bottom: 25px;right: 5px;" onclick="location.href = '/R-DTH/login/customer.html'">
                        <i class="material-icons">add</i>
                    </button>
                </c:if>
                <button class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect see" itemid="${package.packageId}">View Chanel</button>
            </div>
        </div>

    </c:forEach>
</div>
<div class="popup">

</div>