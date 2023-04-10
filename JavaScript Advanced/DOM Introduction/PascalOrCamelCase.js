function solve() {
    let text = document.getElementById('text').value;
    let type = document.getElementById('naming-convention').value;

    let result = '';
    const arr = text.split(' ');

    if(type == 'Camel Case') {
        result = arr[0][0].toLowerCase() + arr[0].slice(1).toLowerCase();
        for (let index = 1; index < arr.length; index++) {
            const element = arr[index];
            result += element[0].toUpperCase() + element.slice(1).toLowerCase();
        }
    }else if(type == 'Pascal Case') {
        for (let index = 0; index < arr.length; index++) {
            const element = arr[index];
            result += element[0].toUpperCase() + element.slice(1).toLowerCase();
        }
    }else {
        result = 'Error!';
    }

    document.getElementById('result').textContent = result;

}