package es.molabs.kata.tennisgame;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ScoreShould 
{
	private final static String PLAYER_A_NAME = "A";
	private final static String PLAYER_B_NAME = "B";
	
	private Player playerA;
	private Player playerB;
	private Score score;
	
	@Test
	public void be_the_player_with_more_points_or_first()
	{
		playerA.addPoints(2);
		playerB.addPoints(4);
		
		Assert.assertThat(playerB, Is.is(playerB));
	}
	
	@Test
	public void be_love_when_winning_player_have_0_points()
	{
		Assert
			.assertThat
			(
				score.getScore(), 
				Is.is(PLAYER_A_NAME + " " + Score.SCORE_LOVE)
			);
	}
	
	@Test
	public void be_fifteen_when_winning_player_have_1_point()
	{
		playerA.addPoints(1);
		
		Assert
			.assertThat
			(
				score.getScore(), 
				Is.is(PLAYER_A_NAME + " " + Score.SCORE_FIFTEEN)
			);
	}
	
	@Test
	public void be_thirty_when_winning_player_have_2_poins()
	{
		playerA.addPoints(2);
		
		Assert
			.assertThat
			(
				score.getScore(), 
				Is.is(PLAYER_A_NAME + " " + Score.SCORE_THIRTY)
			);
	}
	
	@Test
	public void be_forty_when_winning_player_have_3_poins()
	{
		playerA.addPoints(3);
		
		Assert
			.assertThat
			(
				score.getScore(), 
				Is.is(PLAYER_A_NAME + " " + Score.SCORE_FORTY)
			);
	}
	
	@Test
	public void be_advantage_when_players_have_at_least_3_points_and_lead_player_is_one_point_ahead()
	{
		playerA.addPoints(4);
		playerB.addPoints(3);
		
		Assert
			.assertThat
			(
				score.getScore(), 
				Is.is(PLAYER_A_NAME + " " + Score.SCORE_ADVANTAGE)
			);
	}
	
	@Test
	public void be_deuce_when_players_have_at_least_3_points_and_scores_are_equal()
	{
		playerA.addPoints(3);
		playerB.addPoints(3);
		
		Assert
			.assertThat
			(
				score.getScore(),
				Is.is(PLAYER_A_NAME + " " + Score.SCORE_DEUCE)
			);
	}
	
	@Test
	public void be_won_when_a_player_has_at_least_4_points_and_is_two_points_ahead()
	{
		playerA.addPoints(3);
		playerB.addPoints(5);
		
		Assert
			.assertThat
			(
				score.getScore(), 
				Is.is(PLAYER_B_NAME + " " + Score.SCORE_WON)
			);
	}
	
	@Before
	public void setUp()
	{
		playerA = new Player(PLAYER_A_NAME);
		playerB = new Player(PLAYER_B_NAME);
		
		score = new Score(playerA, playerB);
	}
}
