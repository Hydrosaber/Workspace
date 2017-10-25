package polynomialsExercise;

public class Variable implements Comparable<Variable>{
	int power;
	char symbol;
	public Variable() {
		symbol='x';
		power=0;
	}
	public Variable(char x) {
		symbol=x;
		power=1;
	}
	public Variable(char x, int pow) {
		this(x);
		power=pow;
	}
	public Variable(int pow) {
		this('x',pow);
	}
	public int getPow() {
		return power;
	}
	public void setPow(int n) {
		power = n;
	}
	public char getSymbol() {
		return symbol;
	}
	public boolean equals(Variable other) {
		return power==other.getPow()&&symbol==other.getSymbol();
	}
	public boolean sameVar(Variable other) {
		return symbol==other.getSymbol();
	}
	public int compareTo(Variable other) {
		if(sameVar(other)) {
			int cmp, a=power, b=other.getPow();
			if (a > b) {
				cmp = +1;
			}else if (a < b) {
				cmp = -1;
			}else {
				cmp = 0;
			}
			return cmp;
		}
		int cmp;
		char a=symbol, b=other.getSymbol();
		if(b=='x'||a=='x') {
			if(a=='x'&&b!='x') {
				return -1;
			}else if(a!='x'&&b=='x') {
				return 1;
			}
			return 0;
		}else if (a > b) {
			cmp = +1;
		}else if (a < b) {
			cmp = -1;
		}else {
			cmp = 0;
		}
		return cmp;
	}
	public String toString() {
		if(power>0)
			return "("+symbol+((power==1)?(")"):("^"+power+")"));
		return "";
	}
}
