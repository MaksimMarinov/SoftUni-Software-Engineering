function solve(arr, n){
    let newArr = arr;
    for(i=0; i<n; i++){
        let number = arr[0];
        for(j=0; j<arr.length; j++){
            
            newArr[j]=newArr[j+1];
        }
        newArr[newArr.length-1]=number;
    }
    console.log(newArr.join(" "));
}solve([51, 47, 32, 61, 21], 2);