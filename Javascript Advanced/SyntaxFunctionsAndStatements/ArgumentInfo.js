function solve(...input) {
    let argumentInfo = {};
    input.forEach(arg => {
        argumentInfo.hasOwnProperty(typeof arg) ? argumentInfo[typeof arg] += 1 : argumentInfo[typeof arg] = 1;
    })

    return argumentInfo;

}

console.log(solve(1, 'cat', 42, function () {
    console.log('Hello world!');
}))