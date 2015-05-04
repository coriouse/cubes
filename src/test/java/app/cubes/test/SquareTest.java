 package app.cubes.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import app.cubes.models.Square;
import app.cubes.utils.Utils;

public class SquareTest {

	
	@Test
	public void testSquare() {
		Map<Integer, Square> blueCube = new HashMap<Integer, Square>() {/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{			
			put(1,new Square(1, new int[][]{{0,0,1,0,0}, {0,1,1,1,0}, {1,1,1,1,1}, {0,1,1,1,0}, {0,0,1,0,0}}));
			put(2,new Square(2, new int[][]{{1,0,1,0,1}, {1,1,1,1,1}, {0,1,1,1,0}, {1,1,1,1,1}, {1,0,1,0,1}}));
			put(3,new Square(3, new int[][]{{0,0,1,0,0}, {0,1,1,1,1}, {1,1,1,1,0}, {0,1,1,1,1}, {0,0,1,0,0}}));
			put(4,new Square(4, new int[][]{{0,1,0,1,0}, {1,1,1,1,0}, {0,1,1,1,1}, {1,1,1,1,0}, {1,1,0,1,0}}));
			put(5,new Square(5, new int[][]{{0,1,0,1,0}, {1,1,1,1,1}, {0,1,1,1,0}, {1,1,1,1,1}, {1,0,1,0,0}}));
			put(6,new Square(6, new int[][]{{0,1,0,1,0}, {0,1,1,1,1}, {1,1,1,1,0}, {0,1,1,1,1}, {1,1,0,1,1}}));
		}};
		
	
		
		
		assertEquals(1, blueCube.get(1).getNumber());
		assertEquals(2, blueCube.get(2).getNumber());
		assertEquals(3, blueCube.get(3).getNumber());
		assertEquals(4, blueCube.get(4).getNumber());
		assertEquals(5, blueCube.get(5).getNumber());
		assertEquals(6, blueCube.get(6).getNumber());
		
	
		int[][] real = {{0,0,1,0,0}, {0,1,1,1,1}, {1,1,1,1,0}, {0,1,1,1,1}, {0,0,1,0,0}};
		
		boolean isReal = true;
		for(int i = 0;i<5;i++) {
			for(int j = 0;j<5;j++) {
				if(real[i][j] != blueCube.get(3).getOriginal()[i][j]) 
					isReal = false;
			}
			
		}
		assertTrue(isReal);		
		blueCube.get(3).rotate();		
		int[][] rotate = {{0,0,1,0,0}, {0,1,1,1,0}, {1,1,1,1,1}, {0,1,1,1,0}, {0,1,0,1,0} };		
		boolean isRotate = true;
		for(int i = 0;i<5;i++) {
			for(int j = 0;j<5;j++) {
				if(rotate[i][j] != blueCube.get(3).getOriginal()[i][j]) 
					isRotate = false;
			}			
		}
		assertTrue(isRotate);			
		blueCube.get(6).transposition();		
		int[][] transposition = {{0,0,1,0,1}, {1,1,1,1,1}, {0,1,1,1,0}, {1,1,1,1,1}, {0,1,0,1,1} };		
		boolean isTransposition = true;
		for(int i = 0;i<5;i++) {
			for(int j = 0;j<5;j++) {
				if(transposition[i][j] != blueCube.get(6).getOriginal()[i][j]) 
					isTransposition = false;
			}			
		}
		assertTrue(isRotate);
	}
	
	
	
