<%--
  Created by IntelliJ IDEA.
  User: user1
  Date: 2017/10/23
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>user页面</title>
    <script type="text/javascript" src="/jquery/jquery.min.js"></script>
    <style type="text/css">
        .td{border:1px #0066ff solid;}
        .table{border-collapse:collapse;}
    </style>

    <%--<style type="text/css">--%>
        <%--.td{border: 1px #1e11ff solid;}--%>
        <%--.table{border-collapse: collapse;}--%>
    <%--</style>--%>

    <script type="text/javascript">

        /**
         * 全选框
         * @param who CheckBox的name属性
         * @param obj
         */
        function allChecked(who, obj) {
            var curCheckBox = document.getElementsByName(who);
            for (var i = 0; i < curCheckBox.length; i++) {
                curCheckBox.item(i).checked = obj.checked;
            }
        }

        /**
         * 获取选中的数据行的id值
         */
        function getIds() {
            var idss = "";
            $("input[name=checkIds]:checked").each(function () {
                idss = idss + $(this).val() + ",";
            });
            idss = idss.substring(0, idss.length - 1);
            return idss;
        }

//        function deleteUser() {
//            checkedIds = getIds();
//            alert(checkedIds);
//            $.ajax({
//                url : "/user/deleteBatch",
//                type : "post",
//                data : {"ids" : checkedIds},
//                statusCode: {
//                    204 : function () {
//                        alert("删除数据成功！");
//                        //刷新页面
//                        window.location.reload();
//                    },
//                    500 : function () {
//                        alert("删除数据失败！");
//                    }
//                }
//            });
//
//        }
        
        $(function () {
            $("#btu").click(function () {
                checkedIds = getIds();
                alert(checkedIds);
                $.ajax({
                    url : "/user/deleteBatch",
                    type : "post",
                    data : {"ids" : checkedIds},
                    statusCode: {
                        204 : function () {
                            alert("删除数据成功！");
                            //刷新页面
                            window.location.reload();
                        },
                        500 : function () {
                            alert("删除数据失败！");
                        }
                    }
                });
            })
        })

    </script>
</head>
<body>
    <table id="showUser" align="center" class="table" width="400px">
        <tr align="center">
            <th class="td">姓名</th>
            <th class="td">性别</th>
            <th class="td">年龄</th>
            <th class="td"><input type="checkbox" name="sbglId" onclick="allChecked('checkIds', this)"><input type="button" id="btu" value="删除" onclick="deleteUser()"></th>
        </tr>
        <c:forEach items="${userList}" var="user">
            <tr align="center">
                <td class="td">${user.userName}</td>
                <td class="td">${user.sex}</td>
                <td class="td">${user.age}</td>
                <td class="td"><input type="checkbox" name="checkIds" value="${user.id}"></td>
            </tr>
        </c:forEach>
    </table>

    <%--<form method="post" id="formData" action="/user/delete">--%>
        <%--<input type="text" name="id" value="3"><br>--%>
        <%--<input type="submit" value="删除一条">--%>
    <%--</form>--%>

</body>
</html>
