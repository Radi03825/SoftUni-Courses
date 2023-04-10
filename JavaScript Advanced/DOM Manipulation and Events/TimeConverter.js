function attachEventsListeners() {
    document.querySelector('main').addEventListener('click', onClick);

    function onClick(ev) {
        if (ev.target.type == 'button'){
            const input = ev.target.parentElement.querySelector('input[type="text"]')
            const result = convert(Number(input.value), input.id)
        }
    }

    const constants = {
        days: 1,
        hours: 24,
        minutes: 1440,
        seconds: 86400
    }

    function convert(value, constType) {
        const inDays = value / constants[constType];
        document.querySelector('#days').value = inDays * constants.days;
        document.querySelector('#hours').value = inDays * constants.hours;
        document.querySelector('#minutes').value = inDays * constants.minutes;
        document.querySelector('#seconds').value = inDays * constants.seconds;
    }
}