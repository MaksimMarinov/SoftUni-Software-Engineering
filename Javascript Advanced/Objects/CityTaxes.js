function cityTaxes(name, population, treasury) {
    return {
        name, population, treasury,
        taxRate: 10,
        collectTaxes() {
            this.treasury += this.population * this.taxRate
        },
        applyGrowth(percent) {
            this.population += Math.floor(this.population*percent/100)
        },
        applyRecession(percentage) {
        this.treasury -= Math.ceil(this.treasury*percentage/100);

        }
    }
}