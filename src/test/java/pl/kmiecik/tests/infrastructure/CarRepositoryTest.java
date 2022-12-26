package pl.kmiecik.tests.infrastructure;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
class CarRepositoryTest {
    @Autowired
    private CarRepository carRepository;

    @Test
    void shouldSaveOneCarWithId1(){
        CarEntity carEntity=new CarEntity();
        carEntity.setModel("Opel");

        CarEntity savedCar = carRepository.save(carEntity);

        assertAll(
                ()->assertEquals(1,carRepository.findAll().size()),
                ()->assertEquals(carEntity.getId(),savedCar.getId()),
                ()->assertEquals(carEntity.getModel(),savedCar.getModel())
        );
    }

}