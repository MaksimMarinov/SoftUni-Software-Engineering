function solve() {
    document.querySelector('#btnSend').addEventListener('click', onClick);

    function onClick() {
        const input = JSON.parse(document.querySelector('#inputs>textarea').value);
        const restaurants= {};
        const outputRestaurant = document.querySelector('#bestRestaurant>p');
        const outputWorkers = document.querySelector('#workers>p');

        for (const inputElement of input) {
            const tokens = inputElement.split(' - ');
            const name = tokens[0];
            const workersArr = tokens[1].split(', ');
            let workers = [];
            for (let worker of workersArr) {
                const workerTokens = worker.split(' ');
                const salary = Number(workerTokens[1]);
                workers.push({
                    name: workerTokens[0],
                    salary
                })
            }

            if(restaurants[name]!==undefined) {
                workers = workers.concat(restaurants[name].workers)

            }

            workers.sort((w1, w2)=>w2.salary-w1.salary);
            const bestSalary = workers[0].salary;
            const averageSalary = (workers.reduce((sum, currentWorker)=>sum+currentWorker.salary, 0)
            /workers.length);
            restaurants[name]={
                workers, averageSalary, bestSalary
            }



        }
        let bestRestaurantSalary=0;
        let bestRestaurant = undefined;
        for (const name in restaurants) {
            if(restaurants[name].averageSalary>=bestRestaurantSalary){
                bestRestaurantSalary=restaurants[name].averageSalary;
                bestRestaurant= {
                    name,
                    workers: restaurants[name].workers,
                    bestSalary: restaurants[name].bestSalary,
                    averageSalary: restaurants[name].averageSalary
                }
                bestRestaurantSalary = bestRestaurant.averageSalary;
            }

        }

        outputRestaurant.textContent =
            `Name: ${bestRestaurant.name} Average Salary: ${bestRestaurant.averageSalary.toFixed(2)} Best Salary: ${bestRestaurant.bestSalary.toFixed(2)}`;

        let result = '';
        bestRestaurant.workers.forEach(worker=>{
            result += `Name: ${worker.name} With Salary: ${worker.salary} `
        })
        outputWorkers.textContent=result.trim();

    }
}