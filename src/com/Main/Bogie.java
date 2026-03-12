package com.Main;

public class Bogie {
	
		private String name;
		private int capacity;
		
		public Bogie(String name, int capacity) {
			this.name = name;
			this.capacity = capacity;
		}
		
		public String getName() {
			return this.name;
		}
		
		public int getCapacity() {
			return this.capacity;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}
		
		@Override 
		public String toString(){
			return String.format("(%s, %s)", name, capacity);
		}
	}
