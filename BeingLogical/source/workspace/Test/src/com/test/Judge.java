package com.test;

import java.util.ArrayList;
import java.util.List;

public class Judge {
	
//	4个人3个人是真话,一个假话.

	public Persion[] decideTruth(Persion ... pers) {
		List<Persion> list = new ArrayList<Persion>();
		int truthCount = 0;//三个不是贼,一个是贼.
//		如何判定三个人是真话,一个假话.
//			假设当前人说的是假话
//		判断其他人所说的事情是否都成立,则确认当前说话的人是说的假话.
		for(Persion liar: pers) {
			truthCount = 0;
			truthCount = (?1:0) + (?1:0) + (?1:0) + (?1:0);
			if(truthCount == 3) {
				break;
			}
		}
		return null;
	}
	
	public Persion whoIsThief(Think think) {
		
		return null;
	}
	
	public int convertThink(Think think, boolean isThief) {
		if(think.suspectIsThief()) {
			
		}
		return 0;
	}
}
