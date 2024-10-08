import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Player player = new Player(100, 50, 10, 5);
        Inventory inventory = player.getInventory();

        inventory.addItem(new GreatSword("Excalibur", 150, 10, 30, "Steel", new SwordAbility(20, 10), 1, 3));
        inventory.addItem(new MagicalStick("Fire Rod", 200, 7, 25, "Wood & Fire", new Spell("Fire Ball", 5), 1, 3));
        inventory.addItem(new ManaPotion("Mana Potion", 10, 1, "Restores mana", 50));
        inventory.addItem(new HealthPotion("Health Potion", 15, 1, "Restores health", 50));
        inventory.addItem(new DamagePotion("Damage Potion", 20, 1, "Increases damage", 10));
        inventory.addItem(new HeavyArmour("Heavy Armour", 500, 150, 50, "Steel"));
        inventory.addItem(new IronManArmour("Iron Man Suit", 1000, 50, 70, "Alloy", "Red and Gold"));

        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Show Inventory");
            System.out.println("2. Use Item");
            System.out.println("3. Throw Item");
            System.out.println("4. Add Item");
            System.out.println("5. Equip Item");
            System.out.println("6. Unequip Item");
            System.out.println("7. Upgrade Item");
            System.out.println("8. Attack With Weapon");
            System.out.println("9. Show Player Stats");
            System.out.println("0. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    inventory.displayItems();
                    break;
                case 2:
                    inventory.displayItems();
                    System.out.println("Enter the item number to use:");
                    int useChoice = scanner.nextInt() - 1;
                    Item itemToUse = inventory.getItem(useChoice);
                    if (itemToUse != null) {
                        player.useItem(itemToUse);
                    }
                    break;
                case 3:
                    inventory.displayItems();
                    System.out.println("Enter the item number to throw:");
                    int throwChoice = scanner.nextInt() - 1;
                    Item itemToThrow = inventory.getItem(throwChoice);

                    if (itemToThrow != null) {
                        if (itemToThrow == player.getEquippedWeapon()) {
                            player.unequipItem(itemToThrow);
                        } else if (itemToThrow == player.getEquippedArmour()) {
                            player.unequipItem(itemToThrow);
                        }

                        itemToThrow.throwItem();
                        inventory.removeItem(throwChoice);
                    }
                    break;
                case 4:
                    System.out.println("Choose the type of item to add:");
                    System.out.println("1. GreatSword");
                    System.out.println("2. MagicalStick");
                    System.out.println("3. Mana Potion");
                    System.out.println("4. Health Potion");
                    System.out.println("5. Damage Potion");
                    System.out.println("6. Heavy Armour");
                    System.out.println("7. Iron Man Armour");
                    int itemType = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter the name of the item:");
                    String name = scanner.nextLine();

                    System.out.println("Enter the worth of the item:");
                    int worth = scanner.nextInt();

                    System.out.println("Enter the weight of the item:");
                    int weight = scanner.nextInt();

                    switch (itemType) {
                        case 1: //GreatSword
                            System.out.println("Enter the damage of the GreatSword:");
                            int damage = scanner.nextInt();
                            System.out.println("Enter the material of the GreatSword:");
                            scanner.nextLine();
                            String material = scanner.nextLine();
                            System.out.println("Enter the area damage of the sword ability:");
                            int areaDamage = scanner.nextInt();
                            System.out.println("Enter the extra damage of the sword ability:");
                            int extraDamage = scanner.nextInt();
                            System.out.println("Enter the starting level of the GreatSword:");
                            int level = scanner.nextInt();
                            System.out.println("Enter the max level of the GreatSword:");
                            int maxLevel = scanner.nextInt();
                            SwordAbility ability = new SwordAbility(areaDamage, extraDamage);
                            GreatSword newGreatSword = new GreatSword(name, worth, weight, damage, material, ability, level, maxLevel);
                            inventory.addItem(newGreatSword);
                            System.out.println("GreatSword added to inventory.");
                            break;
                        case 2: // Magical Stick
                            System.out.println("Enter the damage of the Magical Stick:");
                            int stickDamage = scanner.nextInt();
                            System.out.println("Enter the material of the Magical Stick:");
                            scanner.nextLine(); // Consume the newline character left from previous input
                            String stickMaterial = scanner.nextLine();
                            System.out.println("Enter the element of the spell (e.g., Fire, Ice, Lightning):");
                            String spellElement = scanner.nextLine();
                            System.out.println("Enter the extra damage of the spell:");
                            int spellExtraDamage = scanner.nextInt();
                            Spell spell = new Spell(spellElement, spellExtraDamage);
                            System.out.println("Enter the starting level of the Magical Stick:");
                            int Sticklevel = scanner.nextInt();
                            System.out.println("Enter the max level of the Magical Stick:");
                            int StickmaxLevel = scanner.nextInt();
                            MagicalStick newMagicalStick = new MagicalStick(name, worth, weight, stickDamage, stickMaterial, spell, Sticklevel, StickmaxLevel);
                            inventory.addItem(newMagicalStick);
                            System.out.println("Magical Stick added to inventory.");
                            break;
                        case 3: // Mana Potion
                            System.out.println("Enter the mana increase of the potion:");
                            int manaInc = scanner.nextInt();
                            Consumable manaPotion = new ManaPotion(name, worth, weight, "Restores mana", manaInc);
                            inventory.addItem(manaPotion);
                            System.out.println("Mana Potion added to inventory.");
                            break;
                        case 4: // Health Potion
                            System.out.println("Enter the health increase of the potion:");
                            int healthInc = scanner.nextInt();
                            Consumable healthPotion = new HealthPotion(name, worth, weight, "Restores health", healthInc);
                            inventory.addItem(healthPotion);
                            System.out.println("Health Potion added to inventory.");
                            break;
                        case 5: // Damage Potion
                            System.out.println("Enter the damage increase of the potion:");
                            int damageInc = scanner.nextInt();
                            Consumable damagePotion = new DamagePotion(name, worth, weight, "Increases Damage", damageInc);
                            inventory.addItem(damagePotion);
                            System.out.println("Health Potion added to inventory.");
                            break;
                        case 6: // Heavy Armour
                            System.out.println("Enter the protection value of the Heavy Armour:");
                            int heavyProtection = scanner.nextInt();
                            System.out.println("Enter the material of the Heavy Armour:");
                            scanner.nextLine();
                            String heavyArmourMaterial = scanner.nextLine();
                            HeavyArmour newHeavyArmour = new HeavyArmour(name, worth, weight, heavyProtection, heavyArmourMaterial);
                            inventory.addItem(newHeavyArmour);
                            System.out.println("Heavy Armour added to inventory.");
                            break;

                        case 7: // Iron Man Armour
                            System.out.println("Enter the protection value of the Iron Man Armour:");
                            int ironProtection = scanner.nextInt();
                            System.out.println("Enter the material of the Iron Man Armour:");
                            scanner.nextLine();
                            String ironArmourMaterial = scanner.nextLine();
                            System.out.println("Enter the fancy colour of the Iron Man Armour:");
                            String fancyColour = scanner.nextLine();
                            IronManArmour newIronManArmour = new IronManArmour(name, worth, weight, ironProtection, ironArmourMaterial, fancyColour);
                            inventory.addItem(newIronManArmour);
                            System.out.println("Iron Man Armour added to inventory.");
                            break;
                        default:
                            System.out.println("Invalid item type.");
                    }
                case 5:
                    inventory.displayItems();
                    System.out.println("Enter the item number to equip:");
                    int equipChoice = scanner.nextInt() - 1;
                    Item itemToEquip = inventory.getItem(equipChoice);
                    if (itemToEquip != null) {
                        player.equipItem(itemToEquip);
                    }
                    break;
                case 6:
                    inventory.displayItems();
                    System.out.println("Enter the item number to unequip:");
                    int unequipChoice = scanner.nextInt() - 1;
                    Item itemToUnequip = inventory.getItem(unequipChoice);
                    if (itemToUnequip != null) {
                        player.unequipItem(itemToUnequip);
                    }
                    break;
                case 7:
                    inventory.displayItems();
                    System.out.println("Enter the item number to upgrade:");
                    int upgradeChoice = scanner.nextInt() - 1;
                    Item itemToUpgrade = inventory.getItem(upgradeChoice);
                    if (itemToUpgrade instanceof Upgradeable) {
                        ((Upgradeable) itemToUpgrade).upgrade();
                    } else {
                        System.out.println("This item cannot be upgraded.");
                    }
                    break;
                case 8:
                    inventory.displayItems();
                    System.out.println("Enter the item number to attack with:");
                    int attackChoice = scanner.nextInt() - 1;
                    Item itemToAttack = inventory.getItem(attackChoice);
                    if (itemToAttack instanceof Weapon) {
                        ((Weapon) itemToAttack).attack();
                    } else {
                        System.out.println("This item is not a weapon and cannot be used for attacking.");
                    }
                    break;
                case 9:
                    System.out.println("");
                    player.showStats();
                    System.out.println("");
                    player.showEquippedItems();
                    break;
                case 0:
                    System.out.println("Exiting game.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
