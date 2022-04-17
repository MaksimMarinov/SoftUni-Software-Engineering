function addAndRemove(arrayOfCommands){
    const result = [];
    let started=1;
    const commands = {
        'add': (array, number)=>array.push(number),
        'remove': (array)=>array.pop()
    }
    for (let i = 0; i < arrayOfCommands.length; i++) {
        commands[arrayOfCommands[i]](result, started++);
    }

    return result.length===0?'Empty': result.join('\n');
}

console.log(addAndRemove(['add',
    'add',
    'remove',
    'add',
    'add']

));