function solve(char1, char2) {
    let indexFirstChar = char1.codePointAt();
    let indexSecondChar = char2.codePointAt();

    let outputChars = (indexFirst, indexSecond) => {
        let output = '';
        for (let i = indexFirst + 1; i < indexSecond; i++) {
            let current = String.fromCharCode(i);
            output += (current + ' ');
        }

        return output;

    }

    if(indexFirstChar>indexSecondChar){
        let varIndex = indexFirstChar;
        indexFirstChar=indexSecondChar;
        indexSecondChar=varIndex;
    }

    console.log(outputChars(indexFirstChar, indexSecondChar));


} solve('C',
'#'
)