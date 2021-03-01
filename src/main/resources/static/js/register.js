let form = document.forms['register1']
let email = form['email'];
let password = form['password'];

function buttonFind(event) {
    event.preventDefault();
    console.log('user written: email: ' + email.value + " password: " + password.value);

    let user_register = {
        email: email.value,
        password: password.value
    }

    
    fetch("register", {
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


