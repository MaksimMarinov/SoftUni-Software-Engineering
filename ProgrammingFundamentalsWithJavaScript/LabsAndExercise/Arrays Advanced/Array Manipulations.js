function solve (commands){
    let array = commands.shift().split(' ').map(Number);
    while(commands.length>0){
        let tokens = commands.shift().split(' ');
        let index;
        switch(tokens[0]){
            case'Add':
            array.push(Number(tokens[1]));
                break;
                case'Remove':
               index = Number(tokens[1]);
                array = array.filter(e=>e!=index);
                break;
                case'RemoveAt':
               index = Number(tokens[1]);
                array.splice(index,1);
                break;
                case'Insert':
                let number = Number(tokens[1]);
                index = Number(tokens[2]);
                array.splice(index, 0, number);
            }
            
    }
    function remove(num) {
        array = array.filter(el => el !== num);
    }
    console.log(array.join(' '));
  

    
}solve(['4 19 2 53 6 43 2',
'Add 3',
'Remove 2',
'RemoveAt 1',
'Insert 8 3']
)