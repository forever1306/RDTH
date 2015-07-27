<%-- 
    Document   : OrderProduct
    Created on : Jul 3, 2015, 7:04:13 AM
    Author     : Minh-IT
--%>
<%@taglib prefix="table"  uri="/WEB-INF/tlds/table_library" %>
<script>
    $(document).ready(function(){
        $('.bgDiv').hide();
        $('button[pri="true"]').on("click",function (){
            $.ajax({
                url:'${pageContext.request.contextPath}/distributor/orderProduct/edit/'+$(this).attr('itemid')+'.html',
                type:'get',
                success:function(data){
                    $('.bgDiv').hide().html(data).slideDown(1000);
                }
            })
        })
    })
</script>
<div class="title">
    <p>Order Product Manager</p>
</div>
<table:TableTagHandler column="${column}" data="${data}" edit="true"/>
<div class="bgDiv"></div>
