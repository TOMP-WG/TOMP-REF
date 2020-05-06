package org.tomp.api.utils;

public interface ObjectProvider<T> {

	T getObject(String acceptLanguage, Class<T> c, String fromFile);

}
