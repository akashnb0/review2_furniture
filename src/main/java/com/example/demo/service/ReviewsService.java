package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Reviews;
import com.example.demo.repository.ReviewsRepo;

@Service
public class ReviewsService {
    @Autowired
    ReviewsRepo rw;
    
    public Reviews saveinfo(Reviews b)
    {
    	return rw.save(b);
    }
    public List<Reviews> savedetails(List<Reviews> s)
    {
   	 return (List<Reviews>)rw.saveAll(s);
    }
    
    
    public List<Reviews> showinfo()
    {
    	return rw.findAll();
    }
    public Optional<Reviews> showbyid(int id)
    {
    	return rw.findById(id);
    }
    
    
    public Reviews changeinfo(Reviews ss)
    {
    	return rw.saveAndFlush(ss);
    }
    public String updateinfobyid(int id, Reviews s)
    {
    	rw.saveAndFlush(s);
    	if(rw.existsById(id))
    	{
    		return "updated";
    	}
 		return "enter valid id";
    }
    
    
    public void deleteinfo(Reviews ss)
    {
    	 rw.delete(ss);
    }
    public void deleteid(int id)
    {
    	rw.deleteById(id);
    }
    
    //jpql
    public List<Reviews> getRev(int i)
    {
    	return rw.getReviewInfo(i);
    }
    
    //sorting and pagination
    public List<Reviews> page(int pgno,int pgsize,String s)
    {
 	   Page <Reviews> c = rw.findAll(PageRequest.of(pgno, pgsize, (Sort.by(Sort.Direction.ASC,s))));
 	   return c.getContent();
    }
}