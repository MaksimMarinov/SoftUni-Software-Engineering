function solve(cityName, cityArea, cityPopulation, cityCountry, cityPostCode){
    let cityInfo = {
        name: cityName,
        area: cityArea,
        population: cityPopulation,
        country: cityCountry,
        postCode: cityPostCode
    };
    
    for (const key in cityInfo) {
        console.log(`${key} -> ${cityInfo[key]}`);
    };
}
solve("Sofia"," 492", "1238438", "Bulgaria", "1000")