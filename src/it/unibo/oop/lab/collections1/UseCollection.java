package it.unibo.oop.lab.collections1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	
	private static final int TO_MS = 1_000_000;

    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	ArrayList<Integer> arrl = new ArrayList<>();
    	for(int i = 1000; i<2000; i++) {
    		arrl.add(i);
    	}
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	//LinkedList<Integer> linl = new LinkedList<>(arrl);
    	LinkedList<Integer> linl = new LinkedList<>();
    	linl.addAll(arrl);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	int change = arrl.get(0);
    	arrl.set(0, arrl.get(arrl.size() - 1));
    	arrl.set(arrl.size() -1 , change);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
		System.out.print("[");
    	for(int elem : arrl) {
    		System.out.print(elem + ", ");
    	}
		System.out.println("]");
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	long timea = System.nanoTime();
    	for(int i=0; i<100_000; i++) {
    		arrl.add(i);
    	}
    	timea = System.nanoTime() - timea;
    	System.out.println("Inserting 100'000 integers in a ArrayList took " + timea + "ns (" + timea / TO_MS + "ms)");
    	
    	long timel = System.nanoTime();
    	for(int i=0; i<100_000; i++) {
    		linl.add(i);
    	}
    	timel = System.nanoTime() - timel;
    	System.out.println("Inserting 100'000 integers in a LinkedList took " + timel + "ns (" + timel / TO_MS + "ms)");
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    	long timea2 = System.nanoTime();
    	for(int i=0; i<1_000; i++) {
    		@SuppressWarnings("unused")
			int n = arrl.get(arrl.size() / 2);
    	}
    	timea2 = System.nanoTime() - timea2;
    	System.out.println("Reading 1000 integers in a ArrayList took " + timea2 + "ns (" + timea2 / TO_MS + "ms)");
        
    	long timel2 = System.nanoTime();
    	for(int i=0; i<1_000; i++) {
    		@SuppressWarnings("unused")
			int n = linl.get(linl.size() / 2);
    	}
    	timel2 = System.nanoTime() - timel2;
    	System.out.println("Reading 1000 integers in a ArrayList took " + timel2 + "ns (" + timel2 / TO_MS + "ms)");
    	/*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
    	Map<String, Long> map = new HashMap<>();
    	map.put("Africa", (long) 1_110_635_000);
    	map.put("Americas", (long) 972_005_000);
    	map.put("Antarctica", (long) 0);
    	map.put("Asia", 4_298_723_000L);
    	map.put("Europe", (long) 742_452_000);
    	map.put("Oceania", (long) 38_304_000);
        /*
         * 8) Compute the population of the world
         */
    	long poptot = 0;
    	for(long pop : map.values()) {
    		poptot += pop;
    	}
    	System.out.println("Population: " + poptot);
    }
}
