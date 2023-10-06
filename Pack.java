public class Pack {
    
    private InventoryItem[] items;
    private final double MAX_WEIGHT;
    private final double MAX_VOLUME;
    private int next;
    private double weight;
    private double volume;
    
    public Pack(int maxItems, double maxWeight, double maxVolume) {
        items = new InventoryItem[maxItems];
        MAX_WEIGHT = maxWeight;
        MAX_VOLUME = maxVolume;
        next = 0;
        weight = 0;
        volume = 0;
    }
    
    public boolean add(InventoryItem item) {
        if (next >= items.length || weight + item.getWeight() > MAX_WEIGHT ||
            volume + item.getVolume() > MAX_VOLUME) {
            return false;
        }
        weight += item.getWeight();
        volume += item.getVolume();
        items[next] = item;
        next++;
        return true;
    }
    
    public int getItemCount() {
        return next;
    }
    
    public int getMaxItems() {
        return items.length;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public double getMaxWeight() {
        return MAX_WEIGHT;
    }
    
    public double getVolume() {
        return volume;
    }
    
    public double getMaxVolume() {
        return MAX_VOLUME;
    }
    
    public String toString() {
        StringBuilder builder = new StringBuilder("Pack containing");
        for(int i = 0; i < next; i++) {
            builder.append(" " + items[i]);
        }
        return builder.toString();
    }
}