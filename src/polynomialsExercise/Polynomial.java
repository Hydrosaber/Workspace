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
	public Polynomial(ArrayList<Monomial> ts, ArrayList<Polynomial> fs) {
		this(ts.toArray(new Monomial[ts.size()]), fs);
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
	public Monomial[] toArray() {
		return terms.toArray(new Monomial[terms.size()]);
	}
	public ArrayList<Monomial> getTerms(){
		return terms;
	}
	public ArrayList<Polynomial> getFactors(){
		return factors;
	}
	public String toString() {
		String end="(";
		for(int i=0;i<terms.size();i++) {
			if(terms.get(i).getCoefficient()>0&&i!=0) {
				end+="+";
			}
			end+=terms.get(i);
		}
		return end+")";
	}
	public String toFactorString() {
		String end="";
		if(factors==null) {
			return end;
		}
		for(int i=0;i<factors.size();i++) {
			end+=factors.get(i);
		}
		return end;
	}
	
}
