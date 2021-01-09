function solve(a1, a2) {
    for (let i = 0; i < a1.length; i++) {
        if (a2.includes(a1[i])) {
            console.log(a1[i]);
        }
    }

} solve(['Hey', 'hello', 2, 4, 'Peter', 'e'],
    ['Petar', 10, 'hey', 4, 'hello', '2']
)