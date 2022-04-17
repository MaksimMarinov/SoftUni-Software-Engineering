function TimeToWalk(stepsToUni, footprintInMeters, speedInKm){
    const speedInMeters = speedInKm*(5/18);
    const distanceInMeters = stepsToUni*footprintInMeters;
    const breaksTimeInSeconds = Math.floor(distanceInMeters/500)*60;
    let totalTimeInSeconds = distanceInMeters/speedInMeters+breaksTimeInSeconds;
    let hours=0;
    let minutes =0;
    if(totalTimeInSeconds>=3600){
        hours=Math.floor(totalTimeInSeconds/3600);
        totalTimeInSeconds -= hours*3600;
    }

    if(totalTimeInSeconds>=60){
        minutes=Math.floor(totalTimeInSeconds/60);
        totalTimeInSeconds-=minutes*60;
    }
    let hoursToPrint = transformTimeFormNumberToString(hours);
    const minutesToPrint = transformTimeFormNumberToString(minutes);
    const secondsToPrint = transformTimeFormNumberToString(Math.ceil(totalTimeInSeconds));

  return `${hoursToPrint}:${minutesToPrint}:${secondsToPrint}`


    function transformTimeFormNumberToString(number){
        if(number>=10){
            return number.toString();
        }else if(number>0){
            return '0'+number.toString()
        }
        return '00'
    }
}

console.log(TimeToWalk(2564, 0.70, 5.5));