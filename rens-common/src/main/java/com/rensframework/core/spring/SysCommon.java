package com.rensframework.core.spring;

import org.springframework.beans.factory.FactoryBean;

public class SysCommon implements FactoryBean<String> {

	private String name;
	
	private Integer age;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String getObject() throws Exception {
		return this.name+"的年龄"+this.age;
	}

	@Override
	public Class<?> getObjectType() {
		return String.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

}
