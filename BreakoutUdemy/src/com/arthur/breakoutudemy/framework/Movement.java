package com.arthur.breakoutudemy.framework;

public enum Movement {
	RUNVEL (8),
	PADDLEVEL(10),
	STARTVEL (1);
	
	public final int vel;
	
	Movement(int velocity){
		this.vel = velocity;
	}
}
