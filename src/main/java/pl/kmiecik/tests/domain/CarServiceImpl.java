package pl.kmiecik.tests.domain;

import org.springframework.stereotype.Service;
import pl.kmiecik.tests.infrastructure.CarEntity;
import pl.kmiecik.tests.infrastructure.CarRepository;

import java.util.ArrayList;
import java.util.List;
@Service
class CarServiceImpl implements CarService {
private final CarRepository carRepository;

    CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAll() {
        List<CarEntity> entities = carRepository.findAll();
        List<Car> carList=new ArrayList<>();
        entities.forEach(c->{
            Car car=new Car();
            car.setModel(c.getModel());
            carList.add(car);
        });
        return carList;
    }

    @Override
    public void save(Car car) {

    }
}
