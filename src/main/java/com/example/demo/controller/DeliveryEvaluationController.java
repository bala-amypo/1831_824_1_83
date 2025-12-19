package com.example.demo.controller;

import com.example.demo.model.DeliveryEvaluation;
import com.example.demo.service.DeliveryEvaluationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery-evaluations")
public class DeliveryEvaluationController {

    private final DeliveryEvaluationService service;

    public DeliveryEvaluationController(DeliveryEvaluationService service) {
        this.service = service;
    }

    @PostMapping
    public DeliveryEvaluation create(@RequestBody DeliveryEvaluation evaluation) {
        return service.createEvaluation(evaluation);
    }

    @GetMapping("/{id}")
    public DeliveryEvaluation getById(@PathVariable Long id) {
        return service.getEvaluationById(id);
    }

    @GetMapping
    public List<DeliveryEvaluation> getAll() {
        return service.getAllEvaluations();
    }

    @PutMapping("/{id}")
    public DeliveryEvaluation update(
            @PathVariable Long id,
            @RequestBody DeliveryEvaluation evaluation) {
        return service.updateEvaluation(id, evaluation);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteEvaluation(id);
    }
}
