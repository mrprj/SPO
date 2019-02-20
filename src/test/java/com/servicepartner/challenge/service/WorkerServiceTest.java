package com.servicepartner.challenge.service;

import com.servicepartner.challenge.model.WorkerCombination;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@RunWith(SpringRunner.class)
@SpringBootTest
class WorkerServiceTest {

    @Autowired
    IWorkerService workerService;

    @ParameterizedTest
    @MethodSource("provideSampleData")
    void computeWorkerCombination(List<WorkerCombination> result, int [] rooms, int senior, int junior) {
        assertEquals(result, workerService.computeWorkerCombination(rooms, senior, junior));
    }

    private static Stream<Arguments> provideSampleData(){
        return Stream.of(
                arguments(Arrays.asList(new WorkerCombination(3,1,-1)
                        , new WorkerCombination(1,2,-1)
                        , new WorkerCombination(2,0,-1)
                        , new WorkerCombination(1,3,-1))
                        , new int[] {35,21,17,28}
                        , 10
                        ,6
                ),arguments(Arrays.asList(new WorkerCombination(2,1,-1)
                        , new WorkerCombination(2,1,-1))
                        , new int[] {24,28}
                        , 11
                        ,6
                )
        );
    }
}