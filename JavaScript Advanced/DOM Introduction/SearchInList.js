function search() {
    let searchText = document.getElementById('searchText').value;

    let items = Array.from(document.querySelectorAll('#towns li'))

    let counter = 0;

    for (const item of items) {
        if(item.textContent.includes(searchText)) {
            item.style.fontWeight = 'bold';
            item.style.textDecoration = 'underline';
            counter++;
        }else {
            item.style.fontWeight = 'normal';
            item.style.textDecoration = '';
        }
    }

    document.getElementById('result').textContent = `${counter} matches found`;
}