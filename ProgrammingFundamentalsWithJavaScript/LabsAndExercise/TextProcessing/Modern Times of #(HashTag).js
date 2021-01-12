function solve(input){
    let letters =/^[A-Za-z]+$/;
    input.split(' ').filter(word=>word.startsWith('#')&& word.length>1&&word.substring(1).match(letters)).forEach(word => {
        console.log(word.substring(1));
    });
}solve('Nowadays everyone uses # to tag a #special word in #socialMedia')