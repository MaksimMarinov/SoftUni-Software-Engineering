package onlineShop.core;

import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {
    Map<Integer, Computer> computers;
    Map<Integer, Peripheral> peripherals;
    Map<Integer, Component> components;

    public ControllerImpl() {
        this.computers = new HashMap<>();
        this.peripherals = new HashMap<>();
        this.components = new HashMap<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        if (computers.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
        }
        Computer computer;
        if (computerType.equals("DesktopComputer")) {
            computer = new DesktopComputer(id, manufacturer, model, price);
        } else if (computerType.equals("Laptop")) {
            computer = new Laptop(id, manufacturer, model, price);

        } else {
            throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);
        }



        this.computers.putIfAbsent(id, computer);
        return String.format(ADDED_COMPUTER, id);
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer,
                                String model, double price, double overallPerformance, String connectionType) {
        if (!computers.containsKey(computerId)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        if (peripherals.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
        }
        Peripheral peripheral;
        if (peripheralType.equals("Headset")) {
            peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
        } else if (peripheralType.equals("Keyboard")) {
            peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
        } else if (peripheralType.equals("Monitor")) {
            peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
        } else if (peripheralType.equals("Mouse")) {
            peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
        } else {
            throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }

        Computer computer = computers.get(computerId);
        computer.addPeripheral(peripheral);
        peripherals.put(id, peripheral);
        return String.format(ADDED_PERIPHERAL,
                peripheralType, id, computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        if (!computers.containsKey(computerId)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        Computer computer = computers.get(computerId);
        /*if (!peripheralType.equals("Headset") && !peripheralType.equals("Keyboard")
                && !peripheralType.equals("Monitor") && !peripheralType.equals("Mouse")) {
            throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }*/


        Peripheral peripheral = computer.removePeripheral(peripheralType);
        peripherals.remove(peripheral.getId());
        return String.format(REMOVED_PERIPHERAL, peripheralType, peripheral.getId());
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer,
                               String model, double price, double overallPerformance, int generation) {
        if (!computers.containsKey(computerId)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        if (components.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }
        Component component;
        if (componentType.equals("CentralProcessingUnit")) {
            component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
        } else if (componentType.equals("Motherboard")) {
            component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
        } else if (componentType.equals("PowerSupply")) {
            component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
        } else if (componentType.equals("RandomAccessMemory")) {
            component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
        } else if (componentType.equals("SolidStateDrive")) {
            component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
        } else if (componentType.equals("VideoCard")) {
            component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
        } else {
            throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }
        if (!computers.containsKey(computerId)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }

        components.put(id, component);
        computers.get(computerId).addComponent(component);
        return String.format(ADDED_COMPONENT, componentType, id, computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {

        /*if (!componentType.equals("CentralProcessingUnit") && !componentType.equals("Motherboard") &&
                !componentType.equals("PowerSupply") && !componentType.equals("RandomAccessMemory") && !componentType.equals("SolidStateDrive")
                && !componentType.equals("VideoCard")) {
            throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }*/
        if (!computers.containsKey(computerId)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        Component component = computers.get(computerId).removeComponent(componentType);
        components.remove(component.getId());
        return String.format(REMOVED_COMPONENT, componentType, component.getId());
    }

    @Override
    public String buyComputer(int id) {
        if (!computers.containsKey(id)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        Computer computer = computers.remove(id);

        return computer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {
        List<Computer> filtered = this.computers.values().stream().filter(computer -> computer.getPrice() <= budget)
                .sorted(Comparator.comparing(Computer::getOverallPerformance).reversed()).collect(Collectors.toList());
        if (filtered.isEmpty()) {
            throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER, budget));
        }
        Computer remove = computers.remove(filtered.get(0).getId());



        return remove.toString();
    }

    @Override
    public String getComputerData(int id) {
        if (!computers.containsKey(id)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        return computers.get(id).toString();
    }
}
