function encodeAndDecodeMessages() {
    let placeHolder = document.querySelectorAll('textarea placeholder');

    let normalMessage = document.getElementsByTagName('textarea')[0];

    let encodeMessage = document.getElementsByTagName('textarea')[1];

    let encodeButton = document.getElementsByTagName('button')[0];

    let decodeButton = document.getElementsByTagName('button')[1];

    encodeButton.addEventListener('click', encode);

    function encode() {
        decodeButton.addEventListener('click', decode);

        let mes = '';
        for (let index = 0; index < normalMessage.value.length; index++) {

            mes += String.fromCharCode(normalMessage.value.charCodeAt(index) + 1);
        }

        encodeMessage.value = mes;
        normalMessage.value = '';
    }

    function decode() {
        let mes = '';
        for (let index = 0; index < encodeMessage.value.length; index++) {

            mes += String.fromCharCode(encodeMessage.value.charCodeAt(index) - 1);
        }

        encodeMessage.value = mes;

        decodeButton.removeEventListener('click', decode);
    }
}