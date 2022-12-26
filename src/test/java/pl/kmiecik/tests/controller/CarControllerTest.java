package pl.kmiecik.tests.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.kmiecik.tests.domain.Car;
import pl.kmiecik.tests.domain.CarService;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest
class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Test
    void shouldGetResponseStatus200() throws Exception {
        //given
        Car car1 = new Car();
        car1.setModel("Opel");
        List<Car> carList = List.of(car1);

        Mockito.when(carService.getAll()).thenReturn(carList);
        //when   //then
        mockMvc.perform(MockMvcRequestBuilders.get("/cars")
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].model").value("Opel"));
    }


}