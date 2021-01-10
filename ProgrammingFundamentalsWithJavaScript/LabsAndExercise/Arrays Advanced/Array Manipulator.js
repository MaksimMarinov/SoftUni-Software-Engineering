function solve(array, commands) {

    while (commands != 'print') {
        let tokens = commands.shift().split(' ');
        let index;
        let number;

        switch (tokens[0]) {
            case ('add'):
                index = tokens[1];
                number = Number(tokens[2]);
                array.splice(index, 0, number);
                break;
            case 'addMany':
                index = Number(tokens[1]);
                addMany(array, tokens, index);
                break;
            case ('contains'):
                number = Number(tokens[1]);
                checkIfIncludes(array, number);
                break;
            case 'remove':
                index = Number(tokens[1]);
                array.splice(index, 1);
                break;
            case 'shift':
                number = Number(tokens[1]);
                shift(number, array);
                break;
                case 'sumPairs':
                array = sumPairs(array);
                break;
        }
        
    }

    function addMany(arr, tokens, index) {
        while (tokens.length > 2) {
            number = Number(tokens.splice(2, 1));
            arr.splice(index, 0, number);
            index++;
        }
       
    }
    function shift(n, arr) {
        for (let i = 0; i < n; i++) {
            let firstNumber = arr.shift();
            arr.push(firstNumber);
        }

    }
    function checkIfIncludes(arr, num) {
        if (arr.includes(num)) {
            console.log(arr.indexOf(num));
        } else {
            console.log(-1);
        }
    }
    function sumPairs(arr) {
        let newArr = []
        for(let i =0; i < arr.length; i =i+2){
            if(i==arr.length-1){
                newArr.push(arr[i]);
            }else{
                let n1 = Number(arr[i]);
                let n2 = Number(arr[i+1]);
                newArr.push((n1+n2));
            }
            
        }return newArr;
    }
    let print = arr=>{
        let output='';
        for(let i =0; i<arr.length; i++){
            let sep = ', ';
            if(i==arr.length-1){
                sep='';
            }
            output+=(arr[i]+sep);
        }
        console.log(`[ ${output} ]`);
        return;
    }

   
    print(array);

} solve([1, 2, 3, 4, 5],
    ['addMany 5 9 8 7 6 5', 'contains 15', 'remove 3', 'shift 1', 'print']
)
solve([1, 2, 4, 5, 6, 7],
    ['add 1 8', 'contains 1', 'contains 3', 'print']
    )
