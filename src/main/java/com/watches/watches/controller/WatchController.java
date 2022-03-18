package com.watches.watches.controller;

import com.watches.watches.dto.WatchDTO;
import com.watches.watches.exception.NoWatchFoundException;
import com.watches.watches.model.Watch;
import com.watches.watches.service.WatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/watches/")
@CrossOrigin
public class WatchController {

    private final WatchService watchService;

    @Autowired
    public WatchController(WatchService watchService) {
        this.watchService = watchService;
    }

    @GetMapping("getWatches")
    public List<Watch> getAll() {
        return watchService.findAll();
    }

    @GetMapping("/watchNr/{id}")
    public ResponseEntity<Watch> getById(@PathVariable("id") Long id) throws NoWatchFoundException {
        Watch response = watchService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);

    }

    @DeleteMapping("deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id){

         watchService.deleteById(id);

    }

    @PostMapping("AddWatch")
    public Watch create(@RequestBody WatchDTO watchDTO) {
        return watchService.addWatch(watchDTO);
    }

    @PutMapping("updateWatch/{id}")
    public Watch updateVehicle(@PathVariable("id") Long id,@RequestBody WatchDTO updateWatchDto) throws NoWatchFoundException {

        return watchService.updateWatch(id, updateWatchDto);
    }

}
