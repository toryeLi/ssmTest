<%--
  Created by IntelliJ IDEA.
  User: Torey
  Date: 2019/2/12
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <title>Title</title>
</head>
<body>
<!--form[action="user/old",method="post"]>(p>input)*3
IntelliJ IDEA 自带 Emmet 功能，使用的快捷键是 Tab
https://blog.csdn.net/cgl125167016/article/details/78764001
-->
<h5>使用HttpServletRequest获取前端参数演示：</h5>
<form action="user/old" method="post">
<p>编号：<input type="text" name="userId"></p>
<p>用户名：<input type="text" name="userName"></p>
    <p>备注：<input type="text" name="remark"></p>
<p><input type="submit" value="提交" ></p>
</form>
<hr>
<h5>使用springMVC获取前端参数-1演示：</h5>
<form action="user/springMvcSetUser" method="post">
    <p>编号：<input type="text" name="userId"></p>
    <p>用户名：<input type="text" name="userName"></p>
    <p>备注：<input type="text" name="remark"></p>
    <p><input type="submit" value="提交" ></p>
</form>
<hr>
<h5>使用springMVC获取前端参数-2演示：</h5>
<form action="user/springMvcSetUserTwo" method="post">
    <p>编号：<input type="text" name="userId"></p>
    <p>用户名：<input type="text" name="userName"></p>
    <p>备注：<input type="text" name="remark"></p>
    <p><input type="submit" value="提交" ></p>
</form>
<h5>使用springMVC获取前端参数-3演示,有两个对象，但这两个对象的同时都有userName这个属性,错误演示：</h5>
<form action="user/springMvcSetUser3" method="post">
    <p>编号：<input type="text" name="userId"></p>
    <p>用户名：<input type="text" name="userName"></p>
    <p>备注：<input type="text" name="remark"></p>
    <p>账号名：<input type="text" name="userName"></p>
    <p>密码：<input type="text" name="passWord"></p>
    <p><input type="submit" value="提交" ></p>
</form>
<h5>使用springMVC获取前端参数-3演示,有两个对象，但这两个对象的同时都有userName这个属性，解决方法：</h5>
<form action="user/springMvcSetUser4" method="post">
    <p>编号：<input type="text" name="user.userId"></p>
    <p>用户名：<input type="text" name="user.userName"></p>
    <p>备注：<input type="text" name="user.remark"></p>
    <p>账号名：<input type="text" name="account.userName"></p>
    <p>密码：<input type="text" name="account.passWord"></p>
    <p><input type="submit" value="提交" ></p>
</form>
<h5>将本页面的数据传送到后台，数据处理后，在返回到index.jsp页面</h5>
<form action="user/getNameByModelMap3" method="post">
    <p>baseDTO.user.userName用户名：<input type="text" name="user.userName"></p>
    <p>baseDTO.account.userName账号名：<input type="text" name="account.userName"></p>
    <p><input type="submit" value="提交" ></p>
</form>

</body>
</html>
