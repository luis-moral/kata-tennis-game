package es.molabs.kata.tennisgame;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PlayerShould 
{
	private String playerName = "name";
	private Player player;
	
	@Test
	public void have_name()
	{
		Assert.assertThat(player.getName(), Is.is(playerName));
	}
	
	@Test
	public void start_with_zero_points()
	{
		Assert.assertThat(player.getPoints(), Is.is(0));		
	}
	
	@Test
	public void have_one_point_after_adding_one_point()
	{
		player.addPoints(1);
		
		Assert.assertThat(player.getPoints(), Is.is(1));
	}
	
	@Before
	public void setUp()
	{
		player = new Player(playerName);
	}
}