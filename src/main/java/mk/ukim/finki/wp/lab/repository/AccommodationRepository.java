package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.domain.Accommodation;
import mk.ukim.finki.wp.lab.model.projection.AccommodationExtendedView;
import mk.ukim.finki.wp.lab.model.projection.AccommodationShortView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation,Long> {
    @Query("SELECT a.id AS id, a.name AS name, a.accommodationCategory AS accommodationCategory, a.numRooms AS numRooms " +
            "FROM Accommodation a")
    List<AccommodationShortView> findAllShortView();

    @Query("SELECT a.id AS id, a.name AS name, a.accommodationCategory AS accommodationCategory, a.numRooms AS numRooms, " +
            "CONCAT(h.name, ' ', h.surname) AS hostFullName, c.name AS hostCountryName " +
            "FROM Accommodation a JOIN a.host h JOIN h.country c")
    List<AccommodationExtendedView> findAllExtendedView();

    @EntityGraph(value = "Accommodation.withHostAndCountry", type = EntityGraph.EntityGraphType.FETCH)
    List<Accommodation> findAllBy();

}
