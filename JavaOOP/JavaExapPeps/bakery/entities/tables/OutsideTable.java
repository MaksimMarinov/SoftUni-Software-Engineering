package bakery.entities.tables;

public class OutsideTable extends BaseTable{
    private static final double PRICEPERPERSON = 3.50;

    public OutsideTable(int tableNumber, int capacity) {
        super(tableNumber, capacity, PRICEPERPERSON);
    }
}
