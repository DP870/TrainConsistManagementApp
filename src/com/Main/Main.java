package com.Main;
import java.util.*;
/*
 * 
 * Map Bogie to Capacity
 * The Train Consist Management App is a console-based Java application that simulates how a railway system manages a train’s consist, which is a collection of bogies attached to an engine.

	The application supports:

	Passenger bogies (Sleeper, AC Chair, First Class) with seat capacity tracking.

	Goods bogies (Rectangular, Cylindrical) with cargo type and safety constraints.

	Tracking composition, capacity, cargo types, and safety compliance.

	Each use case introduces one or more Java concepts through a realistic railway Scenario.
	
	@author Dhruv
	@version 6.0

 */
public class Main {
	public static void main(String[] args) {
		 System.out.println("==================================================");
	     System.out.println("============Map Bogie to Capacity============");

	     Map<String, Integer> capacity = new HashMap<>();

	        capacity.put("Sleeper", 100);
	        capacity.put("AC Chair", 100);
	        capacity.put("Cargo", 80);
	        capacity.put("First Class", 30);
	        

	        System.out.println("Bogie Capacity Details:");
	        for (Map.Entry<String, Integer> entry : capacity.entrySet()) {
	            System.out.println(entry.getKey() + " -> " + entry.getValue());
	        }
	        System.out.println();

	        


		}
}
