package app.cubes.core;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import app.cubes.models.Square;
import app.cubes.utils.Constants;
import app.cubes.utils.Utils;
/**
 * 
 * Base class for building of cube
 *
 */
public class Cube {
	
	private Map<Integer, Square> happyElements;
	private List<Integer[]> listPositions = new ArrayList<>();
	private String solution;
	public Cube(Map<Integer, Square> happyElements, String solution) {
		this.solution = solution;
		this.happyElements = happyElements;
	}

	private void prepareReportFile() {
		try {
			Files.deleteIfExists(new File("report.log").toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	*  building of cube is
	*/
	public void build() {
		prepareReportFile();
		getVariant(new Integer[]{1,2,3,4,5,6}, 6);
		for(Integer[] positions : listPositions) {
			searchCubes(positions);
		}
	}
	
	/**
	 * Method search cubes 
	 * 
	 * @param positions - positions of the square
	 */
	private void searchCubes(Integer[] positions) {
			resetAll();			
			Square side = getSquare(positions[0]);
			Square right = getSquare(positions[1]);
			Square rightNext = getSquare(positions[2]);
			Square rightNextNext = getSquare(positions[3]);
			Square top = getSquare(positions[4]);
			Square bottom = getSquare(positions[5]);
			
			int trnspSide = 0;
			//transposition of SIDE
			while(trnspSide < Constants.TRANSPOSITION_COUNTER) {
				int rotateSide = 0;	
				//search sides by SIDE
				while(rotateSide < Constants.ROTATE_COUNTER) {
							int trnspRight = 0;
							//transposition of RIGHT
							while(trnspRight < Constants.TRANSPOSITION_COUNTER) {
								int rotateRight = 0;	
								//search sides by RIGHT
								while(rotateRight < Constants.ROTATE_COUNTER) {
									int trnspRightNext = 0;
									//transposition of RIGHT_NEXT
									while(trnspRightNext < Constants.TRANSPOSITION_COUNTER) {
										int rotateRightNext = 0;	
										//search sides by RIGHT_NEXT
										while(rotateRightNext < Constants.ROTATE_COUNTER) {
											int trnspRightNextNext = 0;
											//transposition of RIGHT_NEXT_NEXT
											while(trnspRightNextNext < Constants.TRANSPOSITION_COUNTER) {
												int rotateRightNextNext = 0;	
												//search sides by RIGHT_NEXT_NEXT
												while(rotateRightNextNext < Constants.ROTATE_COUNTER) {
													int trnspTop = 0;
													//transposition of TOP
													while(trnspTop < Constants.TRANSPOSITION_COUNTER) {
														int rotateTop = 0;	
														//search sides by TOP
														while(rotateTop < Constants.ROTATE_COUNTER) {
															int trnspBottom = 0;
															//transposition of BOTTOM
															while(trnspBottom < Constants.TRANSPOSITION_COUNTER) {
																int rotateBottom = 0;	
																//search sides by BOTTOM
																while(rotateBottom < Constants.ROTATE_COUNTER) {
																	
																	//condition
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
																	if(Utils.isEqualSide(side.getTop(), top.getBottom()) && 
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
																			Utils.isEqualSideRevers(right.getBottom(), bottom.getRight()) &&	
																			Utils.isEqualSideRevers(rightNext.getBottom(), bottom.getBottom()) &&
																			Utils.isEqualSide(rightNextNext.getBottom() , bottom.getLeft()) &&
																				(side.getBottom()[4]+right.getLeft()[0]+bottom.getTop()[4])==1 &&
																				(right.getBottom()[4]+rightNext.getLeft()[0]+bottom.getRight()[0]) == 1 &&
																				(rightNext.getBottom()[4]+rightNextNext.getLeft()[0]+bottom.getBottom()[0]) == 1 &&
																				(rightNextNext.getBottom()[4]+side.getLeft()[0]+bottom.getTop()[0]) == 1) {
																			
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
																	if(countEqual == 5) {
																		//print cube
																		side.printUnfolded(solution);
																		resetAll();
																	} else {
																		resetAll();
																	}
																		
																	rotateBottom++;
																	bottom.rotate();
																}//search sides by BOTTOM
																	
																if(trnspBottom == 0)
																	bottom.transposition();
																
																trnspBottom++;
															}//transposition of BOTTOM
																
														rotateTop++;
														top.rotate();
														}//search sides by TOP
														
														if(trnspTop == 0)
															top.transposition();
															
														trnspTop++;
													}//transposition of TOP
												rotateRightNextNext++;
												rightNextNext.rotate();
												}//search sides by RIGHT_NEXT_NEXT
												
												if(trnspRightNextNext == 0)
													rightNextNext.transposition();
												
												trnspRightNextNext++;
											}//transposition of RIGHT_NEXT_NEXT
										rotateRightNext++;
										rightNext.rotate();
										}//search sides by RIGHT_NEXT
											
										if(trnspRightNext == 0)	
											rightNext.transposition();
										
										trnspRightNext++;
									}//transposition of RIGHT_NEXT
									rotateRight++;
									right.rotate();
								}//search sides by RIGHT
									
								if(trnspRight == 0)	
									right.transposition();
								
								trnspRight++;
							}//transposition of RIGHT
					side.rotate();
					rotateSide++;
					}//search sides by SIDE
				if(trnspSide == 0)
					side.transposition();
				
				trnspSide++;
			 }//search side by SIDE			
				
	}
	/**
	 * Methos return one Square
	 * @param key key of the map
	 * @return Square
	 */
	private Square getSquare(Integer key) {
		return happyElements.get(key);
	}
	
	/**
	 * Methos reset state of the cobes
	 */
	public void resetAll() {
		for(int i = 1;i<=6;i++) {
			this.getSquare(i).reset();
		}
	}
	/**
	 * Get all combination(permutation) from array
	 * @param source array
	 * @param length - count elements
	 */
	private void getVariant(Integer[] array, int length) {
		if (length == 1) {
			Integer[] copy = Arrays.copyOf(array, array.length);
			listPositions.add(copy);
				return;
		}
		for (int i = 0; i < length; i++) {
			change(array, i, length-1);
			getVariant(array, length-1);
			change(array, i, length-1);
		}
	}


	private void change(Integer[] array, int i, int j) {
		int v;
		v = array[i]; 
		array[i] = array[j]; 
		array[j] = v;
	}
}
