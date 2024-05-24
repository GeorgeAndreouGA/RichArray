package hw1;
/*
* A brief summary about this class.
* Takes a 2d array and makes it immutable.You can call methods to generate a new 
* immutable array based on the one you created but the array you've created is not going to change!!!
*
* @author George Andreou
* @since 13/2/15
* @see Homeworks.hw1.RichArrayTest
*/

public class RichArray {
	private int[][] pin2D;

	/**
	 * Constructs a new RichArray object. Initializes the array with dimensions
	 * [1][3] and fills it with default values.
	 */
	public RichArray() {
		int[][] array = new int[1][3];
		this.fill2D(array);
	}

	/**
	 * Constructs a new RichArray object with the provided 2D array. Initializes the
	 * 'pin2D' attribute with the same dimensions as the provided array and fills it
	 * with default values. If the provided array is correctly dimensioned, it fills
	 * the 'pin2D' array with values from the provided array. If an error occurs
	 * during filling, it catches the exception and prints an error message.
	 * 
	 * @param array The 2D array to initialize the 'pin2D' array with.
	 * @throws NullPointerException           if the provided array is null.
	 * @throws ArrayIndexOutOfBoundsException if the provided array has invalid
	 *                                        dimensions.
	 */

	public RichArray(int[][] array) {

		pin2D = new int[array.length][array[0].length];
		if (this.isCorrect2d())
			fill2D(array);
		else
			throw new IllegalArgumentException("An error occurred while filling the array: ");

	}

	/**
	 * Constructs a new RichArray object with the provided 1D array. Initializes the
	 * 'pin2D' attribute with the same dimensions as the provided array and fills it
	 * with default values. If the provided array is correctly dimensioned, it fills
	 * the 'pin2D' array with values from the provided array. If an error occurs
	 * during filling, it catches the exception and prints an error message.
	 * 
	 * @param array The 1D array to initialize the 'pin2D' array with.
	 * @throws NullPointerException           if the provided array is null.
	 * @throws ArrayIndexOutOfBoundsException if the provided array has invalid
	 *                                        dimensions.
	 */
	public RichArray(int[] array) {
		pin2D = new int[1][array.length];
		if (this.isCorrect2d())
			this.fill1D(array);
		else
			throw new IllegalArgumentException("An error occurred while filling the array: ");

	}

	/**
	 * Fills the 'pin2D' attribute with values from the provided 1D array.
	 * 
	 * @param array The 1D array containing values to fill the 'pin2D' attribute
	 *              with.
	 */
	private void fill1D(int[] array) {
		for (int j = 0; j < this.pin2D[0].length; j++)
			this.pin2D[0][j] = array[j];
	}

	/**
	 * Checks if the 'pin2D' attribute has correct dimensions.
	 * 
	 * @return True if the dimensions are correct, False otherwise.
	 */
	private boolean isCorrect2d() {
		if ((this.pin2D.length == 1 && this.pin2D[0].length == 1)
				|| (this.pin2D.length == 0 && this.pin2D[0].length == 0))
			return false;
		return true;
	}

	/**
	 * Fills the 'pin2D' attribute with values from the provided 2D array.
	 * 
	 * @param pin The 2D array containing values to fill the 'pin2D' attribute with.
	 */
	private void fill2D(int[][] pin) {
		for (int i = 0; i < this.pin2D.length; i++)
			for (int j = 0; j < this.pin2D[i].length; j++)
				this.pin2D[i][j] = pin[i][j];
	}

	/**
	 * Creates a new RichArray object with its rows reversed compared to the
	 * original RichArray.
	 * 
	 * @return A new RichArray object with reversed rows.
	 */
	public RichArray reverse() {
		RichArray reverse = new RichArray(this.pin2D);
		int k = 0, s = 0;
		for (int i = 0; i < this.pin2D.length; i++) {
			s = 0;
			for (int j = this.pin2D[i].length - 1; j >= 0; j--) {
				reverse.pin2D[k][s] = this.pin2D[i][j];
				s++;
			}
			k++;
		}
		return reverse;
	}

	/**
	 * Creates a new RichArray object with its elements rotated 90 degrees to the
	 * right.
	 * 
	 * @return A new RichArray object with elements rotated 90 degrees to the right.
	 */
	public RichArray rotateRight() {
		int[][] pin = new int[this.pin2D[0].length][this.pin2D.length];
		RichArray rotateRight = new RichArray(pin);
		int k = 0, s = 0;
		for (int i = this.pin2D.length - 1; i >= 0; i--) {
			k = 0;
			for (int j = 0; j < this.pin2D[i].length; j++) {
				rotateRight.pin2D[k][s] = this.pin2D[i][j];
				k++;
			}
			s++;
		}
		return rotateRight;
	}

