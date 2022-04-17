function previousDate(year, month, day){

   let date = new Date(year, month, day);
   let substracter = 1;
   if(day ===1){
       substracter++;
   }
    date.setDate(date.getDate()-substracter);


    return `${date.getFullYear()}-${date.getMonth()}-${date.getDate()}`
}

console.log(previousDate(2016, 10, 1))