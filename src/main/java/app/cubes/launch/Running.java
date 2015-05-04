package app.cubes.launch;


import java.util.Map;

import app.cubes.core.Cube;
import app.cubes.models.Square;

/**
 * Class entry point in programm
 * In this class is descrited only blue squares
 * 
 *
 */
public class Running {
	
	public static void main(String[] args) {
		
		/*args  = new String[2]; 
		args[0] = "cube=purple";
		args[1] = "solution=all";*/

		
		if(args.length == 0) {
			System.out.println("Example : java -jar cubes.jar cube={blue | purple | red | green} solution={default:one | all} ");
			System.exit(1);
		}
		
		String type = null; 
		String solution = "one";
		for(String param : args) {
			String[] p = param.split("=");
			switch(p[0]) {
			case "cube":
				type = p[1];
				break;
			case "solution":
				solution = p[1];
				break;
			default:	
				System.out.println("Example : java -jar cubes.jar cube={blue | purple | red | green} solution={default:one | all}");
				System.exit(1);
			}
		}
		
		
		Map<Integer, Square> cube = null;
		
		switch(type) {
			case "blue":
					cube = Cubes.BLUE;
				break;
			case "purple":
					cube = Cubes.PURPLE;
				break;
			case "red":
					cube = Cubes.RED;
				break;
			case "green":
					cube = Cubes.GREEN;
				break;
			default:
				System.out.println("Example : java -jar cubes.jar cube={blue | purple | red | green} solution={default:one | all}");
				System.exit(1);
		}
		
		

		
		Cube search = new Cube(cube, solution);
		search.build();
	}
}
