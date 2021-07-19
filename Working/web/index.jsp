<%--
  Created by IntelliJ IDEA.
  User: 亚辉
  Date: 2021/7/16
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="JS/jquery-1.8.3.js"></script>
<script>
  $(function (){
    $("#tb tr:even").css("background","#999").parent().css("text-align","center");
    $("a").click(function (){
      var id=$(this).attr("id");
      location.href='TestServlet?opr=ck&id='+id;
    });
  });
</script>
<html>
  <head>
    <title>工作笔记</title>
  </head>
  <body style="width: 600px;margin: 30px auto">
<c:if test="${wlist==null}">
  <c:redirect url="TestServlet"></c:redirect>
</c:if>
  <h2 style="font-size: 30px;text-align: center">工作笔记</h2>
  <p style="text-align: right;width: 450px"><a href="add.jsp">添加笔记</a></p>
  <table width="600" border="1" id="tb">
    <tr>
      <th>笔记标题</th>
      <th>笔记分类</th>
      <th>编写时间</th>
      <th>操作</th>
    </tr>
    <c:forEach items="${wlist}" var="wk">
      <tr>
        <td>${wk.title}</td>
        <td>
            <c:choose>
              <c:when test="${wk.type==1}">
                技术
              </c:when>
              <c:when test="${wk.type==2}">
              行政
              </c:when>
              <c:otherwise>
                人事
              </c:otherwise>
            </c:choose>
        </td>
        <td>${wk.creataDate}</td>
        <td><a href="javascript:;" id="${wk.id}">查看</a></td>
      </tr>
    </c:forEach>
  </table>
  </body>
</html>
