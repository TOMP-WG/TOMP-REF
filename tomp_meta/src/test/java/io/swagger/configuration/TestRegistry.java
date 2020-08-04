package io.swagger.configuration;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import io.swagger.model.Coordinates;

public class TestRegistry {

	@Test
	public void testRegisterArea() {
		Registry registry = new Registry();
		registry.registerArea("1", "[[[10.4920501709,45.8179931641],[10.4920501709,47.808380127],[5.9559111595,47.808380127],[5.9559111595,45.8179931641],[10.4920501709,45.8179931641]]]");
		Coordinates location = new Coordinates();
		location.setLng(BigDecimal.valueOf(7.4920501709));
		location.setLat(BigDecimal.valueOf(46.8179931650));		
		boolean inArea = registry.isInArea("1", location);
		assertTrue(inArea);
	}
	
	@Test
	public void testRegisterAreaOldVersion() {
		Registry registry = new Registry();
		registry.registerArea("1", "{points=[{lng=10.4920501709, lat=45.8179931641}, {lng=10.4920501709, lat=47.808380127}, {lng=5.9559111595, lat=47.808380127}, {lng=5.9559111595, lat=45.8179931641}, {lng=10.4920501709, lat=45.8179931641}]}");
		Coordinates location = new Coordinates();
		location.setLng(BigDecimal.valueOf(7.4920501709));
		location.setLat(BigDecimal.valueOf(46.8179931650));		
		boolean inArea = registry.isInArea("1", location);
		assertTrue(inArea);
	}
}
