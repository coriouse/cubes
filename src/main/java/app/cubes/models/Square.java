package app.cubes.models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import app.cubes.utils.Constants;

/**
 *
 * Class representation of the Square
 * 
 */
public class Square {
	
	private final Map<String, Square> BIND_SIDES = new HashMap<String, Square>(4);	
	private int[][] square = new int[Constants.SIDE_SIZE][Constants.SIDE_SIZE];	
	private int[][] original = new int[Constants.SIDE_SIZE][Constants.SIDE_SIZE];
	
	private int number;
	
	public Square(int number, int[][] square) {
		this.square = square;
		createOriginal();
		this.number = number;
	}

	private void createOriginal() {
		//create original
		for(int i = 0;i<square[0].length;i++) {
			for(int j = 0;j<square.length;j++) {
				original[i][j] = square[i][j];
			}
		}
	}
	
	public void reset() {
		for(int i = 0;i<square[0].length;i++) {
			for(int j = 0;j<square.length;j++) {
				square[i][j] = original[i][j];
			}
		}
		BIND_SIDES.clear();
	}
	

	
	public void printOriginal() {
		for(int i = 0;i<original[0].length;i++) {
			for(int j = 0;j<original.length;j++) {
				System.out.printf("%2c ", getChar(original[i][j]));
			}
			System.out.println();
		}
	}
	
	
	public void print() {
		for(int i = 0;i<square[0].length;i++) {
			for(int j = 0;j<square.length;j++) {
				System.out.printf("%2c ",getChar(square[i][j]));
			}
			System.out.println();
		}
	}
	/**
	 * get number of Square
	 * 
	 * @return Square
	 */
	public int getNumber() {
		return number;
	}
	
	
	public void transposition() {
		int[][] trans, originalTrans;
		trans = new int[Constants.SIDE_SIZE][Constants.SIDE_SIZE];
		originalTrans = new int[Constants.SIDE_SIZE][Constants.SIDE_SIZE];
		for(int i=0; i<Constants.SIDE_SIZE; ++i) {
			for(int j=0; j<Constants.SIDE_SIZE; ++j) {
				trans[j][i] = square[i][j];
				originalTrans[j][i] = original[i][j];
			}	
		}	
		original = originalTrans;
		square = trans; 
	}
	
	public void rotate() {
		int[][] rotated, rotateOriginal;
		rotated = new int[Constants.SIDE_SIZE][Constants.SIDE_SIZE];
		rotateOriginal = new int[Constants.SIDE_SIZE][Constants.SIDE_SIZE];
		int r = 0, c = 0;
		for (int i = Constants.SIDE_SIZE - 1; i >= 0; i--) {
			for (int j = 0; j < Constants.SIDE_SIZE; j++) {
				rotated[j][i] = square[r][c];
				rotateOriginal[j][i] = original[r][c];
				c++;
			}	
			c = 0; r++;
		}
		original =  rotateOriginal;
		square = rotated;
	}	
	
	public int[][] getSquare() {
		return square;
	}
	
	public int[][] getOriginal() {
		return original;
	}
	
	public int[] getTop() {
		int[] side = new int[Constants.SIDE_SIZE];
		for(int j = 0;j<square.length;j++) {
			side[j] = square[0][j];
		}
		return side;
	}
	
	public int[] getLeft() {
		int[] side = new int[Constants.SIDE_SIZE];
		int c = 0;
		for(int j = square.length-1;j>=0;j--) {
			side[c++] = square[j][0];
		}	
		return side;
	}
	
	public int[] getRight() {
		int[] side = new int[Constants.SIDE_SIZE];
		int c = 0;
		for(int j = square.length-1;j>=0;j--) {
			side[c++] = square[j][square.length-1];
		}
		return side;
	}
	
	public int[] getBottom() {
		int[] side = new int[Constants.SIDE_SIZE];
		for(int j = 0;j<square.length;j++) {
			side[j] = square[square.length-1][j];
		}
		return side;
	}
	
	/**
	 * get bind of thw square
	 * @param side
	 * @return Square
	 */
	public Square getBind(String side) {
		return this.BIND_SIDES.get(side);
	}
	
