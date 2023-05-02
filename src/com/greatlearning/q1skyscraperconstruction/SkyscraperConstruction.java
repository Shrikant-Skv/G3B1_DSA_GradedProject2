package com.greatlearning.q1skyscraperconstruction;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Collections;
import java.util.Iterator;

public class SkyscraperConstruction {
	
	public static void assembleSkyscraper() {

		Scanner sc = new Scanner(System.in);

		// Taking total no of floors input
		System.out.println("enter the total no of floors in the building ");
		int N = sc.nextInt();
		while (N <= 0) {
			System.out.println("Invalid input. Please enter a positive integer (>0) for the number of floors.");
			N = sc.nextInt();
		}

		// Taking floor sizes input
		int i = 1;
		LinkedHashSet<Integer> floorSizes = new LinkedHashSet<>(N);

		int size = 0;

		while (i <= N) {
			System.out.println("Enter the floor size given on day: " + i);
			size = sc.nextInt();
			while (size <= 0 || (i > 1 && floorSizes.contains(size))) {
				System.out.println("Invalid floor size! The floor size must be a positive integer and not a duplicate.");
				System.out.println("Enter the floor size given on day: " + i);
				size = sc.nextInt();
			}
			floorSizes.add(size); // adding the floor size to the set
			i++;
		}

		// Order of Construction
		System.out.println("\nThe order of construction is as follows\n");
		// Using Iterator to iterate through the floor sizes...
		Iterator<Integer> itr = floorSizes.iterator();
		int dayCount = 1;
	//	int N = floorSizes.size();

		// to store the floor sizes that can be assembled
		TreeSet<Integer> assembledSizes = new TreeSet<>();

		while (itr.hasNext()) {

			System.out.println("Day: " + dayCount);

			int num = itr.next(); // get the next floor size.
			itr.remove(); // remove the current floor size from the 'floorSizes' set.

			assembledSizes.add(num); // if the 'assembledSizes' set is empty, add the current floor size to it.

			while (!assembledSizes.isEmpty()) {
			    if (dayCount == N) {
			        System.out.print(assembledSizes.pollLast() + " ");
			    } else if (assembledSizes.last() > Collections.max(floorSizes)) {
			        System.out.print(assembledSizes.pollLast() + " ");
			    } else {
			        break;
			    }
			}
			System.out.println("");
			dayCount++;	
		}
		sc.close();
	}

	public static void main(String[] args) {
		SkyscraperConstruction.assembleSkyscraper();
	}
}
