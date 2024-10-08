public abstract class Armour extends Item implements Equipable {
    protected int protection;
    protected String material;

    public Armour(String name, int worth, int weight, int protection, String material) {
        super(name, worth, weight);
        this.protection = protection;
        this.material = material;
    }

    @Override
    public void equip() {
        System.out.println(name + " has been equipped.");
        System.out.println("Protection increased by " + this.protection);
    }

    @Override
    public void unequip() {
        System.out.println(name + " has been unequipped.");
        System.out.println("Protection decreased by " + this.protection);
    }
}
