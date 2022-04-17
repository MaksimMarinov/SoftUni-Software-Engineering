function lastKNumberSequence(n,k){
    const result = [1];

    for (let i = 1; i < n; i++) {
        result[i] = fillArray(result, k);
    }
    return result;

    function fillArray(result, k) {
       k= result.length > k ? k: result.length;
       let sum=0;
        for (let i = 1; i <= k ; i++) {
            sum += result[result.length-i];
        }

        return sum;
    }
}

console.log(lastKNumberSequence(6,3))