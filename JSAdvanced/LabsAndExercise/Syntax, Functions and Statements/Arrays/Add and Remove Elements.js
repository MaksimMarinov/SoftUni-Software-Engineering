function addAndRemove(array) {
    let result = [];
    let currentElement = 1;
    array.forEach(e => {
        switch (e) {
            case "add":
                result.push(currentElement);
                break;
            case "remove":
                result.pop();
                break;
        }
        currentElement++;

    });
    return result.length != 0 ? result.join('\n') : 'Empty'

} console.log(addAndRemove(['add',
    'add',
    'add',
    'add']

));
