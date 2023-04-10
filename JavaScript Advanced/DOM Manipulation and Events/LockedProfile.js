function lockedProfile() {
    let buttons = document.querySelectorAll('#container .profile button');

    for (const button of buttons) {
        button.addEventListener('click', showFullInfo);
    }

    function showFullInfo(ev) {

        let buttonContent = ev.target.textContent;
        const parent = ev.target.parentNode;

        const locked = Array.from(parent.querySelectorAll('input')).find(i => i.name.includes('Locked'));

        if(!locked.checked) {
            if(buttonContent == 'Show more') {
                Array.from(parent.querySelectorAll('div')).find(d => d.id.includes('HiddenFields')).style.display = 'block';
                ev.target.textContent = 'Hide it';
            }else {
                Array.from(parent.querySelectorAll('div')).find(d => d.id.includes('HiddenFields')).style.display = 'none';
                ev.target.textContent = 'Show more';
            }
        }

    }
}