package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Products;
import com.example.demo.repository.ProductsRepo;

@Service
public class ProductsService {
     @Autowired
     ProductsRepo re;
     
     public Products saveinfo(Products b)
     {
     	return re.save(b);
     }
     public List<Products> savedetails(List<Products> s)
     {
    	 return (List<Products>)re.saveAll(s);
     }
     
     public List<Products> showinfo()
     {
     	return re.findAll();
     }
     public Optional<Products> showbyid(int id)
     {
     	return re.findById(id);
     }
     
     public Products changeinfo(Products ss)
     {
     	return re.saveAndFlush(ss);
     }
     public String updateinfobyid(int id, Products s)
     {
     	re.saveAndFlush(s);
     	if(re.existsById(id))
     	{
     		return "updated";
     	}
 		return "enter valid id";
     }
     
     public void deleteinfo(Products ss)
     {
     	re.delete(ss);
     }
     public void deleteid(int id)
     {
     	re.deleteById(id);
     }
}