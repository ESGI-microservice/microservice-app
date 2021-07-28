/*package com.microservice.marketmanager.regulation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegulationService {

    private final RegulationRepository regulationRepository;

    @Autowired
    public RegulationService(RegulationRepository regulationRepository) { this.regulationRepository = regulationRepository; }


    public List<Regulation> regulationsById(Iterable<Long> id) {

        var regulation = this.regulationRepository.findAllById(id);
        *//*if (reservation.isEmpty()) {
            throw new ReservationNotFoundException();
        }*//*
        List<Regulation> regulations= new ArrayList<Regulation>();

        regulations = regulation;

        return regulations;
    }


}*/
