function carFactory(car) {
    const newCar = {};
    newCar.model = car.model;

    if (car.power <= 90) {
        newCar.engine = {
            power: 90,
            volume: 1800
        }
    } else if (car.power <= 120) {
        newCar.engine = {
            power: 120,
            volume: 2400
        }
    } else {
        newCar.engine = {
            power: 200,
            volume: 3500
        }


    }
    newCar.carriage = {
        type: car.carriage,
        color: car.color
    };

    newCar.wheels = new Array(4).fill(car.wheelsize % 2 === 1 ? car.wheelsize : car.wheelsize - 1)

    return newCar;
}

console.log(carFactory({
        model: 'VW Golf II',
        power: 90,
        color: 'blue',
        carriage: 'hatchback',
        wheelsize: 14
    }
));