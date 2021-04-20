<#macro achievement requiredValue description>
    <link rel="stylesheet" href="<@spring.url 'css/achievement.css'/>" type="text/css">
    <div class="achieve">
        <div>
            <p class="description_achieve">${description}</p>
        </div>
<#--        <div class="value_achieve">-->
<#--            <#if got == 'true'>-->
<#--                Completed-->
<#--            <#else> ${currentValue}-->
<#--            </#if>-->
<#--        </div>-->
    </div>
</#macro>