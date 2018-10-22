package lab09.init;

import java.lang.reflect.Method;

public class AnnotationAnalyzer {

	public static void printAnnotationDetails(Object object) {
		// Implement this
	}
	
	public static void main(String[] args) {
		printAnnotationDetails(new EmployeeDataAccessor());
		printAnnotationDetails(new CustomerDataAccessor());
		printAnnotationDetails(new OrderDataAccessor());
	}
	
}
