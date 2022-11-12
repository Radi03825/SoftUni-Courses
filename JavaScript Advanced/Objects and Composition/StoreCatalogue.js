function catalogue(arr) {
    result = {};
    arr.sort((a, b) => a.localeCompare(b));
    for (let product of arr) {
        const literal = product[0];
        let [prName, price] = product.split(' : ')
        price = Number(price);
        if (!result[literal]) {
            result[literal] = {};
        }
        result[literal][prName] = price;
    }
    for (const r in result) {
        console.log(r);
        const stored = Object.entries(result[r])
        for (let pr of stored) {
            console.log(`  ${pr[0]}: ${pr[1]}`)
        }

    }
}