package lab10.fin;

public class Pair<T, U> {

	private final T t;
	private final U u;
	
	public Pair(T t, U u) {
		this.t = t;
		this.u = u;
	}

	public T getT() {
		return t;
	}

	public U getU() {
		return u;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((t == null) ? 0 : t.hashCode());
		result = prime * result + ((u == null) ? 0 : u.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		Pair other = (Pair) obj;
		if (t == null) {
			if (other.t != null)
				return false;
		} else if (!t.equals(other.t))
			return false;
		if (u == null) {
			if (other.u != null)
				return false;
		} else if (!u.equals(other.u))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[" + t.toString() + " " + u.toString() + "]"; 
	}
}
