const palavra = document.getElementById('palavra-resposta').innerText;
let contadorLinhaForm = 1;

init();

function init(){
    document.addEventListener("keydown", function(event) {
        if (event.key === "Enter") {
            validarResposta();
        }
    });

    document.addEventListener("input", function(event) {
        if (event.key !== "Enter") {
            changeFocus();
        }
    });
}


function validarResposta(){  
    var linhas = document.getElementsByName(`linha${contadorLinhaForm}`);

    for (var i = 0; i < linhas.length; i++){
        if(linhas[i].value === ""){
            return;
        }
    }

    let palavraDigitada = '';

    for (var i = 0; i < linhas.length; i++){
        var input = linhas[i];
        if(input.value.toUpperCase() === palavra[i]){
            input.classList.add('bloco_verde');
        }
        else if(palavra.includes(input.value.toUpperCase())){
            input.classList.add('bloco_amarelo');
        }

        palavraDigitada += input.value.toUpperCase();

        input.readOnly = true;
    }

    if(palavraDigitada === palavra){
        showModal(true);
        return;
    }else if(contadorLinhaForm >= 6){
        showModal(false);
        return;
    }

    habilitarCampos();
}

function habilitarCampos(){
    contadorLinhaForm++;

    var linhas = document.getElementsByName(`linha${contadorLinhaForm}`);

    for (var i = 0; i < linhas.length; i++){
        linhas[i].readOnly = false;
    }
}

function showModal(isVenceu){    
    if(isVenceu){
        document.getElementById('idVenci').style.display = 'flex';
    }
    else{
        document.getElementById('idPerdi').style.display = 'flex';
    }
}

function changeFocus(){
    var id = document.activeElement.id;

    let idPadrao = `linha${contadorLinhaForm}-coluna`;

    let numberColumn = Number(id.replace(idPadrao, ''));

    if(numberColumn < 5){
        document.getElementById(`${idPadrao}${numberColumn + 1}`).focus()
    }
}