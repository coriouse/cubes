package app.cubes.launch;

import java.util.HashMap;
import java.util.Map;

import app.cubes.model.Square;

public class Cubes {

	public static Map<Integer, Square> BLUE = new HashMap<Integer, Square>() {
		private static final long serialVersionUID = 1L;

		{
			put(1, new Square(1, new int[][] { { 0, 0, 1, 0, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 },
					{ 0, 1, 1, 1, 0 }, { 0, 0, 1, 0, 0 } }));

			put(2, new Square(2, new int[][] { { 1, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 0 },
					{ 1, 1, 1, 1, 1 }, { 1, 0, 1, 0, 1 } }));

			put(3, new Square(3, new int[][] { { 0, 0, 1, 0, 0 }, { 0, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0 },
					{ 0, 1, 1, 1, 1 }, { 0, 0, 1, 0, 0 } }));

			put(4, new Square(4, new int[][] { { 0, 1, 0, 1, 0 }, { 1, 1, 1, 1, 0 }, { 0, 1, 1, 1, 1 },
					{ 1, 1, 1, 1, 0 }, { 1, 1, 0, 1, 0 } }));

			put(5, new Square(5, new int[][] { { 0, 1, 0, 1, 0 }, { 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 0 },
					{ 1, 1, 1, 1, 1 }, { 1, 0, 1, 0, 0 } }));

			put(6, new Square(6, new int[][] { { 0, 1, 0, 1, 0 }, { 0, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0 },
					{ 0, 1, 1, 1, 1 }, { 1, 1, 0, 1, 1 } }));
		}
	};

	public static Map<Integer, Square> PURPLE = new HashMap<Integer, Square>() {
		private static final long serialVersionUID = 1L;

		{
			put(1, new Square(1, new int[][] { { 1, 1, 0, 1, 0 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 },
					{ 0, 1, 1, 1, 1 }, { 0, 0, 1, 0, 0 } }));

			put(2, new Square(2, new int[][] { { 0, 0, 0, 1, 1 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 },
					{ 0, 1, 1, 1, 0 }, { 0, 1, 0, 1, 0 } }));

			put(3, new Square(3, new int[][] { { 0, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 }, { 0, 1, 1, 1, 1 },
					{ 1, 1, 1, 1, 0 }, { 0, 0, 1, 0, 0 } }));

			put(4, new Square(4, new int[][] { { 1, 1, 0, 1, 1 }, { 0, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0 },
					{ 0, 1, 1, 1, 0 }, { 0, 1, 0, 1, 0 } }));

			put(5, new Square(5, new int[][] { { 0, 0, 1, 0, 1 }, { 0, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 },
					{ 1, 1, 1, 1, 0 }, { 1, 0, 1, 1, 0 } }));

			put(6, new Square(6, new int[][] { { 0, 1, 0, 1, 1 }, { 0, 1, 1, 1, 0 }, { 0, 1, 1, 1, 1 },
					{ 1, 1, 1, 1, 0 }, { 1, 1, 0, 1, 0 } }));
		}
	};

	public static Map<Integer, Square> RED = new HashMap<Integer, Square>() {
		private static final long serialVersionUID = 1L;

		{
			put(1, new Square(1, new int[][] { { 0, 0, 0, 1, 1 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 },
					{ 0, 1, 1, 1, 0 }, { 0, 1, 0, 1, 1 } }));

			put(2, new Square(2, new int[][] { { 0, 1, 0, 1, 0 }, { 1, 1, 1, 1, 0 }, { 0, 1, 1, 1, 1 },
					{ 1, 1, 1, 1, 0 }, { 0, 1, 0, 0, 0 } }));

			put(3, new Square(3, new int[][] { { 0, 1, 1, 0, 1 }, { 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 0 },
					{ 1, 1, 1, 1, 1 }, { 1, 0, 0, 1, 1 } }));

			put(4, new Square(4, new int[][] { { 0, 0, 1, 0, 0 }, { 1, 1, 1, 1, 0 }, { 0, 1, 1, 1, 1 },
					{ 1, 1, 1, 1, 0 }, { 0, 0, 1, 0, 0 } }));

			put(5, new Square(5, new int[][] { { 0, 0, 1, 1, 0 }, { 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 0 },
					{ 1, 1, 1, 1, 1 }, { 1, 0, 1, 0, 0 } }));

			put(6, new Square(6, new int[][] { { 0, 1, 1, 0, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 },
					{ 0, 1, 1, 1, 0 }, { 1, 1, 0, 1, 1 } }));
		}
	};

	public static Map<Integer, Square> GREEN = new HashMap<Integer, Square>() {
		private static final long serialVersionUID = 1L;

		{
			put(1, new Square(1, new int[][] { { 0, 0, 1, 0, 0 }, { 1, 1, 1, 1, 0 }, { 0, 1, 1, 1, 1 },
					{ 1, 1, 1, 1, 0 }, { 0, 1, 0, 1, 0 } }));

			put(2, new Square(2, new int[][] { { 0, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 0 },
					{ 1, 1, 1, 1, 0 }, { 0, 1, 0, 1, 0 } }));

			put(3, new Square(3, new int[][] { { 0, 0, 1, 0, 1 }, { 0, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0 },
					{ 1, 1, 1, 1, 1 }, { 1, 0, 1, 0, 0 } }));

			put(4, new Square(4, new int[][] { { 1, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 0 },
					{ 1, 1, 1, 1, 1 }, { 1, 0, 1, 0, 0 } }));

			put(5, new Square(5, new int[][] { { 0, 0, 1, 0, 0 }, { 0, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0 },
					{ 0, 1, 1, 1, 1 }, { 1, 1, 0, 1, 0 } }));

			put(6, new Square(6, new int[][] { { 0, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 },
					{ 0, 1, 1, 1, 0 }, { 0, 1, 0, 1, 1 } }));
		}
	};

}
