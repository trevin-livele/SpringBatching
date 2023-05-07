package com.trevin.spring.batching.partition;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

import java.util.HashMap;
import java.util.Map;

public class ColumnRangePartitioner implements Partitioner {
    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {
        int min = 1;
        int max = 1000;
        int targetSize = (max-min) / gridSize + 1;
        System.out.println("target size : " + targetSize);
        Map<String, ExecutionContext> result = new HashMap<>();

        int number =0;
        int start = min;
        int end = start + targetSize -1;
//        start from 1 to 500
// 501 to 1000
        while (start <= max){
            ExecutionContext value = new ExecutionContext();
            result.put("partitioning" + number, value);

            if (end >= max){
                end = max;
            }
            value.putInt("minValue", start);
            value.putInt("maxValue", end);
            start += targetSize;
            end += targetSize;
            number ++;
        }
        System.out.println("partition result: " + result.toString());
        return result;
    }
}
