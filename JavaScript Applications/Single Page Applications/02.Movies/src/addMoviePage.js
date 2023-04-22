import { showView } from "./app.js";
import { showHome } from "./homePage.js";

let addMoviePage = document.getElementById('add-movie');

export function showAddMovie() {
    showView(addMoviePage);
}

let addForm = document.querySelector('#add-movie form');
addForm.addEventListener('submit', addMovie);

async function addMovie(ev) {
    ev.preventDefault();

    let formData = new FormData(addForm);
    let title = formData.get('title');
    let description = formData.get('description');
    let imageUrl = formData.get('imageUrl');

    let userData = JSON.parse(sessionStorage.getItem('userData'));


    let res = await fetch('http://localhost:3030/data/movies', {
        method: 'post',
        headers: { 'Content-type': 'application/json', 'X-Authorization': userData.token},
        body: JSON.stringify({
            _ownerId: userData.id,
            title: title,
            description: description,
            img: imageUrl
        }) 
    })

    showHome();
}