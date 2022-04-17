function roadRadar(speed, area){
  let speedInTown ={
      'motorway': 130,
      'interstate': 90,
      'city': 50,
      'residential': 20,
  }
  let status = '';
  const speedLimit = speedInTown[area];
  if(speed<=speedLimit){
      return`Driving ${speed} km/h in a ${speedLimit} zone`
  }
  const diff = speed-speedLimit;
    if(diff<=20){
        status= 'speeding';
    }else if (diff<=40){
        status = 'excessive speeding ';
    }else{
        status='reckless driving ';
    }
    return `The speed is ${diff} km/h faster than the allowed speed of ${speedLimit} - ${status}`

}