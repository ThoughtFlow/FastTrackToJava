package chap12;

public class GenericsCovariance {

	@SuppressWarnings("unused")
	public static void main(String... args) {

		// The idea behind generics is to eliminate type surprises at runtime. 
		// You can prove at compilation that your program will not encounter class cast exceptions.
		// Static typing is great but there is a price to pay. Generics are non-intuitive.
		// Furthermore, sometimes, you don't care what the specific type is because you are only interested in processing the generic class 
		// without interacting with its parameterized type.
		// And this is where the fun begins!
		
		
        // While this works (regular polymorphism we all know and love)
		{
		   ChildClass typeChild = new ChildClass();
		   ParentClass typeParent = typeChild;
		}
		
		// The same thinking does not work with parameterized types (because by default, parameterized types are not covariant)
		{
		   GenericClass<ChildClass> genericOfChild = new GenericClass<>();
  		   //GenericClass<ParentClass> genericOfParent = genericOfChild; //fails compilation
		}
		
		// To achieved the same thing, we need to make them covariant with bounded wildcards
		{
		   GenericClass<? extends ChildClass> genericOfExtendsChild = new GenericClass<ChildClass>();
		   GenericClass<? extends ParentClass> genericOfExtendsParent = genericOfExtendsChild;
		   
		   // or this to be unbounded
		   GenericClass<?> genericOfWildcard = genericOfExtendsChild;
		   
		   // Or this
		   GenericClass<?> genericOfWildcard2 = genericOfExtendsParent;
		   
		   // But not this
  		   //	GenericClass<? extends ChildClass> genericOfExtendsChild = new GenericClass<? extends ChildClass>() // cannot instantiate a wildcard type
		}

		// But covariant parameterized types limit what we can do 
		{
			// One set of rules for extends
			GenericClass<? extends ChildClass> genericOfExtendsChild = new GenericClass<ChildClass>();

			// Can't use any method that expects a concrete type because then no guarantees could be made about the parameterized type
			//genericOfExtendsChild.setT(new ChildClass()); 

            // But this is OK because we know for sure is that it's AT LEAST a ChildClass.
			ChildClass typeChild = genericOfExtendsChild.get(); 

			// Upcasting works as expected.
			Object typeObject = genericOfExtendsChild.get(); 
			
			// Another set of rules for super
			GenericClass<? super ChildClass> genericOfSuperChild = new GenericClass<ChildClass>();

			// Only the super type (ChildClass) works because we're sure that it can substitute for any type for GenericClass.
			genericOfSuperChild.setT(new ChildClass()); 

			// This won't work because it can't substitute for ChildClass
			//genericOfSuperChild.setT(new ParentClass()); 

            // But can only be assigned to Object
			typeObject = genericOfSuperChild.get(); 

			//It's perfectly legal to call a method that expects a concrete type
			GenericClass<? extends ParentClass> genericOfExtendsParent = new GenericClass<ChildClass>();
			genericOfExtendsParent.setConcreteType("Hello");
		}
	}
	
	private static class ParentClass {
		
	}
	
	private static class ChildClass extends ParentClass {
		
	}
	
	private static class GenericClass<T> {
		private T t;
		private String string;
		
		public void setT(T t) {
			this.t = t;
		}
		
		public T get() {
			return this.t;
		}

		public void setConcreteType(String string) {
   			this.string = string;
		}

		public String  getConcreteType() {
   			return string;
		}
	}
}
