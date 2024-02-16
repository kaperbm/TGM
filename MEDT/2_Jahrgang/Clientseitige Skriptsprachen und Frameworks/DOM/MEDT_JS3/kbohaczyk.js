function reverseArr(arr) {
    var x = new Array;

    for(var i = arr.length-1; i >= 0; i--) {
        x = arr[i];
    }
    return x;
}

function reverseREK (arr2) {
    if (arr2 === "") {
        return "";
    } else {
        return reverse(arr2.substr(1)) + arr2.charAt(0);
    }
}

function randomColor() {
    var hexaLetters = "0123456789ABCDEF";
    var color = "#";
    for (var i = 0; i < 6; i++) {
        color += hexaLetters[Math.floor(Math.random() * 16)];
    }
    return color;
}



let footer = document.getElementById('footer');
function changeColor(){
    footer.style.backgroundColor = randomColor();
}
footer.addEventListener('mouseover', changeColor);
function doSomething() {
    footer.innerHTML = event.clientX + " / " + event.clientY;
}

let lipsum = document.getElementById('lipsum');
lipsum.addEventListener('mousemove',doSomething);
