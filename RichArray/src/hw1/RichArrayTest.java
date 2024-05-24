package hw1;

/*
* A brief summary about this class.
* Takes a 2d array and makes it immutable.You can call methods to generate a new 
* immutable array based on the one you created but the array you've created is not going to change!!!
*
* @author George Andreou
* @since 13/2/15
* @see Homeworks.hw1.RichArray
*/
public class RichArrayTest {

	public static void main(String[] args) {
		int[] reverse = { 3, 1, 4, 1, 6 };
		RichArray reverseTest = new RichArray(reverse);
		System.out.println(reverseTest.reverse());
		int[][] reverse2d = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		RichArray reverse2dTest = new RichArray(reverse2d);
		System.out.println(reverse2dTest.reverse());
		int[][] rotateRight = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		RichArray rotateRightTest = new RichArray(rotateRight);
		System.out.println(rotateRightTest.rotateRight());
		int[][] rotateLeft = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		RichArray rotateLeftTest = new RichArray(rotateLeft);
		System.out.println(rotateLeftTest.rotateLeft());
		int[][] transpose = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		RichArray transposeTest = new RichArray(transpose);
		System.out.println(transposeTest.transpose());
		int[] ravel = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		int n = 4;
		RichArray ravelTest = new RichArray(ravel);
		ravelTest = ravelTest.ravel(n);
		System.out.println(ravelTest);
		int[][] unravel = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		RichArray unravelTest = new RichArray(unravel);
		System.out.println(unravelTest.unravel());
		int[][] reshape = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		n = 6;
		RichArray reshapeTest = new RichArray(reshape);
		reshapeTest = reshapeTest.reshape(n);
		System.out.println(reshapeTest);
		int[][] joinLeft = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] joinRight = { { 10, 20, 30, 40 }, { 50, 60, 70, 80 } };
		RichArray joinTestLeft = new RichArray(joinLeft);
		RichArray joinTestRight = new RichArray(joinRight);
		RichArray joinTest = joinTestLeft.join(joinTestRight);
		System.out.println(joinTest);
		int[][] stackTop = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
		int[] stackBottom = { 10, 20, 30, 40 };
		RichArray stackTestTop = new RichArray(stackTop);
		RichArray stackTestBottom = new RichArray(stackBottom);
		RichArray stackTest = stackTestTop.stack(stackTestBottom);
		System.out.println(stackTest);
		int[][] slice = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		int firstRow = 1, lastRow = 2, firstColumn = 2, lastColumn = 3;
		RichArray sliceTest = new RichArray(slice);
		sliceTest = sliceTest.slice(firstRow, lastRow, firstColumn, lastColumn);
		System.out.println(sliceTest);
		int[][] replaceOriginal = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 },
				{ 16, 17, 18, 19, 20 } };
		int[][] replaceAt = { { 55, 66, 77 }, { 88, 99, 100 } };
		int row = 1, column = 2;
		RichArray replaceTestOriginal = new RichArray(replaceOriginal);
		RichArray replaceTestAt = new RichArray(replaceAt);
		RichArray replaceTest = replaceTestOriginal.replace(replaceTestAt, row, column);
		System.out.println(replaceTest);
	}
}