	@Test
	public void testSetBind() {
		Map<Integer, Square> blueCube = new HashMap<Integer, Square>() {
			private static final long serialVersionUID = 1L;
		{			
			put(1,new Square(1, new int[][]{{0,0,1,0,0}, {0,1,1,1,0}, {1,1,1,1,1}, {0,1,1,1,0}, {0,0,1,0,0}}));
			put(2,new Square(2, new int[][]{{1,0,1,0,1}, {1,1,1,1,1}, {0,1,1,1,0}, {1,1,1,1,1}, {1,0,1,0,1}}));
			put(3,new Square(3, new int[][]{{0,0,1,0,0}, {0,1,1,1,1}, {1,1,1,1,0}, {0,1,1,1,1}, {0,0,1,0,0}}));
			put(4,new Square(4, new int[][]{{0,1,0,1,0}, {1,1,1,1,0}, {0,1,1,1,1}, {1,1,1,1,0}, {1,1,0,1,0}}));
			put(5,new Square(5, new int[][]{{0,1,0,1,0}, {1,1,1,1,1}, {0,1,1,1,0}, {1,1,1,1,1}, {1,0,1,0,0}}));
			put(6,new Square(6, new int[][]{{0,1,0,1,0}, {0,1,1,1,1}, {1,1,1,1,0}, {0,1,1,1,1}, {1,1,0,1,1}}));
		}};
		
		
		Square side = blueCube.get(1);
		Square right = blueCube.get(2);
		Square rightNext = blueCube.get(3);
		Square rightNextNext = blueCube.get(4);
		Square top = blueCube.get(6);
		Square bottom = blueCube.get(5);
		
		
		rightNext.rotate();
		rightNext.rotate();
		rightNext.rotate();
		rightNextNext.transposition();
		rightNextNext.rotate();
		rightNextNext.rotate();
		top.rotate();
		bottom.rotate();
		
		int countEqual = 0;
		//search RIGHT
		if(Utils.isEqualSide(side.getRight(), right.getLeft())) {
			side.saveBind("right", right);
			right.saveBind("left", side);
			countEqual++;
		}

		
		//search RIGHT_NEXT
		if(Utils.isEqualSide(right.getRight(), rightNext.getLeft())) {
			right.saveBind("right", rightNext);
			rightNext.saveBind("left", right);
			countEqual++;
		}
		
	
		
		//search RIGHT_NEXT_NEXT
		if(Utils.isEqualSide(rightNext.getRight(), rightNextNext.getLeft()) && 
				Utils.isEqualSide(side.getLeft(), rightNextNext.getRight())) {
			rightNext.saveBind("right", rightNextNext);
			rightNextNext.saveBind("left", rightNext);
			side.saveBind("left", rightNextNext);
			rightNextNext.saveBind("right", side);
			countEqual++;
		}

		//search TOP

		if(	Utils.isEqualSide(side.getTop(), top.getBottom()) && 
			Utils.isEqualSide(right.getTop(), top.getRight()) &&
			Utils.isEqualSideRevers(rightNext.getTop(), top.getTop()) &&
			Utils.isEqualSideRevers(rightNextNext.getTop(), top.getLeft())  &&  
					(side.getTop()[4]+top.getBottom()[4]+right.getLeft()[4])==1 &&
					(right.getTop()[4]+top.getRight()[4]+rightNext.getLeft()[4]) == 1 && 
					(rightNext.getTop()[4]+top.getTop()[0]+rightNextNext.getLeft()[4]) == 1 && 
					(rightNextNext.getRight()[4]+top.getLeft()[0]+side.getTop()[0])==1 ) {
				
				side.saveBind("top", top);
				top.saveBind("bottom", side);				
				right.saveBind("top", top);
				top.saveBind("right", right);				
				rightNext.saveBind("top", top);
				top.saveBind("top", rightNext);				
				rightNextNext.saveBind("top", top);
				top.saveBind("left", rightNextNext);				
				countEqual++;
			}
		
		//search BOTTOM
		if(Utils.isEqualSide(side.getBottom(), bottom.getTop()) &&
			Utils.isEqualSideRevers( right.getBottom(), bottom.getRight()) &&	
			Utils.isEqualSideRevers( rightNext.getBottom(), bottom.getBottom()) &&
			Utils.isEqualSide( rightNextNext.getBottom() , bottom.getLeft()) &&
					(side.getBottom()[4]+right.getLeft()[0]+bottom.getTop()[4])==1 &&
					(right.getBottom()[4]+rightNext.getLeft()[0]+bottom.getRight()[0]) == 1 &&
					(rightNext.getBottom()[4]+rightNextNext.getLeft()[0]+bottom.getBottom()[0]) == 1 &&
					(rightNextNext.getBottom()[4]+side.getLeft()[0]+bottom.getTop()[0]) == 1															
					) {
				side.saveBind("bottom", bottom);
				bottom.saveBind("top", side);
				right.saveBind("bottom", bottom);
				bottom.saveBind("right", right);
				rightNext.saveBind("bottom", bottom);
				bottom.saveBind("bottom", rightNext);	
				rightNextNext.saveBind("bottom", bottom);
				bottom.saveBind("left", rightNextNext);
				countEqual++;
			}
		assertEquals(5, countEqual);
		}
}
