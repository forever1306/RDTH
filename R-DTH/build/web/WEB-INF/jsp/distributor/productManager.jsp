<%-- 
    Document   : productManager
    Created on : Jun 14, 2015, 2:20:48 PM
    Author     : Minh-IT
--%>
<%@taglib prefix="table" uri="/WEB-INF/tlds/table_library" %>
<script>
    $(document).ready(function(){
        $('.bgDiv').hide();
        $('button[pri="true"]').on("click",function (){
             $.ajax({
                url:'${pageContext.request.contextPath}/distributor/productManager/edit/'+$(this).attr('itemid')+'.html',
                type:'get',
                success:function(data){
                    $('.bgDiv').hide().html(data).slideDown(1000);
                }
            })
        })
    })
</script>
<div class="title">
    <p>Product Manager</p>
</div>
<table:TableTagHandler column="${column}" data="${data}" edit="true"/>
<div class="bgDiv"></div>
