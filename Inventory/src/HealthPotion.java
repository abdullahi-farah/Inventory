public class HealthPotion extends Consumable {
    public int healthInc;

    public HealthPotion(String name, int worth, int weight, String effect, int healthInc) {
        super(name, worth, weight, effect);
        this.healthInc = healthInc;
    }

    @Override
    public void drink() {
        System.out.println("Drinking health potion. Health increased by " + healthInc);
    }
}
