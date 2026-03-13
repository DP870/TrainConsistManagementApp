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
	@version 15.0

 */
import java.util.stream.Collectors;
public class Main {
	public static void main(String[] args) {
		System.out.println("==========================================");
		System.out.println("=======Train Consist Management App=======");
		System.out.println("==========================================");
		Scanner sc = new Scanner(System.in);

		List<Bogie> fleetList = new ArrayList<>();

		System.out.println("Fleet initialized successfully");
		System.out.println("Initial Unit Count: " +fleetList.size());
		System.out.println("Current Consist: " +fleetList);
		System.out.println("\nDispatcher ready for commands\n");

		boolean isRunning = true;

		while(isRunning) {
			System.out.println("--- System Main Menu ---");
			System.out.println("1. Manage Consists");
			System.out.println("2. Manage Cargo Operations");
			System.out.println("3. Run ID Validation");
			System.out.println("0. Exit System");
			System.out.print("Select Option: ");
			String navChoice = sc.nextLine();

			isRunning = switch(navChoice) {
			case "1" -> {
				try {
					handleFleetFlow(fleetList, sc);
				} catch(FreightIncompatibilityException ex) {
					System.out.println("Alert: " + ex.getMessage());
				}
				yield true;
			}
			case "2" -> {
				// Logic: try-catch-finally for runtime safety checks
				try {
					handleSecurityFlow(sc);
				} catch(FreightIncompatibilityException ex) {
					System.out.println("Safety Violation: " + ex.getMessage());
				} finally {
					System.out.println("Safety audit sequence finished for the current batch.");
				}
				yield true;
			}
			case "3" -> {
				handleSecurityFlow(sc);
				yield true;
			}
			case "0" -> false;
			default -> true;
			};
		}

		sc.close();
	}

	private static void handleFleetFlow(List<Bogie> unitList, Scanner sc) {
		boolean subMenu = true;

		while(subMenu) {
			System.out.println("---Consist Management Menu---");
			System.out.println("1.Attach Bogie");
			System.out.println("2.Detach Bogie");
			System.out.println("3.Verify Existence");
			System.out.println("4.Show All Bogies");
			System.out.println("5.Organize by Capacity");
			System.out.println("6.Filter High-Capacity Units");
			System.out.println("7.Group by Model Type");
			System.out.println("8.Total Fleet Capacity");
			System.out.println("9.Bubble Sort");
			System.out.println("10.Alphabetical Library Sort");
			System.out.println("0. Return");
			System.out.print("Action: ");
			String action = sc.nextLine();

			subMenu = switch(action) {
			case "1" -> {
				System.out.print("Enter bogie designation: ");
				String label = sc.nextLine();

				System.out.print("Enter seating capacity: ");
				int cap = Integer.parseInt(sc.nextLine());

				unitList.add(new Bogie(label, cap));
				System.out.println("Bogie " + label + " (Cap: "+cap+" attached successfully.");

				yield true;
			}
			case "2" -> {
				System.out.print("Enter designation to detach: ");
				String target = sc.nextLine();
				
				boolean removed = false;
				for (int i = 0; i < unitList.size(); i++) {
					if (unitList.get(i).getName().equalsIgnoreCase(target)) {
						unitList.remove(i);
						System.out.println("Bogie " + target + " detached from consist.");
						removed = true;
						break;
					}
				}

				if(!removed) {
					System.out.println("Unit " + target + " not found.");
				}
				yield true;
			}
			case "3" -> {
				System.out.print("Search for bogie: ");
				String query = sc.nextLine();
				
				boolean found = unitList.stream().anyMatch(b -> b.getName().equalsIgnoreCase(query));
				System.out.println("Status for '" + query + "': " + found);
				yield true;
			}
			case "4" -> {
				System.out.println("Current Manifest Details:\n");
				unitList.forEach(b->System.out.println(b.getName() + " >> " + b.getCapacity()));
				yield true;
			}
			case "5" -> {
				unitList.sort((b1, b2)->b1.getCapacity()-b2.getCapacity());
				System.out.println("Consist re-ordered by capacity.");
				yield true;
			}
			case "6" -> {
				System.out.println("Filtering Units (Capacity > 60): ");
				unitList.stream()
						.filter(b->b.getCapacity() > 60)
						.forEach(b->System.out.println(b.getName() + " -> " + b.getCapacity()));
				yield true;
			}
			case "7" -> {
				Map<String, List<Bogie>> mappedUnits = unitList.stream().collect(Collectors.groupingBy(Bogie::getName));

				System.out.println("\nCategorized Bogie Report: \n");
				mappedUnits.forEach((type, list) -> {
					System.out.println("Category: " + type);
					list.forEach(item -> System.out.println(" - Capacity: " + item.getCapacity()));
				});
				yield true;
			}
			case "8" -> {
				int total = unitList.stream().mapToInt(Bogie::getCapacity).sum();
				System.out.println("Aggregate Fleet Seating: " + total);
				yield true;
			}
			//Bubble sort
			case "9"->{
			int size = unitList.size();
			int[] metrics = new int[size];
			
			for(int k = 0; k < size; k++) {
				metrics[k] = unitList.get(k).getCapacity();
			}
			
			System.out.println("Pre-sorted Metrics: " + Arrays.toString(metrics));
			
			
			for(int outer = 0; outer < metrics.length - 1; outer++) {
				for(int inner = 0; inner < metrics.length - outer - 1; inner++) {
					if(metrics[inner] > metrics[inner + 1]) {
						// Perform Swap --- > Bubble Sort
						int placeholder = metrics[inner];
						metrics[inner] = metrics[inner + 1];
						metrics[inner + 1] = placeholder;
					}
				}
			}
			
			System.out.println("Algorithmic Sorted Result: "+ Arrays.toString(metrics));
			yield true;
		}
			case "10" -> {
				//UC17 
				String[] labelList = new String[unitList.size()];
				
				for(int i=0;i<unitList.size(); i++) {
					labelList[i]=unitList.get(i).getName();
				}
				
				System.out.println("Original Designation Order: \n" + Arrays.toString(labelList));
				Arrays.sort(labelList);
				System.out.println("Alphabetical Sorted Order: \n" + Arrays.toString(labelList));
				
				yield true;
			}


			case "0" -> {
				System.out.println("Returning to main operations...");
				yield false;
			}
			default -> {
				System.out.println("Invalid Selection!!");
				yield true;
			}
			};
		}
	}
	private static void handleSecurityFlow(Scanner scanner) {
		final String train_Exp="TRN-\\d{4}";
		final String cargo_Exp="PET-[A-Z]{2}";
		Pattern pEngine = Pattern.compile(train_Exp);
		Pattern pFreight = Pattern.compile(cargo_Exp);
		boolean menuActive = true;
		while(menuActive) {
			System.out.println("--- Validation Security Menu ---");
			System.out.println("1. Check Engine ID");
			System.out.println("2. Check Freight ID");
			System.out.println("0. Back");
			System.out.print("Command: ");
			String opt = scanner.nextLine();

			if (opt.equals("1")) {
				System.out.print("Enter Engine ID (TRN-1234): ");
				String idInput = scanner.nextLine();
				System.out.println("ID Verified: " + pEngine.matcher(idInput).matches());
			} else if (opt.equals("2")) {
				System.out.print("Enter Freight ID (PET-AB): ");
				String idInput = scanner.nextLine();
				System.out.println("ID Verified: " + pFreight.matcher(idInput).matches());
			} else if (opt.equals("0")) {
				menuActive = false;
			} else {
				System.out.println("Error: Command not recognized.");
			}
		}}
	
