package pl.kmiecik.tests.domain;

import java.util.List;

public interface CarService {

    List<Car> getAll();
    void save(Car car);

}
