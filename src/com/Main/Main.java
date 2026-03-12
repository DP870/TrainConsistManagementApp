package com.Main;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * The Train Consist Management App is a console-based Java application that simulates how a railway system manages a train’s consist, which is a collection of bogies attached to an engine.

	The application supports:

	Passenger bogies (Sleeper, AC Chair, First Class) with seat capacity tracking.

	Goods bogies (Rectangular, Cylindrical) with cargo type and safety constraints.

	Tracking composition, capacity, cargo types, and safety compliance.

	Each use case introduces one or more Java concepts through a realistic railway Scenario.
	
	@author Dhruv
	@version 11.0

 */
import java.util.stream.Collectors;
public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("==========================================");
		System.out.println("   === Train Consist Management App ===   ");
		System.out.println("==========================================");
		List<Bogie> bogies = new ArrayList<>();
		System.out.println("Train initializaed sucessfully");
		System.out.println("Inital Bogie Count: " + bogies.size());
		System.out.println("Current Train Consist: " + bogies);
		System.out.println("\nSystem ready for operations\n");

		boolean ch = true;

		while(ch) {
			System.out.println("--- Train App Menu ---");
			System.out.println("1. Manage Train Consists");
			System.out.println("2. Validate IDs");
			System.out.println("0. Exit");
			System.out.print("Enter Choice: ");
			String choice = scanner.nextLine();

			ch = switch(choice) {
			case "1" -> {
				handleConsistFlow(bogies, scanner);
				yield true;
			}
			case "2" -> {
				handleValidationFlow(scanner);
				yield true;
			}
			case "0" -> {
				yield false;
			}
			default -> {
				yield true;
			}
			};
		}

		scanner.close();
	}
				
			
			

private static void handleConsistFlow(List<Bogie> bogies, Scanner scanner) {
	boolean ch2 = true;

	while(ch2) {
		System.out.println("\n--- Train Consist Menu ---");
		System.out.println("1. Add Bogies");
		System.out.println("2. Remove Bogies");
		System.out.println("3. Check if Bogie Exists");
		System.out.println("4. Display Consists");
		System.out.println("5. Sort Consists");
		System.out.println("6. Filter By Potential Passenger Lobies");
		System.out.println("7. Group By Bogie Type");
		System.out.println("8. Get Total Capacity");
		System.out.println("0. Exit");
		System.out.print("Enter Choice: ");
		String choice = scanner.nextLine();

		ch2 = switch(choice) {
		case "1" -> {
			System.out.print("Enter the name of bogie to add: ");
			String bogie = scanner.nextLine();

			System.out.print("Enter the capacity of bogie to add: ");
			String capacity = scanner.nextLine();

			bogies.add(new Bogie(bogie, Integer.parseInt(capacity)));
			System.out.printf("Added bogie "+bogie+" of capacity "+capacity+" to train successfully.");

			yield true;
		}
		case "2" -> {
			System.out.print("Enter name of bogie to remove: ");
			String bogie = scanner.nextLine();

			for(Bogie b : bogies) {
				if(b.getName().equals(bogie)) {
					bogies.remove(b);
					System.out.printf("Removed bogie "+bogie+" from train successfully.");
					yield true;
				}
			}

			System.out.printf("The bogie "+bogie+" does not exist.");
			yield true;

		}
		case "3" -> {
			System.out.print("Enter name of bogie to check: ");
			String bogie = scanner.nextLine();

			for(Bogie b : bogies) {
				if(b.getName().equals(bogie)) {
					System.out.printf("Contains \'%s\'? :  true\n", bogie);
					yield true;
				}
			}

			System.out.printf("Contains \'%s\'? :  false\n", bogie);

			yield true;
		}
		case "4" -> {
			System.out.println("Bogie Capacity Details:-\n");

			for(Bogie bogie : bogies) {
				System.out.printf("%s -> %s\n", bogie.getName(), bogie.getCapacity());
			}

			yield true;
		}
		case "5" -> {
			Collections.sort(bogies, Comparator.comparingInt(Bogie::getCapacity));
			System.out.println("Bogies sorted successfully!");
			yield true;
		}
		case "6" -> {
			System.out.println("Filtering Bogies (Capacity > 60): ");
			for(Bogie bogie : bogies.stream().filter(b -> b.getCapacity() > 60).collect(Collectors.toList())) {
				System.out.printf("%s -> %s\n", bogie.getName(), bogie.getCapacity());
			}
			yield true;
		}
		case "7" -> {
			Map<String, List<Bogie>> groupedBogies = bogies.stream().collect(Collectors.groupingBy(Bogie::getName));
			System.out.println("\nGrouped Bogies: \n");
			for(Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
				System.out.printf("Boogie Type: %s\n", entry.getKey());
				for(Bogie bogie : entry.getValue()) {
					System.out.printf("Capacity -> %s\n", bogie.getCapacity());
				}
			}
			System.out.println();
			yield true;
		}
		case "8" -> {
			System.out.printf("Total Seating Capacity of Train: %d\n", bogies.stream().map(b -> b.getCapacity()).reduce(0, Integer::sum));
			yield true;
		}
		case "0" -> {
			System.out.println("Exiting to main menu...\n");
			yield false;
		}
		default -> {
			System.out.println("Invalid Choice!!");
			yield true;
		}
		};
	}
}

private static void handleValidationFlow(Scanner scanner) {
	final String train_regex = "TRN-\\d{4}";
	final String cargo_regex = "PET-[A-Z]{2}";

	Pattern trainIdPattern = Pattern.compile(train_regex);
	Pattern cargoIdPattern = Pattern.compile(cargo_regex);

	boolean inMenu = true;

	while(inMenu) {
		System.out.println("--- Validation Menu ---");
		System.out.println("1. Validate Train ID");
		System.out.println("2. Validate Cargo ID");
		System.out.println("0. Exit");
		System.out.print("Enter Your Choice: ");
		String choice = scanner.nextLine();

		inMenu = switch(choice) {
		case "1" -> {
			
			System.out.print("Enter Train ID (Format: TRN-1234): ");
			String trainId = scanner.nextLine();
			
			Matcher matcher = trainIdPattern.matcher(trainId);
			
			System.out.println("Train ID Valid : " + matcher.matches());
			
			yield true;
		}
		case "2" -> {
			System.out.print("Enter Cargo ID (Format: PET-AB): ");
			String cargoId = scanner.nextLine();
			
			Matcher matcher = cargoIdPattern.matcher(cargoId);
			
			System.out.println("Cargo ID Valid : " + matcher.matches());
			yield true;
		}
		case "0" -> {
			System.out.println("Exiting to main menu...\n");
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


		
