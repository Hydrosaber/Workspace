package polynomialsExercise;

public class VariableMath {
	public static Monomial multiply(Monomial v1, Monomial v2) {
		Monomial end = new Monomial(v1);
		end.addVariables(v2.getVariables());
		end.setCoefficient(end.getCoefficient()*v2.getCoefficient());
		return end;
	}
	public static Polynomial multiply(Polynomial p1, Polynomial p2) {
		return null;
	}
	public static Polynomial multiply(Monomial m, Polynomial p) {
		return null;
	}
}