	private static void handleCargoWorkflow(Scanner scanner) {
		List<GoodsBogie> cargoList = new ArrayList<>();
		boolean active = true;
		
		while(active) {
			System.out.println("\n--- Freight Operations Menu ---");
			System.out.println("1. Load Goods Car");
			System.out.println("2. Remove Goods Car");
			System.out.println("3. Inventory Verification");
			System.out.println("4. Integrity Benchmark");
			System.out.println("5. View Manifest");
			System.out.println("0. Return");
			System.out.print("Select: ");
			String input = scanner.nextLine();

			switch(input) {
			case "1" -> {
				System.out.print("Container Type: ");
				String kind = scanner.nextLine();
				System.out.print("Material: ");
				String item = scanner.nextLine();
				cargoList.add(new GoodsBogie(kind, item));
				System.out.println("Loaded successfully.");
			}
			case "2" -> {
				System.out.print("Container type to detach: ");
				String searchType = scanner.nextLine();
				cargoList.removeIf(gb -> gb.getType().equalsIgnoreCase(searchType));
				System.out.println("Inventory updated.");
			}
			case "3" -> {
				System.out.print("Check inventory for type: ");
				String searchType = scanner.nextLine();
				boolean exists = false;
				for(GoodsBogie gb : cargoList) {
					if(gb.getType().equalsIgnoreCase(searchType)) {
						exists = true; 
						break;
					}}
				System.out.println("Found: " +exists);}
			case "4" -> {
				long streamStart =System.nanoTime();
				boolean isClear = cargoList.stream().noneMatch(b -> b.getType().equalsIgnoreCase("Cylindrical") && b.getCargo().equalsIgnoreCase("Coal"));
				long streamEnd =System.nanoTime();
				
				long loopStart =System.nanoTime();
				boolean loopSafe =true;
				for(GoodsBogie gb : cargoList) {
					if(gb.getType().equalsIgnoreCase("Cylindrical") && gb.getCargo().equalsIgnoreCase("Coal")) {
						loopSafe = false;
						break;
					}
				}
				long loopEnd = System.nanoTime();
				
				System.out.println("Iterative Time: " + (loopEnd - loopStart));
				System.out.println("Functional Time: " + (streamEnd - streamStart));
				System.out.println("Safe to Proceed: " + isClear);
			}
			case "5" -> {
				System.out.println("Cargo Manifest:\n");
				for(GoodsBogie gb : cargoList) {
					System.out.println(gb.getType() + " : " + gb.getCargo());
				}
			}
			case "0" -> active = false;
			default -> System.out.println("Action Denied.");
			}
		}
	}
}


/**
 * Model for Freight Bogies
 */
class GoodsBogie {
	private String type;
	private String cargo;
	
	public GoodsBogie(String type, String cargo) {
		this.type = type;
		this.cargo = cargo;
	}
	
	public String getType() { return type; }
	public String getCargo() { return cargo; }
	public void setType(String type) { this.type = type; }
	public void setCargo(String cargo) { this.cargo = cargo; }
	
	@Override
	public String toString() {
		return "GoodsBogie{type='" + type + "', cargo='" + cargo + "'}";
	}
}

/**
 * Custom Exception for Capacity Validation
 */
@SuppressWarnings("serial")
class CapacityValidationException extends Exception {
	public CapacityValidationException(String detail) {
		super(detail);
	}
}

/**
 * Custom Runtime Exception
 */
@SuppressWarnings("serial")
class FreightIncompatibilityException extends RuntimeException {
	public FreightIncompatibilityException(String msg) {
		super(msg);
	}
}


