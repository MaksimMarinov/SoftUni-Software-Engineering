function buyFruit(fruitName, weight, price){
    let moneyNeeded= weight*price/1000;
console.log(`I need $${moneyNeeded.toFixed(2)} to buy ${(weight/1000).toFixed(2)} kilograms ${fruitName}.`);
}buyFruit('apple', 1563, 2.35)