package org.tomp.api.utils;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

import io.swagger.model.Coordinates;

public class GeoUtilTest {

	@Test
	@Ignore
	public void testDistance() {
		Coordinates coordinates = GeoUtil.toCoordinates(52.257205, 6.538051);
		Coordinates coordinates2 = GeoUtil.toCoordinates(52.258256, 6.531517);
		assertTrue(GeoUtil.isNearby(coordinates, coordinates2, 500));
	}
}