	/**
	 * Creates a new RichArray object with its elements rotated 90 degrees to the
	 * left.
	 * 
	 * @return A new RichArray object with elements rotated 90 degrees to the left.
	 */

	public RichArray rotateLeft() {
		int[][] pin = new int[this.pin2D[0].length][this.pin2D.length];
		RichArray rotateLeft = new RichArray(pin);
		int k = 0, s = 0;
		for (int i = 0; i < this.pin2D.length; i++) {
			k = 0;
			for (int j = this.pin2D[i].length - 1; j >= 0; j--) {
				rotateLeft.pin2D[k][s] = this.pin2D[i][j];
				k++;
			}
			s++;
		}
		return rotateLeft;
	}

	/**
	 * Creates a new RichArray object with its rows and columns transposed.
	 * 
	 * @return A new RichArray object with transposed rows and columns.
	 */
	public RichArray transpose() {
		int[][] pin = new int[this.pin2D[0].length][this.pin2D.length];
		RichArray transpose = new RichArray(pin);
		int k = 0, s = 0;
		for (int i = 0; i < this.pin2D.length; i++) {
			k = 0;
			for (int j = 0; j < this.pin2D[i].length; j++) {
				transpose.pin2D[k][s] = this.pin2D[i][j];
				k++;
			}
			s++;
		}
		return transpose;
	}

	/**
	 * Creates a new RichArray object by reshaping the original RichArray into a
	 * specified number of columns.
	 * 
	 * @param n The number of columns to reshape the original RichArray into.
	 * @return A new RichArray object with reshaped columns.
	 * @throws it handles the cases where the number of lines must be only 1 or when
	 *            the calculated number of columns is not an integer by printing
	 *            error messages and returning new RichArray objects with the same
	 *            dimensions but filled with zeros.
	 */
	public RichArray ravel(int n) {
		double lines = 0;
		int k = 0, s = 0, plith = 1;
		if (this.pin2D.length > 1) {
			System.out.println("can not create ravel.Lines must be only 1!!!");
			int[][] blankArray = new int[this.pin2D.length][this.pin2D[0].length];
			return new RichArray(blankArray);
		} else {
			lines = (double) this.pin2D[0].length / n;
			if (lines - (int) lines != 0) {
				System.out.println("can't create ravel.Columns/n are not integer.");
				int[][] blankArray = new int[this.pin2D.length][this.pin2D[0].length];
				return new RichArray(blankArray);
			} else {
				int[][] pin = new int[(int) lines][n];

				RichArray ravel = new RichArray(pin);
				for (int i = 0; i < this.pin2D.length; i++)
					for (int j = 0; j < this.pin2D[i].length; j++) {
						ravel.pin2D[k][s] = this.pin2D[i][j];
						s++;
						plith++;
						if (plith > n) {
							k++;
							s = 0;
							plith = 1;
						}
					}

				return ravel;
			}
		}
	}

	/**
	 * Creates a new RichArray object by converting a 2D array into a 1D array.
	 * 
	 * @return A new RichArray object with elements converted to a 1D array.
	 * @throws It handles the case where the original RichArray has only one row by
	 *            printing an error message and returning a new RichArray object
	 *            with the same dimensions but filled with zeros.
	 */

	public RichArray unravel() {
		int k = 0, s = 0;
		if (this.pin2D.length == 1) {
			System.out.println("can not create unravel.Lines must be >1!!!");
			int[][] blankArray = new int[this.pin2D.length][this.pin2D[0].length];
			return new RichArray(blankArray);

		} else {
			int[][] pin = new int[1][this.pin2D.length * this.pin2D[0].length];
			RichArray unravel = new RichArray(pin);
			for (int i = 0; i < this.pin2D.length; i++)
				for (int j = 0; j < this.pin2D[i].length; j++) {
					unravel.pin2D[k][s] = this.pin2D[i][j];
					s++;
				}
			return unravel;
		}
	}

