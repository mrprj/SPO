package com.servicepartner.challenge.service;

import com.google.common.collect.Lists;
import com.servicepartner.challenge.model.WorkerCombination;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class WorkerService implements IWorkerService {

    /**
     * Considering the constrains defined (in the challenge description) by limiting the number of structures and rooms to 100, I simply implemented the brute force way to examine all possible solutions
     * @param rooms
     * @param senior
     * @param junior
     * @return A list of worker combination
     */
    @Override
    public List<WorkerCombination> computeWorkerCombination(int[] rooms, int senior, int junior) {
        List<WorkerCombination> finalList = new ArrayList<>();
        for (int room : rooms) {
            List<Integer> seniors = IntStream.rangeClosed(1, room / senior + 1).mapToObj(j -> j * senior).collect(Collectors.toList());
            List<Integer> juniors = IntStream.rangeClosed(0, room / junior + 1).mapToObj(j -> j * junior).collect(Collectors.toList());
            List<List<Integer>> cartesianProduct = Lists.cartesianProduct(seniors, juniors);

            Optional<WorkerCombination> min = cartesianProduct.stream()
                    .filter(list -> room <= (list.get(0) + list.get(1)))
                    .map(list -> new WorkerCombination(list.get(0) / senior, list.get(1) / junior, Math.abs(room - (list.get(0) + list.get(1)))))
                    .min(WorkerCombination.getComparator());

            finalList.add(min.orElseGet(() -> new WorkerCombination(-1, -1, -1)));
        }
        return finalList;
    }
}
