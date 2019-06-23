
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Yatzy {
	
	

	protected List<Integer> allDices = new ArrayList<Integer>();

    /**
     * Get sum of all dice
     * @param listOfNumbers
     * @return 
     */
	public static int chance(List<Integer> listOfDices)
    {
		
    	int total = listOfDices
    			.stream()
    			.mapToInt(i -> i)
    			.sum();
    	return total;
    }

    /**
     * Get 50 if all dice have the same number
     * @param listOfNumbers
     * @return  
     */
    public static int yatzy(List<Integer> listOfDices)
    {
    	int firstElement = listOfDices.get(0);
    	long countOfNumber =  listOfDices
    		    .stream()
    		    .filter(i -> i == firstElement)
    		    .count();
    	
    	if(countOfNumber == 5)
    		return 50;
    	return 0;
    }
    
    
    /**
     * Check two values if equals
     * @param a
     * @param b
     * @return
     */
    private static boolean checkIfEqual(int a, int b) {
    	
    	return a==b;
    }

    /**
     * Sum of the dice
     * @param listOfDices
     * @return
     */
    public static int ones(List<Integer> listOfDices) {
    	
    	long sum = 0;
        
    	sum = listOfDices.stream().filter(number -> checkIfEqual(number, 1)).count();

        return (int) sum;
    }
    
    
    /**
     * Sum of the dice
     * @param listOfDices
     * @return
     */
    public static int twos(List<Integer> listOfDices) {
        
        int[] sum = {0};
        listOfDices.forEach(number->{
        	if(checkIfEqual(number, 2))
        		sum[0]+=2;
        });
        return sum[0];
    }

    /**
     * Sum of the dice
     * @param listOfDices
     * @return
     */
    public static int threes(List<Integer> listOfDices) {
    	
    	int[] sum = {0};
    	listOfDices.forEach(number->{
        	if(checkIfEqual(number, 3))
        		sum[0]+=3;
        });
        return sum[0];
    }

    
    /**
     * Constructor 
     * @param _diceOne
     * @param _diceTwo
     * @param _diceTree
     * @param _diceFour
     * @param _diceFive
     */
    public Yatzy(int _diceOne, int _diceTwo, int _diceTree, int _diceFour, int _diceFive)
    {
    	allDices = Arrays.asList(_diceOne, _diceTwo, _diceTree, _diceFour, _diceFive);
    }

    /**
     * Sum of the dice
     * @return
     */
    public int fours()
    {
    	int[] sum = {0};
    	allDices.forEach(number->{
        	if(checkIfEqual(number, 4))
        		sum[0]+=4;
        });
        return sum[0];
    }

    /**
     * Sum of the dice
     * @return
     */
    public int fives()
    {
    	int[] sum = {0};
    	allDices.forEach(number->{
        	if(checkIfEqual(number, 5))
        		sum[0]+=5;
        });
        return sum[0];
    }

    /**
     * Sum of the dice
     * @return
     */
    public int sixes()
    {
    	int[] sum = {0};
    	allDices.forEach(number->{
        	if(checkIfEqual(number, 6))
        		sum[0]+=6;
        });
        return sum[0];
    }

    /**
     * Sum of the two highest matching dice
     * @param listOfDices
     * @return
     */
    public static int score_pair(List<Integer> listOfDices)
    {
    	
        int[] pairs = new int[6];
        pairs = setTableOfCounts(listOfDices);
        for (int i = pairs.length - 1; i >= 0 ; i--) {
        	if (pairs[i] >= 2)
                return (i+1)*2;
		}
        return 0;
    }
    
    /**
     * Set a table with counter of same number
     * @param listOfDices
     * @return
     */
    private static int[] setTableOfCounts(List<Integer> listOfDices) {
    	int[] counts = new int[6];
    	listOfDices.forEach(number->{
    		counts[number-1]++;
    	});
    	return counts;
    }

    /**
     * Sum two pairs of dice with the same number
     * @param listOfDices
     * @return
     */
    public static int two_pair(List<Integer> listOfDices)
    {
    	int[] pairs = new int[6];
    	int score = 0;
    	
        pairs = setTableOfCounts(listOfDices);
        
        for (int i = pairs.length - 1; i >= 0 ; i--) {
        	if (pairs[i] >= 2)
                score += (i+1)*2;
		}
        
        return score;
    }

    /**
     * Sum of dice with the same number
     * @param listOfDices
     * @return
     */
    public static int four_of_a_kind(List<Integer> listOfDices)
    {
    	int[] pairs = new int[6];
    	
        pairs = setTableOfCounts(listOfDices);
        
        for (int i = pairs.length - 1; i >= 0 ; i--) {
        	if (pairs[i] >= 4)
                return (i+1)*4;
		}
        return 0;
    }

    /**
     * Sum of dice with the same number
     * @param listOfDices
     * @return
     */
    public static int three_of_a_kind(List<Integer> listOfDices)
    {
    	int[] pairs = new int[6];
    	
        pairs = setTableOfCounts(listOfDices);
        
        for (int i = pairs.length - 1; i >= 0 ; i--) {
        	if (pairs[i] >= 3)
                return (i+1)*3;
		}
        return 0;
    }

    /**
     * Sum of all dice in small straight
     * @param listOfDices
     * @return
     */
    public static int smallStraight(List<Integer> listOfDices)
    {
        int[] tallies = new int[6];
        tallies = setTableOfCounts(listOfDices);
        
        if (isSmallStraight(tallies))
            return 15;
        return 0;
    }

    /**
     * Check if is small straight
     * @param listOfCounts
     * @return
     */
    private static boolean isSmallStraight(int[] listOfCounts) {
    	boolean isTrue=true;
    	for(int i=0;i<listOfCounts.length-1;i++) {
    		if(listOfCounts[i]!=1)
    			return isTrue=false;
    			
    	}
    	return isTrue;
    	
    }
    
    /**
     * Sum of all dice in large straight
     * @param listOfDices
     * @return
     */
    public static int largeStraight(List<Integer> listOfDices)
    {
    	int[] tallies = new int[6];
    	
        tallies = setTableOfCounts(listOfDices);
        
        if (isLargeStraight(tallies))
            return 20;
        return 0;
    }
    
    /**
     * Check if is large straight
     * @param listOfCounts
     * @return
     */
    private static boolean isLargeStraight(int[] listOfCounts) {
    	boolean isTrue=true;
    	
    	for(int i=1;i<listOfCounts.length;i++) {
    		if(listOfCounts[i]!=1)
    			return isTrue=false;
    			
    	}
    	
    	return isTrue;
    	
    }

    /**
     * Sum all dices if they are two of a kind and three of a kind
     * @param listOfDices
     * @return
     */
    public static int fullHouse(List<Integer> listOfDices)
    {
        
        int twoPairs = 0;
        int treeParis = 0;

        
        treeParis =	three_of_a_kind(listOfDices);
        twoPairs = score_pair(listOfDices);

        

        if (twoPairs != 0 && treeParis != 0)
            return  twoPairs + treeParis ;
        else
            return 0;
    }
}