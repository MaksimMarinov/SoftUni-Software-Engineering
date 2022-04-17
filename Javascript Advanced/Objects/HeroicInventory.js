function heroicInventory(input){
    const result = [];
    for (const inputElement of input) {
        let [name, level, items] = inputElement.split(' / ');
        items= items ? items.split(', '):[];
        level = Number(level)
        result.push({name, level, items});
    }
    return JSON.stringify(result);
}

console.log(heroicInventory(['Isacc / 25 / Apple, GravityGun',
    'Derek / 12 / BarrelVest, DestructionSword',
    'Hes / 1 / Desolator, Sentinel, Antara']
));