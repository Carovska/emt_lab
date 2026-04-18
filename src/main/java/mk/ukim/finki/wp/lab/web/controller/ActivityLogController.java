package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.domain.ActivityLog;
import mk.ukim.finki.wp.lab.service.application.ActivityLogService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/activity-log")
public class ActivityLogController {

    private final ActivityLogService activityLogService;

    public ActivityLogController(ActivityLogService activityLogService) {
        this.activityLogService = activityLogService;
    }

    @GetMapping
    public ResponseEntity<Page<ActivityLog>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(activityLogService.findAll(page, size));
    }
}