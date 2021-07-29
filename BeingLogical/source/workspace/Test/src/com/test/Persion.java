package com.test;

public class Persion {
	
	private String name;
	private Think think;
	public void voting(Persion per, boolean isThief) {
		think = new Think(per, isThief);
	}
	public Persion(String name) {
		super();
		this.name = name;
	}
	public Think getThink() {
		return think;
	}
	public String getName() {
		return name;
	}
}
