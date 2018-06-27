<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\6\9 0009
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
</div>

<div style="width:500px;margin:20px auto;text-align: center">
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${page.list}" var="c" varStatus="st">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td><a href="categoryById?id=${c.id}">编辑</a></td>
                <td><a href="deleteCategory?id=${c.id}">删除</a></td>
            </tr>
        </c:forEach>

    </table>
    <br>
    <div>
        <a href="?start=1">[首  页]</a>
        <a href="?start=${page.pageNum-1}">[上一页]</a>
        <a href="?start=${page.pageNum+1}">[下一页]</a>
        <a href="?start=${page.pages}">[末  页]</a>
    </div>
    <br>
    <form action="addCategory" method="post">

        name: <input name="name"> <br>
        <button type="submit">提交</button>

    </form>
</div>
</body>
</html>
