<#macro achievement requiredValue description currentValue got>
    <link rel="stylesheet" href="<@spring.url 'css/achievement.css'/>" type="text/css">
    <div class="achieve">
        <div>
            <p class="description_achieve">${description}</p>
        </div>
        <div class="value_achieve">
            <#if got>
                Completed
            <#else> ${currentValue}/${requiredValue}
            </#if>
        </div>
    </div>
</#macro>