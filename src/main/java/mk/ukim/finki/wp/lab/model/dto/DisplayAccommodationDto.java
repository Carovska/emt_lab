package mk.ukim.finki.wp.lab.model.dto;

import mk.ukim.finki.wp.lab.model.domain.Accommodation;
import mk.ukim.finki.wp.lab.model.enums.AccommodationCategory;

import java.util.List;

public record DisplayAccommodationDto(
       Long id,
       String name,
       AccommodationCategory accommodationCategory,
       Long host_id,
       Integer numRooms
) {
       public static DisplayAccommodationDto from(Accommodation accommodation){
           return new DisplayAccommodationDto(
                   accommodation.getId(),
                   accommodation.getName(),
                   accommodation.getAccommodationCategory(),
                   accommodation.getHost().getId(),
                   accommodation.getNumRooms()
           );
       }
       public static List<DisplayAccommodationDto> from(List<Accommodation> accommodations){
           return accommodations
                   .stream()
                   .map(DisplayAccommodationDto::from)
                   .toList();
       }

}
