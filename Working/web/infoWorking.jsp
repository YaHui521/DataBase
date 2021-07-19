<%--
  Created by IntelliJ IDEA.
  User: 亚辉
  Date: 2021/7/16
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
  function ck(){
    location.href="index.jsp";
  }
</script>
<html>
<head>
    <title>我的工作笔记</title>
</head>
<body>
<div style="width: 600px;height: 350px;margin: 30px auto;border: 1px black solid" >
  <h2 style="width: 600px;text-align: center">我的工作笔记</h2>
  <p>标题：${working.title}</p>
  <p>内容：${working.content}</p>
  <p>类型：<c:choose>
    <c:when test="${working.type==1}">
      技术
    </c:when>
    <c:when test="${working.type==2}">
      行政
    </c:when>
    <c:otherwise>
      人事
    </c:otherwise>
  </c:choose></p>
  <p>日期：${working.creataDate}</p>
  <input type="button" value="返回" onclick="ck()" style="margin-left: 290px">
</div>
</body>
</html>
