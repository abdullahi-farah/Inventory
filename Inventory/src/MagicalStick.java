public class MagicalStick extends Weapon implements Upgradeable {
    private Spell spell;
    private int level;
    private int maxLevel;

    public MagicalStick(String name, int worth, int weight, int damage, String material, Spell spell, int level, int maxLevel) {
        super(name, worth, weight, damage, material);
        this.spell = spell;
        this.level = level;
        this.maxLevel = maxLevel;
    }

    @Override
    public void attack() {
        System.out.println("Magical Stick attack with damage: " + (damage + level * 2));
        spell.castSpell();
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

