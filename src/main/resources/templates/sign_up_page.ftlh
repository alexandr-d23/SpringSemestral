<#import "spring.ftl" as spring/>
<#import "views/tags/header.ftlh" as header/>
<#import "views/tags/leftblock.ftlh" as leftblock/>
<#import "views/tags/footer.ftlh" as footer/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="<@spring.url 'css/main.css'/>" type="text/css">
    <link rel="stylesheet" href='<@spring.url 'https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'/>'
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body class="my_body">
<@header.header/>
<div class="my_container">
    <@leftblock.leftblock/>
    <div class="my-center-block">
        <form action="${springMacroRequestContext.contextPath}/signUp" method="POST" >
            <div class="data-form">
                <input type = "text" name="email" placeholder="<@spring.message "sign_up_page.email"/>"/>
                <input type = "text" name="name" placeholder="<@spring.message "sign_up_page.name"/>"/>
                <input type = "password" name="password" placeholder="<@spring.message "sign_up_page.password"/>"/>
                <div><@spring.message "sign_up_page.gender"/>
                    <br>
                    <input type="radio" name="gender" value="female" checked />Female
                    <input type="radio" name="gender" value="male" />Male
                </div>
                Country: <select name="country">
                    <option>Spain</option>
                    <option>France</option>
                    <option>Germany</option>
                    <option>Russia</option>
                </select>
                <br>
                <div class="data-button">
                    <input type="submit" value="<@spring.message "sign_up_page.signUp"/>" name="color-button" class="btn btn-dark"/>
                </div>
<#--                <c:if test="${requestScope.get('registered') == 'false'}">-->
<#--                    <p class = 'wrong-data'>${requestScope.get('failedDescription')}</p>-->
<#--                </c:if>-->
<#--                <c:if test="${requestScope.get('registered') == 'true'}">-->
<#--                    <p class = 'user-registered'>Поздравляем, вы успешно зарегистрированы</p>-->
<#--                </c:if>-->
            </div>
        </form>
    </div>
    <div class="my-right-block"  id = 'right-block'>
        <div class = "cub"></div>
    </div>
</div>
<@footer.footer />
</body>

</html>