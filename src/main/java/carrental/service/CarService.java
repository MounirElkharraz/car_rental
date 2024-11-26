package carrental.service;

import java.util.List;

import carrental.dto.CarDTO;
import carrental.entity.Car;

public interface CarService {
	
    List<CarDTO> getAllCars();

    CarDTO addCar(CarDTO carDTO);

}
