package cresla.core;

import cresla.entities.Modules.CooldownSystem;
import cresla.entities.Modules.CryogenRod;
import cresla.entities.Modules.HeatProcessor;
import cresla.entities.reactors.CryoReactor;
import cresla.entities.reactors.HeatReactor;
import cresla.interfaces.*;
import cresla.interfaces.Module;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager {
    private static int id;
    private Map<Integer, Reactor> reactors;
    private Map<Integer, Module> modules;

    public ManagerImpl(){
        this.reactors = new HashMap<>();
        this.modules = new HashMap<>();
        ManagerImpl.id=1;
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        String type = arguments.get(0);
        int additionalParameter = Integer.parseInt(arguments.get(1));
        int moduleContainerCapacity = Integer.parseInt(arguments.get(2));
        Reactor reactor = null;
        if (type.equals("Cryo")) {
           reactor= new CryoReactor(id, moduleContainerCapacity,additionalParameter);
        } else if (type.equals("Heat")) {
            reactor= new HeatReactor(id, moduleContainerCapacity,additionalParameter);
        }
        this.reactors.put(id, reactor);
        return String.format("Created %s Reactor - %d", type, id++);
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        int reactorId = Integer.parseInt(arguments.get(0));
        String type = arguments.get(1);
        int additionalParam = Integer.parseInt(arguments.get(2));
        Module module = null;
        switch (type){
            case "HeatProcessor":
            module= new HeatProcessor(id, additionalParam);
                break;
            case "CryogenRod":
                module= new CryogenRod(id, additionalParam);
                break;
            case "CooldownSystem":
                module=new CooldownSystem(id, additionalParam);
                break;
        }
        if(type.equals("CryogenRod")){
            this.reactors.get(reactorId).addEnergyModule((EnergyModule) module);

        }else{
            this.reactors.get(reactorId).addAbsorbingModule((AbsorbingModule) module);
        }

        this.modules.put(id, module);
        return String.format("Added %s - %d to Reactor - %d",type, id++,reactorId );
    }

    @Override
    public String reportCommand(List<String> arguments) {
        int key = Integer.parseInt(arguments.get(0));
        if(reactors.get(key)!=null){
            Reactor reactor = reactors.get(key);
            return  reactor.toString();
        }
        Module module = modules.get(key);
        return module.toString();
    }

    @Override
    public String exitCommand(List<String> arguments) {
        StringBuilder out = new StringBuilder();
        int cryoReactorsCount = (int) reactors.values().stream()
                .filter(reactor -> reactor.getClass().getSimpleName().equals("CryoReactor")).count();
        out.append("Cryo Reactors: ").append(cryoReactorsCount).append(System.lineSeparator());
        int heatReactorsCount = (int) reactors.values().stream()
                .filter(reactor -> reactor.getClass().getSimpleName().equals("HeatReactor")).count();
        out.append("Heat Reactors: ").append(heatReactorsCount).append(System.lineSeparator());
        int energyModulesCount = (int) modules.values().stream().filter(module -> module.getClass().getSimpleName().equals("CryogenRod")).count();
        out.append("Energy Modules: ").append(energyModulesCount).append(System.lineSeparator());
        int absorbingModulesscount = (int) modules.values().stream().filter(module -> module instanceof AbsorbingModule).count();
        out.append("Absorbing Modules: ").append(absorbingModulesscount).append(System.lineSeparator());
        long energyOutput = reactors.values().stream().mapToLong(Reactor::getTotalEnergyOutput).sum();
        long sum = reactors.values().stream().mapToLong(Reactor::getTotalHeatAbsorbing).sum();
        if(energyOutput>sum){
            energyOutput=0;
        }
        out.append("Total Energy Output: ").append(energyOutput).append(System.lineSeparator());

        out.append("Total Heat Absorbing: ").append(sum);

        return out.toString();
    }
}
