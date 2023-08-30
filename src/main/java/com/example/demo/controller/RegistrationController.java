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

import com.example.demo.model.Registration;
import com.example.demo.service.RegistrationService;

@RestController
public class RegistrationController {
    @Autowired
    RegistrationService o;
    
    @PostMapping("post")
	public Registration add(@RequestBody Registration ss)
	{
		return o.saveinfo(ss);
	}
    @PostMapping("postl")
	public List<Registration> addn(@RequestBody List<Registration> ss)
	{
		return o.savedetails(ss);
	}
    
    
    @GetMapping("get")
	public List<Registration> show()
	{
		return o.showinfo();
	}
    @GetMapping("getbyid/{id}")
    public Optional<Registration> showid(@PathVariable int id)
    {
   	 return o.showbyid(id);
    }
    
    
    @PutMapping("put")
	public Registration modify(@RequestBody Registration ss)
	{
		return o.changeinfo(ss);
	}
    @PutMapping("putbyid/{id}")
    public String modifybyid(@PathVariable int id,@RequestBody Registration b)
    {
    	return o.updateinfobyid(id, b);
    }
    
    
    @DeleteMapping("delete")
	public String deleteInfo(@RequestBody Registration ss)
	{
	      o.deleteinfo(ss);
	      return "Deleted successfully";
	}
    @DeleteMapping("deleteid/{id}")
	public void deletemyid(@PathVariable int id)
	{
		o.deleteid(id);
	}
}