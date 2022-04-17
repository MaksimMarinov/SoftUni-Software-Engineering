function solve() {
    const input = document.getElementById('input').value;

    const text = input.split('.').filter(el => el.trim());

    const output = document.getElementById('output');
    let result = '<p>';
    let counter = 1;
    for (let i = 0; i < text.length; i++) {
        result += (text[i] + '.');
        if (counter % 3 === 0) {

            i !== text.length - 1 ? result += '</p><p>' : result += '</p>';
        }else if(i===text.length-1){
            result += '</p>'
        }
        counter++;
    }

    output.innerHTML = result;
}