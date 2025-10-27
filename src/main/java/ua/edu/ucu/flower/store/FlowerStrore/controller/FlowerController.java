package ua.edu.ucu.flower.store.FlowerStrore.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.edu.ucu.flower.store.FlowerStrore.Flower;
import ua.edu.ucu.flower.store.FlowerStrore.FlowerColor;
import ua.edu.ucu.flower.store.FlowerStrore.FlowerType;

@RestController
@RequestMapping("/flowers")
public class FlowerController {

    @GetMapping("/flowerlist")
    public List<Flower> getItems() {
        return List.of(
                new Flower(0.5, FlowerColor.BLUE, 2, FlowerType.ROSE)
        );
    }
}