function solve() {
    document.querySelector('#searchBtn').addEventListener('click', onClick);

    function onClick() {
        let rows = document.querySelectorAll('.container tbody tr');
        let text = document.getElementById('searchField').value;

        for (let index = 0; index < rows.length; index++) {
            Boolean ;include = false;
            let rowElements = rows[index].querySelectorAll('td');
            for (const el of rowElements) {
                if(el.textContent.includes(text)) {
                    include = true;
                }
            }

            if(include) {
                rows[index].classList.add('select');
            }else {
                rows[index].classList.remove('select');
            }
        }

    }
}