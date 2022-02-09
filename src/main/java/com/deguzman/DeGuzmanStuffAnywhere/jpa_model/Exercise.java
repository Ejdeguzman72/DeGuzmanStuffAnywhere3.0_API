package com.deguzman.DeGuzmanStuffAnywhere.jpa_model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.deguzman.DeGuzmanStuffAnywhere.authentication_models.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "EXERCISE")
@CrossOrigin
@JsonIgnoreProperties(value = "hibernateLazyInitializer")
public class Exercise implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1101615341293557860L;
	public int exerciseid;
	public String exerciseName;
	public int sets;
	public int reps;
	public double weight;
	public String date;
	
	public ExerciseType exerciseType;
	
	public User user;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "exercise_id")
	public int getExerciseid() {
		return exerciseid;
	}

	public void setExerciseid(int exerciseid) {
		this.exerciseid = exerciseid;
	}

	@Column(name = "exercise_name")
	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	@Column(name = "sets")
	public int getSets() {
		return sets;
	}

	public void setSets(int sets) {
		this.sets = sets;
	}

	@Column(name = "reps")
	public int getReps() {
		return reps;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}

	@Column(name = "weight")
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "exercise_type_id")
	public ExerciseType getExerciseType() {
		return exerciseType;
	}

	public void setExerciseType(ExerciseType exerciseType) {
		this.exerciseType = exerciseType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((exerciseName == null) ? 0 : exerciseName.hashCode());
		result = prime * result + ((exerciseType == null) ? 0 : exerciseType.hashCode());
		result = prime * result + exerciseid;
		result = prime * result + reps;
		result = prime * result + sets;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Exercise other = (Exercise) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (exerciseName == null) {
			if (other.exerciseName != null)
				return false;
		} else if (!exerciseName.equals(other.exerciseName))
			return false;
		if (exerciseType == null) {
			if (other.exerciseType != null)
				return false;
		} else if (!exerciseType.equals(other.exerciseType))
			return false;
		if (exerciseid != other.exerciseid)
			return false;
		if (reps != other.reps)
			return false;
		if (sets != other.sets)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Exercise [exerciseid=" + exerciseid + ", exerciseName=" + exerciseName + ", sets=" + sets + ", reps="
				+ reps + ", weight=" + weight + ", date=" + date + ", exerciseType=" + exerciseType + ", user=" + user
				+ "]";
	}

	public Exercise(String exerciseName, int sets, int reps, double weight, String date,
			ExerciseType exerciseType, User user) {
		super();
//		this.exerciseid = exerciseid;
		this.exerciseName = exerciseName;
		this.sets = sets;
		this.reps = reps;
		this.weight = weight;
		this.date = date;
		this.exerciseType = exerciseType;
		this.user = user;
	}

	public Exercise() {
		super();
		// TODO Auto-generated constructor stub
	}

}