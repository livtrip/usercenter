package com.trj.usercenter.core.gen;

import com.trj.usercenter.core.gen.model.Entity;
import com.trj.usercenter.core.gen.model.Table;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;


public class JavaCodeGen  implements AutoGen{
	String basePackage;
	Entity entity;
	static String CR = System.getProperty("line.separator");
	
	public JavaCodeGen(String basePackage,Entity entity) {
		this.basePackage =basePackage;
		this.entity = entity;
	}
	@Override
	public void make(Target target, Entity entity) {
		JavaServiceGen serviceGen = new JavaServiceGen(this);
		serviceGen.make(target, entity);

		JavaServiceImplGen serviceImplGen = new JavaServiceImplGen(this);
		serviceImplGen.make(target, entity);

		JavaControllerGen webGen = new JavaControllerGen(this);
		webGen.make(target, entity);

		JavaControllerTestGen webTestGen = new JavaControllerTestGen(this);
		webTestGen.make(target, entity);
	}
	
	@Override
	public String getName() {
		return "";
	}
	
}




class JavaServiceGen  implements AutoGen{
	JavaCodeGen gen;
	public JavaServiceGen(JavaCodeGen gen){
		this.gen = gen;
	}
	@Override
	public void make(Target target, Entity entity) {
		GroupTemplate gt = target.getGroupTemplate();
		Template template = gt.getTemplate("/java/service.java");
		template.binding("entity", entity);
		template.binding("target", target);
		template.binding("package", gen.basePackage+".service");
		template.binding("basePackage", gen.basePackage);
		String content = template.render();
		target.flush(this, content);
	}

	@Override
	public String getName() {
		return gen.entity.getName()+"Service.java";
	}
	
}

class JavaServiceImplGen  implements AutoGen{
	JavaCodeGen gen;
	public JavaServiceImplGen(JavaCodeGen gen){
		this.gen = gen;
	}
	@Override
	public void make(Target target, Entity entity) {
		GroupTemplate gt = target.getGroupTemplate();
		Template template = gt.getTemplate("/java/serviceImpl.java");
		template.binding("entity", entity);
		template.binding("target", target);
		template.binding("package", gen.basePackage+".service.impl");
		template.binding("basePackage", gen.basePackage);
		String content = template.render();
		target.flush(this, content);
	}

	@Override
	public String getName() {
		return gen.entity.getName()+"ServiceImpl.java";
	}

}



class JavaControllerGen  implements AutoGen{
	JavaCodeGen gen;
	public JavaControllerGen(JavaCodeGen gen){
		this.gen = gen;
	}
	@Override
	public void make(Target target, Entity entity) {
		GroupTemplate gt = target.getGroupTemplate();
		Template template = gt.getTemplate("java/controller.java");
		template.binding("entity", entity);
		template.binding("target", target);
		template.binding("table",entity.getTable());
		template.binding("package", gen.basePackage+".web");
		template.binding("basePackage", gen.basePackage);
		String content = template.render();
		target.flush(this, content);
	}

	@Override
	public String getName() {
		return gen.entity.getName()+"Controller.java";
	}
	
}

class JavaControllerTestGen  implements AutoGen{
	JavaCodeGen gen;
	public JavaControllerTestGen(JavaCodeGen gen){
		this.gen = gen;
	}
	@Override
	public void make(Target target, Entity entity) {
		GroupTemplate gt = target.getGroupTemplate();
		Template template = gt.getTemplate("java/controllerTest.java");
		template.binding("entity", entity);
		template.binding("target", target);
		template.binding("package", gen.basePackage+".controller");
		template.binding("basePackage", gen.basePackage);
		String content = template.render();
		target.flush(this, content);
	}

	@Override
	public String getName() {
		return gen.entity.getName()+"ControllerTest.java";
	}

}








