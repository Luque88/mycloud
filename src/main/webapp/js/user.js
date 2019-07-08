var jsonUsers;

document.querySelector("body").onload = caricaUsers;

function caricaUsers(){
    fetch('http://localhost:8080/mycloud/resources/users' + Math.random())
            .then(response =>.json())
            .then(json => {
                creaTabellaDaJson(json, "cognome, nome, username, password, email", "tabUsers", "tabella", "id", b_inserisci);
        jsonUsers=json;
        console.log(json);
    })
            .catch(x => {
                alert("err" + x);
        console.log("err", x);
    });
    document.querySelector("#div_inserisci").style.display ="none";
}

function caricaUser(idUser){
    let user = getRecJson(jsonUsers, "id", idUser);
    
    document.querySelector("#id").value = id;
    document.querySelector("#cognome").value= user.cognome;
    document.querySelector("#nome").value= user.nome;
    document.querySelector("#username").value= user.username;
    document.querySelector("#password").value= user.password;
    document.querySelector("#email").value= user.email;
};

document.querySelector("#b_inserisci").onclick= function(){
    document.querySelector("#div_inserisci").style.display= "none";
};

console.log("insersci", user);

fetch('http://localhost:8080/mycloud/resources/users' + idUser{
    method: 'get',
    
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(user)
}).then(function (response){
    console.log("response", response);
    console.log("response.text():", response.text());
    caricaUser();
    return;
}).catch(res => console.error ("Errore:", res));


