package GameSchedulerMaven.GameSchedulerMaven;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.*;

import com.cg.bean.Day;
import com.cg.bean.Game;
import com.cg.exception.DuplicateEntriesException;
import com.cg.repo.DayRepo;
import com.cg.repo.GameRepo;
import com.cg.repo.GameRepoImpl;
import com.cg.repo.DayRepoImpl;

public class GameRepoTest {

private GameRepo gameRepo;
private DayRepo dayRepo;
	private Game game;

	@Before
	public void init(){
		
		gameRepo = new GameRepoImpl(new HashSet<Game>());
		dayRepo = new DayRepoImpl(new ArrayList<Day>());
	}
	
	
	@Test(expected=NullPointerException.class)
	public void test_saveGame() {
		Game game = new Game();
		gameRepo.save(game);
	}
	

	@Test(expected=NullPointerException.class)
	public void test_save_Game_throwsExceptionForIllegalArguments() {
		
		Game game =null;
		gameRepo.save(game);
	}
	
	
	
	@Test(expected=NullPointerException.class)
	public void test_save_Game_throwsExceptionForEmptyName() {
			
		Game game = new Game();
		gameRepo.save(game);
	}
	
	
	@Test(expected=NullPointerException.class)
	public void test_findByName_Game() {
		String gameName =null;
		gameRepo.findByName(gameName);
	}
	
	
	@Test
	public void test_findByGamesNametrue() {
		Game game = new Game();
		game.setGameName("cricket");
		gameRepo.save(game);
		String GameName ="cricket";
		Game g =gameRepo.findByName(GameName);
		assertTrue("cricket".equals(g.getGameName()));
	}
	
	@Test
	public void test_findByGamesNamefalse() {
		Game game = new Game();
		game.setGameName("hockey");
		gameRepo.save(game);
		String GameName ="cricket";
		Game g =gameRepo.findByName(GameName);
		assertNull(g);
	}
	
	
	/*..................DayRepo>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/	
	
	
	@Test(expected=NullPointerException.class)
	public void test_saveDay_Day_value_null() throws DuplicateEntriesException {
		//DayRepo dayRepo = new DayRepoImpl();
		Day day = new Day();
		dayRepo.save(day);
	}
	
	@Test(expected=NullPointerException.class)
	public void test_save_Day_daynull() throws DuplicateEntriesException {
		//DayRepo dayRepo = new DayRepoImpl();
		Day day = null;		
		dayRepo.save(day);
	}
	
	@Test(expected=NullPointerException.class)
	public void test_findByGamesName() {
		//DayRepo dayRepo = new DayRepoImpl();
		String GameName =null;
		dayRepo.findByGamesName(GameName);
	}
	
	@Test
	public void test_findByGamesName1() throws DuplicateEntriesException {
		Set<Game> set=new HashSet<Game>();
		set.add(new Game("Kabaddi", (byte)7));
		set.add(new Game("Cricket", (byte)7));
		set.add(new Game("KhoKho", (byte)7));
		Day day = new Day();
		day.setDayName("1");
		day.setGames(set);
		dayRepo.save(day);
		
		String GameName ="Cricket";
		List<Day> days=dayRepo.findByGamesName(GameName);
		assertFalse(days.isEmpty());
	}
	
	@Test
	public void test_findByGamesName2() throws DuplicateEntriesException {
		Set<Game> set=new HashSet<Game>();
		set.add(new Game("Kabaddi", (byte)7));
		set.add(new Game("Cricket1", (byte)7));
		set.add(new Game("KhoKho", (byte)7));
		Day day = new Day();
		day.setDayName("1");
		day.setGames(set);
		dayRepo.save(day);
		String GameName ="cricket";
		List<Day> days=dayRepo.findByGamesName(GameName);
		assertTrue(days.isEmpty());
	}
	
}
