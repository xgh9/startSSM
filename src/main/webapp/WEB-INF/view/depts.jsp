<%@ taglib
        prefix="c"
        uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xingg
  Date: 2020/6/1
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page
        contentType="text/html;charset=UTF-8"
        language="java" %>
<html>
<head>
    <title>部门信息</title>
</head>
<body  class="bg">
${depts}
<%--<table>--%>
<%--    <tr>--%>
<%--        <th>部门名称</th>--%>
<%--        <th>员工数量</th>--%>
<%--    </tr>--%>
<%--    <c:forEach items="depts" var="dept">--%>
<%--        <tr>--%>
<%--            <td>${dept.name}</td>--%>
<%--            <td>${dept.number}</td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
</table>
</body>
</html>
