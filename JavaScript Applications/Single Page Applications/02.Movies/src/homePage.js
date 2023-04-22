import { showNav, showView, showPage } from "./app.js";

let homePage = document.getElementById('home-page');
homePage.remove();

export function showHome() {
    getMovies();
    showView(homePage);
    showNav();
}

export async function getMovies() {
    let res = await fetch('http://localhost:3030/data/movies');
    let data = await res.json();

    catalog.replaceChildren(...data.map(createMovieCard));
}

let catalog = homePage.querySelector('.card-deck.d-flex.justify-content-center');

function createMovieCard(movie) {
    let div = document.createElement('div');
    div.className = 'card mb-4'

    div.innerHTML = `<img class="card-img-top" src="${movie.img}"
            alt="Card image cap" width="400">
        <div class="card-body">
            <h4 class="card-title">${movie.title}</h4>
        </div>
        <div class="card-footer">
            <a href="#">
                <button id="${movie._id}" type="button" class="btn btn-info">Details</button>
            </a>
        </div>`;

    return div;
}