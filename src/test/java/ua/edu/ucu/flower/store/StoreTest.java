package ua.edu.ucu.flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class StoreTest {

    private static final double SEPAL_RED_TULIP = 0.04;
    private static final double PRICE_RED_TULIP = 10;

    private static final double SEPAL_BLUE_TULIP = 0.1;
    private static final double PRICE_BLUE_TULIP = 14;

    private static final double SEPAL_CHAMOMILE = 0.05;
    private static final double PRICE_CHAMOMILE = 13;

    private static final double SEPAL_TEST = 0.02;

    private static final int RED_TULIP_QUANTITY = 5;
    private static final int BLUE_TULIP_QUANTITY = 3;
    private static final int BLUE_CHAMOMILE_QUANTITY = 2;

    private static final int EXPECTED_ONE = 1;
    private static final int EXPECTED_ZERO = 0;
    private static final int EXPECTED_STORE_SIZE = 2;

    private Store flowerShop;
    private FlowerBucket tulipBucket, chamomileBucket;
    private Flower tulipRed, tulipBlue, chamomileBlue;

    @BeforeEach
    public void init() {
        flowerShop = new Store();

        tulipRed = new Flower(
            SEPAL_RED_TULIP, 
            FlowerColor.RED, 
            PRICE_RED_TULIP, 
            FlowerType.TULIP
        );

        tulipBlue = new Flower(
            SEPAL_BLUE_TULIP,
            FlowerColor.BLUE,
            PRICE_BLUE_TULIP,
            FlowerType.TULIP
        );

        chamomileBlue = new Flower(
            SEPAL_CHAMOMILE,
            FlowerColor.BLUE,
            PRICE_CHAMOMILE,
            FlowerType.CHAMOMILE
        );

        FlowerPack tulipsRed = new FlowerPack(tulipRed,
        RED_TULIP_QUANTITY);
        FlowerPack tulipsBlue = new FlowerPack(tulipBlue,
        BLUE_TULIP_QUANTITY);
        FlowerPack chamomilesBlue = new FlowerPack(chamomileBlue,
        BLUE_CHAMOMILE_QUANTITY);

        tulipBucket = new FlowerBucket();
        tulipBucket.add(tulipsRed);
        tulipBucket.add(tulipsBlue);

        chamomileBucket = new FlowerBucket();
        chamomileBucket.add(chamomilesBlue);

        flowerShop.addBouquet(chamomileBucket);
        flowerShop.addBouquet(tulipBucket);
    }

    @Test
    public void searchRedTulips() {
        FlowerSpecs flowerSpecs = new FlowerSpecs(
            SEPAL_RED_TULIP,
            FlowerColor.RED,
            FlowerType.TULIP
        );

        List<FlowerBucket> matchesFound = flowerShop.search(flowerSpecs);

        Assertions.assertEquals(EXPECTED_ONE, matchesFound.size());
        Assertions.assertTrue(matchesFound.contains(tulipBucket));
    }

    @Test
    public void searchRedTulipNot() {
        FlowerSpecs flowerSpecs = new FlowerSpecs(
            SEPAL_TEST,
            FlowerColor.RED,
            FlowerType.TULIP
        );

        List<FlowerBucket> matchesFound = flowerShop.search(flowerSpecs);

        Assertions.assertEquals(EXPECTED_ZERO, matchesFound.size());
        Assertions.assertFalse(matchesFound.contains(tulipBucket));
        Assertions.assertFalse(matchesFound.contains(chamomileBucket));
    }

    @Test
    public void searchChamomiles() {
        FlowerSpecs flowerSpecs = new FlowerSpecs(
            SEPAL_CHAMOMILE,
            FlowerColor.BLUE,
            FlowerType.CHAMOMILE
        );

        List<FlowerBucket> matchesFound = flowerShop.search(flowerSpecs);

        Assertions.assertTrue(matchesFound.contains(chamomileBucket));
    }

    @Test
    public void storeSize() {
        Assertions.assertEquals(EXPECTED_STORE_SIZE, 
                                flowerShop.getFlowerBouquets().size());
    }
}