function solve(number){
    if((number%2==0||number%3==0)&&number>5){
        console.log(false);
    }else{
        console.log(true);
    }
}solve(11);