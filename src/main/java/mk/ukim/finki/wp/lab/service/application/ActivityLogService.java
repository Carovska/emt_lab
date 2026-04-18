package mk.ukim.finki.wp.lab.service.application;

import mk.ukim.finki.wp.lab.model.domain.ActivityLog;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

public interface ActivityLogService {
    ActivityLog save(String accommodationName, String eventType);
    Page<ActivityLog> findAll(int page, int size);
}