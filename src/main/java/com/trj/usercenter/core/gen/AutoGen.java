package com.trj.usercenter.core.gen;


import com.trj.usercenter.core.gen.model.Entity;

public interface AutoGen {
	public void make(Target target, Entity entity);
	public String getName();
}
