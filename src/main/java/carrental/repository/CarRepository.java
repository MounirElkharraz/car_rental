package carrental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import carrental.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

}
