package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Reviews;
import com.example.demo.service.ReviewsService;

@RestController
public class ReviewsController {
   @Autowired
   ReviewsService rss;
   
   @PostMapping("postr")
	public Reviews add(@RequestBody Reviews  ss)
	{
		return rss.saveinfo(ss);
	}
  @PostMapping("postrl")
	public List<Reviews> addn(@RequestBody List<Reviews> ss)
	{
		return rss.savedetails(ss);
	}
  
  

  @GetMapping("getr")
	public List<Reviews> show()
	{
		return rss.showinfo();
	}
  @GetMapping("getbyidr/{id}")
  public Optional<Reviews> showid(@PathVariable int id)
  {
 	 return rss.showbyid(id);
  }
  
  @PutMapping("putr")
 	public Reviews  modify(@RequestBody Reviews ss)
 	{
 		return rss.changeinfo(ss);
 	}
    @PutMapping("putbyidr/{id}")
     public String modifybyid(@PathVariable int id,@RequestBody Reviews b)
     {
     	return rss.updateinfobyid(id, b);
     }
    
    
    @DeleteMapping("deleter")
	public String deleteInfo(@RequestBody Reviews ss)
	{
	      rss.deleteinfo(ss);
	      return "Deleted successfully";
	}
    @DeleteMapping("deleteidr/{id}")
	public void deletemyid(@PathVariable int id)
	{
		rss.deleteid(id);
	}
    
    //jpql
    @GetMapping("showquery/{reviewId}")
    public List<Reviews> showdetails(@PathVariable int reviewId)
    {
    	return rss.getRev(reviewId);
    }
    
  //sorting and paging
    @GetMapping("page/{pgno}/{pgsi}/{s}")
    public List<Reviews> showpage(@PathVariable int pgno,@PathVariable int pgsi,@PathVariable String s)
    {
  	  return rss.page(pgno, pgsi, s);
    }
}