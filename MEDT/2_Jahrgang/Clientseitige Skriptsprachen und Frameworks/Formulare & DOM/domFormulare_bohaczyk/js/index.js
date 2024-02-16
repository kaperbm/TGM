function funktion() {
    let name = document.getElementById("name");
    let name2 = document.getElementById("name2");
    let bday = document.getElementById("bday");

    let male = document.getElementById("male");
    let female = document.getElementById("female");

    let name3 = document.getElementById("name3");

    let image = document.querySelector("input#image");
    let bg = document.getElementById("bg");
    let personal = document.getElementById("personal");
    let text = document.getElementById("websitetext");

    document.getElementById("name3preview").innerHTML = name3.value;

    if(personal.checked){ 
        var text2 = "";
        if(male.checked){
            text2 = `Das ist die Seite von Herr ${name.value} ${name2.value} geboren am ${bday.value}`;

        }
        else if(female.checked){
            text2 = `Das ist die Seite von Frau ${name.value} ${name2.value} geboren am ${bday.value}`;
        }

        document.getElementById("text2preview").innerHTML = text2;
    }
    else{
        document.getElementById("text2preview").innerHTML = "Das ist die Seite von Herr/Frau Vor/Nachname geboren am Geburtsdatum";
    }
    document.getElementById("textpreview").innerHTML = text.value;
    document.getElementById("preview").style.backgroundColor = bg.value;
    let img = document.form.image.files[0];

    document.getElementById("imagepreview").src = "src/" + img.name;
}
    document.getElementById("send").addEventListener("click", funktion,false);