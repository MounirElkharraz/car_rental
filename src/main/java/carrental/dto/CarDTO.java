package carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {

    private Long id;
    private String registrationNumber;
    private String brand;
    private String model;
    private double pricePerDay;
    private boolean available;
}
