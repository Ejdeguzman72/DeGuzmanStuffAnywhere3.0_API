package com.deguzman.DeGuzmanStuffAnywhere.dto;

public class GeneralTrxInfoDTO {

	public long transaction_id;
	public double amount;
	public String paymentDate;
	public String entity;
	public String transaction_type_descr;
	public String name;
	public long getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(long transaction_id) {
		this.transaction_id = transaction_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public String getTransaction_type_descr() {
		return transaction_type_descr;
	}
	public void setTransaction_type_descr(String transaction_type_descr) {
		this.transaction_type_descr = transaction_type_descr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((entity == null) ? 0 : entity.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((paymentDate == null) ? 0 : paymentDate.hashCode());
		result = prime * result + (int) (transaction_id ^ (transaction_id >>> 32));
		result = prime * result + ((transaction_type_descr == null) ? 0 : transaction_type_descr.hashCode());
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
		GeneralTrxInfoDTO other = (GeneralTrxInfoDTO) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (entity == null) {
			if (other.entity != null)
				return false;
		} else if (!entity.equals(other.entity))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (paymentDate == null) {
			if (other.paymentDate != null)
				return false;
		} else if (!paymentDate.equals(other.paymentDate))
			return false;
		if (transaction_id != other.transaction_id)
			return false;
		if (transaction_type_descr == null) {
			if (other.transaction_type_descr != null)
				return false;
		} else if (!transaction_type_descr.equals(other.transaction_type_descr))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GeneralTrxInfoDTO [transaction_id=" + transaction_id + ", amount=" + amount + ", paymentDate="
				+ paymentDate + ", entity=" + entity + ", transaction_type_descr=" + transaction_type_descr + ", name="
				+ name + "]";
	}
	public GeneralTrxInfoDTO(long transaction_id, double amount, String paymentDate, String entity,
			String transaction_type_descr, String name) {
		super();
		this.transaction_id = transaction_id;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.entity = entity;
		this.transaction_type_descr = transaction_type_descr;
		this.name = name;
	}
	public GeneralTrxInfoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
