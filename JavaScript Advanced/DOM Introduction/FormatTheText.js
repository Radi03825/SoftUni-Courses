function solve() {
    let sentences = document.getElementById('input').value.split('.');
    sentences.pop();
    let output = document.getElementById('output');
    let blocks = Math.ceil(sentences.length / 3);
    let result = '';
    for (let i=0; i<blocks; i++) {
        result += `<p>${sentences.splice(0, 3).join('.')}.</p>`;
    }
    output.innerHTML = result;
}