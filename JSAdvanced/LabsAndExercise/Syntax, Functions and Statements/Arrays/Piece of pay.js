function piece(array, piece1, piece2) {
    let startingIndex = array.indexOf(piece1);
    let endIndex = array.indexOf(piece2);
    return array.slice(startingIndex, endIndex + 1)
} console.log(piece(['Apple Crisp',
'Mississippi Mud Pie',
'Pot Pie',
'Steak and Cheese Pie',
'Butter Chicken Pie',
'Smoked Fish Pie'],
'Pot Pie',
'Smoked Fish Pie'
));
