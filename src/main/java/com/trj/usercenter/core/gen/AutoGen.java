package com.trj.usercenter.core.gen;


import com.trj.usercenter.core.gen.model.Entity;
import com.trj.usercenter.core.gen.model.Table;

public interface AutoGen {
	public void make(Target target, Entity entity, Table table);
	public String getName();
}
