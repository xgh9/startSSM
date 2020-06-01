<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib
        prefix="form"
        uri="http://www.springframework.org/tags/form" %>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
    <title>添加警报</title>
    <meta charset="utf-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="./css/event.css">
    <link rel="stylesheet" type="text/css" href="./css/button.css">
    <link rel="stylesheet" type="text/css" href="./css/add.css">

</head>

<body class="bg" style="color:white;">

<div class="header-container">
    <span class="title3"></span>
</div>

<div id="b">
    <form:form action="${pageContext.servletContext.contextPath}/user" method="post" modelAttribute="user">
        <c:if test="${empty user.id}" var="flag"></c:if>

        <c:if test="${!flag}">
            <form:hidden path="id"></form:hidden>
            <input type="hidden" value="PUT" name="_method"/>
        </c:if>

        <table>
            <tr>
                <th colspan="2">修改信息</th>
            </tr>
            <tr>
                <td>姓名</td>
                <td>
                    <form:input path="userName"></form:input>
                </td>
            </tr>
            <tr>
                <td>性别</td>
                <td>
                    <form:input path="sex"></form:input>
                </td>
            </tr>
            <tr>
                <td>年龄</td>
                <td>
                    <form:input path="age"></form:input>
                </td>
            </tr>
            <tr>
                <td>部门</td>
                <td>
                    <form:select path="dept.id" items="${depts}" itemLabel="name" itemValue="id"></form:select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <c:if test="${!flag}">
                        <input type="submit" class="a button button-primary button-rounded button-small" value="修改" />  <br/>
                    </c:if>
                    <c:if test="${flag}">
                        <input type="submit" class="a button button-primary button-rounded button-small" value="添加" />  <br/>
                    </c:if>
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
