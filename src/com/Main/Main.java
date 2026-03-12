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
	@version 9.0

 */
import java.util.stream.Collectors;


public class Main {
	public static void main(String[] args) {

				Scanner sc = new Scanner(System.in);
				
				System.out.println("==========================================");
				System.out.println("=======Train Consist Management App=======");
				System.out.println("==========================================");
				
				List<Bogie> bogies = new ArrayList<>();

				System.out.println("Train initializaed sucessfully");
				System.out.println("Inital Bogie Count: " + bogies.size());
				System.out.println("Current Train Consist: " + bogies);
				System.out.println("System ready for operations");
				
				boolean ch = true;
				
				while(ch) {
					System.out.println("1.Add Bogies");
					System.out.println("2.Remove Bogies");
					System.out.println("3.Display Bogies");
					System.out.println("4.Sort Bogies");
					System.out.println("5.Filter Bogies");
					System.out.println("6.Group By");
					System.out.println("7.Get Total Capacity");
					System.out.println("0.Exit");
					System.out.print("Enter Choice: ");
					String choice = sc.nextLine();
					
					ch = switch(choice) {
						case "1" -> {
							System.out.print("Enter the name of bogie: ");
							String bogie = sc.nextLine();
							System.out.print("Enter the capacity of bogie: ");
							String cap = sc.nextLine();
							bogies.add(new Bogie(bogie, Integer.parseInt(cap)));
							System.out.println("Added bogie and capacity successfully.");
									
							yield true;
						}
						case "2" -> {
							System.out.print("Enter name of bogie to remove: ");
							String bogie = sc.nextLine();
							
							for(Bogie b : bogies) {
								if(b.getName().equals(bogie)) {
									bogies.remove(b);
									System.out.println("Removed bogie from train successfully.");
									yield true;
								}
							}

							System.out.println("The bogie does not exist.");
							yield true;

						}
						
						case "3" -> {
							System.out.println("Bogie Capacity Details:-");
							
							for(Bogie bogie : bogies) {
								System.out.println(bogie.getName()+" ->"+bogie.getCapacity());
							}
							
							yield true;
						}
						case "4" -> {
							Collections.sort(bogies, Comparator.comparingInt(Bogie::getCapacity));
							System.out.println("Bogies sorted successfully!");
							yield true;
						}
						case "5" -> {
							System.out.println("Filtering Bogies: ");
							for(Bogie bogie : bogies.stream().filter(b -> b.getCapacity() > 60).collect(Collectors.toList())) {
								System.out.println(bogie.getCapacity()+"-> "+ bogie.getName());
							}
							yield true;
						}
						case "6" -> {
					
							Map<String, List<Bogie>> groupedBogies = bogies.stream().collect(Collectors.groupingBy(Bogie::getName));
							System.out.println("Grouped Bogies:");
							for(Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
								System.out.printf("Boogie Type: %s\n", entry.getKey());
								for(Bogie bogie : entry.getValue()) {
									System.out.println("Capacity -> "+bogie.getCapacity());
								}
							}
							System.out.println();
							yield true;
						}
						case "7" -> {
							System.out.printf("Total Seating Capacity of Train:"+ bogies.stream().map(b -> b.getCapacity()).reduce(0, Integer::sum));
							yield true;
						}
						case "0" -> {
							System.out.println("Thank You!!");
							yield false;
						}
						default -> {
							System.out.println("Invalid Choice!!");
							yield true;
						}
					};
				}
				
			
			}


		}
