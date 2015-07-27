<%-- 
    Document   : viewChanel
    Created on : Jun 29, 2015, 8:40:36 AM
    Author     : Minh-IT
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .card-image{
        width: 100px;
        height: 100px;
        display: inline-block;
        border-radius: 50%;
        margin: 10px;
    }

    .card-image__filename {
        color: #cc6600;
        background-color: rgba(0, 0, 0, 0.2);
    }
</style>

<c:forEach items="${listChanel}" var="chanel">
    <div class="card-image" style="background: url('${pageContext.request.contextPath}/${chanel.chanelImage}') no-repeat,center;">
        <div class="card-image__filename">    
            <span>${chanel.chanelName}</span>
        </div>
    </div>

</c:forEach>

