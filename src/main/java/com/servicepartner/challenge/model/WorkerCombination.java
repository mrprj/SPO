package com.servicepartner.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Comparator;
import java.util.Objects;

public class WorkerCombination {

    /**
     * I know: I should have made the fields private and provide getters and setters. I did this just for simplicity!
     */
    // TODO: Provide getters and setters instead of making fields public!
    @JsonProperty("senior")
    public int senriorCount;

    @JsonProperty("junior")
    public int juniorCount;

    @JsonIgnore
    public int difference;

    public WorkerCombination(int senriorCount, int juniorCount, int differentce) {
        this.senriorCount = senriorCount;
        this.juniorCount = juniorCount;
        this.difference = differentce;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkerCombination that = (WorkerCombination) o;
        return senriorCount == that.senriorCount &&
                juniorCount == that.juniorCount;
    }

    @Override
    public int hashCode() {

        return Objects.hash(senriorCount, juniorCount);
    }

    public static Comparator<WorkerCombination> getComparator(){
        return ((wc1, wc2) -> {
            if (wc1.difference > wc2.difference){
                return 1;
            }else if(wc1.difference == wc2.difference){
                if(wc1.senriorCount+wc1.juniorCount > wc2.senriorCount+wc2.juniorCount){
                    return 1;
                }else{
                    return -1;
                }
            }else{
                return -1;
            }
        });
    }
}
