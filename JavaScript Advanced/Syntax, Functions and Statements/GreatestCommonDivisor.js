function greatestDivisor(a, b) {
    while(b != 0) {
        let c = b;
        b = a % b;
        a = c;
    }
    return a;
}

greatestDivisor(3156, 57);