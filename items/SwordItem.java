package items;

public class SwordItem extends InventoryItem {

    public SwordItem() {
        super(5.0, 3.0);
    }
    
    @Override
    public String toString() {
        return "Sword";
    }
}