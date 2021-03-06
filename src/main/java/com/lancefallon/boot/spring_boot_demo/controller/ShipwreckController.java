package com.lancefallon.boot.spring_boot_demo.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lancefallon.boot.spring_boot_demo.model.Shipwreck;
import com.lancefallon.boot.spring_boot_demo.repository.ShipwreckRepository;

@RestController
@RequestMapping("api/v1/")
public class ShipwreckController {
	
	@Autowired
	private ShipwreckRepository shipwreckRepository;

	@RequestMapping(value="shipwrecks", method=RequestMethod.GET)
	public List<Shipwreck> list(){
		return shipwreckRepository.findAll();
	}
	
	@RequestMapping(value="shipwrecks", method=RequestMethod.POST)
	public Shipwreck create(@RequestBody Shipwreck shipwreck) throws Exception{
		try{
			return shipwreckRepository.save(shipwreck);
		} catch(Exception e){
			System.out.println(e.getMessage());
			throw new Exception(e);
		}
		
	}
	
	@RequestMapping(value="shipwrecks/{id}", method=RequestMethod.GET)
	public Shipwreck get(@PathVariable long id){
		return shipwreckRepository.findOne(id);
	}
	
	@RequestMapping(value="shipwrecks/{id}", method=RequestMethod.PUT)
	public Shipwreck update(@PathVariable long id, @RequestBody Shipwreck shipwreck){
		Shipwreck existingShipwreck = shipwreckRepository.findOne(id);
		BeanUtils.copyProperties(shipwreck, existingShipwreck);
		return shipwreckRepository.saveAndFlush(existingShipwreck);
	}
	
	@RequestMapping(value="shipwrecks/{id}", method=RequestMethod.DELETE)
	public Shipwreck delete(@PathVariable long id){
		Shipwreck shipwreck = shipwreckRepository.findOne(id);
		shipwreckRepository.delete(id);
		return shipwreck;
	}
	
}
