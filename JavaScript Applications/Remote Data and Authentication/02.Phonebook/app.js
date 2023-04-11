async function attachEvents() {
    let ul = document.getElementById('phonebook');
    let person = document.getElementById('person');
    let phone = document.getElementById('phone');

    let loadBtn = document.getElementById('btnLoad');
    let createBtn = document.getElementById('btnCreate');

    loadBtn.addEventListener('click', loadContacts);
    createBtn.addEventListener('click', createContact);

    async function createContact() {
        const data = {"person": person.value,
        "phone": phone.value};

       fetch('http://localhost:3030/jsonstore/phonebook', {
       
       method: 'post',
       
       headers: { 'Content-type': 'application/json' },
       
       body: JSON.stringify(data)
       
       });   

       person.value = '';
       phone.value = '';

       loadContacts();
    }

    async function loadContacts() {
        let res = await fetch('http://localhost:3030/jsonstore/phonebook');
        let data = await res.json();
    
        ul.innerHTML = '';

        for (const d in data) {
            let li = document.createElement('li');
            li.textContent = `${data[d].person}: ${data[d].phone}`;
    
            let deleteBtn = document.createElement('button');
            deleteBtn.textContent = 'Delete';
            deleteBtn.addEventListener('click', deleteContact);
    
            li.appendChild(deleteBtn);
            ul.appendChild(li);
        }

    }

    

    async function deleteContact(ev) {
        let liToRemove = ev.target.parentNode.textContent;
        liToRemove = liToRemove.replace('Delete', '');
        let personToRemove = liToRemove.split(': ')[0];
        let phoneToRemove = liToRemove.split(': ')[1];

        let res = await fetch('http://localhost:3030/jsonstore/phonebook');
        let data = await res.json();

        for (const d in data) {
            if(data[d].person == personToRemove && data[d].phone == phoneToRemove) {
                await fetch(`http://localhost:3030/jsonstore/phonebook/${data[d]._id}`, {
                    method: 'delete'
                });
                break;
            }
        }
        
        loadContacts();
    }
}

attachEvents();