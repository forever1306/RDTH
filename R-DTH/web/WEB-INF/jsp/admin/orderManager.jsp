<%-- 
    Document   : orderManager
    Created on : Jun 20, 2015, 3:35:38 PM
    Author     : Minh-IT
--%>
<%@taglib prefix="table" uri="/WEB-INF/tlds/table_library" %>
<script>
    $(document).ready(function(){
        $('.bgDiv').hide();
        $('button[pri="true"]').on("click",function (){
             $.ajax({
                url:'${pageContext.request.contextPath}/admin/orderManager/edit/'+$(this).attr('itemid')+'.html',
                type:'get',
                success:function(data){
                    $('.bgDiv').hide().html(data).slideDown(1000);
                }
            })
        })
    })
</script>
<div class="title">
    <p>Order Manager</p>
</div>
<table:TableTagHandler column="${column}" data="${data}"  edit="true"/>
<div class="bgDiv"></div>
