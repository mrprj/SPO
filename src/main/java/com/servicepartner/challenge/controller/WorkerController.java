package com.servicepartner.challenge.controller;

import com.servicepartner.challenge.model.WorkerCombination;
import com.servicepartner.challenge.model.WorkerRequest;
import com.servicepartner.challenge.service.IWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicepartner")
public class WorkerController {

    @Autowired
    IWorkerService workerService;

    @PostMapping(path="/workercount")
    public @ResponseBody ResponseEntity<List<WorkerCombination>> getWorkerCount(@RequestBody WorkerRequest workerRequest) {
        return ResponseEntity.ok(workerService.computeWorkerCombination(workerRequest.getRooms(), workerRequest.getSenior(), workerRequest.getJunior()));
    }
}
