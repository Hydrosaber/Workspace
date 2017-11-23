package polynomialsExercise;

import java.util.ArrayList;

public class VariableMath {
	public static Monomial multiply(Monomial v1, Monomial v2) {
		Monomial end = new Monomial(v1);//to avoid double reference and altering of the original monomial
		end.addVariables(v2.getVariables());
		end.setCoefficient(end.getCoefficient()*v2.getCoefficient());
		return end;
	}
	public static Polynomial multiply(Polynomial p1, Polynomial p2) {
		Monomial[] parts = p1.toArray();
		Polynomial end = new Polynomial();
		for(int i=0;i<parts.length;i++) {//adds and simplifies all instances multiplied by each term of first polynomial
			Polynomial adder = multiply(parts[i],p2);
			end=add(end, adder);
		}
		return end;
	}
	public static Polynomial multiply(Monomial m, Polynomial p) {
		Monomial[] parts = p.toArray();
		ArrayList<Monomial> end = new ArrayList<Monomial>();
		for(Monomial t:parts) {//adds all monomials multiplied by term m to end
			end.add(multiply(t,m));
		}
		return new Polynomial(end);//returns an entirely new polynomial
	}
	public static Polynomial add(Polynomial p1, Polynomial p2) {
		Monomial[] parts1 = p1.toArray(), parts2 = p2.toArray();
		ArrayList<Monomial> end = new ArrayList<Monomial>();
		for(Monomial t:parts1) {//adds all terms of first polynomial
			end.add(t);
		}
		for(Monomial t:parts2) {//adds terms of second polynomial
			end.add(t);
		}
		return new Polynomial(end);//returns an entirely new polynomial
	}
}
