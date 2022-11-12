class Stringer {
    constructor(str, len) {
        this.innerString = str,
            this._innerLength = len
    }

    get innerLength() {
        return this._innerLength;
    }

    set innerLength(value) {
        if (value < 0) {
            this._innerLength = 0;
        }else {
            this._innerLength = value
        }
    }

    increase(length) {
        this.innerLength += length;
    }

    decrease(length) {
        this.innerLength -= length;
    }

    toString() {
        if (this.innerString.length > this.innerLength) {
            return this.innerString.slice(0, this.innerLength) + '...';
        }
        return this.innerString;
    }
}