class List {
    constructor() {
        this.elements = [],
        this.size = 0
    }

    add(element) {
        this.elements.push(element);
        this.size++;
        this.elements = this.elements.sort((a, b) => a - b);
    }

    remove(index) {
        if (this.size > 0 && index >= 0 && index < this.size) {
            this.elements.splice(index, 1);
            this.size--;
        } else {
            throw  new Error('Invalid index or empty array!');
        }

    }

    get(index) {
        if (this.size > 0 && index >= 0 && index < this.size) {
            return this.elements[index];
        }else {
            throw  new Error('Invalid index or empty array!');
        }
    }
}