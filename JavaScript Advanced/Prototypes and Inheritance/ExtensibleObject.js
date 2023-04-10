function extensibleObject() {
    let obj = {
        extend: function(template){
            for(let [key, value] of Object.entries(template)){
                if(typeof(value) == "function"){
                    Object.getPrototypeOf(obj)[key] = value;
                } else {
                    obj[key] = value;
                }
            }
        }
    };

    return obj;
}