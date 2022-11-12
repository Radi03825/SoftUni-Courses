class Company {
    constructor() {
        this.departments = {};
    }

    static validateInput(empl) {
        for (let el of empl) {
            if (el == '' || el == undefined || el == null) {
                throw new Error("Invalid input!");
            }
        }

        if (empl[1] < 0) {
            throw new Error("Invalid input!");
        }
    }

    addEmployee(...empl) {
        Company.validateInput(empl);
        let [name, salary, position, department] = empl;

        if (Object.keys(this.departments).includes(department)) {
            this.departments[department].push([name, salary, position]);
        }else {
            this.departments[department] = [[name, salary, position]];
        }
        return `New employee is hired. Name: ${name}. Position: ${position}`
    }

    bestDepartment() {
        let bestAvgSal = 0;
        let bestDepart;
        let bestEmpl;

        for (let dep in this.departments) {
            let avgSal = 0;
            for (let emp of this.departments[dep]) {
                avgSal += emp[1];
            }
            if (avgSal / this.departments[dep].length > bestAvgSal) {
                bestAvgSal = avgSal / this.departments[dep].length;
                bestDepart = dep;
                bestEmpl = this.departments[dep]
            }
        }
        bestEmpl.sort((a, b) => a[0].localeCompare(b[0])).sort((a, b) => b[1] - a[1]);


        let result = `Best Department is: ${bestDepart}\n`;
        result += `Average salary: ${bestAvgSal.toFixed(2)}\n`;
        result += `${bestEmpl.map(e => `${e[0]} ${e[1]} ${e[2]}`).join('\n')}`;
        return result;
    }
}