function solve() {
    let info = document.getElementsByClassName('info')[0];
    let departBtn = document.getElementById('depart');
    let arriveBtn = document.getElementById('arrive');


    let id;
    async function depart() {
        if(info.textContent == 'Not Connected') {
            id = 'depot';
        }
        
        try{
        departBtn.disabled = true;

        let url = `http://localhost:3030/jsonstore/bus/schedule/${id}`;
        let res = await fetch(url);

        if(res.status == false) {
            throw Error('Error');
        }

        let data = await res.json();

        id = data.next;

        info.textContent = `Next stop ${data.name}`;

        arriveBtn.disabled = false;
     }catch(error) {
        info.textContent = 'Error';

        departBtn.disabled = true;
        arriveBtn.disabled = true;
     }
    }

    function arrive() {
        let stop = info.textContent.slice(9);
     
        info.textContent = `Arriving at ${stop}`;
        

        departBtn.disabled = false;
        arriveBtn.disabled = true;
    }

    return {
        depart,
        arrive
    };
}

let result = solve();