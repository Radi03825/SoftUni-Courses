function generateReport() {
    let report = [];
    let elementsInput = Array.from(document.getElementsByTagName('input'));
    let rows = Array.from(document.getElementsByTagName('tr')).splice(1);
    let checkedCols = elementsInput
        .map((el, i) => [el, i])
        .filter(el =>  el[0].checked);

    for (let row of rows) {
        let result = {};
        for (let [el, i] of checkedCols) {
            result[el.name] = row.children[i].textContent;
        }
        report.push(result);
    }
    document.querySelector('#output').innerHTML = JSON.stringify(report);
}