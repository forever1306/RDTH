<%-- 
    Document   : feedback
    Created on : Jul 8, 2015, 8:11:30 AM
    Author     : Minh-IT
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    $(document).ready(function () {
        $('.btAdd').on('click', function () {
            $.ajax({
                url: '${pageContext.request.contextPath}/customer/feedback/addFeedback.html',
                type: 'get',
                success: function (data) {
                    $('div.popup').hide().html(data).show('clip');
                }
            })
        })
    })
    $(document).mouseup(function (e) {
        if (!$('.popup').is(e.target) && $('.popup').has(e.target).length === 0) {
            $('div .popup').hide('drop', 1000);
        }
    });
</script>
<div class="title">
    <p>View my feedback</p>
</div>
<div class="faq">
    <c:forEach items="${listFeed}" var="feed">
        <div class="faqQues">
            <p>[${feed.feedDate}] <b>${feed.feedTitle}</b></p>
            <i>${feed.feedContent}</i>
        </div>
        <div class="faqQues faqAnw">
            <c:if test="${empty feed.feedReply}">
                <p>No Reply</p>
            </c:if>
            <c:if test="${not empty feed.feedReply}">
                <p>${feed.feedReply}</p>
            </c:if>
        </div>
    </c:forEach> 
</div>
<div class="btAdd">
    <button class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored addfeed">
        <i class="material-icons">add</i>
    </button>
</div>
<div class="popup" style="width: 30%;left:35%;background-color:  #3cabd7;">

</div>