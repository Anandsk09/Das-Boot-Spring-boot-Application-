package com.boot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.Repository.ShipwreckRepository;

public class ShipwreckControllerTest {
	@InjectMocks
	private ShipwreckController shipwreckController;
	@Mock
	private ShipwreckRepository shipwreckRepository;
	
	@Before
	
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testShipwreckget()
	{
		Shipwreck shipwreck=new Shipwreck();
		shipwreck.setId(1L);
		when(shipwreckRepository.findById(1L)).thenReturn(Optional.ofNullable(shipwreck));
		Shipwreck shipwreck2=shipwreckController.getShipWreck(1L);
		verify(shipwreckRepository).findById(1L);
		assertNotNull(shipwreck2.getId().longValue());
		assertEquals(1L,shipwreck2.getId().longValue());
		//fail("Hello");
	}
	
	
	@Test
	public void testShipwreckgetAll()
	{
		List<Shipwreck> ls=new ArrayList<Shipwreck>();
		ls=getList(ls);
		when(shipwreckRepository.findAll()).thenReturn(ls);
		assertNotNull(shipwreckController.getShipWreckList());
		assertEquals(ls,shipwreckController.getShipWreckList());
	
	}
	
	
	@Test
	public void testaddShipwreck()
	{
		List<Shipwreck> ls=new ArrayList<Shipwreck>();
		ls=getList(ls);
		when(shipwreckRepository.findAll()).thenReturn(ls);
		assertEquals(ls,shipwreckController.getShipWreckList());
	
	}
	
	public List<Shipwreck> getList(List<Shipwreck> ls)
	{
		Shipwreck shipwreck=new Shipwreck();
		shipwreck.setId(1L);
		shipwreck.setCondition("abc");
		shipwreck.setDescription("desc");
		shipwreck.setDepth(1);
		shipwreck.setLatitude(1D);
		shipwreck.setLongitude(1D);
		ls.add(shipwreck);
		return ls;
	}

}
