package com.engeto.wedding.controller;

import com.engeto.wedding.error.ErrorResponse;
import com.engeto.wedding.model.Occurrence;
import com.engeto.wedding.repository.WeddingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("wedding")
public class WeddingController {

    @Value("${de.engeto.author}")
    private String nameOfAuthor;

    Logger logger = LoggerFactory.getLogger(WeddingController.class);

    @Autowired
    WeddingRepository weddingRepository;

    @PostMapping(value = "/occurrence")
    public void createNewOccurrenceOfWedding(@RequestBody Occurrence occurrenceToCreate) {
        logger.info("Occurrence to create " + occurrenceToCreate.toString() + ".");
        weddingRepository.addNewWedding(occurrenceToCreate);
    }

    @GetMapping(value = "/occurrence/{id}")
    public Occurrence getOneOccurrence(@PathVariable Long id) {
        logger.info(String.format("Get one occurrence %s .", id) );
        return weddingRepository.getOneOccurrence(id);
    }

    @GetMapping(value = "/occurrences")
    public List<Occurrence> getAllOccurrences() {
        logger.info("Get all occurrences.");
        return weddingRepository.getAllOccurence();
    }

    @DeleteMapping(value = "/occurrence")
    public void deleteOccurrence(@RequestBody Occurrence occurrenceToDelete){
        logger.info(String.format("One occurrence to delete > %s .", occurrenceToDelete.toString()));
        weddingRepository.deleteWedding(occurrenceToDelete);
    }

    @PutMapping(value = "/occurrence")
    public Occurrence updateOneOccurrence(@RequestBody Occurrence updateOccurence){
        return weddingRepository.updateOneOccurrence(updateOccurence);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handlerException(Exception e){
        return new ErrorResponse(e.getMessage(), nameOfAuthor, LocalDateTime.now());
    }
}
