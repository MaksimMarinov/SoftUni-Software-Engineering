function solve(input, text){
    let replacementWords = input.split(', ');
   replacementWords.forEach(word => {
       wordToReplace = '*'.repeat(word.length);
      text = text.replace(wordToReplace, word )
   });
   console.log(text);
}solve('great, learning',
'softuni is ***** place for ******** new programming languages'

)