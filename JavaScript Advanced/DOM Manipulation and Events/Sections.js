function create(words) {
    for (const word of words) {
        let div = document.createElement('div');

        div.addEventListener('click', showText);

        let p = document.createElement('p');
        p.textContent = word;

        p.style.display = 'none';

        div.appendChild(p);
        document.getElementById('content').appendChild(div);

        function showText(ev) {
            ev.target.querySelector('p').style.display = 'block';
        }
    }
}