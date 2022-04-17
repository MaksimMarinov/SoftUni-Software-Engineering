function solve(area, vol, input) {

    return JSON.parse(input)
        .map(cube => ({
            area: area.apply(cube),
            volume: vol.apply(cube)
        }));

}

function vol() {
    return Math.abs(this.x * this.y * this.z);
};

function area() {
    return Math.abs(this.x * this.y);
};

const json = `[
{"x":"1","y":"2","z":"10"},
{"x":"7","y":"7","z":"10"},
{"x":"5","y":"2","z":"10"}
]`;

console.log(solve(area, vol, json));
