function solve(input) {
    const cars = {};
    for (const token of input) {
        const [brand, model, produced] = token.split(' | ');
        if (cars[brand]&&cars[brand][model]) {
            cars[brand][model] += Number(produced);
        } else if (cars[brand]) {
            cars[brand][model] = Number(produced);
        } else {
            cars[brand] = {};
            cars[brand][model] = Number(produced);

        }
    }

   return  Object.entries(cars).map(([brand, models])=> `${brand}
${Object.entries(models)
            .map(([model, quantity])=>
            `###${model} -> ${quantity}`)
            .join('\n')}`).join('\n');


}

console.log(solve(['Audi | Q7 | 1000',
    'Audi | Q6 | 100',
    'BMW | X5 | 1000',
    'BMW | X6 | 100',
    'Citroen | C4 | 123',
    'Volga | GAZ-24 | 1000000',
    'Lada | Niva | 1000000',
    'Lada | Jigula | 1000000',
    'Citroen | C4 | 22',
    'Citroen | C5 | 10']
))