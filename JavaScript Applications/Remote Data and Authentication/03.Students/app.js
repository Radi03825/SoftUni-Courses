    let form = document.getElementById('form');

    form.addEventListener('submit', addStudent);

    async function addStudent(ev) {
        ev.preventDefault();
        let data = new FormData(form);

        let firstName = data.get('firstName').trim();
        let lastName = data.get('lastName').trim();
        let facultyNumber = data.get('facultyNumber').trim();
        let grade = data.get('grade').trim();


        await fetch('http://localhost:3030/jsonstore/collections/students', {
            method:'post',
            headers: { 'Content-type': 'application/json' },
            body: JSON.stringify({
                firstName,
                lastName,
                facultyNumber,
                grade
            }) 
        });

        form.reset();

        fillTheTable();
    }

async function fillTheTable() {
    let table = document.querySelector('#results tbody');

    let res = await fetch('http://localhost:3030/jsonstore/collections/students');
    let data = await res.json();

    table.innerHTML = '';

    for (const d in data) {
        let tr = document.createElement('tr');

        tr.innerHTML = `<td>${data[d].firstName}</td> <td>${data[d].lastName}</td> <td>${data[d].facultyNumber}</td> <td>${data[d].grade}</td>`;
        table.appendChild(tr);
    }
}


fillTheTable();