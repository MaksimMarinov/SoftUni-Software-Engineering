function solve(array){
   const employees={};
  array.forEach(element => {
      employees[element] = element.length;
  });
  for (const name in employees) {
      console.log(`Name: ${name} -- Personal Number: ${name.length}` );
      
  }
           

}solve([
    'Silas Butler',
    'Adnaan Buckley',
    'Juan Peterson',
    'Brendan Villarreal'
    ]
    )