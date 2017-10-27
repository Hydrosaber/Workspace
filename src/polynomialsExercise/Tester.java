package polynomialsExercise;

import java.util.ArrayList;
import java.util.Collections;

public class Tester {
	public static void main(String[] args) {
		Monomial[] terms = {new Monomial(new Variable('x')), new Monomial(-2)}, terms2 = {new Monomial(new Variable('x')), new Monomial(2)};
		Polynomial[] factors = {new Polynomial(terms), new Polynomial(terms2)};
		System.out.println(""+factors[0]+factors[1]);
		Polynomial end = VariableMath.add(factors[0],factors[1]);
		System.out.println(end);
		System.out.println(end.toFactorString());
	}
}
