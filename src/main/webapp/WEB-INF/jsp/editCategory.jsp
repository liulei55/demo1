<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\6\9 0009
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="margin:0px auto; width:500px">

    <form action="updateCategory" method="post">

        name: <input name="name" value="${c.name}"> <br>

        <input name="id" type="hidden" value="${c.id}">
        <button type="submit">提交</button>

    </form>
</div>
</body>

</html>
