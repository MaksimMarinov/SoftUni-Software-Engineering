function roadRadar(speed, area) {
    let speeding = false;
    let speedLimit = 0;
    switch (area) {
        case 'motorway':
            if (speed > 130) {
                speeding = true;
            }
            speedLimit = 130;
            break;
        case 'interstate':
            if (speed > 90) {
                speeding = true;
            }
            speedLimit = 90;
            break;
        case 'city':
            if (speed > 50) {
                speeding = true;
            }
            speedLimit = 50;
            break;
        case 'residential':
            if (speed > 20) {
                speeding = true;
            }
            speedLimit = 20;
            break;
    }
    if (speeding) {
        let speedBreak = speed - speedLimit;
        if (speedBreak <= 20) {
            console.log(`The speed is ${speedBreak} km/h faster than the allowed speed of ${speedLimit} - speeding`);
        } else if (speedBreak <= 40) {
            console.log(`The speed is ${speedBreak} km/h faster than the allowed speed of ${speedLimit} - excessive speeding`)
        } else {
            console.log(`The speed is ${speedBreak} km/h faster than the allowed speed of ${speedLimit} - reckless driving`)
        }
    } else {
        console.log(`Driving ${speed} km/h in a ${speedLimit} zone`);
    }
}roadRadar(200, 'motorway')