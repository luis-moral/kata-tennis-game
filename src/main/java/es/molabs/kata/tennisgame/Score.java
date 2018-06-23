package es.molabs.kata.tennisgame;

public class Score 
{
	public final static String SCORE_LOVE = "love";
	public final static String SCORE_FIFTEEN = "fifteen";
	public final static String SCORE_THIRTY = "thirty";
	public final static String SCORE_FORTY = "forty";
	public final static String SCORE_ADVANTAGE = "advantage";
	public final static String SCORE_DEUCE = "deuce";
	public final static String SCORE_WON = "won";
	
	private final Player firstPlayer;
	private final Player secondPlayer;
	
	public Score(Player firstPlayer, Player secondPlayer)
	{
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
	}
	
	public Player getWinningPlayer()
	{
		Player player;
		
		if (secondPlayer.getPoints() > firstPlayer.getPoints())
		{
			player = secondPlayer;
		}
		else
		{
			player = firstPlayer;
		}
		
		return player;
	}
		
	public String getScore()
	{
		String score;
		
		Player winningPlayer = getWinningPlayer();		
		
		if (winningPlayer.getPoints() < 3)
		{
			score = getScoreWhenLessThanThreePoints(winningPlayer.getPoints());
		}
		else
		{			
			score = getScoreWhenAtLeastThreePoints(firstPlayer.getPoints(), secondPlayer.getPoints());		
		}
		
		return formatScore(winningPlayer, score);
	}
	
	private String formatScore(Player winningPlayer, String score)
	{
		return winningPlayer.getName() + " " + score;
	}
	
	private String getScoreWhenLessThanThreePoints(int maxPoints)
	{
		String score;
		
		switch (maxPoints)
		{
			case 1:
				score = SCORE_FIFTEEN;
				break;
				
			case 2:
				score = SCORE_THIRTY;
				break;
				
			default:
				score = SCORE_LOVE;
				break;
		}
		
		return score;
	}
	
	private String getScoreWhenAtLeastThreePoints(int pointsFirstPlayer, int pointsSecondPlayer)
	{
		String score;
		
		if (pointsFirstPlayer >= 3 && pointsSecondPlayer >= 3)
		{
			int pointDifference = Math.abs(pointsFirstPlayer - pointsSecondPlayer);		
			
			if (pointDifference == 0)
			{
				score = SCORE_DEUCE;
			}
			else if (pointDifference == 1)
			{
				score = SCORE_ADVANTAGE;	
			}
			else 
			{
				score = SCORE_WON;
			}
		}
		else
		{
			score = SCORE_FORTY;
		}	
		
		return score;
	}
}
