function register(){
    let firstName = document.getElementById('first').value;
    let lastName = document.getElementById('last').value;

    if(!checkIfNull(firstName)){
        alert('Enter First Name')
    }
    if(!checkIfNull(lastName)){
        alert('Enter Last Name')
    }
}

function checkIfNull(information){
    if(information == null||information == ""){
        return false;
    }
}