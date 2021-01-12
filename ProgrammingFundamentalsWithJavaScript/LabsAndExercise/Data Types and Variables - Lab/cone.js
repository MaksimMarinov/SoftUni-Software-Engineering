function solve(radius, height){
    console.log(`volume = ${(Math.PI*(Math.pow(radius,2)*(height/3))).toFixed(4)}`);
    console.log(`area = ${(Math.PI*radius*(radius + (Math.sqrt(Math.pow(radius,2)+Math.pow(height,2))))).toFixed(4)}`)
}solve(3.3,
    7.8)