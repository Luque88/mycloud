var jsonDocumenti;

function caricaDocumento(){
    fetch('http://localhost:8080/mycloud/resources/documents')
            .then(response => {
                console.log("response...", response);
        return response.json();
    })
            .then(json => {
                creaTabellaDaJson(json, "", "tabDocumenti", "tabella", "#contenitore");
                jsonDocumenti = json;
    })
            .then(e => caricaSelect())
            .catch(x => {
                alert("err", x);
    });
}

caricaDocumento();

function caricaSelect(){
    document.querySelector("#sel_documenti").innerHTML="";
    
    let opt = document.createElement("option");
    opt.innerHTML = "Scegli il documento da modificare";
    opt.value= -1;
    document.querySelector("#sel_documenti").append(opt);
    
    jsonDocumenti.forEach((documento, j)=>{
        let opt= document.createElement("option");
        opt.innerHTML= documento.id + "--> " + documento.documento + " - " + documento.titolo + " - " + documento.file + " - " + documento.user_id;
        opt.value=j;
        opt.setAttribute("documento", documento.documento);
        opt.setAttribute("titolo", documento.titolo);
        opt.setAttribute("file", documento.file);
        opt.setAttribute("user_id", documento.user_id);
        opt.setAttribute("id", documento.id);
        document.querySelector("#sel_documenti").append(opt);
    });
}


//completare e rivedere

