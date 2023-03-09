package com.example.brzageografija.service.impl;

import com.example.brzageografija.repository.MountainRepository;
import com.example.brzageografija.service.MountainService;
import org.springframework.stereotype.Service;

@Service
public class MountainServiceImpl implements MountainService {
    private final MountainRepository mountainRepository;

    public MountainServiceImpl(MountainRepository mountainRepository) {
        this.mountainRepository = mountainRepository;
    }

    @Override
    public boolean isValidAnswer(String input, String s) {
        return mountainRepository.findAllByMountainNameEqualsIgnoreCaseAndMountainNameStartsWith(input, s).size()>0;
    }
}
