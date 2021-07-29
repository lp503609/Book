package com.test;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Persion a = new Persion("A");
		Persion b = new Persion("B");
		Persion c = new Persion("C");
		Persion d = new Persion("D");
		a.voting(a, false);
		b.voting(c, true);
		c.voting(d, true);
		d.voting(c, false);
		
		Judge judge = new Judge();
		Persion [] truthPersions = judge.decideTruth(a, b, c, d);
		
		
		
//		for i in range(4):
//		    i += 1
//		    if 3 == ((i != 1) + (i == 3) + (i == 4) + (i != 4)):
//		        str = chr(96 + i) + "是小偷！"

	}

}
