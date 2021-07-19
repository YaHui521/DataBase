<%--
  Created by IntelliJ IDEA.
  User: 亚辉
  Date: 2021/7/16
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="JS/jquery-1.8.3.js"></script>
<script>
    $(function (){
        $("#title").blur(function (){
            if($("#title").val()==''){
                return;
            }
            $.ajax({
                url:"TestServlet",
                type:"post",
                data:"opr=jy&title="+$("#title").val(),
                dataType:"json",
                success:function (data){
                if (data==1){
                    alert("已存在该标题！");
                }
                }
            });
        });
    });
    function check() {
        if ($("#title").val() == "") {
            alert("标题不能为空！请重新填入！");
            $("#title").focus();
            return false;
        } else if ($("#content").val() == "") {
            alert("内容不能为空！请重新填入！");
            $("#content").focus();
            return false;
        }else if ($("#type").val() == 0) {
            alert("请选择类型！");
            $("#type").focus();
            return false;
        }
        return true;
    }
</script>
<html>
<head>
    <title>添加笔记</title>
</head>
<body>
<h2 style="font-size: 30px;margin-left: 100px">我的工作笔记</h2>
<form action="TestServlet?opr=add" method="post" onsubmit="return check()">
<table width="400" id="tb1">
    <tr>
        <td>标题:</td>
        <td><input type="text" id="title" name="title"></td>
    </tr>
    <tr>
        <td>内容:</td>
        <td><textarea cols="40" rows="4" id="content" name="content"></textarea></td>
    </tr>
    <tr>
        <td>类别:</td>
        <td><select id="type" name="type">
            <option selected value="0">--请选择类别--</option>
            <option value="1">技术</option>
            <option value="22">行政</option>
            <option value="3">人事</option>
            </select>
        </td>
    </tr>
</table>
    <input type="submit" value="提交">
</form>
</body>
</html>
