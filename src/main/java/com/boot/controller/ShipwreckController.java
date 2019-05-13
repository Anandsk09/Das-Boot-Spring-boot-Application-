package com.boot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.Repository.ShipwreckRepository;
import com.boot.model.Shipwreck;

@RestController
@RequestMapping(value="api/v1/")
public class ShipwreckController {
	@Autowired
	ShipwreckRepository shipwreckRepository;
	
	@RequestMapping(value="shipwrecks" ,method=RequestMethod.GET)
	public List<Shipwreck> getShipWreckList()
	{
		//return ShipwreckStub.list();
		return shipwreckRepository.findAll();
		
	}
	
	@RequestMapping(value="shipwrecks/{id}" ,method=RequestMethod.GET)
	public Shipwreck getShipWreck(@PathVariable Long id)
	{
		//return ShipwreckStub.list();
		return shipwreckRepository.findById(id).get();
		//return  (Shipwreck) optional.get();
		
	}
	
	
	@RequestMapping(value="shipwrecks" ,method=RequestMethod.POST)
	public Shipwreck addShipWreck(@RequestBody Shipwreck shipwreck)
	{
		//return ShipwreckStub.create(shipwreck);
		return shipwreckRepository.saveAndFlush(shipwreck);
		
	}
	
	@RequestMapping(value="shipwrecks/{id}" ,method=RequestMethod.PUT)
	public Shipwreck updateShipWreck(@RequestBody Shipwreck shipwreck,@PathVariable long id)
	{
		return ShipwreckStub.update(id, shipwreck);
		
	}
	
	@RequestMapping(value="shipwrecks/{id}" ,method=RequestMethod.DELETE)
	public Shipwreck deleteShipWreck(@PathVariable long id)
	{
		//return ShipwreckStub.delete(id);
		 shipwreckRepository.deleteById(id);
		
		return null;
		
	}

}
