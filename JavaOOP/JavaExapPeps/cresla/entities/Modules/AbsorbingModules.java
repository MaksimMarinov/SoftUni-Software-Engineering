package cresla.entities.Modules;

import cresla.entities.Modules.Modules;
import cresla.interfaces.AbsorbingModule;

public abstract class AbsorbingModules extends Modules implements AbsorbingModule {
    private int heatAbsorbing;
    protected AbsorbingModules(int id, int heatAbsorbing) {
        super(id);
        this.heatAbsorbing=heatAbsorbing;
    }

    @Override
    public int getHeatAbsorbing() {
        return this.heatAbsorbing;
    }
    @Override
    public String toString() {
        return String.format("%s Module – %d%n" +
                        "Heat Absorbing: %d",this.getClass().getSimpleName(), this.getId(),
                this.heatAbsorbing);
    }
}
