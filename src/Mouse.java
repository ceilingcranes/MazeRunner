import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

public class Mouse extends Actor{
	private CS2Stack<Location> stack=new CS2Stack<Location>();
	private CS2Stack<Location> crumbs=new CS2Stack<Location>();
	private boolean backtracking=false;
	private CS2Stack<Location> lastCrossroads=new CS2Stack<Location>();
	public void act(){
		int numberPushed=0;
		for(int dir=0; dir<360; dir+=90){
			if(getGrid().isValid(getLocation().getAdjacentLocation(dir))){
				if(getGrid().get(getLocation().getAdjacentLocation(dir)) instanceof Cheese)
					throw new RuntimeException("Congradulations! You Won!");
				if(getGrid().get(getLocation().getAdjacentLocation(dir))==null){
					stack.push(getLocation().getAdjacentLocation(dir));
					numberPushed++;
				}
			}	
		}
		if(numberPushed>1)
			lastCrossroads.push(getLocation());
		move();
	}
	public void move(){
		Location prev=getLocation();
		Location l=stack.pop();
		Location temp=l;
		Location cross=lastCrossroads.peep();
		if(getGrid().getEmptyAdjacentLocations(getLocation()).size()<=0){
			backtracking=true;
		}
		if(getLocation()==temp){
			backtracking=false;
		}
		if(backtracking){
			stack.push(l);
			l=crumbs.pop();
			getGrid().get(l).removeSelfFromGrid();
		}
		if(!backtracking)
			crumbs.push(prev);
		if(l==cross){
			lastCrossroads.pop();
			backtracking=false;
		}
		setDirection(getLocation().getDirectionToward(l));
		moveTo(l);
		if(backtracking==true){
			Backtracked backtracked=new Backtracked();
			backtracked.setColor(null);
			backtracked.setDirection(getDirection());
			backtracked.putSelfInGrid(getGrid(), prev);
		}
		Breadcrumb breadcrumb=new Breadcrumb();
		breadcrumb.setColor(null);
		breadcrumb.setDirection(getDirection());
		breadcrumb.putSelfInGrid(getGrid(), prev);
	}

}
