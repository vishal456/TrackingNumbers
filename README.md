TrackingNumbers
===============

Range Class contains:

  private Range()
	
	public Range(int start, int end)
	
	public boolean isOverlapping(Range firstRange, Range secondRange)
	
	public boolean isContinous(Range firstRange, Range secondRange)
	
	public boolean contains(Range newRange)
	
	public Range mergeTwoRanges(Range firstRange, Range secondRange)
	
	public ArrayList< Range > splitConstituentRanges(Range dominantRange, Range recessiveRange)
	
	public ArrayList< Range > splitOverlappingRanges(Range dominantRange, Range recessiveRange)
	
	
TrackingRecord Class contains:

