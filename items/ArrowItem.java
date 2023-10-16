package items;

public class ArrowItem extends InventoryItem {

    public ArrowItem() {
        super(0.1, 0.05);
    }
    
    @Override
    public String toString() {
        return "Arrow";
    }
}