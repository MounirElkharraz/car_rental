package carrental.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import carrental.dto.CarDTO;
import carrental.entity.Car;
import carrental.mapper.CarMapper;
import carrental.repository.CarRepository;

public class CarServiceImplTest {
	
	 @Mock
	    private CarRepository carRepository;

	    @Mock
	    private CarMapper carMapper;

	    @InjectMocks
	    private CarServiceImpl carService;

	    private Car car;
	    private CarDTO carDTO;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);

	        car = new Car();
	        car.setId(1L);
	        car.setRegistrationNumber("123-XYZ");
	        car.setBrand("Toyota");
	        car.setModel("Corolla");
	        car.setPricePerDay(50.0);
	        car.setAvailable(true);

	        carDTO = new CarDTO();
	        carDTO.setId(1L);
	        carDTO.setRegistrationNumber("123-XYZ");
	        carDTO.setBrand("Toyota");
	        carDTO.setModel("Corolla");
	        carDTO.setPricePerDay(50.0);
	        carDTO.setAvailable(true);
	    }

	    @Test
	    void getAllCars_ShouldReturnListOfCarDTOs() {
	        // Arrange
	        List<Car> cars = Arrays.asList(car);
	        when(carRepository.findAll()).thenReturn(cars);
	        when(carMapper.toDTO(car)).thenReturn(carDTO);

	        // Act
	        List<CarDTO> result = carService.getAllCars();

	        // Assert
	        assertEquals(1, result.size());
	        assertEquals("Toyota", result.get(0).getBrand());
	        verify(carRepository, times(1)).findAll();
	        verify(carMapper, times(1)).toDTO(car);
	    }

	    @Test
	    void addCar_ShouldSaveAndReturnCarDTO() {
	        // Arrange
	        when(carMapper.toEntity(carDTO)).thenReturn(car);
	        when(carRepository.save(car)).thenReturn(car);
	        when(carMapper.toDTO(car)).thenReturn(carDTO);

	        // Act
	        CarDTO result = carService.addCar(carDTO);

	        // Assert
	        assertEquals("Toyota", result.getBrand());
	        verify(carRepository, times(1)).save(car);
	        verify(carMapper, times(1)).toEntity(carDTO);
	        verify(carMapper, times(1)).toDTO(car);
	    }

}
