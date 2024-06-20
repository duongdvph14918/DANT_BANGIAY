package com.fourmen.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.fourmen.dao.AccountDao;
import com.fourmen.dao.FeedbackDao;
import com.fourmen.dao.ProductDao;
import com.fourmen.entity.Accounts;
import com.fourmen.entity.Feedback;
import com.fourmen.entity.Product;
import com.fourmen.entity.UserAcounts;
import com.fourmen.service.FeedbackService;
@Service
public class FeedbackServiceImpl implements FeedbackService{
	@Autowired
	FeedbackDao feedbackDao;
	@Autowired
	ProductDao productDao;
	@Autowired
	AccountDao accountDao;
	@Autowired
	UserAcounts useAcc;
	

	@Override
	public List<Feedback> findByProductID(Integer id) {
		//String feedbackDate;
		// TODO Auto-generated method stub
		Sort sort = Sort.by(Direction.DESC, "feedbackDate");
		return feedbackDao.findByProductID(id,sort);
	}

	@Override
	public List<Feedback> findAll() {
		// TODO Auto-generated method stub
		Sort sort = Sort.by(Direction.DESC, "feedbackDate");
		return feedbackDao.findAll(sort);
	}

	@Override
	public Feedback create(Feedback feedback) {
		// TODO Auto-generated method stub
		//return feedbackDao.save(feedback);
		return feedbackDao.save(feedback);
	}


	@Override
	public Feedback addFeedback(Feedback feedback, Integer id) {
		// TODO Auto-generated method stub
		Accounts account1 = useAcc.User();	
		Long idAc = account1.getAccountId();
		Product product = productDao.findById(id).get();
		Accounts accounts = accountDao.findById(idAc).get();
		
		feedback.setFeedbackDate(new Date());
		feedback.setAccount(accounts);
		feedback.setProduct(product);
		return feedbackDao.save(feedback);
		//return null;
	}

	@Override
	public void delete(Integer id) {
		feedbackDao.deleteById(id);
		
	}

	
}
