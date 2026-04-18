package mk.ukim.finki.wp.lab.model.dto;

import jakarta.validation.constraints.NotBlank;
import mk.ukim.finki.wp.lab.model.domain.Country;

public record CreateCountryDto(
        String name,
        String continent
) {
    public Country toCountry(){
        return new Country(name,continent);
    }
}
