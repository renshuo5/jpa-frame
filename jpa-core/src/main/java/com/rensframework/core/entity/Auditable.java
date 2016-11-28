package com.rensframework.core.entity;

public interface Auditable<T extends Entity> extends Entity {

	public String getEntityName();

	public String getIdStr();

	public String getName();

	public T getOrig();

	public void setOrig(T paramT);
}
