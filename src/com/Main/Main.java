package com.Main;
import java.util.*;

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
					System.out.println("1. Add Bogies");
					System.out.println("2. Remove Bogies");
					System.out.println("3. Display Consists");
					System.out.println("4. Sort Consists");
					System.out.println("0. Exit");
					System.out.print("Enter Choice: ");
					String choice = sc.nextLine();
					
					ch = switch(choice) {
						case "1" -> {
							System.out.print("Enter the name of bogie: ");
							String bogie = sc.nextLine();
							System.out.print("Enter the capacity of bogie: ");
							String cap = sc.nextLine();
							bogies.add(new Bogie(bogie, Integer.parseInt(cap)));
							System.out.printf("Added bogie and capacity successfully.");
									
							yield true;
						}
						case "2" -> {
							System.out.print("Enter name of bogie to remove: ");
							String bogie = sc.nextLine();
							
							for(Bogie b : bogies) {
								if(b.getName().equals(bogie)) {
									bogies.remove(b);
									System.out.printf("Removed bogie from train successfully.");
									yield true;
								}
							}

							System.out.printf("The bogie does not exist.");
							yield true;

						}
						
						case "3" -> {
							System.out.println("Bogie Capacity Details:-\n");
							
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
