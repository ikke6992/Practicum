public class Preparations {
    
    public enum Material {
        WOOD,
        BRONZE,
        IRON,
        STEEL,
        BINARIUM;
        
        @Override
        public String toString() {
            return new String(super.toString().toLowerCase());
        }
    }
    
    public enum Gemstone {
        EMERALD,
        AMBER,
        SAPPHIRE,
        DIAMOND,
        BITSTONE,
        NONE;
        
        @Override
        public String toString() {
            return new String(super.toString().toLowerCase());
        }
    }
    
    public record Sword(Material material, Gemstone gemstone, int length, int width) {
        
        public Sword withMaterial(Material material) {
            return new Sword(material, gemstone(), length(), width());
        }
        
        public Sword withGemstone(Gemstone gemstone) {
            return new Sword(material(), gemstone, length(), width());
        }
        
        @Override
        public String toString() {
            return gemstone() == Gemstone.NONE ? String.format("A plain %s sword of %d centimetres long and a crossguard width " +
                "of %d centimetres", material(), length(), width()) : String.format("A %s sword of %d centimetres long, " +
                "a crossguard width of %d centimetres and an embedded %s", material(), length(), width(), gemstone());
        }
    }
    
    public static void main(String[] args) {
        Sword basic = new Sword(Material.IRON, Gemstone.NONE, 60, 15);
        Sword steel = basic.withMaterial(Material.STEEL);
        Sword amber = basic.withGemstone(Gemstone.AMBER);
        
        System.out.println(basic);
        System.out.println(steel);
        System.out.println(amber);
    }
}