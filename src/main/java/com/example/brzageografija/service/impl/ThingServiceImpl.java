package com.example.brzageografija.service.impl;

import com.example.brzageografija.repository.ThingRepository;
import com.example.brzageografija.service.ThingService;
import org.springframework.stereotype.Service;

@Service
public class ThingServiceImpl implements ThingService {
    private final ThingRepository thingRepository;

    public ThingServiceImpl(ThingRepository thingRepository) {
        this.thingRepository = thingRepository;
    }

    @Override
    public boolean isValidAnswer(String input, String s) {
        return thingRepository.findAllByThingNameEqualsIgnoreCaseAndThingNameStartsWith(input, s).size()>0;
    }
}
