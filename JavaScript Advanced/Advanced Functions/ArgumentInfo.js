function agrInfo (...input) {
    const countTypes = {};

    for (let element of input) {
        const elType = typeof(element);
        if (countTypes.hasOwnProperty(elType)) {
            countTypes[elType] = countTypes[elType] + 1;
        }else {
            countTypes[elType] = 1;
        }
        console.log(`${elType}: ${element}`);
    }

    for (let el of Object.entries(countTypes).sort(([,a], [,b]) => b - a)) {
        console.log(`${el[0]} = ${el[1]}`)
    }
}