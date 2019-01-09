<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath() %>/" />
    <%@include file="layUI.jsp"%>


</head>
<body>

    <form action="/doGoods/goodsUpdate" method="post">
        <label>编号:</label><input type="text"  name="id" value="${gs.id}" readonly/><br>
        <label>商品名称:</label><input type="text" name="goodsName" value="${gs.goodsName}" /><br>
        <label>所属小分类名称:</label>
        <select name="goodsSmalId">
            <option value="${gs.goodsSmalId}" selected="selected">${gs.smallClass.smallName}</option>
        </select><br>
        <label>价格:</label><input type="text" name="goodsMoney" value="${gs.goodsMoney}" /><br>
        <label>数量:</label><input type="text" name="goodsNumber" value="${gs.goodsNumber}" /><br>
        <label>图像:</label><input type="text" name="goodsImage" value="${gs.goodsImage}" /><br>
        <label>运费:</label><input type="text" name="goodsCarriage" value="${gs.goodsCarriage}" /><br>
        <label>类型:</label><input type="text" name="goodsType" value="${gs.goodsType}" /><br>
        <%--<label>类型:</label><input type="text" name="goodsType" value="<if test='${gs.goodsType==0}'></if>${gs.goodsType}" /><br>--%>
        <label>折扣:</label>
        <select name="goodsDiscId">
            <option value="${gs.goodsDiscId}" selected="selected">${gs.discount.discRate}</option>
        </select><br>
        <label>卖家:</label>
        <select name="goodsSellerId">
            <option value="${gs.goodsSellerId}" selected="selected">${gs.seller.sellerName}</option>
        </select><br>
        <input disabled  type="submit" value="保存修改" class="layui-btn"/>
    </form>
</body>
<script src="static/js/jquery-1.8.2.min.js"></script>
<style>
    input{
        border-radius: 5px;
        height: 30px;
        font-size: 15px;
        padding-left: 5px;
    }
    form{
        width: 80%;
        margin: auto;
        padding: 40px;
    }
</style>

<script>
    $(function(){
        //小分类ajax
        var url = "doSmallClass/ajaxQuery";
        $.getJSON(url,function(smallClass){
            $.each(smallClass,function (index,small) {
                $("select[name='goodsSmalId']").append("<option value='"+small.id+"'>"+small.smallName+"</option>");
            });
            <%--$("option[value='${gs.goodsSmalId}']").attr("selected",true);--%>

        });

        //验证输入的商品名称是否重名
        $("input[name='goodsName']").blur(function(){
            var url = "doGoods/checkGoodsName";
            v
            $.post(url,{goodsName:i},function(result){
                if(result=="true"){
                    alert("该商品名称已经存在！");
                    $("input[type='submit']").attr("disabled",true);
                }else{
                    $("input[type='submit']").attr("disabled",false);
                }
            },"text");
        });

        //验证商品名称是否可使用
        // $("input[name='goodsName']").blur(function () {
        //     var i = $(this).val();
        //     $.ajax({
        //         "url":"/doGoods/checkGoodsName",
        //         "type":"post",
        //         "data":{"goodsName":i},
        //         "dataType":"json",
        //         "success":callBack,
        //         "error":function () {
        //             alert("请求异常!");
        //         }
        //     })
        //     function callBack(data) {
        //         if(data.result=="true"){
        //             alert("该商品名称已经存在！");
        //             $("input[type='submit']").attr("disabled",true);
        //         }else{
        //             $("input[type='submit']").attr("disabled",false);
        //         }
        //     }
        // });

        //折扣ajax
        var url2 = "doDiscount/ajaxQuery";
        $.getJSON(url2,function(discount){
            $.each(discount,function (index,dis) {
                $("select[name='goodsDiscId']").append("<option value='"+dis.id+"'>"+dis.discRate+"</option>");
            });
            <%--$("option[value='${gs.goodsDiscId}']").attr("selected",true);--%>

        });

        //卖家ajax
        var url2 = "doSeller/ajaxQuery";
        $.getJSON(url2,function(seller){
            $.each(seller,function (index,sel) {
                $("select[name='goodsSellerId']").append("<option value='"+sel.id+"'>"+sel.sellerName+"</option>");
            });
            <%--$("option[value='${gs.goodsSellerId}']").attr("selected",true);--%>

        });
    });
</script>
</html>


