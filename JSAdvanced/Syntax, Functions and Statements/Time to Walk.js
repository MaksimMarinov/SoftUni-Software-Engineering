function solve(steps, lengthOfStep, speed){
    const distanceToUniversity = steps*lengthOfStep;
    const breaksCount = Math.floor(distanceToUniversity/500);
    let walkingTimeInMinutes = distanceToUniversity/1000/speed*60+breaksCount;
    

    let hours = 0;
    if(walkingTimeInMinutes>=60){
hours=Math.trunc(walkingTimeInMinutes/60);
walkingTimeInMinutes-=hours*60;
    }
    let walkingTimeInseconds = walkingTimeInMinutes*60;
  let minutes = 0;
    if(walkingTimeInseconds>=60){
        minutes=Math.trunc(walkingTimeInseconds/60);
        walkingTimeInseconds-=minutes*60;
    }
    let outputHours ='';
    if(hours<9){
        outputHours+='0';
    }outputHours+=hours;
    let outputMinutes = '';
    if(minutes<9){
        outputMinutes+='0';
        
    }outputMinutes+=minutes;
    walkingTimeInseconds=Math.round(walkingTimeInseconds)
    let outputSeconds ='';
    if(walkingTimeInseconds<9){
        outputSeconds+='0';;
    }
        outputSeconds+=walkingTimeInseconds;
    

    console.log(`${outputHours}:${outputMinutes}:${outputSeconds}`);
}solve(7000, 0.70, 5.5)