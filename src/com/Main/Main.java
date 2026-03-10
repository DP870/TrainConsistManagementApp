package com.Main;
import java.util.*;
/*
 * The Train Consist Management App is a console-based Java application that simulates how a railway system manages a train’s consist, which is a collection of bogies attached to an engine.

	The application supports:

	Passenger bogies (Sleeper, AC Chair, First Class) with seat capacity tracking.

	Goods bogies (Rectangular, Cylindrical) with cargo type and safety constraints.

	Tracking composition, capacity, cargo types, and safety compliance.

	Each use case introduces one or more Java concepts through a realistic railway Scenario.
	
	@author Dhruv
	@version 2.0

 */
public class Main {
	public static void main(String[] args) {
		System.out.println("====================================");
		System.out.println("====Train Consist Management App====");
		System.out.println("====================================");
		
		List<String> trainConsist=new ArrayList<>();
		System.out.println("Train Intitalized successfully...");
		System.out.println("Intial Bogie Count: "+trainConsist.size());
		System.out.println("Current Train Consist: "+trainConsist);
		System.out.println("");
		System.out.println("System Ready for operations...");
		
		List<String> bogies=new ArrayList<>();
		 
		bogies.add("First Class");
		bogies.add("AC Chair");
		bogies.add("Sleeper");
	    
	    

	    System.out.println("After Adding Bogies:");
	     System.out.println("Passenger Bogies : " + bogies + "\n");

	     System.out.println("After Removing Sleeper:");
	     bogies.remove("Sleeper");
	     System.out.println("Passenger Bogies: " +bogies);

	     System.out.println("Checking if 'Sleeper' exists:");
	     boolean hasSleeper = bogies.contains("Sleeper");
	     System.out.println("Contains Sleeper? : " + hasSleeper);

	     System.out.println("Final Train Passenger Consist:");
         System.out.println(bogies);
		}
}
