function inventory(inputArray) {
    let allHoroesInfo = [];
    inputArray.forEach(e => {
        let[name, level, items] = e.split(' / ');
       level = Number(level);
       items = items ? items.split(', '): [];
        allHoroesInfo.push({ name, level, items });
    });
    
    
    return JSON.stringify(allHoroesInfo);
}console.log(inventory(['Isacc / 25 / Apple, GravityGun',
    'Derek / 12 / BarrelVest, DestructionSword',
    'Hes / 1 / Desolator, Sentinel, Antara']
));