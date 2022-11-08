function calcBill(product, grams, pricePerKilo) {
    grams /= 1000;

    let totalPrice = grams * pricePerKilo;

    totalPrice = totalPrice.toFixed(2);

    grams = grams.toFixed(2);

    console.log(`I need $${totalPrice} to buy ${grams} kilograms ${product}.`);
}

calcBill('apple', 2500, 1.80);