function lowestPrice(arr) {
    let result = {};
    for (let tpp of arr) {
        let [city, product, price] = tpp.split(' | ');
        price = Number(price);

        if (!result[product]) {
            result[product] = {};
        }
        result[product][city] = price;
    }

    for (const pr in result) {
        const sorted = Object.entries(result[pr]).sort((a, b) => a[1] - b[1]);
        console.log(`${pr} -> ${sorted[0][1]} (${sorted[0][0]})`)
    }
}