<#macro add_achievement>
    <link rel="stylesheet" href="<@spring.url 'css/achievement_edit.css'/>" type="text/css">
    <form>
        <div class="achieve">
            <div>
                <input type="text" name="description" placeholder="Description"/>
            </div>
            <div>
                <input type="text" name="type" placeholder="Action type"/>
            </div>
            <div class="value_achieve">
                <input type="hidden" name="id" value="-1"/>
                <input type="number" name="value" placeholder="Required value"/>
            </div>
            <button formaction="${springMacroRequestContext.contextPath}/edit" formmethod="post"
                    type="submit" name="add" value="add" class="btn btn-dark">Add
            </button>
        </div>
    </form>
</#macro>