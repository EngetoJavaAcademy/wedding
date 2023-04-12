package com.engeto.wedding.controller;

import com.engeto.wedding.model.Occurrence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("wedding")
public class WeddingController {

    Logger logger = LoggerFactory.getLogger(WeddingController.class);

    @PostMapping(value = "/occurrence")
    public void createNewOccurrenceOfWedding(@RequestBody Occurrence occurrenceToCreate) {
        logger.info("Occurrence to create " + occurrenceToCreate.toString() + ".");
    }

    @GetMapping(value = "/occurrence/{id}")
    public Occurrence getOneOccurrence(@PathVariable Long id) {
        logger.info(String.format("Get one occurrence %s .", id) );
        return null;
    }

    @GetMapping(value = "/occurrences")
    public List<Occurrence> getAllOccurrences() {
        logger.info("Get all occurrences.");
        return null;
    }

    @DeleteMapping(value = "/occurrence")
    public void deleteOccurrence(@RequestBody Occurrence occurrenceToDelete){
        logger.info(String.format("One occurrence to delete > %s .", occurrenceToDelete.toString()));
    }
}
