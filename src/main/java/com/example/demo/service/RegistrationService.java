package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Registration;
import com.example.demo.repository.RegistrationRepo;

@Service
public class RegistrationService {
     @Autowired
     RegistrationRepo r;
     
     public Registration saveinfo(Registration b)
     {
     	return r.save(b);
     }
     public List<Registration> savedetails(List<Registration> s)
     {
    	 return (List<Registration>)r.saveAll(s);
     }
     
     
     public List<Registration> showinfo()
     {
     	return r.findAll();
     }
     public Optional<Registration> showbyid(int id)
     {
     	return r.findById(id);
     }
     
     
     public Registration changeinfo(Registration ss)
     {
     	return r.saveAndFlush(ss);
     }
     public String updateinfobyid(int id, Registration s)
     {
     	r.saveAndFlush(s);
     	if(r.existsById(id))
     	{
     		return "updated";
     	}
 		return "enter valid id";
     }
     
     
     public void deleteinfo(Registration ss)
     {
     	r.delete(ss);
     }
     public void deleteid(int id)
     {
     	r.deleteById(id);
     }
}