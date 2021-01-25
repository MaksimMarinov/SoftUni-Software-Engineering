function carFactory(object){
  let returnedObject = {};
  returnedObject.model = object.model;
  if(object.power<=90){
      returnedObject.engine={
        power: 90, 
        volume: 1800 
      }
      
  }else if(object.power<=120){
    returnedObject.engine={
        power: 120, 
        volume: 2400
      }
  }else{
    returnedObject.engine={
        power: 200, 
        volume: 3500
      }
  }
  returnedObject.carriage = {
      type: object.carriage,
      color: object.color
  }
    if(object.wheelsize%2==0){
        object.wheelsize-=1;
    }
    returnedObject.wheels = [object.wheelsize,object.wheelsize,object.wheelsize,object.wheelsize ]
  

    return returnedObject;


}
console.log(carFactory({ model: 'VW Golf II',
power: 90,
color: 'blue',
carriage: 'hatchback',
wheelsize: 14 }
));
console.log(carFactory({ model: 'Opel Vectra',
power: 110,
color: 'grey',
carriage: 'coupe',
wheelsize: 17 }
));