<%-- 
    Document   : pickPackage
    Created on : Jun 30, 2015, 8:10:38 AM
    Author     : Minh-IT
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script>
    $(document).ready(function () {
        $('#product').hide();
        loadProduct();
        $(document).on('change', '.listDis', function () {
            $.ajax({
                url: '${pageContext.request.contextPath}/viewPackage/showProduct/' + $('.listDis').val() + '/' + $('.listDis option:selected').attr('title') + '.html',
                type: 'get',
                success: function (data) {
                    $('div #product').hide().html(data).slideDown(1000);

                }
            })
        });

        function loadProduct() {
            $.ajax({
                url: '${pageContext.request.contextPath}/viewPackage/showProduct/' + $('.listDis').val() + '/' + $('.listDis option:selected').attr('title') + '.html',
                type: 'get',
                success: function (data) {
                    $('div #product').hide().html(data).slideDown(1000);

                }
            })
        }
        $('#btAdd').on('click', function () {
            $('input[type="radio"][name="product"]').children().prop("checked");
            $.ajax({
                url: '${pageContext.request.contextPath}/viewPackage/addToOrder/' + $('.listDis').attr('title') + '/' + $('input[type="radio"][name="product"]:checked').val() + '.html',
                type: 'get',
                success: function (data) {
                    $('form').append(data);
                }
            })
        })
        $('#btCreate').on('click', function () {
            $.ajax({
                url: '${pageContext.request.contextPath}/viewPackage/createOrder.html',
                type: 'get',
                success: function (data) {
                    $('form').append(data);
                }
            })
        })
    })
</script>

<span style="color: white;">Choose product</span>

<form:form commandName="requirement" action="/viewPackage/process.html" method="post" cssStyle="padding:3%">
    <p style="color: white">Distributor:</p>
    <form:select path="" cssClass="listDis" name="listDis" title="${packid}">
        <form:options items="${listDistributor}" itemLabel="disName" itemValue="distributorId"  title="${type}"/>
    </form:select>
    <p style="color: white">Choose Product:</p>
    <div id="product"></div>
    <hr/>
    <input type="button" id="btAdd" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" value="Add to Cart"/>
    <input type="button" id="btCreate" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" value="Buy"/>
</form:form>
