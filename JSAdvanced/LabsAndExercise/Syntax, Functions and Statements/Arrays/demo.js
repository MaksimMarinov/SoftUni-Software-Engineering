function demo(){
    let dashBoard = [[4, 5, 6],
    [6, 5, 4],
    [5, 5, 5]]
   
    let check='';
        let current = '';
           for(let row=0; row<dashBoard.length; row++){
               current=dashBoard[row][0];
               for(let col=0; col<dashBoard[row].length; col++){
                if(current!=dashBoard[row][col]){
                    check= false;
                }else{
                    check= true;
                }
                
               }console.log(check);
               
               
           }
           
    
    
   
        
}demo()


    




  





    

            
        

        

