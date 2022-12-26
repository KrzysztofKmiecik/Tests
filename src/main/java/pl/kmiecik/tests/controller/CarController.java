package pl.kmiecik.tests.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kmiecik.tests.domain.Car;
import pl.kmiecik.tests.domain.CarService;

import java.util.List;

@RestController()
class CarController {
    private final CarService carService;

    CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public List<Car> getAll(){
    return carService.getAll();
    }
}
