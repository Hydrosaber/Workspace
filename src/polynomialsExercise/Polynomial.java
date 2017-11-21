package polynomialsExercise;

import java.util.ArrayList;

public class Polynomial {
	private ArrayList<Monomial> terms;
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
	private void simplify() {
		for(int i=0;i<terms.size();i++) {
			Monomial current = terms.get(i);
			for(int x=terms.size()-1;x>i;x--) {
				System.out.println("Is "+current+"="+terms.get(x));
				if(current.equals(terms.get(x))) {
					System.out.println("Yes");
					current.setCoefficient(current.getCoefficient()+terms.remove(x).getCoefficient());
				}else {
					System.out.println("No");
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
}
