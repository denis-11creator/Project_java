package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GameInformationModelTest {
	
	GameInformationModel b ;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	

	@Before
	public void setUp() throws Exception {
		this.b = new GameInformationModel(10);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetScore() {
		int a = 0 ;
		assertEquals(a,b.getScore());
	}

	@Test
	public void testSetScore() {
		
	}

}
