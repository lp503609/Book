package com.test;

public class Think {
	public static enum Status{UNKOWN, TRUE, FALSE};
	private Persion suspect;
	private boolean suspectIsThief;
	
	
	public Think(Persion suspect, boolean isThief) {
		super();
		this.suspect = suspect;
		this.suspectIsThief = isThief;
	}
	public Persion getSuspect() {
		return suspect;
	}
	public boolean suspectIsThief() {
		return suspectIsThief;
	}
}
