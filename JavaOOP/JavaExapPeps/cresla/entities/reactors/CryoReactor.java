package cresla.entities.reactors;

import cresla.entities.reactors.Reactors;

public class CryoReactor extends Reactors {
    private int cryoProductionIndex;


    public CryoReactor(int id, int moduleCapacity, int cryoProductionIndex) {
        super(id, moduleCapacity);
        this.cryoProductionIndex = cryoProductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        return super.getTotalEnergyOutput()*this.cryoProductionIndex;
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
                energyOutput, this.getTotalHeatAbsorbing(), this.getModuleCount());
    }
}
