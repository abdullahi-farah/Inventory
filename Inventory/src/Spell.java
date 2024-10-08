public class Spell {
    private String element;
    private int extraDamage;

    public Spell(String element, int extraDamage) {
        this.element = element;
        this.extraDamage = extraDamage;
    }

    public String getElement() {
        return element;
    }

    public void castSpell() {
        System.out.println("Casting " + element + " spell gives extra damage of: " + extraDamage);
    }
}
