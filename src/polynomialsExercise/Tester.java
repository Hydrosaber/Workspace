package polynomialsExercise;

import java.util.ArrayList;
import java.util.Collections;

public class Tester {
	public static void main(String[] args) {
		Monomial t1 = new Monomial(3, new Variable('b',1)), t2 = new Monomial(2, new Variable('x',2));
		Monomial t3 = VariableMath.multiply(t1, t2);
		System.out.println(t3);
		ArrayList<Variable> bob = new ArrayList<Variable>();
		bob.add(new Variable('b',2));
		bob.add(new Variable('a',4));
		bob.add(new Variable('m',2));
		bob.add(new Variable('x',2));
		bob.add(new Variable('y',2));
		bob.add(new Variable('a',2));
		Collections.sort(bob);
		System.out.println(bob);
	}
}
