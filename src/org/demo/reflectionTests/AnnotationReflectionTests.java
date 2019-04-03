package org.demo.reflectionTests;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.demo.customAnnotations.Init;
import org.demo.customAnnotations.JsonElement;
import org.demo.customAnnotations.JsonSerializable;
import org.demo.model.Person;

public class AnnotationReflectionTests {
	
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Person person = new Person("surbhi", "sharma","750 Sylvan Ave");
		AnnotationReflectionTests test = new AnnotationReflectionTests();
		System.out.println(test.serializePerson(person));
		
	}
	
	public String serializePerson(Person person) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String result = "";
		//check if the class of person object contains the jsonSerializable annotation
		if(isJsonSerializable(person)) {
			//get reference to the initializeVariable method and invoke it
			initializeObject(person);
			//serialize and get the string out
			result = getJsonString(person);
		}
		return result;
	}
	
	public String getJsonString(Person person) throws IllegalArgumentException, IllegalAccessException {
		String result = "";
		Class personClass = person.getClass();
		Field[] fields = personClass.getDeclaredFields();
		Map<String, String> holder = new HashMap<String, String>();
		for(Field field: fields) {
			//put all key-value of fields in hashmap
			if(field.isAnnotationPresent(JsonElement.class)) {
				field.setAccessible(true);
				String key = getKey(field);
				String value = (String) field.get(person);
				holder.put(key, value);
			}
		}
		//iterate through the map to form a json string out of it
		result = holder.entrySet()
						.stream()
						.map(entry -> "\"" + entry.getKey() + "\":\"" +  entry.getValue() + "\"")
						.collect(Collectors.joining(","));
		
		return "{" + result + "}";
		
	}
	
	public String getKey(Field field) {
		String key = field.getAnnotation(JsonElement.class).key();
		return key.isEmpty() || key == null ? field.getName() : key;
	}
	
	
	public void initializeObject(Person person) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class personClass = person.getClass();
		Method[] methods = personClass.getDeclaredMethods();
		for(Method method: methods) {
			if(method.isAnnotationPresent(Init.class)) {
				method.setAccessible(true);
				method.invoke(person, null);
			}
		}
	}
	
	
	
	public boolean isJsonSerializable(Person person) {
		Class personClass = person.getClass();
		if(personClass.isAnnotationPresent(JsonSerializable.class)) return true;
		else return false;
	}

}
