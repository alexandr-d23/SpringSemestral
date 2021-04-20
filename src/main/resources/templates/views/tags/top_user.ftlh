<#macro  topUser name score>
    <link rel="stylesheet" href= "<@spring.url '/css/top_user.css'/>" type="text/css">
    <div class="achieve">
        <div>
            <p class="description_achieve">${name}</p>
        </div>
        <div class="value_achieve">
            ${score}
        </div>
    </div>
</#macro>
