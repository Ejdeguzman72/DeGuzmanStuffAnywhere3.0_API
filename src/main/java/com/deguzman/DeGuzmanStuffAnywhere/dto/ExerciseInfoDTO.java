package com.deguzman.DeGuzmanStuffAnywhere.dto;

public class ExerciseInfoDTO {

	public int exercise_id;
	public String exerciseName;
	public int sets;
	public int reps;
	public double weight;
	public String date;
	public String exercise_type_name;
	public String username;
	
	public int getExercise_id() {
		return exercise_id;
	}
	public void setExercise_id(int exercise_id) {
		this.exercise_id = exercise_id;
	}
	public String getExerciseName() {
		return exerciseName;
	}
	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}
	public int getSets() {
		return sets;
	}
	public void setSets(int sets) {
		this.sets = sets;
	}
	public int getReps() {
		return reps;
	}
	public void setReps(int reps) {
		this.reps = reps;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getExercise_type_name() {
		return exercise_type_name;
	}
	public void setExercise_type_name(String exercise_type_name) {
		this.exercise_type_name = exercise_type_name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((exerciseName == null) ? 0 : exerciseName.hashCode());
		result = prime * result + exercise_id;
		result = prime * result + ((exercise_type_name == null) ? 0 : exercise_type_name.hashCode());
		result = prime * result + reps;
		result = prime * result + sets;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		ExerciseInfoDTO other = (ExerciseInfoDTO) obj;
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
		if (exercise_id != other.exercise_id)
			return false;
		if (exercise_type_name == null) {
			if (other.exercise_type_name != null)
				return false;
		} else if (!exercise_type_name.equals(other.exercise_type_name))
			return false;
		if (reps != other.reps)
			return false;
		if (sets != other.sets)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ExerciseInfoDTO [exercise_id=" + exercise_id + ", exerciseName=" + exerciseName + ", sets=" + sets
				+ ", reps=" + reps + ", weight=" + weight + ", date=" + date + ", exercise_type_name="
				+ exercise_type_name + ", username=" + username + "]";
	}
	public ExerciseInfoDTO(int exercise_id, String exerciseName, int sets, int reps, double weight, String date,
			String exercise_type_name, String username) {
		super();
		this.exercise_id = exercise_id;
		this.exerciseName = exerciseName;
		this.sets = sets;
		this.reps = reps;
		this.weight = weight;
		this.date = date;
		this.exercise_type_name = exercise_type_name;
		this.username = username;
	}
	public ExerciseInfoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
