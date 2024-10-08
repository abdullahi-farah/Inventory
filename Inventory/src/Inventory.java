import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> itemsList;

    public Inventory() {
        itemsList = new ArrayList<>();
    }

    public void addItem(Item item) {
        itemsList.add(item);
    }

    public void removeItem(int index) {
        if (index >= 0 && index < itemsList.size()) {
            itemsList.remove(index);
            System.out.println("Item removed from inventory.");
        } else {
            System.out.println("Invalid item selection.");
        }
    }

    public void displayItems() {
        System.out.println("Inventory:");
        for (int i = 0; i < itemsList.size(); i++) {
            System.out.println(i + 1 + ". " + itemsList.get(i).toString());
        }
    }

    public Item getItem(int index) {
        if (index >= 0 && index < itemsList.size()) {
            return itemsList.get(index);
        } else {
            System.out.println("Invalid item selection.");
            return null;
        }
    }
    public int getItemIndex(Item item) {
        return itemsList.indexOf(item);
    }
}
