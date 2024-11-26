package carrental.mapper;

import org.mapstruct.Mapper;

import carrental.dto.CarDTO;
import carrental.entity.Car;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarDTO toDTO(Car car);

    Car toEntity(CarDTO carDTO);
}
