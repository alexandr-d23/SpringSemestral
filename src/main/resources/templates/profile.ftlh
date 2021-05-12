<#import "spring.ftl" as spring/>
<#import "views/tags/header.ftlh" as header/>
<#import "views/tags/leftblock.ftlh" as leftblock/>
<#import "views/tags/footer.ftlh" as footer/>
<#import "views/tags/top_user.ftlh" as topUser/>
<#import "views/tags/user_purchase.ftlh" as userPurchase/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="<@spring.url 'css/main.css'/>" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
            crossorigin="anonymous"></script>
    <script
            src="https://code.jquery.com/jquery-3.5.1.min.js"
            integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
            crossorigin="anonymous"></script>
</head>
<body class="my_body">
<@header.header/>
<div class="my_container">
    <@leftblock.leftblock/>
    <div class="my-center-block">
        <div class="data-form">
            <div class="field">
                Email: <p name="email">${User.email}</p>
            </div>
            <div class="field">
                Name: <p name="name">${User.name}</p>
            </div>
            <br>
            <div class="field">
                <p>Scores per click:</p>
                <p> ${User.clickPower}</p>
            </div>
            <div class="data-button">
                <a href="/myAchievements" class="btn btn-dark">Мои достижения</a>
            </div>
        </div>
        <p>Your purchases: </p>
        <div class="purchases">
            <#list products as purchase>
                <@userPurchase.user_purchase description = "${purchase.description}" cost = "${purchase.cost}"/>
            </#list>
        </div>
    </div>
    <div class="my-right-block" id='right-block'>
        <div class="cub"></div>
    </div>
</div>

<@footer.footer/>
</body>

</html>
