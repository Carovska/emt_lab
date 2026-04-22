package mk.ukim.finki.wp.lab.service.application;

import mk.ukim.finki.wp.lab.model.dto.CreateHostDto;
import mk.ukim.finki.wp.lab.model.dto.DisplayHostDto;
import mk.ukim.finki.wp.lab.model.projection.HostCountryProjection;

import java.util.List;
import java.util.Optional;

public interface HostApplicationService {
    Optional<DisplayHostDto> findById(Long id);

    List<DisplayHostDto> findAll();

    DisplayHostDto create(CreateHostDto createHostDto);

    Optional<DisplayHostDto> update(Long id,CreateHostDto createHostDto);

    Optional<DisplayHostDto> deleteById(Long id);

    List<HostCountryProjection> getHostCountry();
}
