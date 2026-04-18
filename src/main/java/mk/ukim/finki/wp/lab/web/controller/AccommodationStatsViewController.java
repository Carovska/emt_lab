package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.views.AccommodationStatsView;
import mk.ukim.finki.wp.lab.repository.AccommodationStatsViewRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accommodations/stats-view")
public class AccommodationStatsViewController {

    private final AccommodationStatsViewRepository accommodationStatsViewRepository;

    public AccommodationStatsViewController(AccommodationStatsViewRepository accommodationStatsViewRepository) {
        this.accommodationStatsViewRepository = accommodationStatsViewRepository;
    }

    @GetMapping
    public ResponseEntity<List<AccommodationStatsView>> getStatsView() {
        return ResponseEntity.ok(accommodationStatsViewRepository.findAll());
    }
}