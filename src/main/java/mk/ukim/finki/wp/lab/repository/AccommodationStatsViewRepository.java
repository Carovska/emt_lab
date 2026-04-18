package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.views.AccommodationStatsView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationStatsViewRepository extends JpaRepository<AccommodationStatsView, String> {
}