function summenberechnung(n){
    let x = 0;
    let sum =0;
    while(x<n) {
        x++;
        sum = sum + x;
    }
    return sum;
}
let eing = prompt('Gib was ein' , '');
alert(summenberechnung(eing));
function onclick1(){
    console.log(('on click'));
}
function onmouseup1(){
    console.log(('oben'));
}
function onmousedown1(){
    console.log(('unten'));
}
function logon(e) {
     console.log("On:");
     console.log(e);
     }
     function logoff(e) {
     console.log("Off:");
     console.log(e);
     }
     function key(){
         console.log(event.code);
         console.log("Fokus: " + event.srcElement());
     }
     key(); 