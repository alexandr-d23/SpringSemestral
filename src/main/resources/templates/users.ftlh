<#import "spring.ftl" as spring/>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Registration</title>
    <link rel="stylesheet" href="../static/css/main.css" type="text/css">
</head>
<body>
<div class="registration-content">
    <div>
        Hello, ${user.name}, your id is ${user.id}
        <#if user.age??>
            Age is ${user.age}
        <#else>
            Age is undefined
        </#if>

        Other users:
        <#list users as listUser>
            <tr>
                Name: ${listUser.name}
                Email: ${listUser.email}
            </tr>
        </#list>
        Hello man
    </div>
</div>
</body>
</html>