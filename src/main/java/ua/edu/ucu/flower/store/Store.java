package ua.edu.ucu.flower.store;
import java.util.List;
import java.util.ArrayList;
import lombok.Getter;

@Getter
public class Store {
    private List<FlowerBucket> flowerBouquets = new ArrayList<>();

    public void addBouquet(FlowerBucket bouquet) {
        flowerBouquets.add(bouquet);
    }

    public List<FlowerBucket> search(FlowerSpecs searchSpecifics) {
        List<FlowerBucket> matchingBouquets = new ArrayList<>();
        
        for (FlowerBucket bouquet: flowerBouquets) {
            if (bouquet.match(searchSpecifics)) {
                matchingBouquets.add(bouquet);
            }
        }

        return matchingBouquets;
        
    }

}