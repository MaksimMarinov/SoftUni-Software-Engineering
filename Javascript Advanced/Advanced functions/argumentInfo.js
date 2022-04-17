function argumentInfo(...input) {
    const result = {};
    input.forEach(arg => {
        result.hasOwnProperty(typeof arg) ? result[typeof arg] += 1 : result[typeof arg] = 1;
        console.log(`${typeof arg}: ${arg}`)
    });

  Object.keys(result).filter(k=>result[k]>0).sort((a,b)=>result[b]-result[a]).forEach(s=>{
        console.log(`${s} = ${result[s]}`)
    });

}

argumentInfo({ name: 'bob'}, 3.333, 9.999);