function validate() {
    const emailReg = /(^[a-z]+@[a-v]+\.[a-z]+$)/;
    const input = document.querySelector('#email');
    input.addEventListener('change', change);

    function change() {
        if (!emailReg.test(input.value)) {
            input.style = 'border-color: red';
            input.className = 'error';
        }else {
            input.style = '';
            input.className = ''
        }
    }
}