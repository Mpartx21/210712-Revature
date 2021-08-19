package com.revature.calculator;

public class  MathExpressions {
	public MathExpressions(){}
	
	public static double add(double x,double y) {
		return x+y;
	}
	
	public static double sub(double x,double y) {
		return x-y;
	}
	
	public static double multi(double x,double y) {
		return x*y;
	}
	
	public static double divide(double x,double y) {
		double z = x/y;
		z+= x%y;
		return z;
	}

}
