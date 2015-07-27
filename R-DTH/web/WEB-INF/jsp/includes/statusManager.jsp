<%-- 
    Document   : statusManager
    Created on : Jun 28, 2015, 7:31:41 AM
    Author     : Minh-IT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Status</title>
    </head>
    <body>
        <c:if test="${check}">
            <script>
                alert('${alert}');
                location.href = '${link}';
            </script>
        </c:if>
        <c:if test="${!check}">
            <script>
                alert('Error '+${alert});
            </script>
        </c:if>


    </body>
</html>
