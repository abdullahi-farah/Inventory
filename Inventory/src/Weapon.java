public abstract class Weapon extends Item implements Equipable {
    protected int damage;
    protected String material;

    public Weapon(String name, int worth, int weight, int damage, String material) {
        super(name, worth, weight);
        this.damage = damage;
        this.material = material;
    }

    public abstract void attack();

    @Override
    public void equip() {
        System.out.println(name + " has been equipped.");
    }

    @Override
    public void unequip() {
        System.out.println(name + " has been unequipped.");
    }
}
