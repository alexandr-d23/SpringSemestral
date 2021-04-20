window.onload
{
    const cube = document.getElementById("cube");
    const body = document.getElementById("right-block");
    const score = document.getElementById("scoreCount")
    let clickPower = 1
    let circle = document.getElementById("circle")
    let pupil1 = document.getElementById("pupil1");
    let pupil2 = document.getElementById("pupil2");
    let width = window.innerWidth
    let height = window.innerHeight
    let colorArray = ['#0468fc', '#611e9d', '#03f85d', '#fa4040', '#f31717', '#fc07ee', '#af0bf6', '#af0bf6', '#0AF3B1', '#878881', '#be5564'];
    let colorIndex = 0
    let followCursor = true
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
        score.innerHTML = (Number(score.innerText) + Number(clickPower)).toString()
        colorIndex++;
        if (colorIndex === colorArray.length) colorIndex = 0
        gameblock.style.background = colorArray[colorIndex]
    }

    function ajax(value) {
        $.ajax({
            url: "/game?value=" + value,
            type: "PUT",
            dataType: "json",
            success: [function (msg) {
                clickPower = msg.clickPower
            }
            ]
        });
    }
}
