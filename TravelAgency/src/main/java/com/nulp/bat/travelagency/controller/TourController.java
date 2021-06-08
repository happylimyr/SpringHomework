package com.nulp.bat.travelagency.controller;

import com.nulp.bat.travelagency.api.TourApi;
import com.nulp.bat.travelagency.controller.assembler.TourAssembler;
import com.nulp.bat.travelagency.controller.model.TourModel;
import com.nulp.bat.travelagency.dto.TourDto;
import com.nulp.bat.travelagency.model.Tour;
import com.nulp.bat.travelagency.service.TourService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class TourController implements TourApi {

    private final TourAssembler tourAssembler;
    private final TourService tourService;

    @Override
    public TourModel getTour(String tour) {
        TourDto tourDto = tourService.getTour(tour);
        return tourAssembler.toModel(tourDto);
    }


    public List<TourModel> getAllTour() {
        List<TourDto> tour = tourService.getAllTour();
        return tourAssembler.tourModelList(tour);
    }


    @Override
    public TourModel createTour(TourDto tourDto) {
        TourDto statuses = tourService.createTour(tourDto);
        return tourAssembler.toModel(statuses);
    }

    @Override
    public TourModel updateTour(String tour, TourDto tourDto) {
        TourDto statuses = tourService.updateTour(tour, tourDto);
        return tourAssembler.toModel(statuses);
    }

    @Override
    public ResponseEntity<Void> deleteTour(String tour) {
        tourService.deleteTour(tour);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteById(Long idTour) {
        tourService.deleteById(idTour);
        return ResponseEntity.noContent().build();
    }
}
