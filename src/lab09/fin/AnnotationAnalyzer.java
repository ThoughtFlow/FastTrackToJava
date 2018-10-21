package lab09.fin;

import java.lang.reflect.Method;

public class AnnotationAnalyzer {

	public static void printAnnotation(Object object) {
		Method[] methods = object.getClass().getMethods();
		for (Method nextMethod : methods) {
			Transactional t = nextMethod.getAnnotation(Transactional.class);
			if (t != null) {
			   System.out.println(object.getClass().getName() + " " + nextMethod.getName() + ": " + t.value() + " " + t.commitType());
			}
		}
	}
	
	public static void main(String[] args) {
		printAnnotation(new EmployeeDataAccessor());
		printAnnotation(new CustomerDataAccessor());
		printAnnotation(new OrderDataAccessor());
	}
	
}
