function solution(){

    let state ='';

function append(str){
   state+=str;
}

function removeStart(number){
    state = state.slice(number)

}

    function removeEnd(number){
      state=  state.slice(0, -number);
    }

    function print(){
        console.log(state);
    }

return {
    append, removeStart, removeEnd, print
}
}

let firstZeroTest = solution();

firstZeroTest.append('hello');
firstZeroTest.append('again');
firstZeroTest.removeStart(3);
firstZeroTest.removeEnd(4);
firstZeroTest.print();
