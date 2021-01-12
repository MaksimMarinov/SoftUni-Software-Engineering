function main(a) {
    let grade = a;
    grade = grade.toFixed(2);
    if (a >= 2.00 && a <= 2.99) {
        return "Fail" + ' (' + a + ')';
    } else if (a >= 3.00 && a <= 3.49) {
        return "Poor" + ' (' + a.toFixed(2) + ')';
    } else if (a >= 3.50 && a <= 4.49) {
        return "Good" + ' (' + a.toFixed(2) + ')';
    } else if (a >= 4.50 && a <= 5.49) {
        return "Very good" + ' (' + a.toFixed(2) + ')';
    } else if (a >= 5.50 && a <= 6.00) {
        return "Excellent" + ' (' + a.toFixed(2) + ')';
    }
} main(3.33)