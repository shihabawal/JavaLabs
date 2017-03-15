public class StatisticalAlgorithms 
{
	public static double Error (double distance, double tolerance)
	{
		return (Math.abs (tolerance - distance) / Math.abs (distance));
	}
	
	public static double Average (double [] numbers)
	{
		if (numbers.length == 0)
		{
			return 0;
		}
		double average = 0;
		int index;
		for (index = 0; index < numbers.length; index = index + 1)
		{
			average = average + numbers [index];
		}
		average = average / (numbers.length * 1.0);
		return average;
	}
	
	public static double StandardDeviation (double [] numbers)
	{
		if (numbers.length == 0)
		{
			return 0;
		}
		double average = Average (numbers), standarddeviation = 0;
		int index;
		for (index = 0; index < numbers.length; index = index + 1)
		{
			standarddeviation = standarddeviation + Math.pow (numbers [index] - average, 2.0);
		}
		standarddeviation = Math.sqrt (standarddeviation / (numbers.length - 1));
		return standarddeviation;
	}
	
	public static double MeanDeviation (double [] numbers)
	{
		if (numbers.length == 0)
		{
			return 0;
		}
		double average = Average (numbers), meandeviation = 0;
		int index;
		for (index = 0; index < numbers.length; index = index + 1)
		{
			meandeviation = meandeviation + Math.abs (numbers [index] - average);
		}
		meandeviation = meandeviation / (numbers.length * 1.0);
		return meandeviation;
	}
	
	public static double EucledianDistance (double [] input, double [] standard)
	{
		if (input.length == 0 || standard.length == 0)
		{
			return 0;
		}
		if (input.length != standard.length)
		{
			return 0;
		}
		double distance = 0;
		int index;
		for (index = 0; index < input.length; index = index + 1)
		{
			distance = distance + Math.pow ((input [index] - standard [index]), 2.0);
		}
		distance = Math.sqrt (distance);
		return distance;
	}
	
	public static double NormedEucledianDistance (double [] input, double [] standard)
	{
		if (input.length == 0 || standard.length == 0)
		{
			return 0;
		}
		if (input.length != standard.length)
		{
			return 0;
		}
		double distance, norm = 0;
		int index;
		for (index = 0; index < input.length; index = index + 1)
		{
			norm = norm + Math.pow (input [index], 2.0);
		}
		norm = Math.sqrt (norm);
		distance = EucledianDistance (input, standard) / norm;
		return distance;
	}
	
	public static double ManhattanDistance (double [] input, double [] standard)
	{
		if (input.length == 0 || standard.length == 0)
		{
			return 0;
		}
		if (input.length != standard.length)
		{
			return 0;
		}
		double distance = 0;
		int index;
		for (index = 0; index < input.length; index = index + 1)
		{
			distance = distance + Math.abs (input [index] - standard [index]);
		}
		return distance;
	}
	
	public static double ManhattanScaledDistance (double [] input, double [] standard)
	{
		if (input.length == 0 || standard.length == 0)
		{
			return 0;
		}
		if (input.length != standard.length)
		{
			return 0;
		}
		double distance = 0, meandeviation = MeanDeviation (input);
		int index;
		for (index = 0; index < input.length; index = index + 1)
		{
			distance = distance + Math.abs (input [index] - standard [index]) / meandeviation;
		}
		return distance;
	}
	
	public static double MahalanobisDistance (double [] input, double [] standard)
	{
		if (input.length == 0 || standard.length == 0)
		{
			return 0;
		}
		if (input.length != standard.length)
		{
			return 0;
		}
		double distance = 0;
		int index;
		for (index = 0; index < input.length; index = index + 1)
		{
			distance = distance + Math.pow ((input [index] - standard [index]), 2.0) / Math.pow (StandardDeviation (input), 2.0);
			
		}
		distance = Math.sqrt (distance);
		return distance;
	}
	
	public static double [] GetTolerances (double [] [] inputs, double [] standard) // [5] intervals [43] characters.
	{
		if (inputs.length == 0)
		{
			return null;
		}
		double [] tolerances = new double [inputs.length];
		int index;
		for (index = 0; index < inputs.length; index = index + 1)
		{
			tolerances [index] = Average (inputs [index]);
		}
		return tolerances;
	}
	
	public static double GetFalseAcceptanceRate (int numberoffalselyacceptedrequests, int totalnumberofillegitimaterequests)
	{
		return numberoffalselyacceptedrequests / (totalnumberofillegitimaterequests * 1.0);
	}
	
	public static double GetFalseRejectionRate (int numberoffalselyrejectedrequests, int totalnumberoflegitimaterequests)
	{
		return numberoffalselyrejectedrequests / (totalnumberoflegitimaterequests * 1.0);
	}
	
	public static double GetEqualErrorRate (int numberoffalselyacceptedrequests, int totalnumberofillegitimaterequests, int numberoffalselyrejectedrequests, int totalnumberoflegitimaterequests)
	{
		return (GetFalseAcceptanceRate (numberoffalselyacceptedrequests, totalnumberofillegitimaterequests) + GetFalseRejectionRate (numberoffalselyrejectedrequests, totalnumberoflegitimaterequests)) / 2.0;
	}
}