function PrintAnArrayWithGivenDelimiter(array, delimeter){
    return array.join(delimeter);
}

console.log(PrintAnArrayWithGivenDelimiter(['One',
        'Two',
        'Three',
        'Four',
        'Five'],
    '-'
));