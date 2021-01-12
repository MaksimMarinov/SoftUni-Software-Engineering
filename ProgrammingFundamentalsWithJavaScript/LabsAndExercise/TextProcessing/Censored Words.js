function solve(text, word) {
    while (text.includes(word)) {
        let replaceWord = '*'.repeat(word.length)
        text = text.replace(word, replaceWord)
    }
    console.log(text);
} solve("A small sentence with some words", "small")