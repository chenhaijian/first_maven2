<%--
  Created by IntelliJ IDEA.
  User: user1
  Date: 2017/10/23
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user-edit</title>
    <script type="text/javascript" src="/jquery/jquery.min.js"></script>
</head>
<body>

    <form id="formData" method="post">
        姓名 <input type="text" name="userName"><br>
        性别 <input type="text" name="sex"><br>
        年龄 <input type="text" name="age"><br>
        描述 <input type="text" name="desc"><br>
        <input type="button" value="提交" onclick="submitData()">
    </form>

    <script type="text/javascript">
        function submitData() {
            $.ajax({
                url : "/user/save",
                type : "post",
                data : $("#formData").serialize(),
                statusCode : {
                    201 : function () {
                        alert("插入数据成功！");
                    }
                }
            });
        }
    </script>
</body>
</html>
