package com.sumahat.foodzone.svc;

import java.util.PriorityQueue;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.sumahat.foodzone.model.Packer;
import com.sumahat.foodzone.model.PackerComparator;
import com.sumahat.foodzone.repository.PackerRepository;
import com.sumahat.foodzone.so.OrderSO;
import com.sumahat.foodzone.so.PackerSO;

@Service
public class DeliverySvcImpl implements DeliverySvc {

	private static Logger log = LoggerFactory.getLogger(DeliverySvcImpl.class);
	
	@Autowired
	PackerRepository packerRepo;
	
    @Value(value = "${kafka.bootstrap.servers}")
    private String bootstrapAddress;
    
    @KafkaListener(topics = "thetechcheck", groupId = "thetechcheck")
    public void listen(@Payload OrderSO data,
            @Headers MessageHeaders headers) {
    	
    	
    	log.info("received data='{}'", data.getUserId());

        headers.keySet().forEach(key -> {
            log.info("{}: {}", key, headers.get(key));
        });
    }

	@Override
	public void createPacker(PackerSO packer) {
		
		Packer packr = new Packer();
		packr.setName(packer.getName());
		packr.setEmailId(packer.getEmailId());
		packr.setMobile(packer.getMobile());
		packr.setIsActive(packer.isActive()?"Y":"N");
		packr.setCapacity(new Random().nextInt(5));
		packr.setRating(new Random().nextInt(5));
		packerRepo.save(packr);
	}

	@Override
	public boolean startDelivery() {
		PriorityQueue<Packer> queue = new PriorityQueue<Packer>(new PackerComparator());
		return false;
	}
    
    
    
    
    
    
    
    
  
}
