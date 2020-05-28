package org.tomp.api.model;

import java.util.ArrayList;
import java.util.List;

public class Trip {
	private List<Segment> segments = new ArrayList<>();

	public List<Segment> getSegments() {
		return segments;
	}

	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}
}
