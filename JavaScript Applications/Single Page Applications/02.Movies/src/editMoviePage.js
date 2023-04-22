import { showView } from "./app.js";
import { editMovie } from "./details.js";

let editMoviePage = document.getElementById('edit-movie');

export function showEditMovie() {
    showView(editMoviePage);
}

export let editForm = editMoviePage.querySelector('.text-center.border.border-light.p-5');