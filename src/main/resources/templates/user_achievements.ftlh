<#import "spring.ftl" as spring/>
<#import "views/tags/header.ftlh" as header/>
<#import "views/tags/leftblock.ftlh" as leftblock/>
<#import "views/tags/footer.ftlh" as footer/>
<#import "views/tags/got_achievement.ftlh" as gotAchievement/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href= "<@spring.url "css/main.css"/>" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</head>
<body class="my_body">
<@header.header/>
<div class="my_container">
    <@leftblock.leftblock/>
    <div class="my-center-block">
        <#if achievements??>
            <#list achievements as achievement>
                <@gotAchievement.gotAchievement description= "${achievement.description}"/>
            </#list>
        </#if>
    </div>
    <div class="my-right-block"  id = 'right-block'>
        <div class = "cub"></div>
    </div>
</div>


</body>

</html>