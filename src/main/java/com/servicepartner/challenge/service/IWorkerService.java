package com.servicepartner.challenge.service;

import com.servicepartner.challenge.model.WorkerCombination;

import java.util.List;

public interface IWorkerService {

    List<WorkerCombination> computeWorkerCombination(int [] rooms, int senior, int junior);
}
