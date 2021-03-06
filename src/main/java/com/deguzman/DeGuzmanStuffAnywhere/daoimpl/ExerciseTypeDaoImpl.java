package com.deguzman.DeGuzmanStuffAnywhere.daoimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.deguzman.DeGuzmanStuffAnywhere.dao.ExerciseTypeDao;
import com.deguzman.DeGuzmanStuffAnywhere.model.ExerciseType;

@Repository
public class ExerciseTypeDaoImpl implements ExerciseTypeDao {

	String GET_ALL_EXERCISE_TYPES = "SELECT * FROM EXERCISE_TYPE";
	String GET_EXERCISE_TYPE_BY_INFORMATION = "SELECT * FROM EXERCISE_TYPE WHERE EXERCISE_TYPE_ID = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(ExerciseTypeDaoImpl.class);

	@Override
	public List<ExerciseType> findAllExerciseTypeInformation() {
		List<ExerciseType> list = jdbcTemplate.query(GET_ALL_EXERCISE_TYPES,
				BeanPropertyRowMapper.newInstance(ExerciseType.class));

		LOGGER.info("Retrieving All Exercise Types...");

		return list;
	}

	@Override
	public ResponseEntity<ExerciseType> findExerciseTypeInformationById(@PathVariable int exercise_type_id) {
		ExerciseType type = jdbcTemplate.queryForObject(GET_EXERCISE_TYPE_BY_INFORMATION,
				BeanPropertyRowMapper.newInstance(ExerciseType.class), exercise_type_id);

		LOGGER.info("Retrieving Exercise Type by exercise_type_id: " + exercise_type_id);

		return ResponseEntity.ok().body(type);
	}

}
