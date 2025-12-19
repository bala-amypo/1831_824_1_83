package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import com.example.demo.model.DeliveryEvaluation;
import com.example.demo.service.DeliveryEvaluationService;

@RestController
@RequestMapping("/evaluations")
public class DeliveryEvaluationController {

    @Autowired
    private DeliveryEvaluationService service;

    // CREATE
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public DeliveryEvaluation createEvaluation(@RequestBody DeliveryEvaluation evaluation) {
        return service.createEvaluation(evaluation);
    }

    // UPDATE
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public DeliveryEvaluation updateEvaluation(@PathVariable Long id,
                                               @RequestBody DeliveryEvaluation evaluation) {
        return service.updateEvaluation(id, evaluation);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public DeliveryEvaluation getEvaluationById(@PathVariable Long id) {
        return service.getEvaluationById(id);
    }

    // GET ALL
    @GetMapping
    public List<DeliveryEvaluation> getAllEvaluations() {
        return service.getAllEvaluations();
    }

    // DEACTIVATE
    @PutMapping("/{id}/deactivate")
    public void deactivateEvaluation(@PathVariable Long id) {
        service.deactivateEvaluation(id);
    }
}