	/**
	 * Reshapes the original RichArray into a new shape with a specified number of
	 * columns.
	 * 
	 * @param n The number of columns for the new shape.
	 * @return A new RichArray object with reshaped elements.
	 * @throws It handles the cases where the number of lines must be greater than 1
	 *            or when the calculated number of lines is not an integer by
	 *            printing error messages and returning new RichArray objects with
	 *            the same dimensions but filled with zeros.
	 */
	public RichArray reshape(int n) {
		int k = 0, s = 0, plith = 1;
		double lines = 0;
		if (this.pin2D.length == 1) {
			System.out.println("can not create reshape.Lines must be >1!!!");
			int[][] blankArray = new int[this.pin2D.length][this.pin2D[0].length];
			return new RichArray(blankArray);
		} else {
			lines = (double) (this.pin2D.length * this.pin2D[0].length) / n;
			if (lines - (int) lines != 0) {
				System.out.println("can't create reashape.(Lines*columns)/n must give an intiger");
				int[][] blankArray = new int[this.pin2D.length][this.pin2D[0].length];
				return new RichArray(blankArray);
			} else {
				int[][] pin = new int[(int) lines][n];

				RichArray reshape = new RichArray(pin);

				for (int i = 0; i < this.pin2D.length; i++)
					for (int j = 0; j < this.pin2D[i].length; j++) {
						reshape.pin2D[k][s] = this.pin2D[i][j];
						s++;
						plith++;
						if (plith > n) {
							k++;
							s = 0;
							plith = 1;
						}
					}
				return reshape;
			}
		}
	}

	/**
	 * Joins the elements of another RichArray to the current RichArray, creating a
	 * new RichArray with concatenated columns.
	 * 
	 * @param array The RichArray to join with the current RichArray.
	 * @return A new RichArray object with joined elements.
	 * @throws error message and return a new RichArray with the same dimensions but
	 *               filled with zeros when rows are not the same
	 */
	public RichArray join(RichArray array) {
		int k = 0, s = 0;
		if (this.pin2D.length != array.pin2D.length) {
			System.out.println("can not create join.Lines must be the same!!!");
			int[][] blankArray = new int[this.pin2D.length][this.pin2D[0].length];
			return new RichArray(blankArray);
		} else {
			int[][] pin = new int[this.pin2D.length][this.pin2D[0].length + array.pin2D[0].length];
			RichArray join = new RichArray(pin);

			for (int i = 0; i < this.pin2D.length; i++) {
				s = 0;
				for (int j = 0; j < this.pin2D[i].length; j++) {
					join.pin2D[k][s] = this.pin2D[i][j];
					s++;
				}
				k++;
			}
			k = 0;
			for (int i = 0; i < array.pin2D.length; i++) {
				s = this.pin2D[i].length;
				for (int j = 0; j < array.pin2D[i].length; j++) {
					join.pin2D[k][s] = array.pin2D[i][j];
					s++;
				}
				k++;
			}
			return join;
		}
	}

	/**
	 * Stacks another RichArray on top of the current RichArray, creating a new
	 * RichArray with concatenated rows.
	 * 
	 * @param array The RichArray to stack on top of the current RichArray.
	 * @return A new RichArray object with stacked elements.
	 * @throws error messages and returning a new RichArray with the same dimensions
	 *               but filled with zeros when the condition for stacking is not
	 *               met.Columns Mismatch Exception: If the number of columns in the
	 *               current RichArray (this.pin[0].length) is not equal to the
	 *               number of columns in the provided RichArray
	 *               (array.pin[0].length), it prints an error message indicating
	 *               that columns must be the same and returns a new RichArray with
	 *               the same dimensions but filled with zeros.
	 */
	public RichArray stack(RichArray array) {
		if (this.pin2D[0].length != array.pin2D[0].length) {
			throw new IllegalArgumentException("can't create stack columns must be the same");
		} else {
			int k = 0, s = 0;
			int[][] pin = new int[this.pin2D.length + array.pin2D.length][this.pin2D[0].length];
			RichArray stack = new RichArray(pin);

			for (int i = 0; i < this.pin2D.length; i++) {
				s = 0;
				for (int j = 0; j < this.pin2D[i].length; j++) {
					stack.pin2D[k][s] = this.pin2D[i][j];
					s++;
				}
				k++;
			}

			k = this.pin2D.length;
			for (int i = 0; i < array.pin2D.length; i++) {
				s = 0;
				for (int j = 0; j < array.pin2D[i].length; j++) {
					stack.pin2D[k][s] = array.pin2D[i][j];
					s++;
				}
				k++;
			}
			return stack;

		}
	}

