package app.cubes.util;

public class ResolverUtils {
	
	public static boolean isEqualSide(int[] array1, int[]  array2) {
		if(((array1[1]+array2[1]) == 1) && ((array1[2]+array2[2]) == 1) && ((array1[3]+array2[3]) == 1)) {
			if(((array1[0]+array2[0]) < 2) && ((array1[4]+array2[4]) < 2)) 
				return true;
		}
		return false;
	}
	
	public static boolean isEqualSideRevers(int[] normal, int[]  revers) {
		if(((normal[1]+revers[3]) == 1) && ((normal[2]+revers[2]) == 1) && ((normal[3]+revers[1]) == 1)) {
			if(((normal[0]+revers[4]) < 2) &&  ((normal[4]+revers[0]) < 2))
				return true;
		}
		return false;
	}
}
