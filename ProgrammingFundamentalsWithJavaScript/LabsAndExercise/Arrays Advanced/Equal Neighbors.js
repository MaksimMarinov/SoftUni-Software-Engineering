function equalNeighbors(array){
    let countEquals =0 ;
    for(let i = 0; i<array.length-1; i++){
            let currentArray = array[i];
            let nextArray = array[i+1];
            countEquals += checkVertical(currentArray, nextArray);
            countEquals += checkHorizontal(currentArray);
            if(i==array.length-2){
                countEquals+=checkHorizontal(nextArray);
            }
        
    }
    console.log(countEquals);
    
    function checkVertical(arr1, arr2){
        let count =0;
        for(let i =0; i<Math.min(arr1.length, arr2.length); i++){
            let varFromArr1 = arr1[i];
            let varFromArr2 = arr2[i]
            if(varFromArr1===varFromArr2){
                count++;
            }
        }
        return count;
    }
    function checkHorizontal(arr){
        let count=0;
        for(let i =0; i<arr.length-1; i++){
            if(arr[i]===arr[i+1]){
                count++;
            }
        }
        return count;

    }
    
       
}equalNeighbors([['2', '3', '4', '7', '0'],
['4', '0', '5', '3', '4'],
['2', '3', '5', '4', '2'],
['9', '8', '7', '5', '4']])
