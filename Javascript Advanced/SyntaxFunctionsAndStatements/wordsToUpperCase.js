function wordsToUpperCase(input) {
    let result = '';


    return  input.split(' ').filter(w=>w!=='')
        .map(w=>w.toUpperCase()).join(', ');
}

console.log(wordsToUpperCase('Hi, how are you?'));
