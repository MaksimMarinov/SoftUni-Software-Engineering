function encodeAndDecodeMessages() {
    const [writeMsg, receivedMsg] = document.querySelectorAll('textarea');
    const [encodeBtn, decodeBtn] = document.querySelectorAll('button');
    encodeBtn.addEventListener('click', encode);
    decodeBtn.addEventListener('click', decode)

    function encode(e) {
        let text = writeMsg.value;
        receivedMsg.value = coding(text);
        writeMsg.value = '';

    }

    function decode(e) {
        let text = receivedMsg.value;
        let newText = deCoding(text);

        receivedMsg.value = newText;
    }

    function coding(text) {
        let result = '';
        for (let i = 0; i < text.length; i++) {
            let currentChar = text[i]
            let asciCode = currentChar.charCodeAt(0);
            asciCode += 1;
            currentChar = String.fromCharCode(asciCode);
            result += currentChar;
        }

        return result;
    }

    function deCoding(text) {
        let result = '';
        for (let i = 0; i < text.length; i++) {
            let currentChar = text[i]
            let asciCode = currentChar.charCodeAt(0);
            asciCode -= 1;
            currentChar = String.fromCharCode(asciCode);
            result += currentChar;
        }

        return result;
    }
}