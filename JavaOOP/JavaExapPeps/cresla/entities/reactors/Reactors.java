package cresla.entities.reactors;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Reactor;

public abstract class Reactors implements Reactor {
    private final int id;
    private ModuleContainer moduleContainer;

    protected Reactors(int id, int moduleCapacity) {
        this.id = id;
        this.moduleContainer= new ModuleContainer(moduleCapacity);
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public long getTotalEnergyOutput() {
        long energyOutput = moduleContainer.getTotalEnergyOutput();
        long heatAbsorbing = this.getTotalHeatAbsorbing();

        return energyOutput;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return moduleContainer.getTotalHeatAbsorbing();
    }

    @Override
    public int getModuleCount() {
        return moduleContainer.getModuleByInputCount();
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        moduleContainer.addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
    moduleContainer.addAbsorbingModule(absorbingModule);
    }

}
