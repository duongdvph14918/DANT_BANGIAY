package com.fourmen.service;

import java.util.List;

import com.fourmen.entity.Feedback;

public interface FeedbackService {

	List<Feedback> findByProductID(Integer id);


	List<Feedback> findAll();


	Feedback create(Feedback feedback);


	Feedback addFeedback(Feedback feedback, Integer id);


	void delete(Integer id);

}
