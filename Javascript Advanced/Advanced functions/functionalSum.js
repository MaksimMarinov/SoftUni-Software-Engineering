function add(number){
   let sum1 =  number;

   function sum(num2){
       sum1 +=  num2;
       return sum;
   }

   sum.toString = ()=>{
       return sum1;
   }

   return sum;
}

add(1)(1).toString()