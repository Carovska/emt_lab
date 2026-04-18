package mk.ukim.finki.wp.lab.service.application.impl;

import mk.ukim.finki.wp.lab.model.domain.Accommodation;
import mk.ukim.finki.wp.lab.model.domain.Country;
import mk.ukim.finki.wp.lab.model.domain.Host;
import mk.ukim.finki.wp.lab.model.dto.CreateAccommodationDto;
import mk.ukim.finki.wp.lab.model.dto.DisplayAccommodationDto;
import mk.ukim.finki.wp.lab.model.enums.AccommodationCategory;
import mk.ukim.finki.wp.lab.model.exception.HostNotFound;
import mk.ukim.finki.wp.lab.repository.AccommodationRepository;
import mk.ukim.finki.wp.lab.service.application.AccommodationApplicationService;
import mk.ukim.finki.wp.lab.service.domain.AccommodationService;
import mk.ukim.finki.wp.lab.service.domain.CountryService;
import mk.ukim.finki.wp.lab.service.domain.HostService;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationApplicationServiceImpl implements AccommodationApplicationService {
    private final HostService hostService;
    private final AccommodationService accommodationService;
    private final AccommodationRepository accommodationRepository;

    public AccommodationApplicationServiceImpl(HostService hostService, AccommodationService accommodationService, AccommodationRepository accommodationRepository){
        this.accommodationService=accommodationService;
        this.hostService=hostService;
        this.accommodationRepository = accommodationRepository;
    }

    @Override
    public Optional<DisplayAccommodationDto> findById(Long id) {
        return accommodationService
                .findById(id)
                .map(DisplayAccommodationDto::from);
    }
   /*@Override
   public Optional<DisplayAccommodationDto> findById(Long id) {
       return accommodationRepository.findById(id).map(DisplayAccommodationDto::from);
   }*/

    @Override
    public List<DisplayAccommodationDto> findAll() {
        return DisplayAccommodationDto.from(accommodationService.findAll());
    }
    /*@Override
    public List<DisplayAccommodationDto> findAll() {
        return accommodationRepository.findAll()
                .stream()
                .map(DisplayAccommodationDto::from)
                .toList();
    }*/

    @Override
    public DisplayAccommodationDto create(CreateAccommodationDto createAccommodationDto) {
        Host host=hostService.findById(createAccommodationDto.hostId())
                .orElseThrow(() -> new HostNotFound(String.format("Host with id %d not found", createAccommodationDto.hostId())));
        return DisplayAccommodationDto.from(accommodationService.create(createAccommodationDto.toAccommodation(host)));
    }

    /*@Override
    public DisplayAccommodationDto create(CreateAccommodationDto dto) {
        AccommodationCategory category = a.findById(dto.categoryId())
                .orElseThrow(() -> new IllegalStateException("Category not found with id: " + dto.categoryId()));

        State state = stateRepository.findById(dto.stateId())
                .orElseThrow(() -> new IllegalStateException("State not found with id: " + dto.stateId()));

        List<Host> hosts = hostRepository.findAllById(dto.hostIds());


        Accommodation accommodation = new Accommodation(
                dto.name(),
                dto.numRooms(),
                category,
                state,
                hosts
        );

        Accommodation saved = accomodationRepository.save(accommodation);
        return DisplayAccommodationDTO.from(saved);
    }*/

    @Override
    public Optional<DisplayAccommodationDto> update(Long id, CreateAccommodationDto createAccommodationDto) {
        Host host = hostService.findById(createAccommodationDto.hostId())
                .orElseThrow(() -> new HostNotFound(String.format("Host with id %d not found!", createAccommodationDto.hostId())));
        return accommodationService.update(id, createAccommodationDto.toAccommodation(host))
                .map(DisplayAccommodationDto::from);
    }

    @Override
    public Optional<DisplayAccommodationDto> deleteById(Long id) {
        return accommodationService
                .deleteById(id)
                .map(DisplayAccommodationDto::from);

    }

    @Override
    public Optional<DisplayAccommodationDto> makeAsRented(Long id) {
        return accommodationRepository.findById(id)
                .map(acc -> {
                    acc.setIsRented(true);
                    Accommodation updated=accommodationRepository.save(acc);
                    return DisplayAccommodationDto.from(updated);
                });
    }

    @Override
    public Page<DisplayAccommodationDto> findAll(int page, int size, String sortBy) {
        return null;
    }


}
