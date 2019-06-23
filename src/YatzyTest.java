
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class YatzyTest {

	private int given = 0;
	private int expected = 0;
	private List<Integer> entiers = new ArrayList<Integer>();
	
    @Test
    public void chance_scores_sum_of_all_dice() {
    	
    	entiers = Arrays.asList(2,3,4,5,1);
    	given = Yatzy.chance(entiers);
		expected = 15;
		assertEquals(expected, given);
		
    	entiers = Arrays.asList(3,3,4,5,1);
    	given = Yatzy.chance(entiers);
    	expected = 16;
		assertEquals(expected, given);
    }

    @Test 
    public void yatzy_scores_50() {

    	entiers = Arrays.asList(4,4,4,4,4);
    	expected = 50;
        given = Yatzy.yatzy(entiers);
    	assertEquals(expected, given);
    	
    	entiers = Arrays.asList(6,6,6,6,6);
    	expected = 50;
        given = Yatzy.yatzy(entiers);
    	assertEquals(expected, given);
    	
    	entiers = Arrays.asList(6,6,6,6,3);
    	expected = 0;
        given = Yatzy.yatzy(entiers);
    	assertEquals(expected, given);
    	
    	
    }

    @Test 
    public void test_1s() {
    	entiers = Arrays.asList(1,2,3,4,5);
        assertTrue(Yatzy.ones(entiers) == 1);
        
        entiers = Arrays.asList(1,2,1,4,5);
        given=Yatzy.ones(entiers);
    	expected=2;
    	assertEquals(expected, given);
        
        entiers = Arrays.asList(6,2,2,4,5);
        given=Yatzy.ones(entiers);
    	expected=0;
    	assertEquals(expected, given);
        
        entiers = Arrays.asList(1,2,1,1,1);
        given=Yatzy.ones(entiers);
    	expected=4;
    	assertEquals(expected, given);

    }

    @Test
    public void test_2s() {
    	entiers = Arrays.asList(1,2,3,2,6);
    	given=Yatzy.twos(entiers);
    	expected=4;
    	assertEquals(expected, given);
       
        entiers = Arrays.asList(2,2,2,2,2);
        given=Yatzy.twos(entiers);
    	expected=10;
    	assertEquals(expected, given);
       
    }

    @Test
    public void test_threes() {
    	entiers = Arrays.asList(1,2,3,2,3);
    	given=Yatzy.threes(entiers);
    	expected=6;
    	assertEquals(expected, given);
        
        entiers = Arrays.asList(2,3,3,3,3);
        given=Yatzy.threes(entiers);
    	expected=12;
    	assertEquals(expected, given);
    }

    @Test
    public void fours_test() 
    {
        assertEquals(12, new Yatzy(4,4,4,5,5).fours());
        assertEquals(8, new Yatzy(4,4,5,5,5).fours());
        assertEquals(4, new Yatzy(4,5,5,5,5).fours());
    }

    @Test
    public void fives() {
        assertEquals(10, new Yatzy(4,4,4,5,5).fives());
        assertEquals(15, new Yatzy(4,4,5,5,5).fives());
        assertEquals(20, new Yatzy(4,5,5,5,5).fives());
    }

    @Test
    public void sixes_test() {
        assertEquals(0, new Yatzy(4,4,4,5,5).sixes());
        assertEquals(6, new Yatzy(4,4,6,5,5).sixes());
        assertEquals(18, new Yatzy(6,5,6,6,5).sixes());
    }

    @Test
    public void one_pair() {
    	entiers = Arrays.asList(3,4,3,5,6);
    	given=Yatzy.score_pair(entiers);
    	expected=6;
    	assertEquals(expected, given);
        
        entiers = Arrays.asList(5,3,3,3,5);
        given=Yatzy.score_pair(entiers);
    	expected=10;
    	assertEquals(expected, given);

        entiers = Arrays.asList(5,3,6,6,5);
        given=Yatzy.score_pair(entiers);
    	expected=12;
    	assertEquals(expected, given);
    }

    @Test
    public void two_Pair() {
    	entiers = Arrays.asList(3,3,5,4,5);
    	given=Yatzy.two_pair(entiers);
    	expected=16;
    	assertEquals(expected, given);
        
        entiers = Arrays.asList(3,3,5,5,5);
        given=Yatzy.two_pair(entiers);
    	expected=16;
    	assertEquals(expected, given);
    }

    @Test
    public void three_of_a_kind() 
    {
    	entiers = Arrays.asList(3,3,3,4,5);
    	given=Yatzy.three_of_a_kind(entiers);
    	expected=9;
    	assertEquals(expected, given);
        
        entiers = Arrays.asList(5,3,5,4,5);
        given=Yatzy.three_of_a_kind(entiers);
    	expected=15;
    	assertEquals(expected, given);
        
        entiers = Arrays.asList(3,3,3,3,5);
        given=Yatzy.three_of_a_kind(entiers);
    	expected=9;
    	assertEquals(expected, given);
    }

    @Test
    public void four_of_a_knd() {
    	
    	entiers = Arrays.asList(3,3,3,3,5);
    	given=Yatzy.four_of_a_kind(entiers);
    	expected=12;
    	assertEquals(expected, given);
        
        entiers = Arrays.asList(5,5,5,4,5);
        given=Yatzy.four_of_a_kind(entiers);
    	expected=20;
    	assertEquals(expected, given);
        
        entiers = Arrays.asList(3,3,3,3,3);
        given=Yatzy.four_of_a_kind(entiers);
    	expected=12;
    	assertEquals(expected, given);
    }

    @Test
    public void smallStraight() {
    	
    	entiers = Arrays.asList(1,2,3,4,5);
    	given=Yatzy.smallStraight(entiers);
    	expected=15;
    	assertEquals(expected, given);
        
        entiers = Arrays.asList(2,3,4,5,1);
        given=Yatzy.smallStraight(entiers);
    	expected=15;
    	assertEquals(expected, given);
        
        entiers = Arrays.asList(1,2,2,4,5);
        given=Yatzy.smallStraight(entiers);
    	expected=0;
    	assertEquals(expected, given);
    }

    @Test
    public void largeStraight() {
    	
    	entiers = Arrays.asList(6,2,3,4,5);
    	given=Yatzy.largeStraight(entiers);
    	expected=20;
        assertEquals(expected, given);
        
        entiers = Arrays.asList(2,3,4,5,6);
        given=Yatzy.largeStraight(entiers);
    	expected=20;
    	assertEquals(expected, given);
        
        entiers = Arrays.asList(1,2,2,4,5);
        given=Yatzy.largeStraight(entiers);
    	expected=0;
    	assertEquals(expected, given);
    }

    @Test
    public void fullHouse() {
    	
    	entiers = Arrays.asList(6,2,2,2,6);
    	given=Yatzy.fullHouse(entiers);
    	expected=18;
    	assertEquals(expected, given);
        
        entiers = Arrays.asList(2,3,4,5,6);
        given=Yatzy.fullHouse(entiers);
    	expected=0;
    	assertEquals(expected, given);
    }
}