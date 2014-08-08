import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;


public class RangeTest {

	
	@Test
	public void testIsOverLappingTrue() throws IOException {
		Range range = new Range();
        BufferedReader br = new BufferedReader(new FileReader("trueoverlapping.txt"));
        String token = "";   
        
        while((token = br.readLine()) != null){
        	String[] tokens = token.split(" ");
        	assertTrue(range.isOverlapping(new Range(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])), new Range(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]))));
 		}
        
	}
	
	@Test
	public void testIsOverLappingFalse() throws IOException{
		Range range = new Range();
        BufferedReader br = new BufferedReader(new FileReader("falseoverlapping.txt"));
        String token = "";  
        
        while((token = br.readLine()) != null){
        	String[] tokens = token.split(" ");
        	assertFalse(range.isOverlapping(new Range(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])), new Range(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]))));
 		}
	}
	
	@Test
	public void testIsContinuousTrue() throws IOException {
		Range range = new Range();
        BufferedReader br = new BufferedReader(new FileReader("truecontinuous.txt"));
        String token = "";   
        
        while((token = br.readLine()) != null){
        	String[] tokens = token.split(" ");
        	assertTrue(range.isContinuous(new Range(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])), new Range(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]))));
 		}
        
       
	}
	
	@Test
	public void testIsContinuousFalse() throws IOException {
		Range range = new Range();
        BufferedReader br = new BufferedReader(new FileReader("falsecontinuous.txt"));
        String token = "";     
	        
	        while((token = br.readLine()) != null){
	        	String[] tokens = token.split(" ");
	        	System.out.println(token);
	        	assertFalse(range.isContinuous(new Range(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])), new Range(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]))));
	 		}
	}
	
	@Test
	public void testContainsTrue() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("truecontains.txt"));
        String token = "";   
        
        while((token = br.readLine()) != null){
        	String[] tokens = token.split(" ");
        	assertTrue((new Range(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])).contains(new Range(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])))));
 		}
        

	}
	
	@Test
	public void testContains() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("falsecontains.txt"));
        String token = "";  
        
        while((token = br.readLine()) != null){
        	String[] tokens = token.split(" ");
        	assertFalse(new Range(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1])).contains(new Range(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]))));
 		}
	}
	
	@Test
	public void testMerge() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("merge.txt"));
        String token = "";  
        
        while((token = br.readLine()) != null){
        	String[] tokens = token.split(" ");
        	Range range = new Range();
        	range = range.mergeTwoRanges(new Range(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])), new Range(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])));
        	assertEquals(Integer.parseInt(tokens[4]), range.startingNumber);
        	assertEquals(Integer.parseInt(tokens[5]), range.endingNumber);
 		}
	}
	
	@Test
	public void testSplitConstituentRangesOneSplit() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("splitone.txt"));
        String token = "";  
        
        while((token = br.readLine()) != null){
        	String[] tokens = token.split(" ");
        	ArrayList<Integer> list = new ArrayList<Integer>();
        	for( int i = 4; i < tokens.length; i++)
        		list.add(Integer.parseInt(tokens[i]));
        	Range range = new Range();
        	ArrayList<Range> listNew = range.splitConstituentRanges(new Range(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])), new Range(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])));
        	ArrayList< Integer> list1 = new ArrayList<Integer>();
        	for(Range r : listNew){
        		list1.add(r.startingNumber);
        		list1.add(r.endingNumber);
        	}
        	assertTrue(list.equals(list1));
 		}
	}
	
	@Test
	public void testSplitConstituentRangesThreeSplit() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("splitthree.txt"));
        String token = "";  
        
        while((token = br.readLine()) != null){
        	String[] tokens = token.split(" ");
        	ArrayList<Integer> list = new ArrayList<Integer>();
        	for( int i = 4; i < tokens.length; i++)
        		list.add(Integer.parseInt(tokens[i]));
        	Range range = new Range();
        	ArrayList<Range> listNew = range.splitConstituentRanges(new Range(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])), new Range(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])));
        	ArrayList< Integer> list1 = new ArrayList<Integer>();
        	for(Range r : listNew){
        		list1.add(r.startingNumber);
        		list1.add(r.endingNumber);
        	}
        	System.out.println(list);
        	System.out.println(list1);
        	assertTrue(list.equals(list1));
 		}
	}
	
	@Test
	public void testSplitOverlappingRanges() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("splittwo.txt"));
        String token = "";  
        
        while((token = br.readLine()) != null){
        	String[] tokens = token.split(" ");
        	ArrayList<Integer> list = new ArrayList<Integer>();
        	for( int i = 4; i < tokens.length; i++)
        		list.add(Integer.parseInt(tokens[i]));
        	Range range = new Range();
        	ArrayList<Range> listNew = range.splitOverlappingRanges(new Range(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])), new Range(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])));
        	ArrayList< Integer> list1 = new ArrayList<Integer>();
        	for(Range r : listNew){
        		list1.add(r.startingNumber);
        		list1.add(r.endingNumber);
        	}
        	assertTrue(list.equals(list1));
 		}
	}
}
