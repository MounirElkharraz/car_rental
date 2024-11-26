package carrental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cars")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String registrationNumber;

	@Column(nullable = false)
	private String brand;

	@Column(nullable = false)
	private String model;

	@Column(nullable = false)
	private double pricePerDay;

	@Column(nullable = false)
	private boolean available;
}
