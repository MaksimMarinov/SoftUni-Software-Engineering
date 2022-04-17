function pieceOfPie(array, start, end) {
    const startingIndex = array.indexOf(start);
    const endIndex = array.indexOf(end);
    return array.slice(startingIndex,endIndex+1)
}

console.log(pieceOfPie(['Apple Crisp',
        'Mississippi Mud Pie',
        'Pot Pie',
        'Steak and Cheese Pie',
        'Butter Chicken Pie',
        'Smoked Fish Pie'],
    'Pot Pie',
    'Smoked Fish Pie'

));