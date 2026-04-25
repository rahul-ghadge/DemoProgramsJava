package com.demo.program.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Custom Collector Demo
 * Demonstrates creating and using custom collectors in Java 8 streams.
 * This is complex as it requires understanding of the Collector interface and its methods.
 */
public class CustomCollectorDemo {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("hello", "world", "java", "streams", "collector", "custom");


        // Custom collector to collect strings into a frequency map
        Map<String, Integer> frequencyMap = words.stream()
            .collect(new FrequencyCollector());
        System.out.println("\nFrequency Map: " + frequencyMap);


        // Another custom collector: Collect to a custom data structure
        WordStats stats = words.stream()
            .collect(new WordStatsCollector());
        System.out.println("\nWord Stats: " + stats);



        // Using built-in collectors for comparison
        Map<String, Long> builtInFrequency = words.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("\nBuilt-in Frequency: " + builtInFrequency);
    }




    // Custom Collector for frequency map
    static class FrequencyCollector implements Collector<String, Map<String, Integer>, Map<String, Integer>> {

        @Override
        public Supplier<Map<String, Integer>> supplier() {
            return HashMap::new;
        }

        @Override
        public BiConsumer<Map<String, Integer>, String> accumulator() {
            return (map, word) -> map.merge(word, 1, Integer::sum);
        }

        @Override
        public BinaryOperator<Map<String, Integer>> combiner() {
            return (map1, map2) -> {
                map2.forEach((key, value) -> map1.merge(key, value, Integer::sum));
                return map1;
            };
        }

        @Override
        public Function<Map<String, Integer>, Map<String, Integer>> finisher() {
            return Function.identity(); // No transformation needed
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Collections.singleton(Characteristics.IDENTITY_FINISH);
        }
    }




    // Custom Collector for WordStats
    static class WordStatsCollector implements Collector<String, WordStatsAccumulator, WordStats> {

        @Override
        public Supplier<WordStatsAccumulator> supplier() {
            return WordStatsAccumulator::new;
        }

        @Override
        public BiConsumer<WordStatsAccumulator, String> accumulator() {
            return WordStatsAccumulator::accumulate;
        }

        @Override
        public BinaryOperator<WordStatsAccumulator> combiner() {
            return WordStatsAccumulator::combine;
        }

        @Override
        public Function<WordStatsAccumulator, WordStats> finisher() {
            return WordStatsAccumulator::finish;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Collections.emptySet();
        }
    }



    static class WordStatsAccumulator {
        private int totalWords = 0;
        private int totalLength = 0;
        private String longestWord = "";

        public void accumulate(String word) {
            totalWords++;
            totalLength += word.length();
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        public WordStatsAccumulator combine(WordStatsAccumulator other) {
            totalWords += other.totalWords;
            totalLength += other.totalLength;
            if (other.longestWord.length() > longestWord.length()) {
                longestWord = other.longestWord;
            }
            return this;
        }

        public WordStats finish() {
            return new WordStats(totalWords, totalLength, longestWord);
        }
    }



    static class WordStats {
        private final int totalWords;
        private final int totalLength;
        private final String longestWord;

        public WordStats(int totalWords, int totalLength, String longestWord) {
            this.totalWords = totalWords;
            this.totalLength = totalLength;
            this.longestWord = longestWord;
        }

        @Override
        public String toString() {
            return "WordStats{totalWords=" + totalWords + ", totalLength=" + totalLength + ", longestWord='" + longestWord + "'}";
        }
    }
}

//        ---------------------------------------------------------------
//        Output
//        ---------------------------------------------------------------
//        Frequency Map: {java=1, world=1, custom=1, streams=1, hello=1, collector=1}
//
//        Word Stats: WordStats{totalWords=6, totalLength=36, longestWord='collector'}
//
//        Built-in Frequency: {java=1, world=1, custom=1, streams=1, hello=1, collector=1}