package cresla.entities.reactors;

import cresla.entities.reactors.Reactors;

public class HeatReactor extends Reactors {
    private int heatReductionIndex;
    public HeatReactor(int id, int moduleCapacity, int heatReductionIndex) {
        super(id, moduleCapacity);
        this.heatReductionIndex= heatReductionIndex;
    }
@Override
public long getTotalHeatAbsorbing(){
        return super.getTotalHeatAbsorbing()+this.heatReductionIndex;
}
    @Override
    public String toString() {
        long energyOutput = this.getTotalEnergyOutput();
        if(energyOutput>this.getTotalHeatAbsorbing()){
            energyOutput=0;
        }

        return String.format("%s – %d%n" +
                        "Energy Output: %d%n" +
                        "Heat Absorbing: %d%n" +
                        "Modules: %d",
                getClass().getSimpleName(), this.getId(),
                energyOutput,this.getTotalHeatAbsorbing(), this.getModuleCount());
    }
}
