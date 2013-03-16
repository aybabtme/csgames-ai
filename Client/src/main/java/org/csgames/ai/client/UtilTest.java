package org.csgames.ai.client;

import static org.junit.Assert.*;

import java.util.List;

import org.csgames.ai.client.Util.Point2D;
import org.junit.Before;
import org.junit.Test;

public class UtilTest {

	private String[][] map = {
			        
			/* 0 */ {"H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H"},
			/* 1 */ {"H", "1"," "," "," ", "W", "W", "W", "W"," ", "W", "W"," ", "W", "W"," ", "W", "W", "W", "W"," "," "," ", "3", "H"}, 
			/* 2 */ {"H"," ", "H"," ", "H", "W", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H", "W", "H"," ", "H"," ", "H"}, 
			/* 3 */ {"H"," "," ", "W", "W"," "," ", "W", "W"," ", "W"," "," "," ", "W"," ", "W", "W"," "," ", "W", "W"," "," ", "H"}, 
			/* 4 */ {"H"," ", "H", "W", "H", "W", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H", "W", "H", "W", "H"," ", "H"}, 
			/* 5 */ {"H"," "," "," ", "W"," ", "W"," ", "W"," ", "W", "W"," ", "W", "W"," ", "W"," ", "W"," ", "W"," "," "," ", "H"}, 
			/* 6 */ {"H"," ", "H"," ", "H", "W", "H", "W", "H"," ", "H", "W", "H", "W", "H"," ", "H", "W", "H", "W", "H"," ", "H"," ", "H"},
			/* 7 */ {"H"," ", "W"," "," "," ", "W", "W"," "," "," ", "W"," ", "W"," "," "," ", "W", "W"," "," "," ", "W"," ", "H"},
			/* 8 */ {"H"," ", "H"," ", "H"," ", "H", "W", "H"," ", "H"," ", "H"," ", "H"," ", "H", "W", "H"," ", "H"," ", "H"," ", "H"},
			/* 9 */ {"H"," "," "," "," ", "W"," "," ", "W", "W"," ", "W"," ", "W"," ", "W", "W"," "," ", "W"," "," "," "," ", "H"},
			/* 10*/ {"H", "W", "H", "W", "H"," ", "H", "W", "H"," ", "H"," ", "H"," ", "H"," ", "H", "W", "H"," ", "H", "W", "H", "W", "H"},
			/* 11*/ {"H"," "," ", "W", "W"," ", "W", "W", "W"," ", "W"," "," "," ", "W"," ", "W", "W", "W"," ", "W", "W"," "," ", "H"},
			/* 12*/ {"H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"},
			/* 13*/ {"H"," ", "W"," "," ", "W"," "," "," ", "W"," ", "W"," ", "W"," ", "W"," "," "," ", "W"," "," ", "W"," ", "H"},
			/* 14*/ {"H"," ", "H"," ", "H"," ", "H", "W", "H"," ", "H", "W", "H", "W", "H"," ", "H", "W", "H"," ", "H"," ", "H"," ", "H"},
			/* 15*/ {"H", "W"," ", "W"," ", "W"," "," "," ", "W", "W"," "," "," ", "W", "W"," "," "," ", "W"," ", "W"," ", "W", "H"},
			/* 16*/ {"H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"},
			/* 17*/ {"H", "W"," ", "W"," ", "W"," "," "," ", "W", "W"," "," "," ", "W", "W"," "," "," ", "W"," ", "W"," ", "W", "H"},
			/* 18*/ {"H"," ", "H"," ", "H"," ", "H", "W", "H"," ", "H", "W", "H", "W", "H"," ", "H", "W", "H"," ", "H"," ", "H"," ", "H"},
			/* 19*/ {"H"," ", "W"," "," ", "W"," "," "," ", "W"," ", "W"," ", "W"," ", "W"," "," "," ", "W"," "," ", "W"," ", "H"},
			/* 20*/ {"H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"},
			/* 21*/ {"H"," "," ", "W", "W"," ", "W", "W", "W"," ", "W"," "," "," ", "W"," ", "W", "W", "W"," ", "W", "W"," "," ", "H"},
			/* 22*/ {"H", "W", "H", "W", "H"," ", "H", "W", "H"," ", "H"," ", "H"," ", "H"," ", "H", "W", "H"," ", "H", "W", "H", "W", "H"},
			/* 23*/ {"H"," "," "," "," ", "W"," "," ", "W", "W"," ", "W"," ", "W"," ", "W", "W"," "," ", "W"," "," "," "," ", "H"},
			/* 24*/ {"H"," ", "H"," ", "H"," ", "H", "W", "H"," ", "H"," ", "H"," ", "H"," ", "H", "W", "H"," ", "H"," ", "H"," ", "H"},
			/* 25*/ {"H"," ", "W"," "," "," ", "W", "W"," "," "," ", "W"," ", "W"," "," "," ", "W", "W"," "," "," ", "W"," ", "H"},
			/* 26*/ {"H"," ", "H"," ", "H", "W", "H", "W", "H"," ", "H", "W", "H", "W", "H"," ", "H", "W", "H", "W", "H"," ", "H"," ", "H"},
			/* 27*/ {"H"," "," "," ", "W"," ", "W"," ", "W"," ", "W", "W"," ", "W", "W"," ", "W"," ", "W"," ", "W"," "," "," ", "H"},
			/* 28*/ {"H"," ", "H", "W", "H", "W", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H", "W", "H", "W", "H"," ", "H"},
			/* 29*/ {"H"," "," ", "W", "W"," "," ", "W", "W"," ", "W"," "," "," ", "W"," ", "W", "W"," "," ", "W", "W"," "," ", "H"},
			/* 30*/ {"H"," ", "H"," ", "H", "W", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H", "W", "H"," ", "H"," ", "H"},
			/* 31*/ {"H", "Y"," "," "," ", "W", "W", "W", "W"," ", "W", "W"," ", "W", "W"," ", "W", "W", "W", "W"," "," "," ", "4", "H"},
			/* 32*/ {"H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H"}};
	
	private Util util;

	@Before
	public void before(){
		util = new Util();
		util.updateMap(map);
	}

	@Test
	public void testSearch(){
		List<Point2D> bombList = util.search(31, 5, 5, Util.MYSELF);

		assertTrue(bombList.size() == 1);
		assertEquals("Self should be found at (31,1) from (31,5) with max=5", bombList.get(0), new Point2D(31, 1));
	}
	
	@Test
	public void testMyLocation(){
		Point2D expected = new Point2D(31,1);
		Point2D actual = util.getMyLocation();
		
		assertEquals("Self should be at (31,1)", expected, actual );
	}
	
	@Test
	public void testAt(){
		String expected = Util.PLAYER_4;
		String actual = util.at(31, 23);
		
		assertEquals("Player 4 should be at (31,23)", expected, actual);
	}

}