<#macro edit_achievement description type requiredValue id>
    <link rel="stylesheet" href="<@spring.url 'css/achievement_edit.css'/>" type="text/css">
    <form>
        <div class="achieve">
            <div>
                <input type="text" name="description" value="${description}"/>
            </div>
            <div>
                <input type="text" name="type" value="${type}"/>
            </div>
            <div class="value_achieve">
                <input type="hidden" name="id" value="${id}"/>
                <input type="number" name="value" value="${requiredValue}"/>
            </div>
            <button formaction="${springMacroRequestContext.contextPath}/edit" formmethod="post"
                    type="submit" name="change" value="change" class="btn btn-dark">Change
            </button>
            <button formaction="${springMacroRequestContext.contextPath}/edit" formmethod="post"
                    type="submit" name="delete" value="delete" class="btn btn-dark">Delete
            </button>
        </div>
    </form>
</#macro>