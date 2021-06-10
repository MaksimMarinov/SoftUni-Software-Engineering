package bakery.entities.tables;

import bakery.entities.tables.interfaces.Table;

public class InsideTable extends BaseTable {
    private static final double PRICEPERPERSON = 2.50;
    public InsideTable(int tableNumber, int capacity) {
        super(tableNumber, capacity, PRICEPERPERSON);
    }
}
