function orders(word, number) {
    let result;
    switch (word) {
        case 'coffee':
            result = number=> number * 1.50;
            break;
        case 'water':
            result = number => number * 1.00;
            break;
        case 'coke':
            result = number => 1.40 * number;
            break;
        case 'snacks':
            result = number => 2 * number;
            break;

    }
    console.log(result(number).toFixed(2));

} orders('water', 5)