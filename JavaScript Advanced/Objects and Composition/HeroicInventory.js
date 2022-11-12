function heroesFromStr(arr) {
    let result = [];
    for (let el of arr) {
        let [name, level, items] = el.split(' / ');
        level = Number(level);
        items = items ? items.split(', ') : [];
        result.push({
            name,
            level,
            items
        });
    }

    console.log(JSON.stringify(result));
}