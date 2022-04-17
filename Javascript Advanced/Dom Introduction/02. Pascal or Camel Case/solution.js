function solve() {
    const text = document.getElementById('text').value.toLowerCase();
    const label = document.getElementById('naming-convention').value;
    const textAsArray = text.split(' ');
    const result = {
        "Camel Case": () => {
        return cycle(1);
        },
        "Pascal Case": () => {
            return cycle(0);
        }
    }
    result[label] === undefined ? document.getElementById('result')
        .textContent = 'Error!':document.getElementById('result').textContent = result[label](text);

    function textManipulation(text){
      return  text[0].toUpperCase() + text.substring(1);
    }

    function cycle(startingIndex){
        for (let i = startingIndex; i < textAsArray.length; i++) {
            textAsArray[i] = textManipulation(textAsArray[i]);
        }
        return textAsArray.join('');

    }

}
