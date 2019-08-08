package com.sumahat.foodzone.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="packer_assigned_order")
public class PackerAssignedOrder {


    @Embeddable
	public static class Id implements Serializable {
		
    	@Column(name="packer_id")
    	private Long packerId;

		@Column(name = "order_id")
		private Long orderId;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((orderId == null) ? 0 : orderId.hashCode());
			result = prime * result
					+ ((packerId == null) ? 0 : packerId.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Id other = (Id) obj;
			if (orderId == null) {
				if (other.orderId != null)
					return false;
			} else if (!orderId.equals(other.orderId))
				return false;
			if (packerId == null) {
				if (other.packerId != null)
					return false;
			} else if (!packerId.equals(other.packerId))
				return false;
			return true;
		}

		


	}
    @EmbeddedId 
    private Id id;
    
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "packer_id",insertable=false, updatable=false)
	Packer packer;
	
	@Column(name="order_assigned_date")
	private Timestamp assginedDate;
	
	@Column(name="order_delivered_date")
	private Timestamp deliveredDate;

	
	public Timestamp getAssginedDate() {
		return assginedDate;
	}

	public void setAssginedDate(Timestamp assginedDate) {
		this.assginedDate = assginedDate;
	}

	public Timestamp getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(Timestamp deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}
	
	
	
}
