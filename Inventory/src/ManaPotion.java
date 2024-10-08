public class ManaPotion extends Consumable {
    public int manaInc;

    public ManaPotion(String name, int worth, int weight, String effect, int manaInc) {
        super(name, worth, weight, effect);
        this.manaInc = manaInc;
    }

    @Override
    public void drink() {
        System.out.println("Drinking mana potion. Mana increased by " + manaInc);
    }
}
