function solve(input) {
    let bottles = new Map();
    let quantity = new Map;

    input.forEach(el => {
        let tokens = el.split(' => ');
        let fruit = tokens[0];
        let value = tokens[1];

        if (quantity.has(fruit)) {
            quantity.set(fruit, quantity.get(fruit) + Number(value))
        }else {
            quantity.set(fruit, Number(value));
        }

        if (quantity.get(fruit) >= 1000) {
            if (bottles.has(fruit)) {
                bottles.set(fruit, bottles.get(fruit) + Math.floor(quantity.get(fruit) / 1000));
                quantity.set(fruit, quantity.get(fruit) % 1000);
            }else {
                bottles.set(fruit, Math.floor(quantity.get(fruit) / 1000));
                quantity.set(fruit, quantity.get(fruit) % 1000);
            }
        }
    });

    bottles.forEach((value, key) => {
        console.log(`${key} => ${value}`);

    });
}