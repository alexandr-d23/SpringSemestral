<#import "spring.ftl" as spring/>
<#import "views/tags/header.ftlh" as header/>
<#import "views/tags/leftblock.ftlh" as leftblock/>
<#import "views/tags/footer.ftlh" as footer/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="<@spring.url 'css/main.css'/>" type="text/css">
    <link rel="stylesheet"
          href='<@spring.url 'https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'/>'
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body class="my_body">
<@header.header/>
<div class="my_container">
    <@leftblock.leftblock/>
    <div class="my-center-block">
        <@spring.bind "userForm" />
        <form action="${springMacroRequestContext.contextPath}/signUp" method="POST">
            <div class="data-form">
                <#if userExists??>
                    <div class="error">userExists</div>
                </#if>
                <label><@spring.message "sign_up_page.email"/></label>
                <@spring.formInput "userForm.email"/>
                <@spring.showErrors "<br>" "error"  />
                <label><@spring.message "sign_up_page.name"/></label>
                <@spring.formInput "userForm.name"/>
                <@spring.showErrors "<br>" "error"  />
                <label><@spring.message "sign_up_page.password"/></label>
                <@spring.formPasswordInput "userForm.password"/>
                <@spring.showErrors "<br>" "error"  />
                <input name="phone" type="text" placeholder="PHONE">
                <br>
                <div class="data-button">
                    <input type="submit" value="<@spring.message "sign_up_page.signUp"/>" name="color-button"
                           class="btn btn-dark"/>
                </div>
            </div>
        </form>
    </div>
    <div class="my-right-block" id='right-block'>
        <div class="cub"></div>
    </div>
</div>
<@footer.footer />
</body>

</html>