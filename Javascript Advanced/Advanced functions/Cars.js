function cars(input){


    const result = {};
    const commands = {
        create: (name, inherits, parentName)=>{
            result[name] = inherits ? Object.create(result[parentName]):{};
        },
        set: (name, key, value)=>{
            result[name][key]=value;
        },
        print: name=>{
            const out = [];
            for (const key in result[name]) {
                out.push(`${key}:${result[name][key]}`)
            }
            console.log(out.join(','))
        }
    }


    for (const inputElement of input) {
        const [command, name, key, value]=inputElement.split(' ');
        commands[command](name, key, value);
    }
}
cars(['create c1',
    'create c2 inherit c1',
    'set c1 color red',
    'set c2 model new',
    'print c1',
    'print c2']
)