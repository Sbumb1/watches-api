package com.watches.watches.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.watches.watches.dto.WatchDTO;
import com.watches.watches.exception.NoWatchFoundException;
import com.watches.watches.model.Watch;
import com.watches.watches.repository.WatchRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchService {

    private final WatchRepository watchRepository;
    private final ObjectMapper objectMapper;


    @Autowired
    public WatchService(WatchRepository watchRepository, ObjectMapper objectMapper) {
        this.watchRepository = watchRepository;
        this.objectMapper = objectMapper;
    }

    public Watch addWatch(WatchDTO watchDTO){

        Watch watch = objectMapper.convertValue(watchDTO, Watch.class);

        return watchRepository.save(watch);
    }

    public void deleteById(long id) {
        watchRepository.deleteById(id);
    }

    public List<Watch> findAll() {
        return watchRepository.findAll();
    }

    public Watch findById(Long id) throws NoWatchFoundException {
        return watchRepository.findById(id).orElseThrow(()->new NoWatchFoundException("Watch "+id+" not found"));
    }

    public Watch updateWatch(long id, WatchDTO updateWatchDto) throws NoWatchFoundException {
        Watch watch = findById(id);

        BeanUtils.copyProperties(updateWatchDto,watch);

        return watchRepository.save(watch);
    }
}