	/**
	 * Save bind od the Square
	 * 
	 * @param side - aliase square
	 * @param s - square
	 */
	public void saveBind(String side, Square s) {
        this.BIND_SIDES.put(side, s);
        
        if("top".equals(side)) {
        	for(int j = 1;j<square.length-1;j++) {
        		square[0][j] = 1;
        	}
        } else if("bottom".equals(side)) {
        	for(int j = 1;j<square.length-1;j++) {
        		square[square.length-1][j] = 1;
        	}        
        } else if("left".equals(side)) {
        	for(int j = square.length-2;j>=1;j--) {
        		square[j][0] = 1;
        	}        
        } else if("right".equals(side)) {
        	for(int j = square.length-2;j>=1;j--) {
        		square[j][square.length-1] = 1;
        	}
        }
	}
	
	
	
	@Override
	public String toString() {
		return "Square [Number] ="+getNumber()+" [left] ="+Arrays.toString(this.getLeft())+",[right] = "+Arrays.toString(this.getRight())+", [bottom] ="+Arrays.toString(this.getBottom())+", [top]="+Arrays.toString(this.getTop());
	}

	private char getChar(int element) {
		return element == 1 ? 'o' : ' ';
	}

	
	public void printUnfolded(String solution) {
		int size = Constants.SIDE_SIZE;
		
		int[][] top = BIND_SIDES.containsKey("top") ? BIND_SIDES.get("top").getOriginal() : null;
		int[][] right = BIND_SIDES.containsKey("right") ? BIND_SIDES.get("right").getOriginal() : null;
		int[][] left = BIND_SIDES.containsKey("left") ? BIND_SIDES.get("left").getOriginal() : null;
		
		int[][] mirrorThis = null;		
		if(BIND_SIDES.containsKey("right")) {
			if(BIND_SIDES.get("right").BIND_SIDES.containsKey("right")) {
				mirrorThis = BIND_SIDES.get("right").BIND_SIDES.get("right").getOriginal();
				
			}
		}
		
		int[][] bottom = BIND_SIDES.containsKey("bottom") ? BIND_SIDES.get("bottom").getOriginal() : null;
				
		StringBuffer sb = new StringBuffer();
		
		if(top != null) {
			for(int i = 0;i<top[0].length;i++) {
				for(int j = 0;j<top.length;j++) {
					sb.append(Constants.EMPTY).append(getChar(top[i][j]));
				}
			sb.append("\n");
			}
		}
		
		for(int i = 0;i<size;i++) {
			for(int j = 0;j<size;j++) {
				sb.append(Constants.EMPTY).append(getChar(original[i][j]));
			}
			sb.append(Constants.EMPTY).append(Constants.SEPARATOR);
			if(right !=null) {	
				for(int j = 0;j<size;j++) {
					sb.append(Constants.EMPTY).append(getChar(right[i][j]));
				}
			} else {
				for(int j = 0;j<size;j++) {
					sb.append(Constants.EMPTY).append(Constants.SPACE);
				}
			}
			sb.append(Constants.EMPTY).append(Constants.SEPARATOR);
			if(mirrorThis  !=null) {
				for(int j = 0;j<size;j++) {
					sb.append(Constants.EMPTY).append(getChar(mirrorThis[i][j]));
				}
			}  else {
				for(int j = 0;j<size;j++) {
					sb.append(Constants.EMPTY).append(Constants.SPACE);
				}
			}
			sb.append(Constants.EMPTY).append(Constants.SEPARATOR);
			if(left !=null) {
				for(int j = 0;j<size;j++) {
					sb.append(Constants.EMPTY).append(getChar(left[i][j]));
				}
			} else {
				for(int j = 0;j<size;j++) {
					sb.append(Constants.EMPTY).append(Constants.SPACE);
				}
			}
			sb.append("\n");
		}
		
		if(bottom != null) {
			for(int i = 0;i<bottom[0].length;i++) {
				for(int j = 0;j<bottom.length;j++) {
					sb.append(Constants.EMPTY).append(getChar(bottom[i][j]));
				}
				sb.append("\n");
			}
		}
		sb.append("\n");
		
		saveToFile(sb.toString());
		System.out.println(sb.toString());
		if("one".equals(solution))
			System.exit(1);
	}
	
	
	private void saveToFile(String report) {
		if(!Files.exists(new File("report.log").toPath())) {
			try {
				Files.write(new File("report.log").toPath(), report.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("report.log", true)))) {
				out.println(report);
			}catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
	
}