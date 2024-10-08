public class GreatSword extends Weapon implements Upgradeable {
    private SwordAbility ability;
    private int level;
    private int maxLevel;
    public boolean equipped;

    public GreatSword(String name, int worth, int weight, int damage, String material, SwordAbility ability, int level, int maxLevel) {
        super(name, worth, weight, damage, material);
        this.ability = ability;
        this.level = level;
        this.maxLevel = maxLevel;
    }

    @Override
    public void attack() {
        System.out.println("Greatsword attack with damage: " + (damage + level * 2));
        ability.useAbility();
    }

    @Override
    public void upgrade() {
        if (level < maxLevel) {
            level++;
            System.out.println(name + " has been upgraded to level " + level + "!");
        } else {
            System.out.println(name + " is already at max level.");
        }
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getMaxLevel() {
        return maxLevel;
    }

    @Override
    public String toString() {
        return super.toString() + " [Level: " + level + "/" + maxLevel + "]";
    }
}
