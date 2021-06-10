package CollectionHierarchy;

public class MyListImpl extends Collection implements Addable, AddRemovable, MyList {

    @Override
    public String remove() {
        return this.items.remove(0);
    }

    @Override
    public int add(String elements) {
        this.items.add(0, elements);
        return 0;
    }

    @Override
    public int getUsed() {
        return this.items.size();
    }
}
