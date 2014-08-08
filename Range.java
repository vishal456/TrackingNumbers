import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Range {
	int startingNumber;
	int endingNumber;
	
	public Range(){
		
	}
	
	public Range(int start, int end){
		startingNumber	= start;
		endingNumber = end;
	}
	
	public boolean isOverlapping(Range firstRange, Range secondRange){
		if(firstRange.startingNumber <= secondRange.startingNumber && firstRange.endingNumber >= secondRange.startingNumber)
			return true;
		if(secondRange.startingNumber <= firstRange.startingNumber && secondRange.endingNumber >= firstRange.startingNumber)
			return true;
		return false;
	}
	
	public boolean isContinuous(Range firstRange, Range secondRange){
		if(isOverlapping(firstRange, secondRange)) return true;
		
		if(firstRange.endingNumber + 1 == secondRange.startingNumber)
			return true;
		if(secondRange.endingNumber + 1 == firstRange.startingNumber)
			return true;
		return false;
	}
	
	public boolean contains(Range newRange){
		if(this.startingNumber <= newRange.startingNumber && this.endingNumber >= newRange.endingNumber)
			return true;
		return false;
	}
	
	public Range mergeTwoRanges(Range firstRange, Range secondRange){
		Range range = new Range();
		range.startingNumber = Math.min(firstRange.startingNumber, secondRange.startingNumber);
		range.endingNumber = Math.max(firstRange.endingNumber, secondRange.endingNumber);
		return range;
	}
	
	public ArrayList< Range > splitConstituentRanges(Range dominantRange, Range recessiveRange){
		ArrayList<Range> list = new ArrayList<Range>();
		if(dominantRange.contains(recessiveRange)){
			list.add(dominantRange);
			return list;
		}
		else{
			list.add(new Range(recessiveRange.startingNumber, dominantRange.startingNumber - 1));
			list.add(dominantRange);
			list.add(new Range(dominantRange.endingNumber + 1, recessiveRange.endingNumber));
			return list;
		}
	}
	
	public ArrayList< Range > splitOverlappingRanges(Range dominantRange, Range recessiveRange){
		ArrayList<Range> list = new ArrayList<Range>();
		list.add(dominantRange);
		if(dominantRange.startingNumber < recessiveRange.startingNumber){
			list.add(new Range(dominantRange.endingNumber + 1, recessiveRange.endingNumber));
		}
		else{
			list.add(new Range(recessiveRange.startingNumber, dominantRange.startingNumber - 1));
		}
		return list;
		
	}
}
