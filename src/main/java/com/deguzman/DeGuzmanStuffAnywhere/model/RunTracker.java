package com.deguzman.DeGuzmanStuffAnywhere.model;

import java.io.Serializable;

public class RunTracker implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4812037100686878546L;
	public long run_id;
	public String runDate;
	public double runDistance;
	public String runTime;
	public long user_id;
	public long getRun_id() {
		return run_id;
	}
	public void setRun_id(long run_id) {
		this.run_id = run_id;
	}
	public String getRunDate() {
		return runDate;
	}
	public void setRunDate(String runDate) {
		this.runDate = runDate;
	}
	public double getRunDistance() {
		return runDistance;
	}
	public void setRunDistance(double runDistance) {
		this.runDistance = runDistance;
	}
	public String getRunTime() {
		return runTime;
	}
	public void setRunTime(String runTime) {
		this.runTime = runTime;
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
		result = prime * result + ((runDate == null) ? 0 : runDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(runDistance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((runTime == null) ? 0 : runTime.hashCode());
		result = prime * result + (int) (run_id ^ (run_id >>> 32));
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
		RunTracker other = (RunTracker) obj;
		if (runDate == null) {
			if (other.runDate != null)
				return false;
		} else if (!runDate.equals(other.runDate))
			return false;
		if (Double.doubleToLongBits(runDistance) != Double.doubleToLongBits(other.runDistance))
			return false;
		if (runTime == null) {
			if (other.runTime != null)
				return false;
		} else if (!runTime.equals(other.runTime))
			return false;
		if (run_id != other.run_id)
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RunTracker [run_id=" + run_id + ", runDate=" + runDate + ", runDistance=" + runDistance + ", runTime="
				+ runTime + ", user_id=" + user_id + "]";
	}
	public RunTracker(long run_id, String runDate, double runDistance, String runTime, long user_id) {
		super();
		this.run_id = run_id;
		this.runDate = runDate;
		this.runDistance = runDistance;
		this.runTime = runTime;
		this.user_id = user_id;
	}
	public RunTracker() {
		super();
		// TODO Auto-generated constructor stub
	}

}
