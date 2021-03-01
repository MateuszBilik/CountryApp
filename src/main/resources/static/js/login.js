let form = document.forms['login']
let email = form['email'];
let password = form['password'];

function buttonFind(event) {
    event.preventDefault();
    console.log('user written: email: ' + email.value + " password: " + password.value);

    let user_register = {
        email: email.value,
        password: password.value
    }

    //TODO zrobić to tak jak to powinno być
    fetch("login", {
        method: "post",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(user_register)
    })
        .then(response => response.text())
        .then(message => {
            console.log(message);
        })
};

form.addEventListener('submit', buttonFind)


