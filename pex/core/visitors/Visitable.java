package pex.core.visitors;

public interface Visitable {
	/**
	** Visitor abstraction; permits acception of any derived type of visitor.
	*/
	public void accept(Visitor v);
}
