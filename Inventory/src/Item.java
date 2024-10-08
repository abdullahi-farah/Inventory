public class Item {
    protected String name;
    protected int worth;
    protected int weight;

    public Item(String name, int worth, int weight) {
        this.name = name;
        this.worth = worth;
        this.weight = weight;
    }

    public void throwItem() {
        System.out.println(name + " has been thrown away.");
    }

    @Override
    public String toString() {
        return name + " (Worth: " + worth + ", Weight: " + weight + ")";
    }
}
