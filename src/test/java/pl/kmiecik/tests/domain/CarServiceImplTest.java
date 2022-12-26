package pl.kmiecik.tests.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.kmiecik.tests.infrastructure.CarEntity;
import pl.kmiecik.tests.infrastructure.CarRepository;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class CarServiceImplTest {
@Mock
private CarRepository carRepository;
    @InjectMocks
    private CarServiceImpl carService;
    @Test
    void shouldGet(){
        //given
        Car car1=new Car();
        car1.setModel("Fiat");
        List<Car> expected = List.of(car1);

        CarEntity carEntity1=new CarEntity();
        carEntity1.setModel("Fiat");
        List<CarEntity> stubbedResponse = List.of(carEntity1);
        Mockito.when(carRepository.findAll()).thenReturn(stubbedResponse);

        //when
        List<Car> returnedFromService = carService.getAll();
        //then
        Assertions.assertEquals(expected,returnedFromService);
    }

}