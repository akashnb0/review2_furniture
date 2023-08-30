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

import com.example.demo.model.Products;
import com.example.demo.service.ProductsService;

@RestController
public class ProductsController {
    @Autowired
    ProductsService ps;
    
    @PostMapping("postp")
	public Products add(@RequestBody Products ss)
	{
		return ps.saveinfo(ss);
	}
    @PostMapping("postpl")
	public List<Products> addn(@RequestBody List<Products> ss)
	{
		return ps.savedetails(ss);
	}
    
    

    @GetMapping("getp")
	public List<Products> show()
	{
		return ps.showinfo();
	}
    @GetMapping("getbyidp/{id}")
    public Optional<Products> showid(@PathVariable int id)
    {
   	 return ps.showbyid(id);
    }
    
    @PutMapping("putp")
   	public Products modify(@RequestBody Products ss)
   	{
   		return ps.changeinfo(ss);
   	}
      @PutMapping("putbyidp/{id}")
       public String modifybyid(@PathVariable int id,@RequestBody Products b)
       {
       	return ps.updateinfobyid(id, b);
       }
      
      
      @DeleteMapping("deletep")
  	public String deleteInfo(@RequestBody Products ss)
  	{
  	      ps.deleteinfo(ss);
  	      return "Deleted successfully";
  	}
      @DeleteMapping("deleteidp/{id}")
  	public void deletemyid(@PathVariable int id)
  	{
  		ps.deleteid(id);
  	}
}