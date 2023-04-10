function notify(message) {
    const note = document.querySelector('#notification');
    note.textContent = message;
    note.style.display = 'block';
    note.addEventListener('click', () => note.style.display = 'none')
}