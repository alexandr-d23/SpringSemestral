<#import "spring.ftl" as spring/>
<#import "views/tags/header.ftlh" as header/>
<#import "views/tags/leftblock.ftlh" as leftblock/>
<#import "views/tags/footer.ftlh" as footer/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="<@spring.url 'css/game.css' />" type="text/css">
    <script defer type="text/javascript" src="<@spring.url "js/game.js"/>"></script>
    <script
            src="https://code.jquery.com/jquery-3.5.1.min.js"
            integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
            crossorigin="anonymous"></script>
</head>
<body class="my_body">
<@header.header/>
<div class="my_container">
    <@leftblock.leftblock/>
    <div class="my-center-block" id="game">
        <div class="game_description">
            <#if weather??>
                <h1>Температура: ${weather.main.temp}<br> Ощущается как: ${weather.main.feelsLike}</h1>
            <#else>
                Извините, сервис недоступен
            </#if>
        </div>
    </div>
    <div class="my-right-block" id='right-block'>
    </div>
</div>
<@footer.footer/>
</body>
</html>