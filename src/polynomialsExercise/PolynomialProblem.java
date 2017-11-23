package polynomialsExercise;

public class PolynomialProblem {
	private int seedI, seedII;
	private Polynomial problem;
	private Polynomial[] answer;
	private char symb;
	private int missedPlace;
	public PolynomialProblem() {
		symb=(char)((int)'a'+(int)(Math.random()*26));
		seedI=(int)(Math.random()*10)+1;
		seedII=(int)(Math.random()*10)+1;
		missedPlace = (int)(Math.random()*3);
		int factorI=1, factorII=1;
		do {
			factorI=(int)(Math.random()*seedI)+1;
		}while(seedI%factorI!=0);
		do {
			factorII=(int)(Math.random()*seedII)+1;
		}while(seedII%factorII!=0);
		Monomial[] termsI = {new Monomial(factorI, new Variable(symb)), new Monomial(seedI/factorI)};
		Monomial[] termsII = {new Monomial(factorII, new Variable(symb)), new Monomial(seedII/factorII)};
		answer = new Polynomial[2]; 
		answer[0]=new Polynomial(termsI);
		answer[1]=new Polynomial(termsII);
		problem=VariableMath.multiply(answer[0], answer[1]);
	}
	public String showFactoringProblem() {
		return ""+problem;
	}
	public String showMissingTermProblem() {
		return problem.MissATerm(missedPlace);
	}
	public String revealAns() {
		return ""+answer[0]+answer[1];
	}
	public boolean guess(String ans) {
		return ans.equals(revealAns());
	}
}
