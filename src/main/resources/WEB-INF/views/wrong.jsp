<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  entities.User: Alex
  Date: 11.10.2020
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href='<c:url value="/style/style.css"/>' type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</head>
<body class="my_body">
<t:header/>
<div class="my_container">
    <t:leftblock/>
    <div class="my-center-block">
        <div class = "game_description">
                <h1>Неизвестная ошибка, мы уже над ней работаем, попробуйте позже!</h1>
        </div>
    </div>
    <div class="my-right-block"  id = 'right-block'>
        <div class = "cub"></div>
    </div>
</div>

<t:footer footerText="Текст в футере Стартовой страницы"></t:footer>
<script type="text/javascript" src ="${pageContext.request.contextPath}/js/script.js">
</script>
</body>

</html>