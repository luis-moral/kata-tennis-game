package es.molabs.kata.tennisgame;

public class Player 
{
	private final String name;
	private int points;
	
	public Player(String name)
	{
		this.name = name;
		
		points = 0;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void addPoints(int points)
	{
		this.points += points;
	}
	
	public int getPoints()
	{
		return points;
	}
}
