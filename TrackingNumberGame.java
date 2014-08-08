package com.TrackingNumber;

import java.util.ArrayList;
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
		parseInput("input.txt");	
		
	}
	

	public static void processInput(){
		Range rangeObject=new Range();
		for (int i = 1; i < inputTrackRecords.size(); i++){
			TrackList input = inputTrackRecords.get(i);
			for(TrackList track: tracks){
				if(track.range.contains(input.range)){
					//split
				}
				else if(input.range.contains(track.range)){
					//split();
				}
				//else if(){ // condition need to be returned
					// overlapping
			//	}
				else if(input.isStatusEquals(track) && input.isTrackCodeEquals(track) && rangeObject.isContinuous(input.range,track.range))
				{
				   track.setRange(rangeObject.mergeTwoRanges(input.range, track.range));
				}
				
			}
		}
	}
	
	

}
