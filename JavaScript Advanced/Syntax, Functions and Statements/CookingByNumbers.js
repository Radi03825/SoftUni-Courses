function cook (num, op1, op2, op3, op4, op5) {
    let number = Number(num);
    let coms = [op1, op2, op3, op4, op5];
    for (i = 0; i < coms.length; i++) {
        switch (coms[i]) {
            case 'chop':
                number /= 2
                break;
            case 'dice':
                number = Math.sqrt(number)
                break;
            case 'spice': number++
                break;
            case 'bake': number *= 3
                break;
            case 'fillet': number *= 0.8
                break;

        }
        console.log(number)
    }
}

cook(9, 'dice', 'spice', 'chop', 'bake', 'fillet');