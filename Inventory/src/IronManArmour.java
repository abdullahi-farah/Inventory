public class IronManArmour extends Armour {
    private String fancyColour;

    public IronManArmour(String name, int worth, int weight, int protection, String material, String fancyColour) {
        super(name, worth, weight, protection, material);
        this.fancyColour = fancyColour;
    }
}
