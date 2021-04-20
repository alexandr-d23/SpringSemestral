window.onload
{
    const buttons = document.getElementsByName('color-button');
    const block = document.getElementById('right-block');
    const myArray = ['#007BFF', '#DC3545', '#FFC107'];
    let currentIndex = -1;
    for (let i = 0; i < 3; i++) {
        buttons[i].onclick = function () {
            block.style.background = myArray[i]
            currentIndex = i
        }
    }
    buttons[3].onclick = function () {
        currentIndex++;
        if (currentIndex == myArray.length) currentIndex = 0
        block.style.background = myArray[currentIndex]
    }
}


