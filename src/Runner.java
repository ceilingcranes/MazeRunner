




public class Runner {

	public static void main(String[] args) {
		Maze maze = new Maze(30,30);
		maze.printWorld(new Mouse(),new Cheese()).show();
	}

}
