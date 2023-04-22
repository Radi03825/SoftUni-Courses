import { showView } from "./app.js";
import { showHome } from "./homePage.js";

let register = document.getElementById('form-sign-up');
register.remove();

export function showRegisterPage() {
    showView(register);
}

let registerBtn = register.querySelector('button');
registerBtn.addEventListener('click', onRegister);

async function onRegister(ev) {
    ev.preventDefault();

    let form = register.querySelector('form');
    let formData = new FormData(form);


    let email = formData.get('email').trim();
    let password = formData.get('password').trim();
    let repeatPassword = formData.get('repeatPassword').trim();

    try{
        if(email == '') {
            throw Error('The email input must be filled');
        }else if(password.length < 6) {
            throw Error('The password should be at least 6 characters long');
        }else if(password != repeatPassword) {
            throw Error('The repeat password should be equal to the password');
        }

        let res = await fetch('http://localhost:3030/users/register', {
            method: 'post',
            headers: { 'Content-type': 'application/json' },
                body: JSON.stringify({
                    email, password, repeatPassword
                }) 
        })

        if(res.ok == false) {
            let error = res.json();
            throw Error(error.message);
        }

        let data = await res.json();

        sessionStorage.setItem('userData', JSON.stringify({
            email: data.email,
            id: data._id,
            token: data.accessToken
        }))

        form.reset();
        showHome();
    }catch(error) {
        alert(error.message)
    }
}