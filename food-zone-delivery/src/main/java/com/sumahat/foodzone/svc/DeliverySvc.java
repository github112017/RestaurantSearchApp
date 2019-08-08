package com.sumahat.foodzone.svc;

import com.sumahat.foodzone.so.PackerSO;


public interface DeliverySvc {
	
	public void createPacker(PackerSO packer);
	
    public boolean startDelivery();

}
