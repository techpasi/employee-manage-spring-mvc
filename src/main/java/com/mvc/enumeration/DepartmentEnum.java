package com.mvc.enumeration;

public enum DepartmentEnum {
	IT("Infomation Technology"),
	MARKETING("Marketing"),
	HR("Human Resources");
	
	public final String value;

    DepartmentEnum(String value) {
        this.value = value;
    }
}
