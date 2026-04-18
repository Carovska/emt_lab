package mk.ukim.finki.wp.lab.web.controller;

import jakarta.validation.Valid;
import mk.ukim.finki.wp.lab.model.dto.CreateHostDto;
import mk.ukim.finki.wp.lab.model.dto.DisplayHostDto;
import mk.ukim.finki.wp.lab.service.application.HostApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/hosts")
public class HostController {
    private final HostApplicationService hostApplicationService;

    public HostController(HostApplicationService hostApplicationService) {
        this.hostApplicationService = hostApplicationService;
    }

    @GetMapping
    public ResponseEntity<List<DisplayHostDto>> findAll() {
        return ResponseEntity.ok(hostApplicationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayHostDto> findById(@PathVariable Long id) {
        return hostApplicationService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayHostDto> create(@RequestBody @Valid CreateHostDto createHostDto) {
        return ResponseEntity.ok(hostApplicationService.create(createHostDto));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<DisplayHostDto> update(
            @PathVariable Long id,
            @RequestBody @Valid CreateHostDto createHostDto) {
        return hostApplicationService.update(id, createHostDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DisplayHostDto> delete(@PathVariable Long id) {
        return hostApplicationService.deleteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
