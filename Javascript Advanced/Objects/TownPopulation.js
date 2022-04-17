function townPopulation(input) {
    const townInfo = {};
    for (const townInfoElement of input) {
        const [name, population] = townInfoElement.split(' <-> ');
        townInfo.hasOwnProperty(name) ? townInfo[name] += Number(population) : townInfo[name] = Number(population);
    }
    for (const key in townInfo) {
        console.log(`${key} : ${townInfo[key]}`);
    }
}

townPopulation(['Istanbul <-> 100000',
    'Honk Kong <-> 2100004',
    'Jerusalem <-> 2352344',
    'Mexico City <-> 23401925',
    'Istanbul <-> 1000']);