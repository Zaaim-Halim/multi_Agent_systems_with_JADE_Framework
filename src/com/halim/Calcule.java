package com.halim;

import java.io.Serializable;

public class Calcule implements Serializable {
	private float n1;
	private float n2;
	private float res ;
	
	public Calcule(float n1, float n2) {
		super();
		this.n1 = n1;
		this.n2 = n2;
	}
	public float getN1() {
		return n1;
	}
	public void setN1(float n1) {
		this.n1 = n1;
	}
	public float getN2() {
		return n2;
	}
	public void setN2(float n2) {
		this.n2 = n2;
	}
	public float getRes() {
		return res;
	}
	public void setRes(float res) {
		this.res = res;
	}
	

}
