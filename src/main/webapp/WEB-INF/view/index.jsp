<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base  target="main">
    
    <title>用户信息</title>
    
    
  
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="./css/event.css">
	<link rel="stylesheet" type="text/css" href="./css/button.css">
	<script src="./js/jquery.js"></script>

  </head>
  
  <body  class="bg">
	
  
  <header class="header-container">
    <span class="title"></span>
    <a href="users" target="_self" class="handle button button-primary button-rounded button-small">刷新</a>
  </header>
  <div class="main">
     <div class="list">
      <span class="line"></span>
      <span class="line"></span>
      <div class="header">
        <div class="title">用户信息</div>
        <a target="_blank" class="my-select button button-primary button-rounded button-small" href="add">添加</a>
      </div>
      <ul class="table-container"  id="scroller-container">
        <li class="table-item">
          <div>
            <span class="cell">姓名</span>
          </div>
          <div>
            <span class="cell">性别</span>
          </div>
          <div>
            <span class="cell">年龄</span>
          </div>          
          <div>
          	<span class="cell">部门</span>
          </div>
        </li>
        <c:forEach items="${users}" var="user">
            <li class="table-item">
                <div>${user.userName}</div>
                <div>${user.sex}</div>
                <div>${user.age}</div>
                <div>${user.dept.name}</div>
                <div><a  target="_parent" class="button button-primary button-rounded button-small" href="delete/${user.id}">删除</a></div>
                <div><a  target="_parent" class="button button-primary button-rounded button-small" href="user/${user.id}">修改</a></div>
            </li>
        </c:forEach>
      </ul>
    </div>
   </div>
  </body>
</html>
