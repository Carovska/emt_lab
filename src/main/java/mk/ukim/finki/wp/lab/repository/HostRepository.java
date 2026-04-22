package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.domain.Host;
import mk.ukim.finki.wp.lab.model.projection.HostCountryProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HostRepository extends JpaRepository<Host,Long> {
    @Query("select h.country.id as countryId, h.country.name as countryName, COUNT(h) as hostCount " +
            "from Host h group by h.country.id, h.country.name order by count(h) desc ")
    List<HostCountryProjection> findHostCountPerCountry();

}
