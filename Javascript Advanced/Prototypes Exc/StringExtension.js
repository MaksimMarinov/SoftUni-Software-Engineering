(function foo() {
    String.prototype.ensureStart = function (str) {
        return this.toString().startsWith(str) ? this.toString() : str + this.toString();
    }

    String.prototype.ensureEnd = function (str) {
        return this.toString().endsWith(str) ? this.toString() : this.toString()+str;
    }

    String.prototype.isEmpty = function () {
        return this.toString().localeCompare("") == 0;
    };

    String.prototype.truncate = function (n) {
        if (n >= this.length) {
            return this.toString()
        } else if (this.includes(' ')) {
            let lastIndex = this.toString().substr(0, n - 2).lastIndexOf(" ");

            return this.toString().substr(0, lastIndex) + "...";
        } else if (n < 4) {
            return '.'.repeat(n);
        } else {
            return this.toString().substring(0, n - 3) + '...'
        }
    }
    String.format = function (string, ...params) {
        for(let i=0; i<params.length; i++){
            let index = string.indexOf(`${i}`);
            while (index != -1) {
                string = string.replace(`${i}`, params[i]);
                index = string.indexOf(`${i}`);
            }
        }
        return string;
    }



})()