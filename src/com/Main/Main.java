package com.Main;
import java.util.*;
/*
 * 
 * Maintain Ordered Bogie IDs
 * The Train Consist Management App is a console-based Java application that simulates how a railway system manages a train’s consist, which is a collection of bogies attached to an engine.

	The application supports:

	Passenger bogies (Sleeper, AC Chair, First Class) with seat capacity tracking.

	Goods bogies (Rectangular, Cylindrical) with cargo type and safety constraints.

	Tracking composition, capacity, cargo types, and safety compliance.

	Each use case introduces one or more Java concepts through a realistic railway Scenario.
	
	@author Dhruv
	@version 4.0

 */
public class Main {
	public static void main(String[] args) {
		 System.out.println("==================================================");
	     System.out.println("============Maintain Ordered Bogie IDs============");

	     List<String> trainConsist = new LinkedList<>();

	        trainConsist.add("Engine");
	        trainConsist.add("Sleeper");
	        trainConsist.add("AC");
	        

	        System.out.println("Initial Train Consist:");
	        System.out.println(trainConsist);

	        trainConsist.add(3, "Kitchen");
	        System.out.println("After Inserting 'Kitchen':");
	        System.out.println(trainConsist);

	        if (!trainConsist.isEmpty()) {
	            ((LinkedList<String>) trainConsist).removeFirst();
	        }
	        if (!trainConsist.isEmpty()) {
	            ((LinkedList<String>) trainConsist).removeLast();
	        }

	        System.out.println("After Removing First and Last Bogie:");
	        System.out.println(trainConsist);


		}
}
