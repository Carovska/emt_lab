package mk.ukim.finki.wp.lab.service.domain;

import mk.ukim.finki.wp.lab.model.domain.Accommodation;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {
    Optional<Accommodation> findById(Long id);

    List<Accommodation> findAll();

    Accommodation create(Accommodation accommodation);

    Optional<Accommodation> update(Long id, Accommodation accommodation);

    Optional<Accommodation> deleteById(Long id);

    Optional<Accommodation> makeAsRented(Long id);


}
