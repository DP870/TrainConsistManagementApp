package com.Train;
import java.util.*;
public class Train {
   private final List<String> bogies;

	    public Train() {
	        bogies = new ArrayList<>();
	    }

	    public List<String> getBogies() {
	        return bogies;
	    }

	    public int getBogieCount() {
	        return bogies.size();
	    }
	}
