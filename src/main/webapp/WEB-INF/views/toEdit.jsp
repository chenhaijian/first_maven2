<%--
  Created by IntelliJ IDEA.
  User: user1
  Date: 2017/10/23
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>用户修改页面</title>
    <script type="text/javascript" src="/jquery/jquery-3.2.1.min.js"></script>
</head>
<body>

    <form id="formData" method="post">
        姓名 <input type="text" name="userName" value="${user.userName}"><br>
        性别 <input type="text" name="sex" value="${user.sex}"><br>
        年龄 <input type="text" name="age" value="${user.age}"><br>
        <input type="hidden" name="id" value="${user.id}">
        <input type="button" value="更改" onclick="updateData()">
    </form>

    <script type="text/javascript">
        function updateData() {
            $.ajax({
                url : "/user/update",
                type : "post",
                data : $("#formData").serialize(),
                statusCode : {
                    204 : function () {
                        alert("用户更新成功！！！");
                    },
                    500 : function () {
                        alert("用户更新失败！");
                    }
                },
            });
        }
    </script>
</body>
</html>
