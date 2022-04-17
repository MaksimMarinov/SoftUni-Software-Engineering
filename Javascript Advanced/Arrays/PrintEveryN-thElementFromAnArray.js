function printEveryNThElementFromAnArray(array, element) {
    return array.filter((v, i) => i % element == 0);
}

console.log(printEveryNThElementFromAnArray(['1',
        '2',
        '3',
        '4',
        '5'],
    6


));