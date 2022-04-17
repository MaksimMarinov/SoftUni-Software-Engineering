function fruit(name, weightInGrams, price){
    let weightInKg = weightInGrams/1000;
    return `I need $${(price*weightInKg).toFixed(2)} to buy ${weightInKg.toFixed(2)} kilograms ${name}.`;
}

console.log(fruit('orange', 2500, 1.80));