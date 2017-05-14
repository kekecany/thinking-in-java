package bean;

import annotations.UseCase;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class UseCaseTracker {
	
	public static void trackUserCases(List<Integer> useCases, Class<?> cl) { 
		for (Method m: cl.getDeclaredMethods()) {
			UseCase uc = m.getAnnotation(UseCase.class);
			if(uc != null) {
				System.out.println("Found use case: " + uc.id() + " " + uc.description());
				useCases.remove(new Integer(uc.id()));
			}
		}
		for (int i: useCases) {
			System.out.println("Warning: missing use case~" + i);
		}
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(){
			private static final long serialVersionUID = -37366828809400112L;
			{
				add(47);
				add(48);
				add(49);
			}
		};
		trackUserCases(list, PasswordUtils.class);
	}

}
