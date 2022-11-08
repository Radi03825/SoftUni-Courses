function solution() {
    const products = {
        protein: 0,
        carbohydrate: 0,
        fat: 0,
        flavour: 0
    }
    const recLibry = {
        apple: {carbohydrate: 1, flavour: 2},
        lemonade: {carbohydrate: 10, flavour: 20},
        burger: {carbohydrate: 5, fat: 7, flavour: 3},
        eggs: {protein: 5, fat: 1, flavour: 1},
        turkey: {protein: 10, carbohydrate: 10, fat:10, flavour: 10}
    }

    function restock(prod, quant) {
        products[prod] += quant;
        return "Success"
    }

    function prepare(recipe, quant) {
        const remainingPr = {};
        for (let pr in recLibry[recipe]) {
            const remaining = products[pr] - recLibry[recipe][pr] * quant;
            if (remaining < 0) {
                return `Error: not enough ${pr} in stock`;
            }else {
                remainingPr[pr] = remaining;
            }
        }
        Object.assign(products, remainingPr);
        return "Success";
    }

    function report() {
        return `protein=${products.protein} carbohydrate=${products.carbohydrate} fat=${products.fat} flavour=${products.flavour}`
    }

    function commands(input){
        let [command, prRec, qua] = input.split(' ');
        qua = Number(qua);
        const action = {
            'restock': restock(prRec, qua),
            'prepare': prepare(prRec, qua),
            'report': report()
        }
        return action[command];
    }

    return commands;
}