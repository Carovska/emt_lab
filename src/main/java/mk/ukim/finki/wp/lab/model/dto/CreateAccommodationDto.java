package mk.ukim.finki.wp.lab.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import mk.ukim.finki.wp.lab.model.domain.Accommodation;
import mk.ukim.finki.wp.lab.model.domain.Host;
import jakarta.validation.constraints.NotBlank;
import mk.ukim.finki.wp.lab.model.enums.AccommodationCategory;

import java.util.Locale;

public record CreateAccommodationDto(
        String name,
        AccommodationCategory accommodationCategory,
        Long hostId,
        @Positive
        Integer numRooms
) {
        public Accommodation toAccommodation(Host host){
            return new Accommodation(name,accommodationCategory,host,numRooms);
        }
}
