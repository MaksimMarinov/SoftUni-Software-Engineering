function solve(input) {
    let result = [];
    const commands = {
        add: (str) => {
            result.push(str)
        },
        remove: (str) => {
           result = result.filter(s=>s!==str);
        },
        print: ()=>{
            console.log(result.join(','));
        }
    }

    for (const element of input) {
        const [command, currentStr] = element.split(' ');
        commands[command](currentStr);

    }
}solve(['add hello', 'add again', 'remove hello', 'add again', 'print'])