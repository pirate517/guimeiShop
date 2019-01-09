<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath() %>/" />

    <%@include file="layUI.jsp"%>
    <style>
        input,select{
            border-radius: 5px;
            height: 30px;
            font-size: 15px;
            padding-left: 5px;
        }
    </style>
    <script src="static/js/jquery-1.8.2.min.js"></script>
    <script>
        function del(id) {
            var delStatus = window.confirm("是否确认删除id="+id+"商品");
            if(delStatus){
                open("doGoods/delById?goodsId="+id,"iframe_context");
            }
        }
        if(${not empty error}){
            alert("${error}")
        }


        $(function () {
            //小分类ajax
            var url = "doSmallClass/ajaxQuery";
            $.getJSON(url,function(smallClass){
                $.each(smallClass,function (index,small) {
                    $("select[name='goodsSmalId']").append("<option value='"+small.id+"'>"+small.smallName+"</option>");
                });
            });

            //折扣
            var url2 = "doDiscount/ajaxQuery";
            $.getJSON(url2,function(discount){
                $.each(discount,function (index,dis) {
                    $("select[name='goodsDiscId']").append("<option value='"+dis.id+"'>"+dis.discRate+"</option>");
                });

            });

            //卖家
            var url2 = "doSeller/ajaxQuery";
            $.getJSON(url2,function(seller){
                $.each(seller,function (index,sel) {
                    $("select[name='goodsSellerId']").append("<option value='"+sel.id+"'>"+sel.sellerName+"</option>");
                });
            });
        })
    </script>
</head>
<body>
<form action="/doGoods/query" method="post">
    <label>商品编号:</label>
    <input type="text" name="id" placeholder="请输入商品编号" />
    <label>商品名称:</label>
    <input type="text" name="goodsName" placeholder="请输入商品名称"  />
    <label>小分类名称:</label>
    <select name="goodsSmalId">
        <option value="0">请选择</option>
        <%--<option value="1">家用电器</option>--%>
        <%--<option value="2">手机数码</option>--%>
        <%--<option value="2">手机数码</option>--%>
    </select>
    <label>折扣:</label>
    <select name="goodsDiscId">
        <option value="0">请选择</option>
        <%--<option value="1">1</option>--%>
        <%--<option value="2">0.95</option>--%>
    </select>
    <label>卖家:</label>
    <select name="goodsSellerId">
        <option value="0">请选择</option>
    </select>
    <input class="layui-btn " type="submit"  value="查询"/>
</form>
<c:choose>

    <c:when test="${not empty Page.pageData}">
        <table id="stu" width="90%" class="layui-table" lay-size="sm">
            <tr>
                <th>编号</th>
                <th>名称</th>
                <th>小分类名称</th>
                <th>价格</th>
                <th>数量</th>
                <th>图像</th>
                <th>运费</th>
                <th>类型</th>
                <th>折扣</th>
                <th>卖家</th>
                <th colspan="2">操作</th>
            </tr>
            <c:forEach items="${Page.pageData}" var="gs">
                <tr>
                    <td>${gs.id}</td>
                    <td>${gs.goodsName}</td>
                    <td>${gs.smallClass.smallName}</td>
                    <td>${gs.goodsMoney}</td>
                    <td>${gs.goodsNumber}</td>
                    <%--<td>${gs.goodsImage}</td>--%>
                    <td><img class="layui-nav-img" width="36px" src="../static/images/goodsImage/${gs.goodsImage}"></td>
                    <td>${gs.goodsCarriage==0?'免运费':'gs.goodsCarriage'}</td>
                    <td>${gs.goodsType==0?'新品':'二手'}</td>
                    <td>${gs.discount.discRate}</td>
                    <td>${gs.seller.sellerName}</td>
                    <td><b class="layui-btn layui-btn-sm" onclick="del(${gs.id})">删除</b></td>
                    <td><a class="layui-btn layui-btn-sm" href="doGoods/queryById?id=${gs.id}">修改</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="6">
                    <%@include file="PageUtil2.jsp"%>
                </td>
            </tr>
        </table>
    </c:when>
    <c:otherwise>
        <h3>暂无商品信息</h3>
    </c:otherwise>
</c:choose>
</body>
</html>
