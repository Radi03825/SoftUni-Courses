window.addEventListener('load', solution);

async function solution() {
    let main = document.getElementById('main');

    let res = await fetch('http://localhost:3030/jsonstore/advanced/articles/list');
    let data = await res.json();

    for (const profil of data) {
        createAccordion(profil);
    }

    async function createAccordion(profil) {
        let res = await fetch(`http://localhost:3030/jsonstore/advanced/articles/details/${profil._id}`);
        let data = await res.json();

        let div = document.createElement('div');
        div.className = 'accordion';

        let headDiv = document.createElement('div');
        headDiv.className = 'head';

        headDiv.innerHTML = `<span>${profil.title}</span>`;
        let button = document.createElement('button');
        button.className = 'button';
        button.id = profil._id;
        button.textContent = 'more';

        button.addEventListener('click', showInfo);

        let extraDiv = document.createElement('div');
        extraDiv.className = 'extra';
        extraDiv.innerHTML = `<p>${data.content}</p>`;

        headDiv.appendChild(button);
        div.appendChild(headDiv);
        div.appendChild(extraDiv);
        main.appendChild(div);

        function showInfo(ev) {
            let l = ev.target.parentNode.nextSibling;

            if(ev.target.textContent == 'more') {
                ev.target.textContent = 'less';
                l.style.display = 'block';
            }else {
                ev.target.textContent = 'more';
                l.style.display = 'none';

            }
        }
    }
}