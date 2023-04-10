(function solve() {
    String.prototype.ensureStart = function (str) {
        if (this.slice(0, str.length) == str) {
            return `${this}`;
        }
        return `${str}${this}`;
    };
    String.prototype.ensureEnd = function (str) {
        if (this.endsWith(str)) {
            return this.toString();
        }
        return `${this}${str}`;

    };
    String.prototype.isEmpty = function () {
        return this.length == 0;
    };
    String.prototype.truncate = function (n) {
        if (n <= 3) {
            return ".".repeat(n);
        }
        if (this.toString().length <= n) {
            return this.toString();
        } else {
            let lastIndex = this.toString().substr(0, n - 2).lastIndexOf(" ");
            if (lastIndex != -1) {
                return this.toString().substr(0, lastIndex) + "...";
            } else {
                return this.toString().substr(0, n - 3) + "...";
            }
        }
    };

    String.format = function (string, ...params) {
        let regex = /{\d+}/;
        while (regex.test(string) && params.length > 0) {
            string = string.replace(regex, params.shift())
        }
        return string;
    };

})();