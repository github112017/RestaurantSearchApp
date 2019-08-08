package com.sumahat.foodzone.util;

import com.sumahat.foodzone.model.Item;

public abstract class ItemDecorator {

	Item item;
	
	public ItemDecorator(Item itm)
	{
		this.item = itm;
	}
	
}
