package com.Main;
import java.util.*;
/*
 * 
 * Track Unique Bogie IDs
 * The Train Consist Management App is a console-based Java application that simulates how a railway system manages a train’s consist, which is a collection of bogies attached to an engine.

	The application supports:

	Passenger bogies (Sleeper, AC Chair, First Class) with seat capacity tracking.

	Goods bogies (Rectangular, Cylindrical) with cargo type and safety constraints.

	Tracking composition, capacity, cargo types, and safety compliance.

	Each use case introduces one or more Java concepts through a realistic railway Scenario.
	
	@author Dhruv
	@version 3.0

 */
public class Main {
	public static void main(String[] args) {
		 System.out.println("==================================================");
	     System.out.println("================Track Unique Bogie IDs============");

	        Set<String> bogies = new HashSet<>();

	        bogies.add("BG101");
	        bogies.add("BG102");
	        bogies.add("BG103");
	        bogies.add("BG104");

	        bogies.add("BG101");  
	        bogies.add("BG102");  

	        System.out.println("Bogie IDs After Insertion:");
	        System.out.println(bogies);

		}
}
