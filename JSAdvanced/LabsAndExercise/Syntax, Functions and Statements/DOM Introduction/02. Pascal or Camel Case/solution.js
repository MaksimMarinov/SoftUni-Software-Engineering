function solve() {
  const input = document.getElementById('text');
  const command = document.getElementById('naming-convention');
 input = input.toLowerCase();
 let result=[];
  switch(command){
    case'Camel Case':
    input=input.split(' ');
    result.push(input[0])
    for(let i=1; i<input.length; i++){
     let current = input[i];
      let stringToPush = current[0].toUpperCase()+current.substring(1);
      result.push(stringToPush);
      result=result.join('');
    }
    break;
    case'Pascal Case':
    break;
  default:
    result='Error';
    break;
  }
  document.getElementById('result').textContent=result;

  
}