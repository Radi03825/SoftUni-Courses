import { showView } from "./app.js";
import { showHome } from "./homePage.js";

let login = document.getElementById('form-login');
login.remove();

export function showLoginPage() {
    showView(login);
}

let loginBtn = login.querySelector('button');
loginBtn.addEventListener('click', onLogin);

async function onLogin(ev) {
    ev.preventDefault();
    let form = login.querySelector('form');
    let formData = new FormData(form);

    let email = formData.get('email');
    let password = formData.get('password');

    try{
        let res = await fetch('http://localhost:3030/users/login', {
            method: 'post',
            headers: { 'Content-type': 'application/json' },
                body: JSON.stringify({
                    email, password
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
    