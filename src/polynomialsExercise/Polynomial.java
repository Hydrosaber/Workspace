package polynomialsExercise;

import java.util.ArrayList;

public class Polynomial {
	private ArrayList<Monomial> terms;
	private ArrayList<Polynomial> factors;
	public Polynomial(Monomial t) {
		terms=new ArrayList<Monomial>();
		terms.add(t);
		simplify();
	}
	public Polynomial(Monomial[] ts) {
		terms=new ArrayList<Monomial>();
		for(Monomial t:ts) {
			terms.add(t);
		}
		simplify();
	}
	public Polynomial(ArrayList<Monomial> ts) {this(ts.toArray(new Monomial[ts.size()]));}
	public Polynomial(Monomial[] ts, ArrayList<Polynomial> fs) {
		this(ts);
		factors=fs;
	}
	private void simplify() {
		for(int i=0;i<terms.size()-1;i++) {
			Monomial current = terms.get(i);
			for(int x=terms.size()-1;x>i;x--) {
				if(current.equals(terms.get(x))) {
					current.setCoefficient(current.getCoefficient()+terms.remove(x).getCoefficient());
				}
			}
		}
	}
}
