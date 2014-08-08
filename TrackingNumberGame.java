package com.TrackingNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.*;

class TrackList {

	/**
	 * @param args
	 */
	Range range;
	char status;
	int transferCode;

	public TrackList(Range range, char status, int transferCode) {
		this.range = range;
		this.status = status;
		this.transferCode = transferCode;
	}

	public boolean isStatusEquals(TrackList track) {
		if(this.status == track.status)
			return true;
		return false;
	}

	public boolean isTrackCodeEquals(TrackList track) {
		if(this.transferCode == track.transferCode)
			return true;
		return false;
	}
	public void setRange(Range range)
	{
		this.range=range;
	}
	public int getStartingNumber()
	{
		return range.getStartingNumber();
	}
	public char getStatus()
	{
		return this.status;
	}
	public int getTransferCode()
	{
		return this.transferCode;
	}
}

public class TrackingNumberGame {

	static ArrayList<TrackList> inputTrackRecords = new ArrayList<TrackList>();
	static ArrayList<TrackList> tracks = new ArrayList<TrackList>();

	public static void parseInput(String fileName) throws IOException {
		String line;
		TrackList record;
		int startTrackNum;
		int endTrackNum;
		int transferCode;
		char status;
		FileReader file = new FileReader(fileName);
		BufferedReader reader = new BufferedReader(file);
		while ((line = reader.readLine()) != null) {
			String[] input = line.split(" ");
			startTrackNum = Integer.parseInt(input[0]);
			endTrackNum = Integer.parseInt(input[1]);
			status = input[2].toUpperCase().charAt(0);
			transferCode = Integer.parseInt(input[3]);
			record = new TrackList(new Range(startTrackNum, endTrackNum),
					status, transferCode);
			inputTrackRecords.add(record);
		}
		tracks.add(inputTrackRecords.get(0));
      		
		reader.close();

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		parseInput("C:\\Users\\kekt\\Downloads\\teatcase.txt");	
		
		processInput();
		
	}
	

	public static void processInput(){
		
		for (int i = 1; i < inputTrackRecords.size(); i++){
          processTracks(inputTrackRecords.get(i));
          sort();
	}
	System.out.println(tracks);	
	}
	public static void processTracks(TrackList item)
	{
		TrackList input = item;
		Range rangeObject=new Range();
		for(TrackList track: tracks){
			if(rangeObject.isOverlapping(track.range,input.range))
			{
				ArrayList<Range> r = rangeObject.splitOverlappingRanges(track.range,input.range);
				processTracks(new TrackList(r.get(2),input.getStatus(),input.getTransferCode()));
				tracks.add(new TrackList(r.get(1),track.getStatus(),track.getTransferCode()));
				track.setRange(r.get(0));
				
			}
			else if(input.range.contains(track.range)){
				    ArrayList<Range> r = rangeObject.splitConstituentRanges(track.range,input.range);
					track.setRange(r.get(0));
					tracks.add(input);
					tracks.add(new TrackList(r.get(2),track.getStatus(),track.getTransferCode()));						
					
			}
			else
				tracks.add(input);
			
			
		
	}
	}
		private static void sort()
		{
			Collections.sort(tracks, new Comparator<TrackList>(){
                public int compare(TrackList  r1, TrackList r2){
                   return (r1.getStartingNumber() - r2.getStartingNumber());
              }});
		}
		private void merge()
		{
			Range rangeObject = new Range();
		 for(int i = 0; i < tracks.size()-1; i++)
		 {
			 TrackList input = tracks.get(i);
			 TrackList nextTrack = tracks.get(i+1);
			if(input.isStatusEquals(nextTrack) && input.isTrackCodeEquals(nextTrack) && rangeObject.isContinuous(input.range,nextTrack.range))
			{
				input.setRange(rangeObject.mergeTwoRanges(input.range, nextTrack.range));
			    tracks.remove(i+1);
			    i=i-1;
			}
	
		 }
		}
	
	

}
