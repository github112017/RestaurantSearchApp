package com.sumahat.foodzone.model;

import java.util.Comparator;

public class PackerComparator implements Comparator<Packer> {

	@Override
	public int compare(Packer p1, Packer p2) {
		
		Integer p1Cap=((int)p1.getCapacity()- (int)p1.getAssignedOrders().size());
		
		Integer p2Cap=((int)p2.getCapacity()- (int)p2.getAssignedOrders().size());
		
		int i= p1Cap.compareTo(p2Cap);

		if(i!=0)
		return i;
		
		else
		return p1.getRating().compareTo(p2.getRating());
	}
	
	

}
