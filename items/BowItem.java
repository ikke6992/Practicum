package items;

public class BowItem extends InventoryItem {

    public BowItem() {
        super(1.0, 4.0);
    }
    
    @Override
    public String toString() {
        return "Bow";
    }
}