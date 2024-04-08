package items;

public class WaterItem extends InventoryItem {

    public WaterItem() {
        super(2.0, 3.0);
    }
    
    @Override
    public String toString() {
        return "Water";
    }
}