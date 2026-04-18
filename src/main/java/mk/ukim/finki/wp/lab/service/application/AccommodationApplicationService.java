package mk.ukim.finki.wp.lab.service.application;

import mk.ukim.finki.wp.lab.model.dto.CreateAccommodationDto;
import mk.ukim.finki.wp.lab.model.dto.DisplayAccommodationDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface AccommodationApplicationService {
    Optional<DisplayAccommodationDto> findById(Long id);

    List<DisplayAccommodationDto> findAll();

    DisplayAccommodationDto create(CreateAccommodationDto createAccommodationDto);

    Optional<DisplayAccommodationDto> update(Long id,CreateAccommodationDto createAccommodationDto);

    Optional<DisplayAccommodationDto> deleteById(Long id);

    Optional<DisplayAccommodationDto> makeAsRented(Long id);


    Page<DisplayAccommodationDto> findAll(int page, int size, String sortBy);
}
