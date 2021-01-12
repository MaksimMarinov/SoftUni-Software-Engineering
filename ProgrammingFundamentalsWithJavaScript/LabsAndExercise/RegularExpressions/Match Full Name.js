function solve(input) {
    const reg = new RegExp('\\b(?:[A-Z]{1}[a-z]+) (?:[A-Z]{1}[a-z]+)\\b', 'g');
    //const reg = /\b(?:[A-Z]{1}[a-z]+) (?:[A-Z]{1}[a-z]+)\b/g;
    let name = reg.exec(input);
    let output = '';
    while (name) {
        output += name[0] + ' '
        name = reg.exec(input);

    }
    console.log(output.trimEnd());
} solve("Ivan Ivanov, Ivan ivanov, ivan Ivanov, IVan Ivanov, Test Testov, Ivan	Ivanov")