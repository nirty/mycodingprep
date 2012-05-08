package prep.maxsubarray;

import java.io.Console;

public class profitinarray {
	
	public static void main(String[] args)
	{
	    double[] values = { 55.39, 109.23, 48.29, 81.59, 81.58, 105.53, 9.45, 1299.24 };

	    double max = Double.MAX_VALUE, maxDiff = Double.MIN_VALUE, diff = 0;
	    double bottom = values[0];

	    for (int i = 1; i < values.length; i++)
	    {
	        diff += values[i] - values[i - 1];

	        if (diff > maxDiff)
	        {
	            maxDiff = diff;
	            max = values[i];
	        }

	        if (values[i] < bottom)
	        {
	            bottom = values[i];
	            diff = 0;
	        }
	    }

	    System.out.println("Buy at; Sell at" +( max - maxDiff)+" :" + max);
	}

}
