package carrental.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import carrental.dto.CarDTO;
import carrental.entity.Car;
import carrental.mapper.CarMapper;
import carrental.repository.CarRepository;
import carrental.service.CarService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

	private final CarRepository carRepository;
	private final CarMapper carMapper;


	@Override
	public List<CarDTO> getAllCars() {
		return carRepository.findAll().stream().map(carMapper::toDTO).collect(Collectors.toList());
	}

	@Override
	public CarDTO addCar(CarDTO carDTO) {
		Car car = carMapper.toEntity(carDTO);
		Car savedCar = carRepository.save(car);
		return carMapper.toDTO(savedCar);
	}

}
