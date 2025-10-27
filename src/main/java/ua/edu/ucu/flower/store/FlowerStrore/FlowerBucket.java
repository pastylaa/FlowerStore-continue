package ua.edu.ucu.flower.store.FlowerStrore;
import java.util.List;
import java.util.ArrayList;

public class FlowerBucket {
    private List<FlowerPack> flowerPacks = new ArrayList<>();

    public void add(FlowerPack flowers) {
        flowerPacks.add(flowers);
    }
    
    public double getPrice() {
        double price = 0; 
        for (FlowerPack flowerP: flowerPacks) {
            price += flowerP.getPrice();
        }
        return price;
    }

    public boolean match(FlowerSpecs specifications) {
        for (FlowerPack flowerPack: flowerPacks) {
            if (specifications.match(flowerPack)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Bouquet:\n");
        
        for (FlowerPack pack : flowerPacks) {
            sb.append(" - ").append(pack.toString()).append("\n");
        }
        
        sb.append("Price: ").append(getPrice());
        return sb.toString();
    }

}