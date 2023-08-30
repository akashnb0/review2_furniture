package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Orders;
import com.example.demo.repository.OrdersRepo;

@Service
public class OrdersService {
    @Autowired
    OrdersRepo ro;
    
    public Orders saveinfo(Orders b)
    {
    	return ro.save(b);
    }
    public List<Orders> savedetails(List<Orders> s)
    {
   	 return (List<Orders>)ro.saveAll(s);
    }
    
    
    public List<Orders> showinfo()
    {
    	return ro.findAll();
    }
    public Optional<Orders> showbyid(int id)
    {
    	return ro.findById(id);
    }
    
    
    public Orders changeinfo(Orders ss)
    {
    	return ro.saveAndFlush(ss);
    }
    public String updateinfobyid(int id, Orders s)
    {
    	ro.saveAndFlush(s);
    	if(ro.existsById(id))
    	{
    		return "updated";
    	}
 		return "enter valid id";
    }
    
    
    public void deleteinfo(Orders ss)
    {
    	 ro.delete(ss);
    }
    public void deleteid(int id)
    {
    	ro.deleteById(id);
    }
}