public class DamagePotion extends Consumable {
    int damageInc;

    public DamagePotion(String name, int worth, int weight, String effect, int damageInc) {
        super(name, worth, weight, effect);
        this.damageInc = damageInc;
    }

    @Override
    public void drink() {
        System.out.println("Drinking damage potion. Damage increased by " + damageInc);
    }
}
