package cresla.entities.Modules;

import cresla.entities.Modules.Modules;
import cresla.interfaces.EnergyModule;

public abstract class EnergyModules extends Modules implements EnergyModule {
    private int energyOutput;

    protected EnergyModules(int id, int energyOutput) {
        super(id);
        this.energyOutput=energyOutput;
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutput;
    }
    @Override
    public String toString() {
        return String.format("%s Module – %d%n" +
                        "Energy Output: %d",this.getClass().getSimpleName(), this.getId(),
                this.energyOutput);
    }
}
