function population(input) {
    let townInfo = {};
    for (let townAsString of input) {
        let [name, population] = townAsString.split(' <-> ');
        population = Number(population);
        if (townInfo[name] != undefined) {

            population = population + townInfo[name];
        }
        townInfo[name] = population;
    }
    for (const key in townInfo) {
        console.log(`${key} : ${townInfo[key]}`);
    }
} population(['Istanbul <-> 100000',
    'Honk Kong <-> 2100004',
    'Jerusalem <-> 2352344',
    'Mexico City <-> 23401925',
    'Istanbul <-> 1000']

)