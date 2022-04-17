function solve(day){
    let days = {
        'Monday': 1,
        'Tuesday': 2,
        'Wednesday': 3,
        'Thursday': 4,
        'Friday': 5,
        'Saturday': 6,
        'Sunday': 7,
    }
    let result;
    days[day] === undefined ? result = 'error' : result= days[day];
    return result;
}

console.log(solve(''));