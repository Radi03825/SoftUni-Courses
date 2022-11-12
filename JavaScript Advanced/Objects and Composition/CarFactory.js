function carFactory(car) {

    function getEngine(pow) {
        const engineType = [
            { power: 90, volume: 1800 },
            { power: 120, volume: 2400 },
            { power: 200, volume: 3500 }
        ]
        return engineType.find(el => el.power >= pow)
    }

    function getWheels(wheel) {
        if(wheel % 2 == 0) {
            wheel--;
        }
        return new Array(4).fill(wheel, 0, 4);
    }

    return {
        model: car.model,
        engine: getEngine(car.power),
        carriage: {
            type: car.carriage,
            color: car.color
        },
        wheels: getWheels(car.wheelsize)
    }
}

let input = {
    model: 'Ferrari',
    power: 200,
    color: 'red',
    carriage: 'coupe',
    wheelsize: 21
};


carFactory(input);