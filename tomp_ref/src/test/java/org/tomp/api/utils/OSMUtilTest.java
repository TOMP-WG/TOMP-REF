package org.tomp.api.utils;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.junit.Test;
import org.xml.sax.SAXException;

import io.swagger.client.ApiException;
import io.swagger.model.Place;

public class OSMUtilTest {

	@Test
	public void getParkings()
			throws ParserConfigurationException, IOException, SAXException, TransformerException, ApiException {
		List<Place> overpassObjects = OSMUtil.getOverpassObjects("\"amenity\"=\"parking\"",
				new double[] { 52.252357508790574, 6.43074631690979, 52.2582420731094, 6.442065238952637 });
		assertNotNull(overpassObjects);
	}
}
