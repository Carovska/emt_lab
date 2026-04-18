package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.domain.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {
}
