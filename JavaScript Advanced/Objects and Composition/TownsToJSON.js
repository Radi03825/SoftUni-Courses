function toTable(arr) {
    let result = [];
    let [town, lat, lon] = arr[0].slice(2, -2).split(' | ');
    for (let i=1; i<arr.length; i++) {
        let [city, lati, long] = arr[i].slice(2, -2).split(' | ');
        const el = {};
        el[town] = city;
        el[lat] = Number(Number(lati).toFixed(2));
        el[lon] = Number(Number(long).toFixed(2));
        result.push(el);
    }
    return JSON.stringify(result);
}