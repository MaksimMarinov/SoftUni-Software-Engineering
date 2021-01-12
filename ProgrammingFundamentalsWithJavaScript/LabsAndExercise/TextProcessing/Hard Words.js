function solve(input) {
   
    let text = input[0].split(' ');
    let words = input[1];
    for (let i = 0; i < text.length; i++) {
        if (text[i].includes('_')) {
            let wordToReplace = text[i];
            let substituteWord = matchLength(wordToReplace, words);
            text[i] = substituteWord;
        }
    }
    console.log(text.join(' '));

    function matchLength(wordToMacth, arrayOfWords) {
        for (let i = 0; i < arrayOfWords.length; i++) {
            let currentWord = arrayOfWords[i];
            if (currentWord.length == wordToMacth.length) {
                return currentWord;
            }
        }
    };
} solve(['Hi, grandma! I\'m so ____ to write to you. ______ the winter vacation, so _______ things happened. My dad bought me a sled. Mom started a new job as a __________. My brother\'s ankle is ________, and now it bothers me even more. Every night Mom cooks ___ on your recipe because it is the most delicious. I hope this year Santa will _____ me a robot.',
    ['pie', 'bring', 'glad', 'During', 'amazing', 'pharmacist', 'sprained']]
)