package com.example.brzageografija.service.impl;

import com.example.brzageografija.repository.RiverRepository;
import com.example.brzageografija.service.RiverService;
import org.springframework.stereotype.Service;

@Service
public class RiverServiceImpl implements RiverService {
    private final RiverRepository riverRepository;

    public RiverServiceImpl(RiverRepository riverRepository) {
        this.riverRepository = riverRepository;
    }

    @Override
    public boolean isValidAnswer(String input) {
        return riverRepository.findAllByRiverNameEqualsIgnoreCase(input).size()>0;
    }
}
