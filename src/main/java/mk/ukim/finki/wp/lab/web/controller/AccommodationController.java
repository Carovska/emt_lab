package mk.ukim.finki.wp.lab.web.controller;

import jakarta.validation.Valid;
import mk.ukim.finki.wp.lab.model.dto.CreateAccommodationDto;
import mk.ukim.finki.wp.lab.model.dto.DisplayAccommodationDto;
import mk.ukim.finki.wp.lab.model.dto.DisplayHostDto;
import mk.ukim.finki.wp.lab.model.projection.AccommodationExtendedView;
import mk.ukim.finki.wp.lab.model.projection.AccommodationShortView;
import mk.ukim.finki.wp.lab.repository.AccommodationRepository;
import mk.ukim.finki.wp.lab.service.application.AccommodationApplicationService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accommodations")
public class AccommodationController {
    private final AccommodationApplicationService accommodationApplicationService;
    private final AccommodationRepository accommodationRepository;

    public AccommodationController(AccommodationApplicationService accommodationApplicationService, AccommodationRepository accommodationRepository){
        this.accommodationApplicationService=accommodationApplicationService;
        this.accommodationRepository = accommodationRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayAccommodationDto> findById(@PathVariable Long id) {
        return accommodationApplicationService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<DisplayAccommodationDto>> findAll() {
        return ResponseEntity.ok(accommodationApplicationService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayAccommodationDto> create(@RequestBody @Valid CreateAccommodationDto accommodationDto) {
        return ResponseEntity.ok(accommodationApplicationService.create(accommodationDto));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<DisplayAccommodationDto> update(
            @PathVariable Long id,
            @RequestBody CreateAccommodationDto createAccommodationDto
    ) {
        return accommodationApplicationService
                .update(id, createAccommodationDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DisplayAccommodationDto> deleteById(@PathVariable Long id) {
        return accommodationApplicationService
                .deleteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/rent/{id}")
    public ResponseEntity<Optional<DisplayAccommodationDto>> rent(@PathVariable Long id) {
        return ResponseEntity.ok(accommodationApplicationService.makeAsRented(id));
    }

    @GetMapping("/paginated")
    public ResponseEntity<Page<DisplayAccommodationDto>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy
    ) {
        return ResponseEntity.ok(accommodationApplicationService.findAll(page, size, sortBy));
    }

    @GetMapping("/short")
    public List<AccommodationShortView> getShortView() {
        return accommodationRepository.findAllShortView();
    }

    @GetMapping("/extended")
    public List<AccommodationExtendedView> getExtendedView() {
        return accommodationRepository.findAllExtendedView();
    }

}
