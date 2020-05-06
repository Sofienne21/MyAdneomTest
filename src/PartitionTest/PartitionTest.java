package PartitionTest;

import org.junit.Test;

import Adneom.MakePartition;
import Adneom.RessourcePartition;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionTest {
	
	@Test
	public void testListIsNull(){
		Exception exception = assertThrows(IllegalArgumentException.class, () -> 
				MakePartition.partition(null, 1));
		assertEquals(RessourcePartition.LIST_IS_NULL.name(), exception.getMessage());
	}
	
	@Test
	public void testSizeLessThanOne(){
	      Exception exception = assertThrows(IllegalArgumentException.class, () ->
			MakePartition.partition(Arrays.asList(1,2), 0));
	      assertEquals(RessourcePartition.PARTITION_NOT_POSSIBLE_SIZE_LESS_THAN_ONE.name(), exception.getMessage());
	}
	
	@Test
	public void testEmptyList(){
		List[] emptyList = MakePartition.partition(new ArrayList<>(), 1);
		assertTrue(emptyList.length==0);
	}
	
	@Test
	public void testWhenPartitionSizeIs1(){
		List[] list = MakePartition.partition(Arrays.asList(1,2,3,4), 1);
		assertTrue(list.length==4);
		assertEquals(list[0], Arrays.asList(1));
		assertEquals(list[1], Arrays.asList(2));
		assertEquals(list[2], Arrays.asList(3));
		assertEquals(list[3], Arrays.asList(4));
	}
	
	@Test
	public void testWhenPartitionSizeIs2(){
		List[] list = MakePartition.partition(Arrays.asList(1,2,3,4,5), 2);
		assertTrue(list.length==3);
		assertEquals(list[0], Arrays.asList(1,2));
		assertEquals(list[1], Arrays.asList(3,4));
		assertEquals(list[2], Arrays.asList(5));
	}
	
	@Test
	public void testWhenPartitionSizeIsGreaterThanListSize(){
		List[] list = MakePartition.partition(Arrays.asList(1,2,3,4,5), 7);
		assertTrue(list.length==1);
		assertEquals(list[0], Arrays.asList(1,2,3,4,5));
	}

}
