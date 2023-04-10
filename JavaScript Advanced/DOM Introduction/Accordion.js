function toggle() {
    let buttonText = document.querySelector('.button');
    let text = document.getElementById('extra');

    if(buttonText.textContent == 'More') {
        text.style.display = 'block';
        buttonText.textContent = 'Less';
    }else {
        text.style.display = 'none';
        buttonText.textContent = 'More';
    }
}