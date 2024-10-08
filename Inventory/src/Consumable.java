public abstract class Consumable extends Item {
    protected String effect;

    public Consumable(String name, int worth, int weight, String effect) {
        super(name, worth, weight);
        this.effect = effect;
    }

    public abstract void drink();
}
