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
	@version 5.0

 */
public class Main {
	public static void main(String[] args) {
		 System.out.println("==================================================");
	     System.out.println("============Maintain Ordered Bogie IDs============");

	     Set<String> order = new LinkedHashSet<>();

	    order.add("Engine");
	    order.add("Sleeper");
	        order.add("Cargo");
	        order.add("Guard");
	        order.add("Sleeper"); 

	        System.out.println("Final Train Order:");
	        System.out.println(order + "\n");

	        


		}
}
