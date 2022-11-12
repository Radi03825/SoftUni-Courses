class Hex {
    constructor(value) {
        this.value = value;
    }

    valueOf() {
        return this.value;
    }

    toString() {
        return '0x' + this.value.toString(16).toUpperCase();
    }

    plus(num) {
        return new Hex(this.value + num.value);
    }

    minus(num) {
        return new Hex(this.value - num.value);
    }

    parse(str) {
        return parseInt(str, 16);
    }
}