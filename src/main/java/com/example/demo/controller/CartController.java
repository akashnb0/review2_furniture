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

import com.example.demo.model.Cart;
import com.example.demo.service.CartService;


@RestController
public class CartController {
    @Autowired
    CartService cs;
    
    //POST
    @PostMapping("postc")
	public Cart add(@RequestBody Cart ss)
	{
		return cs.saveinfo(ss);
	}
    @PostMapping("postcl")
	public List<Cart> addn(@RequestBody List<Cart> ss)
	{
		return cs.savedetails(ss);
	}
    
    //GET
    @GetMapping("getc")
	public List<Cart> show()
	{
		return cs.showinfo();
	}
    @GetMapping("getbyidc/{id}")
    public Optional<Cart> showid(@PathVariable int id)
    {
   	 return cs.showbyid(id);
    }
    //PUT
    @PutMapping("putc")
   	public Cart modify(@RequestBody Cart ss)
   	{
   		return cs.changeinfo(ss);
   	}
      @PutMapping("putbyidc/{id}")
       public String modifybyid(@PathVariable int id,@RequestBody Cart b)
       {
       	return cs.updateinfobyid(id, b);
       }
      
     //DELETE
      @DeleteMapping("deletec")
  	public String deleteInfo(@RequestBody Cart ss)
  	{
  	      cs.deleteinfo(ss);
  	      return "Deleted successfully";
  	}
      @DeleteMapping("deleteidc/{id}")
  	public void deletemyid(@PathVariable int id)
  	{
  		cs.deleteid(id);
  	}
      
    //SORTING AND PAGINATION
      @GetMapping("paging/{pgno}/{pgsi}/{s}")
      public List<Cart> showpageinfo(@PathVariable int pgno,@PathVariable int pgsi,@PathVariable String s)
      {
    	  return cs.getbypage(pgno, pgsi, s);
      }
}