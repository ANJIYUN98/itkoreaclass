package Ch38ClassDiagram.C00Startcraft;

public abstract class Building {
	
	public int HP;
	public int Ammor;
	
	
	abstract void Construct();
	abstract void UnderAttack(Unit unit);
	

}
