function solve(a1, char, a2,) {
    let res = a1.replace('_', char);
    if (res == a2) {
        console.log('Matched');
    } else {
        console.log('Not Matched');
    }

} solve('Str_ng', 'i', 'String');