	/**
	 * Creates a new RichArray object by slicing a portion of the original
	 * RichArray.
	 * 
	 * @param firstRow    The index of the first row to include in the slice.
	 * @param lastRow     The index of the last row to include in the slice.
	 * @param firstColumn The index of the first column to include in the slice.
	 * @param lastColumn  The index of the last column to include in the slice.
	 * @return A new RichArray object representing the sliced portion of the
	 *         original RichArray.
	 * @throws It handles cases where the provided indices are not valid or in range
	 *            by printing error messages and returning new RichArray objects
	 *            with the same dimensions but filled with zeros.
	 */
	public RichArray slice(int firstRow, int lastRow, int firstColumn, int lastColumn) {
		if ((firstRow > lastRow) || (firstColumn > lastColumn)) {
			System.out.println("firstRow must be < lastRow and firstColumn must be < lastColumn");
			int[][] blankArray = new int[this.pin2D.length][this.pin2D[0].length];
			return new RichArray(blankArray);
		} else if (((firstRow < 0) || (firstRow >= this.pin2D.length))
				|| ((lastRow < 0) || (lastRow >= this.pin2D.length))
				|| ((firstColumn < 0) || (firstColumn >= this.pin2D[0].length))
				|| ((lastColumn < 0) || (lastColumn >= this.pin2D[0].length))) {
			System.out.println("give dimeniton that are in range");
			int[][] blankArray = new int[this.pin2D.length][this.pin2D[0].length];
			return new RichArray(blankArray);
		} else {
			int plithLines = 0, plithColumns = 0, k = 0, s = 0;

			for (int i = firstRow; i <= lastRow; i++)
				plithLines++;
			for (int j = firstColumn; j <= lastColumn; j++)
				plithColumns++;
			int[][] pin = new int[plithLines][plithColumns];
			RichArray slice = new RichArray(pin);

			for (int i = firstRow; i <= lastRow; i++) {
				s = 0;
				for (int j = firstColumn; j <= lastColumn; j++) {
					slice.pin2D[k][s] = this.pin2D[i][j];
					s++;
				}
				k++;
			}
			return slice;
		}
	}

	/**
	 * Replaces a portion of the original RichArray with the content of another
	 * RichArray starting from the specified row and column.
	 * 
	 * @param array  The RichArray containing the content to replace with.
	 * @param row    The starting row index for replacement.
	 * @param column The starting column index for replacement.
	 * @return A new RichArray object with the specified portion replaced.
	 * @throws handles cases where the provided row and column indices are not in
	 *                 range or where the replacement array has larger dimensions
	 *                 than the portion to replace by printing error messages and
	 *                 returning new RichArray objects with the same dimensions but
	 *                 filled with zeros.
	 */
	public RichArray replace(RichArray array, int row, int column) {
		if (((row < 0) || (row >= this.pin2D.length)) || ((column < 0) || (column >= this.pin2D[0].length))) {
			System.out.println("give dimeniton that are in range");
			int[][] blankArray = new int[this.pin2D.length][this.pin2D[0].length];
			return new RichArray(blankArray);
		} else {
			int plithRow = 0, plithColumn = 0;

			for (int i = row; i < this.pin2D.length; i++)
				plithRow++;
			for (int j = column; j < this.pin2D[0].length; j++)
				plithColumn++;

			if ((plithRow < array.pin2D.length) || (plithColumn < array.pin2D[0].length)) {
				System.out.println("The array you want to replace with has larger dm for the given row and column.");
				int[][] blankArray = new int[this.pin2D.length][this.pin2D[0].length];
				return new RichArray(blankArray);
			} else {

				RichArray copyArray = new RichArray(this.pin2D);
				int k = 0, s = 0;
				for (int i = 0; i < array.pin2D.length; i++) {
					s = 0;
					for (int j = 0; j < array.pin2D[i].length; j++) {
						copyArray.pin2D[i + row][j + column] = array.pin2D[k][s];
						s++;
					}
					k++;
				}
				return copyArray;
			}
		}
	}

	/**
	 * Returns a string representation of the RichArray object.
	 * 
	 * @return A string representation of the RichArray object.
	 */
	public String toString() {
		String s = "";
		for (int i = 0; i < this.pin2D.length; i++) {
			for (int j = 0; j < this.pin2D[i].length; j++) {
				s += this.pin2D[i][j] + " ";
			}
			s += "\n";
		}
		return s;
	}

}
