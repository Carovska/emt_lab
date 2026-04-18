package mk.ukim.finki.wp.lab.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import mk.ukim.finki.wp.lab.model.domain.Country;
import mk.ukim.finki.wp.lab.model.domain.Host;

public record CreateHostDto(
        String name,
        String surname,
        Long country_id
) {
        public Host toHost(Country country){
            return new Host(name,surname,country);
        }
}
