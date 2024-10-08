public class SwordAbility {
    private int areaDamage;
    private int extraDamage;

    public SwordAbility(int areaDamage, int extraDamage) {
        this.areaDamage = areaDamage;
        this.extraDamage = extraDamage;
    }

    public void useAbility() {
        System.out.println("Using sword ability with area damage: " + areaDamage + " and extra damage: " + extraDamage);
    }
}
