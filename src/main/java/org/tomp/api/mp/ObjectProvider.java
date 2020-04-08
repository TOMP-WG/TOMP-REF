package org.tomp.api.mp;

public interface ObjectProvider<T> {

	T getObject(String acceptLanguage, Class<T> c, String fromFile);

}
