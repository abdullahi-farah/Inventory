import java.util.ArrayList;
import java.util.List;

public class Player {
    private int health;
    private int maxHealth;
    private int mana;
    private int maxMana;
    private int damage;
    private int protection;
    private Inventory inventory;
    private Weapon equippedWeapon;
    private Armour equippedArmour;
    private List<Item> equippedItems;

    public Player(int maxHealth, int maxMana, int baseDamage, int baseProtection) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.maxMana = maxMana;
        this.mana = maxMana;
        this.damage = baseDamage;
        this.protection = baseProtection;
        this.inventory = new Inventory();
        this.equippedItems = new ArrayList<>();
    }

    public Armour getEquippedArmour() {
        return equippedArmour;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void equipItem(Item item) {
        if (item instanceof Weapon) {
            if (equippedWeapon != null) {
                System.out.println("You already have a weapon equipped: " + equippedWeapon.name + ". Unequip it first before equipping a new one.");
            } else {
                equippedWeapon = (Weapon) item;
                equippedWeapon.equip();
                damage += equippedWeapon.damage;
                System.out.println("Equipped weapon: " + equippedWeapon.name + ". Damage increased to: " + damage);
                equippedItems.add(item);
            }
        } else if (item instanceof Armour) {
            if (equippedArmour != null) {
                System.out.println("You already have an armour equipped: " + equippedArmour.name + ". Unequip it first before equipping a new one.");
            } else {
                equippedArmour = (Armour) item;
                equippedArmour.equip();
                protection += equippedArmour.protection;
                System.out.println("Equipped armour: " + equippedArmour.name + ". Protection increased to: " + protection);
                equippedItems.add(item);
            }
        } else {
            System.out.println("Item cannot be equipped.");
        }
    }

    public void unequipItem(Item item) {
        if (item == equippedWeapon) {
            damage -= equippedWeapon.damage;
            equippedWeapon.unequip();
            equippedWeapon = null;
            System.out.println("Unequipped weapon. Damage decreased to: " + damage);
        } else if (item == equippedArmour) {
            protection -= equippedArmour.protection;
            equippedArmour.unequip();
            equippedArmour = null;
            System.out.println("Unequipped armour. Protection decreased to: " + protection);
            equippedItems.remove(item);
        } else {
            System.out.println("Item is not currently equipped.");
        }
    }

    public void useItem(Item item) {
        if (item instanceof Consumable) {
            Consumable consumable = (Consumable) item;
            if (consumable instanceof ManaPotion) {
                ManaPotion manaPotion = (ManaPotion) consumable;
                mana = Math.min(maxMana, mana + manaPotion.manaInc);
                System.out.println("Used " + manaPotion.name + ". Mana increased to: " + mana);
            } else if (consumable instanceof HealthPotion) {
                HealthPotion healthPotion = (HealthPotion) consumable;
                health = Math.min(maxHealth, health + healthPotion.healthInc);
                System.out.println("Used " + healthPotion.name + ". Health increased to: " + health);
            } else if (consumable instanceof DamagePotion) {
                DamagePotion damagePotion = (DamagePotion) consumable;
                damage = Math.min(maxMana, mana + damagePotion.damageInc);
                System.out.println("Used " + damagePotion.name + ". Damage increased to: " + damage);
            }
            inventory.removeItem(inventory.getItemIndex(item));
        } else {
            System.out.println("This item cannot be used.");
        }
    }

    public void showEquippedItems() {
        System.out.println("Equipped Items:");
        if (equippedItems.isEmpty()) {
            System.out.println("No items equipped.");
        } else {
            for (Item item : equippedItems) {
                System.out.println("- " + item.name);
            }
        }
    }
    public void showStats() {
        System.out.println("Player Stats:");
        System.out.println("Health: " + health + "/" + maxHealth);
        System.out.println("Mana: " + mana + "/" + maxMana);
        System.out.println("Damage: " + damage);
        System.out.println("Protection: " + protection);
    }

    public Inventory getInventory() {
        return inventory;
    }
}
