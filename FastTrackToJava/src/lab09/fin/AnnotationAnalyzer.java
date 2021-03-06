package lab09.fin;

import java.lang.reflect.Method;

public class AnnotationAnalyzer {

	public static void printAnnotationDetails(Object object) {
		Method[] methods = object.getClass().getMethods();
		for (Method nextMethod : methods) {
			Transactional t = nextMethod.getAnnotation(Transactional.class);
			if (t != null) {
			   System.out.println(object.getClass().getName() + " " + nextMethod.getName() + ": " + t.value() + " " + t.commitType());
			}
		}
	}
	
	public static void main(String[] args) {
		printAnnotationDetails(new EmployeeDataAccessor());
		printAnnotationDetails(new CustomerDataAccessor());
		printAnnotationDetails(new OrderDataAccessor());
	}
	
}
