<%-- 
    Document   : FAQView
    Created on : Jul 2, 2015, 3:52:20 PM
    Author     : Minh-IT
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    $(document).ready(function () {
        $('.faqAnw').hide();
        $('.faqQues').on('click', function () {
            $(this).next().slideToggle();
        })
    })
</script>

<div class="faq">
    <c:forEach items="${listFAQ}" var="faq">
        <div class="faqQues">
            <i>Question: </i>${faq.faqQestion}
        </div>
        <div class="faqAnw faqQues">
            <p style="margin-left: 20px"><i>Answer: </i>${faq.faqAnswer}</p>
        </div>
    </c:forEach>
</div>
