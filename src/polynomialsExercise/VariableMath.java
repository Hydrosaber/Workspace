package polynomialsExercise;

import java.util.ArrayList;

public class VariableMath {
	public static Monomial multiply(Monomial v1, Monomial v2) {
		Monomial end = new Monomial(v1);
		end.addVariables(v2.getVariables());
		end.setCoefficient(end.getCoefficient()*v2.getCoefficient());
		return end;
	}
	public static Polynomial multiply(Polynomial p1, Polynomial p2) {
		Monomial[] parts = p1.toArray();
		Polynomial end = multiply(parts[0],p2);
		for(int i=1;i<parts.length;i++) {
			end=add(end, multiply(parts[i],p2));
		}
		return end;
	}
	public static Polynomial multiply(Monomial m, Polynomial p) {
		Monomial[] parts = p.toArray();
		ArrayList<Monomial> end = new ArrayList<Monomial>();
		for(Monomial t:parts) {
			end.add(multiply(t,m));
		}
		return new Polynomial(end);
	}
	public static Polynomial add(Polynomial p1, Polynomial p2) {
		Monomial[] parts1 = p1.toArray(), parts2 = p2.toArray();
		ArrayList<Monomial> end = new ArrayList<Monomial>();
		for(Monomial t:parts1) {
			end.add(t);
		}
		for(Monomial t:parts2) {
			end.add(t);
		}
		return new Polynomial(end);
	}
}
