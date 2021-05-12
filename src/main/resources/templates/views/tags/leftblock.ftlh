<#macro leftblock>
    <link rel="stylesheet" href="<@spring.url 'css/leftblock.css'/>" type="text/css">
    <div class="my-left-block">
        <a href="/game" class="btn btn-danger btn-lg active" role="button"
           aria-pressed="true"><@spring.message "leftblock.btn.game"/></a>
        <#if authorized??>

            <a href="/shop" class="btn btn-primary btn-lg active" role="button"
               aria-pressed="true"><@spring.message "leftblock.btn.shop"/></a>
            <a href="/achievements" class="btn btn-success btn-lg active" role="button"
               aria-pressed="true">Achievements</a>
        </#if>
        <a href="/rating" class="btn btn-warning btn-lg active" role="button"
           aria-pressed="true"><@spring.message "leftblock.btn.rating"/></a>

        <a href="/weather" class="btn btn-info" role="button"
           aria-pressed="true"><@spring.message "weather.kazan"/></a>
    </div>
</#macro>
