<#macro shopItem id cost description>
    <link rel="stylesheet" type="text/css" href="<@spring.url 'css/shop_item.css'/>"/>
    <form action="/shop" method="post">
        <div>
            Cost: <p class="description_achieve">${cost}</p>
        </div>
        <div class="value_achieve">
            ${description}
            <input type="hidden" name = "id" value="${id}"/>
        </div>
        <button type="submit" name="color-button" class="btn btn-dark">Buy</button>
    </form>
</#macro>