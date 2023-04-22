let main = document.getElementById('main');

import {showHome} from "./homePage.js";
import { showLoginPage } from "./loginPage.js";
import { showRegisterPage } from "./registerPage.js";
import { showAddMovie } from "./addMoviePage.js";
import { showDetails } from "./details.js";

showHome();

export function showView(section) {
    main.replaceChildren(section);
}


let views = {
    'homeLink': showHome,
    'loginLink': showLoginPage,
    'registerLink': showRegisterPage
}

document.querySelector('nav').addEventListener('click', showPage);

export function showPage(ev) {
    if(ev.target.tagName == 'A') {
        let view = views[ev.target.id];
        if(typeof view == 'function') {
            ev.preventDefault();
            showNav();
            view();
        }

    }
}

let logoutBtn = document.getElementById('logoutBtn');
logoutBtn.addEventListener('click', logoutAccount);

function logoutAccount(ev) {
    ev.preventDefault();
    sessionStorage.clear();
    showNav();
}

let addMovieBtn = document.getElementById('addMovieBtn');
addMovieBtn.addEventListener('click', showAddMovie);

export function showNav(addMovieBtn) {
    let userData = JSON.parse(sessionStorage.getItem('userData'));


    if(userData != null) {
        Array.from(document.getElementsByClassName('user')).forEach(e => e.style.display = 'block');
        Array.from(document.getElementsByClassName('guest')).forEach(e => e.style.display = 'none');
        let welcomeMessage = document.getElementById('welcomeMessage');
        welcomeMessage.textContent = `Welcome, ${userData.email}`;
    }else {
        Array.from(document.getElementsByClassName('user')).forEach(e => e.style.display = 'none');
        Array.from(document.getElementsByClassName('guest')).forEach(e => e.style.display = 'block');
    }
}


let moviesSection = document.getElementById('movie');
moviesSection.addEventListener('click', showDetails);
