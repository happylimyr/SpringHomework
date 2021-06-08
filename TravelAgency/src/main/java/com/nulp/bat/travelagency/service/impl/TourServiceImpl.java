package com.nulp.bat.travelagency.service.impl;

import com.nulp.bat.travelagency.dto.TourDto;
import com.nulp.bat.travelagency.exeption.NotFoundException;
import com.nulp.bat.travelagency.model.Tour;
import com.nulp.bat.travelagency.repository.HotelRepository;
import com.nulp.bat.travelagency.repository.TourRepository;
import com.nulp.bat.travelagency.repository.TourTypeRepository;
import com.nulp.bat.travelagency.service.TourService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

//

@Slf4j
@Service
@RequiredArgsConstructor
public class TourServiceImpl implements TourService {

    private final TourRepository tourRepository;
    private final HotelRepository hotelRepository;
    private final TourTypeRepository tourTypeRepository;

    @Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public TourDto getTour(String name) {
        log.info("getting tour {}", name);
        Tour statuses = tourRepository.findByName(name)
                .orElseThrow(NotFoundException::new);
        return mapTourToTourDto(statuses);
    }

    @Override
    public List<TourDto> getAllTour() {
        return tourRepository.findAll().stream().map(this::mapTourToTourDto).collect(Collectors.toList());
    }

    @Override
    public TourDto createTour(TourDto tourDto) {
        log.info("creating tour in database: {}", tourDto);
        Tour status = mapTourDtoToTour(tourDto);
        status = tourRepository.save(status);
        return mapTourToTourDto(status);
    }

    @Override
    public TourDto updateTour(String name, TourDto tourDto) {
        log.info("updating tour in database: {}", tourDto);
        Tour statuses = mapTourDtoToTour(tourDto);
        Tour statusFromDB = tourRepository.findByName(name)
                .orElseThrow(NotFoundException::new);
        tourRepository.delete(statusFromDB);
        statuses = tourRepository.save(statuses);
        return mapTourToTourDto(statuses);
    }


    @Override
    public void deleteTour(String name) {
        log.info("deleting status in database by status name {}", name);
        Tour statuses = tourRepository.findByName(name)
                .orElseThrow(NotFoundException::new);
        tourRepository.delete(statuses);
    }

    @Override
    public void deleteById(Long idTour) {
        Tour tour = tourRepository.findById(idTour)
                .orElseThrow(NotFoundException::new);
        tourRepository.delete(tour);
    }

    private TourDto mapTourToTourDto(Tour statuses) {
//        hotelRepository.findByName(statuses.getHotel().getName());
//        tourRepository.findByName(statuses.getTourType().getName());

        return TourDto.builder()
                .name(statuses.getName())
                .price(statuses.getPrice())
                .dateStart(statuses.getDateStart())
                .dateEnd(statuses.getDateEnd())
                .peopleNumber(statuses.getPeopleNumber())
                .firePrice(statuses.getFirePrice())
                .hotel(statuses.getHotel())
                .tourType(statuses.getTourType())
                .build();
    }

    private Tour mapTourDtoToTour(TourDto tourDto) {

        tourDto.setTourType(tourTypeRepository.findByName(tourDto.getTourType().getName()).orElseGet(() -> {
            getSession().save(tourDto.getTourType());
            return tourDto.getTourType();
        }));

        tourDto.setHotel(hotelRepository.findByName(tourDto.getHotel().getName()).orElseGet(() -> {
            getSession().save(tourDto.getHotel());
            return tourDto.getHotel();
        }));
//
//        hotelRepository.findByName(tourDto.getHotel().getName());
//        tourRepository.findByName(tourDto.getTourType().getName());

        return Tour.builder()
                .name(tourDto.getName())
                .price(tourDto.getPrice())
                .dateStart(tourDto.getDateStart())
                .dateEnd(tourDto.getDateEnd())
                .peopleNumber(tourDto.getPeopleNumber())
                .firePrice(tourDto.getFirePrice())
                .tourType(tourDto.getTourType())
                .hotel(tourDto.getHotel())
                .build();
    }
}
