package polynomialsExercise;
import java.util.ArrayList;
import java.util.Collections;

public class Monomial {
	private int coefficient;
	private ArrayList<Variable> variables;
	public Monomial(int c) {
		coefficient=c;
		variables = new ArrayList<Variable>();
	}
	public Monomial(int c, Variable v) {
		this(c);
		variables.add(v);
	}
	public Monomial(Variable[] vs) {
		this(1);
		for(Variable x:vs) {
			variables.add(x);
		}
		simplify();
	}
	public Monomial(Variable v) {
		this(1);
		variables.add(v);
	}
	public Monomial(ArrayList<Variable> vs) {
		this(vs.toArray(new Variable[vs.size()]));
	}
	public Monomial(int c, Variable[] vs) {
		this(vs);
		coefficient=c;
	}
	public Monomial(int c, ArrayList<Variable> vs) {
		this(vs);
		coefficient=c;
	}
	public Monomial(Monomial parent) {
		this(parent.getCoefficient(), parent.getVariables());
	}
	public int getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(int n) {
		coefficient=n;
	}
	private void simplify() {
		for(int i=0;i<variables.size()-1;i++) {
			Variable current = variables.get(i);
			for(int x=variables.size()-1;x>i;x--) {
				if(current.sameVar(variables.get(x))) {
					current.setPow(current.getPow()+variables.remove(x).getPow());
				}
			}
		}
		for(int i=variables.size()-1;i>=0;i--) {
			if(variables.get(i).getPow()==0) {
				variables.remove(i);
			}
		}
		Collections.sort(variables);
	}
	public void addVariables(Variable[] vs) {
		for(Variable v:vs) {
			variables.add(v);
		}
		simplify();
	}
	public void addVariables(ArrayList<Variable> vs) {
		addVariables(vs.toArray(new Variable[vs.size()]));
	}
	public ArrayList<Variable> getVariables() {
		return variables;
	}
	public boolean equals(Monomial other) {
		for(Variable x:variables) {
			if(!other.getVariables().contains(x)) {
				return false;
			}
		}
		return true;
	}
	public String toString() {
		if(coefficient!=0) {
			String str=""+((Math.abs(coefficient)==1)?(""):(coefficient));
			for(Variable x:variables) {
				str+=x;
			}
			return str;
		}
		return "";
	}
	public Polynomial toPolynomial() {
		Monomial[] t = {this};
		return new Polynomial(t);
	}
}
