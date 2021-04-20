<#macro user_purchase cost description>
    <link rel="stylesheet" href="<@spring.url 'css/user_purchase.css'/>" type="text/css">
    <div class="achieve">
        <div>
            Cost: <p class="description_achieve">${cost}</p>
        </div>
        <div class="value_achieve">
            ${description}
        </div>
    </div>
</#macro>