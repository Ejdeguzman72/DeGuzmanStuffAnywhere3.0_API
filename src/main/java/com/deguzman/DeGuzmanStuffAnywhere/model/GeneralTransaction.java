package com.deguzman.DeGuzmanStuffAnywhere.model;

import java.io.Serializable;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public class GeneralTransaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3866557359119459426L;
	private long transaction_id;
	private double amount;
	private String payment_date;
	private String entity;
	public long transaction_type_id;
	public long user_id;

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

	public String getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public long getTransaction_type_id() {
		return transaction_type_id;
	}

	public void setTransaction_type_id(long transaction_type_id) {
		this.transaction_type_id = transaction_type_id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((entity == null) ? 0 : entity.hashCode());
		result = prime * result + ((payment_date == null) ? 0 : payment_date.hashCode());
		result = prime * result + (int) (transaction_id ^ (transaction_id >>> 32));
		result = prime * result + (int) (transaction_type_id ^ (transaction_type_id >>> 32));
		result = prime * result + (int) (user_id ^ (user_id >>> 32));
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
		GeneralTransaction other = (GeneralTransaction) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (entity == null) {
			if (other.entity != null)
				return false;
		} else if (!entity.equals(other.entity))
			return false;
		if (payment_date == null) {
			if (other.payment_date != null)
				return false;
		} else if (!payment_date.equals(other.payment_date))
			return false;
		if (transaction_id != other.transaction_id)
			return false;
		if (transaction_type_id != other.transaction_type_id)
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GeneralTransaction [transaction_id=" + transaction_id + ", amount=" + amount + ", payment_date="
				+ payment_date + ", entity=" + entity + ", transaction_type_id=" + transaction_type_id + ", user_id="
				+ user_id + "]";
	}

	public GeneralTransaction(long transaction_id, double amount, String payment_date, String entity,
			long transaction_type_id, long user_id) {
		super();
		this.transaction_id = transaction_id;
		this.amount = amount;
		this.payment_date = payment_date;
		this.entity = entity;
		this.transaction_type_id = transaction_type_id;
		this.user_id = user_id;
	}

	public GeneralTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

}