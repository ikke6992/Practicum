package items;

public class FoodRationsItem extends InventoryItem {

    public FoodRationsItem() {
        super(1.0, 0.5);
    }
    
    @Override
    public String toString() {
        return "Food Rations";
    }
}