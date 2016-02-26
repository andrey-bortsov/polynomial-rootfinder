/**
* The Polynomial class for the Polynomial object.
* 
* @author Andrey Bortsov
*/
public class Polynomial {
	
	/** Constant representing max size of polynomial*/
    private static final int MAXPOWER = 10;
    
    /** Array to store polynomial coefficients*/
	private double[] poly;

	/** Counter to track filled slots in array*/
	private int currentCoeffIndex;
	
	/** Constant tolerance to determine if two doubles are equal*/
	private static final double TOLERANCE = 0.0001;

	/**
	* Constructor for the Polynomial object.
	* Initializes the array of length specified in the constant MAXPOWER.
	* Initializes the counter currentCoeffIndex at zero, which keeps track of 
	* filled slots of the array.
	*/	
	public Polynomial() {
		 poly = new double[MAXPOWER];
		 currentCoeffIndex = 0;
	}

	/**
	* Add a new coefficient to the coefficient array. Keeps track of the portion
	* of the array that is filled and add any new coefficient into the next unfilled slot.
	* Any coefficient that overfills the array is ignored.
	* @param newCoefficient value to add to the array 
	*/
	public void addCoefficient(double newCoefficient) {
		if (this.currentCoeffIndex < MAXPOWER) {
			this.poly[currentCoeffIndex] = newCoefficient;
			this.currentCoeffIndex += 1;
		}
	}

	/**
	* Simply returns the array of polynomial coefficients
	* @return double array of polynomial coefficients
	*/	
	public double [] getPolynomial() {
		return this.poly;
	}
	
	/**
	* Creates and returns the polynomial formula
	* @return string object representing the polynomial  formula in a form  
	*         -4.0 x^3 + 2.0 x^2 - 5.2 x^1 + 1.0 x^0
	*         terms with zero coefficients are omitted
	*/	
	public String toString() {
		String polyString = "";
		for (int i = currentCoeffIndex-1; i >= 0; i--) {
			double coeff = this.poly[i];
			String sign;
			String oneSpace = " ";
			
			if (coeff >= 0) {
				sign = "+";
			} else {
				sign = "-";
			}
			if (coeff != 0) {
				if (polyString == "") {
					oneSpace = "";
					if (sign == "+") {
						sign = "";
					}
				} else {
					oneSpace = " ";
				}
				polyString = polyString + oneSpace + sign + oneSpace + Math.abs(coeff) + " x^" + i;
			}
		}
		return polyString;
	}

	/**
	* Computes and returns the value of the polynomial using the given number
	* @param x value used to calculate the polynomial
	* @return computed value of polynomial using given number
	*/
	public double getValue(double x) {
		double sum = 0;
		for (int i = 0; i <= (currentCoeffIndex-1); i++) {
			sum = sum + Math.pow(x, i)*this.poly[i];
		}
		return sum;
	}
	
	
	/**
	* Finds roots at or between specified bounds, uses TOLERANCE constant to approximate zero
	* @param lower bound
	* @param upper bound
	* @return integer code for found roots at or between bounds
	*                 2 if roots are found at both bounds
	*                -1 if root is found at lower bound
	*                 1 if root is found at upper bound
	*                 0 if root is found between bounds
	*                -2 if no roots at or between two bounds
	*/
	public int findRoot(double lower, double upper) {
		if (Math.abs(lower - 0) < TOLERANCE && Math.abs(upper - 0) < TOLERANCE) {
			return 2;
		} else if (Math.abs(lower - 0) < TOLERANCE) {
			return -1;
		} else if (Math.abs(upper - 0) < TOLERANCE) {
			return 1;
		} else if (lower*upper < 0) {
			return 0;
		} else {
			return -2;
		}
	}

}
