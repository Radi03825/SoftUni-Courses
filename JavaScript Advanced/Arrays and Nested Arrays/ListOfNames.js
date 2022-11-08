function solve(array) {
    array.sort((a, b) => a.localeCompare(b));

    let count = 1;
    for (const element of array) {
        console.log(`${count}.${element}`);
        count++;
    }
}