<#macro header>
    <link rel="stylesheet" href="<@spring.url 'css/header.css'/>" type="text/css">
    <header class="my_header">
        <div class="main_button">
            <a href="/" class="btn btn-primary btn-lg active" role="button"
               aria-pressed="true"><@spring.message "header.btn.main"/></a>
        </div>
        <div class="right-buttons-block">
            <#if authorized??>
                <#if score?? >
                    <div class="account"><p>Your account :</p>
                    <div id="scoreCount">${score}</div>
                </#if>
                <a href="/profile" class="btn btn-primary btn-lg active" role="button"
                   aria-pressed="true"><@spring.message "header.btn.profile"/></a>
                <a href="/logout" class="btn btn-danger btn-lg active" role="button"
                   aria-pressed="true"><@spring.message "header.btn.signOut"/></a>
                </div>
            <#else>
                <a href="/signUp" class="btn btn-primary btn-lg active" role="button"
                   aria-pressed="true"><@spring.message "header.btn.signUp"/></a>
                <a href="/signIn" class="btn btn-danger btn-lg active" role="button"
                   aria-pressed="true"><@spring.message "header.btn.signIn"/></a>
            </#if>
        </div>
    </header>
</#macro>