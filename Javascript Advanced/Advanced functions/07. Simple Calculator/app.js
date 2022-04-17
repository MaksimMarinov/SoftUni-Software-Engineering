function calculator() {
    let firstInput;
    let secInput;
    let resultBox;

    function init(selector1, selector2, selector3){
    firstInput=document.querySelector(selector1);
    secInput=document.querySelector(selector2);
    resultBox=document.querySelector(selector3);
    }


   function add(){
       resultBox.value= Number(firstInput.value)+Number(secInput.value);

   }

   function subtract(){
       resultBox.value= Number(firstInput.value)-Number(secInput.value);
   }

   return {
        init, add, subtract
   }

}

const calculate = calculator ();
calculate.init ('#num1', '#num2', '#result');





