package com.trj.usercenter.core.gen;


import com.trj.usercenter.core.gen.model.Entity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MavenProjectTarget extends BaseTarget {
	Entity entity;
	String basePackage;
	String basePackagePath = null;
	public MavenProjectTarget(Entity entity,String basePackage) {
		this.entity = entity;
		this.basePackage = basePackage;
		this.basePackagePath = basePackage.replace('.', '/');
	}

	@Override
	public void flush(AutoGen gen, String content) {
		String name = gen.getName();
		String target  = null;
		if (gen instanceof MdGen) {
			 target = getResourcePath()+"/sql/"+entity.getSystem()+"/"+name;
		}else if (gen instanceof JavaServiceGen) {
			 target = getSrcPath()+"/"+basePackagePath+"/service/"+name;
		}else if (gen instanceof JavaControllerGen) {
			 target = getSrcPath()+"/"+basePackagePath+"/web/"+name;
		}else if(gen instanceof  JavaServiceImplGen){
			target = getSrcPath() +"/"+basePackagePath+"/service/impl/"+ name;
		}else if(gen instanceof  JavaControllerTestGen){
			target = getTestSrcPath() +"/"+basePackagePath+"/controller/"+ name;
		}
		if(target==null) {
			return ;
		}
		flush(target,content);

	}

	protected void flush(String path, String content) {
		
		FileWriter fw;
		try {
			File file = new File(path);
			if(!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			fw = new FileWriter(new File(path));
			fw.write(content);
			fw.close();
			System.out.println(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static String getSrcPath() {

		return getRootPath() + File.separator + "src/main/java";
	}

	private static String getResourcePath() {

		return getRootPath() + File.separator + "src/main/resources";
	}

	public static String getTestSrcPath(){
		return  getRootPath() + File.separator +"src/test/java";
	}

	private static String getRootPath() {
		String srcPath;
		String userDir = System.getProperty("user.dir");
		if (userDir == null) {
			throw new NullPointerException("用户目录未找到");
		}

		return userDir;
	}

}
