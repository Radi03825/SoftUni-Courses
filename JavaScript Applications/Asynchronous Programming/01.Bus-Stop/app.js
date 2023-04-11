async function getInfo() {
    let stopId = document.getElementById('stopId');
    let stopName = document.getElementById('stopName');
    let ul = document.getElementById('buses');

    try {

    const res = await fetch(`http://localhost:3030/jsonstore/bus/businfo/${stopId.value}`);

    if(res.status == false) {
        throw Error('Error');
    }

    const data = await res.json();

    console.log(data)


    stopName.textContent = data.name;

    console.log(data.buses)


    ul.innerHTML = '';

    for (const bus in data.buses) {
        let li = document.createElement('li');
        li.textContent = `Bus ${bus} arrives in ${data.buses[bus]} minutes`;
        ul.appendChild(li);
    }
}catch(error) {
    stopName.textContent = 'Error';
    ul.innerHTML = '';

}finally {
    stopId.value = '';
}

}