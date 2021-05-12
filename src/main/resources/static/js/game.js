window.onload
{
    const score = document.getElementById("scoreCount")
    let clickPower = 1
    let countOfClick = 0
    let maxCountOfClick = 30
    let gameblock = document.getElementById("game")
    console.log(gameblock)
    gameblock.addEventListener("click", getScore)

    function getScore() {
        if (countOfClick == 0 || countOfClick >= maxCountOfClick) {
            if (countOfClick == 0) countOfClick = 1
            ajax(countOfClick)
        }
        countOfClick++
        if (countOfClick > maxCountOfClick) countOfClick = 1
        score.innerHTML = (Number(score.innerHTML) + Number(clickPower)).toString()
    }

    function ajax(value) {
        $.ajax({
            url: "/game?value=" + value,
            type: "PUT",
            dataType: "json",
            success: [function (msg) {
                clickPower = parseInt(msg)
            }
            ]
        });
    }
}
