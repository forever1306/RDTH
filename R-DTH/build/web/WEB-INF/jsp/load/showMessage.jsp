<%-- 
    Document   : showMessage
    Created on : Jul 1, 2015, 1:22:52 PM
    Author     : Minh-IT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            alert('${msg}');
                    <c:if test="${ not empty location}">
                        location.href='${location}';
                    </c:if>
        </script>
    </head>
    <body>
    </body>
</html>
