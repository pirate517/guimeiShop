<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>${error}</h3>
   <form action="/customer/addCustomer">
        <label>姓名</label>
       <input type="text" name="cusName" value=""/><br>
        <label>昵称</label>
       <input type="text" name="cusLoginName" value=""/><br>
        <label>密码</label>
       <input type="text" name="cusPassword" value=""/><br>
       <input type="submit" value="提交">
   </form>
</body>
</html>
