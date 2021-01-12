function solve(text, wordToSearch) {

    let count = 0;
    let words = text.split(' ');
    let index = words.indexOf(wordToSearch);
    while (index >= 0) {
        count++;
        index = words.indexOf(wordToSearch, index + 1);

    }
    console.log(count);
} solve("This is a word and it also is a sentence",
    "is"
)