function solve(array, N) {
    for (let index = 0; index < N; index++) {
        let lastElement = array.pop();
        array.unshift(lastElement)
    }
    console.log(array.join(' '));
}

solve([1, 2, 3], 1);