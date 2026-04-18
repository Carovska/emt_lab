package mk.ukim.finki.wp.lab.service.application.impl;

import mk.ukim.finki.wp.lab.model.domain.Country;
import mk.ukim.finki.wp.lab.model.dto.CreateHostDto;
import mk.ukim.finki.wp.lab.model.dto.DisplayHostDto;
import mk.ukim.finki.wp.lab.model.exception.HostNotFound;
import mk.ukim.finki.wp.lab.service.application.HostApplicationService;
import mk.ukim.finki.wp.lab.service.domain.CountryService;
import mk.ukim.finki.wp.lab.service.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostApplicationServiceImpl implements HostApplicationService {
    private final HostService hostService;
    private final CountryService countryService;

    public HostApplicationServiceImpl(HostService hostService,CountryService countryService){
        this.hostService=hostService;
        this.countryService=countryService;
    }

    @Override
    public Optional<DisplayHostDto> findById(Long id) {
        return hostService.findById(id).map(DisplayHostDto::from);
    }

    @Override
    public List<DisplayHostDto> findAll() {
        return DisplayHostDto.from(hostService.findAll());
    }

    @Override
    public DisplayHostDto create(CreateHostDto createHostDto) {
        Country country = countryService.findById(createHostDto.country_id())
                .orElseThrow(() -> new HostNotFound(String.format("Country with id %d not found!", createHostDto.country_id())));
        return DisplayHostDto.from(hostService.create(createHostDto.toHost(country)));    }

    @Override
    public Optional<DisplayHostDto> update(Long id, CreateHostDto createHostDto) {
        Country country = countryService.findById(createHostDto.country_id())
                .orElseThrow(() -> new HostNotFound(String.format("Country with id %d not found!", createHostDto.country_id())));
        return hostService.update(id, createHostDto.toHost(country)).map(DisplayHostDto::from);    }

    @Override
    public Optional<DisplayHostDto> deleteById(Long id) {
        return hostService.deleteById(id).map(DisplayHostDto::from);
    }
}
