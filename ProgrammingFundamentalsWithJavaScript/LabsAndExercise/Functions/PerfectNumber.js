function perfect(number){
    
    let sumOfDigits=0;
    for(let i=1; i<=number/2;i++ ){
            if(number%i==0){
        
                sumOfDigits+=i;
            }
        
            
    }
    if(number==sumOfDigits&&sumOfDigits!=0){
        console.log('We have a perfect number!')
    }else{
    console.log("It's not so perfect.")
    }
}perfect(6)