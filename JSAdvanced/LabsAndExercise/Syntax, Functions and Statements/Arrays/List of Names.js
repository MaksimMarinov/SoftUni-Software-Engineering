function list(array) {
    let output = array.sort((a, b) => a.localeCompare(b)).map((name, index) => {
        return `${index + 1}.${name}`;
    });
    return output.join('\n');
}//list(["John", "Bob", "Christina", "Ema"])
console.log(list(["John", "Bob", "Christina", "Ema"]));