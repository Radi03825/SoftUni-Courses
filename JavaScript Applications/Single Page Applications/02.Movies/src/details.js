import { showView } from "./app.js";
import { editForm, showEditMovie } from "./editMoviePage.js";
import { showHome } from "./homePage.js";

let details = document.getElementById('movie-example');

export async function showDetails(ev) {
    if(ev.target.tagName == 'BUTTON') {
    details.innerHTML = '';

    let res = await fetch('http://localhost:3030/data/movies/' + ev.target.id);
    let data = await res.json();

    let userData = JSON.parse(sessionStorage.getItem('userData'));

    let div = document.createElement('div');
    div.className = 'container';
    div.innerHTML = `<div class="row bg-light text-dark">
    <h1>Movie title: ${data.title}</h1>

    <div class="col-md-8">
        <img class="img-thumbnail" src="${data.img}"
             alt="Movie">
    </div>
    <div class="col-md-4 text-center">
        <h3 class="my-3 ">Movie Description</h3>
        <p>${data.description}</p>
        <a data-id="${ev.target.id}" class="btn btn-danger" href="#">Delete</a>
        <a data-id="${ev.target.id}"class="btn btn-warning" href="#">Edit</a>
        <a data-likes="0" class="btn btn-primary" href="#">Like</a>
    </div>
    </div>`;
       details.appendChild(div)

       let deleteBtn = details.querySelector('.btn.btn-danger');
       let editBtn = details.querySelector('.btn.btn-warning');

       if(userData == null || userData.id != data._ownerId) {
        deleteBtn.style.display = 'none';
        editBtn.style.display = 'none';
       }else {
        deleteBtn.addEventListener('click', deleteMovie);
        editBtn.addEventListener('click', editMovie);
       }

       let likeBtn = details.querySelector('.btn.btn-primary');
       likeBtn.addEventListener('click', likeMovie);

       showView(details);
    }
}

async function deleteMovie(ev) {
    ev.preventDefault();
    let id = ev.target.dataset.id;
    let userData = JSON.parse(sessionStorage.getItem('userData'));
    await fetch('http://localhost:3030/data/movies/' + id, {
                method: 'delete',
                headers: {'X-Authorization': userData.token}
            })

    showHome();
}

export async function editMovie(ev) {
    ev.preventDefault();

    let id = ev.target.dataset.id;

    showEditMovie();

    editForm.addEventListener('submit', editMovieForm);

    async function editMovieForm(ev) {
        ev.preventDefault();
        let formData = new FormData(editForm);

        let userData = JSON.parse(sessionStorage.getItem('userData'));

        await fetch('http://localhost:3030/data/movies/' + id, {
        method: 'put',
        headers: { 'Content-type': 'application/json', 'X-Authorization': userData.token},
        body: JSON.stringify({
            _ownerId: userData.id,
            title: formData.get('title'),
            description: formData.get('description'),
            img: formData.get('imageUrl')
        })
    })

    editForm.reset();

    showHome();
    }
    
}

function likeMovie(ev) {
    ev.preventDefault();

    let likes = Number(ev.target.dataset.likes);
    likes++;
    ev.target.removeEventListener('click', likeMovie);

    ev.target.textContent = `Liked: ${likes}`;
    ev.target.dataset.likes = likes;
}