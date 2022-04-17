function solve(json, criteria) {
    const input = JSON.parse(json);
    let stringResult = '';
    let counter = 0;
    for (const employee of input) {
        if (criteria == 'all') {
            stringResult += addString(employee)
        } else {
            const [position, value] = criteria.split('-');
            if (employee[position] == value) {
                stringResult += addString(employee);
            }
        }
    }

    function addString(employee) {
        return counter++ + '. ' + employee.first_name + ' ' + employee.last_name + ' - ' + employee.email + '\n';
    }

    console.log(stringResult.trim());
}

solve(`[{
    "id": "1",
    "first_name": "Ardine",
    "last_name": "Bassam",
    "email": "abassam0@cnn.com",
    "gender": "Female"
  }, {
    "id": "2",
    "first_name": "Kizzee",
    "last_name": "Jost",
    "email": "kjost1@forbes.com",
    "gender": "Female"
  },  
{
    "id": "3",
    "first_name": "Evanne",
    "last_name": "Maldin",
    "email": "emaldin2@hostgator.com",
    "gender": "Male"
  }]`,
    'gender-Female'
);