let loadBtn = document.getElementById('loadBooks');
loadBtn.addEventListener('click', loadBooks);

let table = document.querySelector('table tbody');
table.addEventListener('click', checkForAction);

let form = document.getElementsByTagName('form')[0];
form.addEventListener('submit', createBook);

function checkForAction(ev) {
    let id = ev.target.dataset.id;

    if(id != undefined) {
        if(ev.target.name == 'edit') {
            let currentTitle = ev.target.parentNode.previousElementSibling.previousElementSibling;
            let currentAuthor = ev.target.parentNode.previousElementSibling;

            let h3 = document.querySelector('form h3');
            h3.textContent = 'Edit FORM';
            let title = document.getElementsByName('title')[0];
            title.value = currentTitle.textContent;
            let author = document.getElementsByName('author')[0];
            author.value = currentAuthor.textContent;

            form.removeEventListener('submit', createBook);
            form.addEventListener('submit', editBook);

            async function editBook(ev) {
                ev.preventDefault();

                let f = new FormData(form);
                let newAuthor = f.get('author');
                let newTitle = f.get('title');

                fetch('http://localhost:3030/jsonstore/collections/books/' + id, {
                    method: 'put',
                    headers: { 'Content-type': 'application/json' },
                    body: JSON.stringify({
                        "title": newTitle,
                        "author": newAuthor
                    })
                })

                h3.textContent = 'FORM';
                form.reset();

                form.addEventListener('submit', createBook);

                currentTitle.textContent = newTitle;
                currentAuthor.textContent = newAuthor;
            }
        }else {
            fetch('http://localhost:3030/jsonstore/collections/books/' + id, {
                method: 'delete'
            });
            let parent = ev.target.parentNode.parentNode;

            table.removeChild(parent);
        }
    }
}



async function loadBooks() {
    let res = await fetch('http://localhost:3030/jsonstore/collections/books');
    let data = await res.json();

    table.innerHTML = '';

    for (const d in data) {
        let tr = document.createElement('tr');

        tr.innerHTML = `<td>${data[d].title}</td>
        <td>${data[d].author}</td>
        <td>
            <button data-id="${d}" name="edit">Edit</button>
            <button data-id="${d}" name="delete">Delete</button>
        </td>`;

        table.appendChild(tr);
    }
}



async function createBook(ev) {
    ev.preventDefault();

    let formData = new FormData(form);

    let title = formData.get('title');
    let author = formData.get('author');

    if(title != '' && author != '') {
        fetch('http://localhost:3030/jsonstore/collections/books', {
            method: 'post',
            headers: { 'Content-type': 'application/json' },
            body: JSON.stringify({
                title,
                author
            })
        });
        form.reset();
    }
}