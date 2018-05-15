package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import main_library.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ListTest {
	private List<String>list_str;

	@Before
	public void setUp() throws Exception {
		list_str = new ArrayList<>();
	}
	@Test
	public final void testListInit() {
		assertTrue(list_str.isEmpty());
		assertTrue(list_str.size() == 0);
		
		//fail("Not yet implemented");
	}
	@Test (expected = IllegalArgumentException.class)
	public final void testCapacityZero() {
		list_str = new ArrayList<String>(0);
	}
	@Test (expected = IllegalArgumentException.class)
	public final void testCapacityNegative() {
		list_str = new ArrayList<String>(-100);
	}
	
	@Test
	public void testAddElements(){
		list_str.add(0, "Ali");
		list_str.add(1, "Hassan");
		list_str.add(2, "Qureshi");
		
		assertEquals("Ali", list_str.get(0));
		assertEquals("Hassan", list_str.get(1));
		assertEquals("Qureshi", list_str.get(2));
		
		list_str.add(1, "Shah-Nawaz");
		
		assertEquals("Ali", list_str.get(0));
		assertEquals("Hassan", list_str.get(1));
		assertEquals("Qureshi", list_str.get(2));
		assertEquals("Shah-Nawaz", list_str.get(3));	
		
		assertTrue(list_str.size()==4);
	}
	
	@Test (expected = NullPointerException.class)
	public void testAddNull(){
		list_str.add(0, null);
	}
	@Test (expected = NullPointerException.class)
	public void testSetElementNull(){
		list_str.add(0, "Kheyla");
		list_str.set(0, null);
	}
	
	@Test
	public void testSetElement(){
		list_str.add(0, "Karol");
		list_str.add(1, "Vanessa");
		list_str.add(2, "Amanda");
		
		list_str.set(1, "Livia");
		
		assertEquals("Karol", list_str.get(0));
		assertEquals("Livia", list_str.get(1));
		assertEquals("Amanda", list_str.get(2));
	}
	
	@Test
	public void testRemoveElement(){
		list_str.add(0, "Karol");
		list_str.add(1, "Vanessa");
		list_str.add(2, "Amanda");
		
		assertEquals("Amanda", list_str.remove(2));
		assertTrue(list_str.size() == 2);
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testRemoveWithEmptyList(){
		list_str.remove(0);
	}
	
//-----------------------------------------
	
	
	@Test
    public void testAssertList() {

        List<String> actual = Arrays.asList("a", "b", "c");
        List<String> expected = Arrays.asList("a", "b", "c");
		
		//All passed / true
		
        //1. Test equal.

        //2. If List has this value?
        //assertEquals(actual, actual.contains("b"));

        //3. Check List Size
        assertEquals(3, actual.size());


        //4.  List order

        // Ensure Correct order
        String arr[] = {"a","b","c"};
        boolean flag = false;
        for(int i=0;i<3;i++) {
        	if(arr[i] == actual.get(i)) {
        		flag = true;
        	}
        	else {
        		flag = false;
        		break;
        	}
        }
        assertTrue(flag);
        //assertEquals(actual, actual.contains(arr));
        
        // Can be any order
        //assertArrayEquals(arr, actual.sort(null));

        //5. check empty list
        assertFalse((actual.isEmpty()));

    }
	@Test
	public void testindexOf() {
		ArrayList<String> ls = new ArrayList<String>(5);
		ls.add("a");
		ls.add("b");
		ls.add("c");
		ls.add("d");
		ls.add("d");
		int index = ls.indexOf("a");
		assertTrue(index>=0);
	}
	@Test
	public void testzeroCapacity() {
		ArrayList<String> ls = new ArrayList<String>(0);
		assertTrue(ls.size()==0);
		ls.add("a");
		assertTrue(ls.size()==1);
	}
	@Test
	public void testClone() {
		ArrayList<String> ls = new ArrayList<String>(5);
		ls.add("a");
		ls.add("b");
		ls.add("c");
		ls.add("d");
		ls.add("d");
		@SuppressWarnings("unchecked")
		ArrayList<String> cloned =(ArrayList<String>) ls.clone();
		assertTrue(cloned.size() == ls.size());
		boolean flag = false;
        for(int i=0;i<ls.size();i++) {
        	if(cloned.get(i) == ls.get(i)) {
        		flag = true;
        	}
        	else {
        		flag = false;
        		break;
        	}
        }
        assertTrue(flag);
	}
}
