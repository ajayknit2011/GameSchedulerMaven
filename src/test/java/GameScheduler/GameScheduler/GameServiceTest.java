package GameScheduler.GameScheduler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.bean.Day;
import com.cg.bean.Game;
import com.cg.bean.Player;
import com.cg.exception.DuplicateEntriesException;
import com.cg.repo.DayRepo;
import com.cg.repo.GameRepo;
import com.cg.repo.PlayerRepo;
import com.cg.service.DayService;
import com.cg.service.DayServiceImpl;
import com.cg.service.GameService;
import com.cg.service.GameServiceImpl;
import com.cg.service.PlayerService;
import com.cg.service.PlayerServiceImpl;

public class GameServiceTest {

	private GameService service;
	private DayService serviced;
	private PlayerService servicep;
	@Mock
	private GameRepo repo;
	@Mock
	private DayRepo  repod;
	@Mock
	private PlayerRepo repop;

	@Before
	public void init() {

		MockitoAnnotations.initMocks(this);
		service = new GameServiceImpl(repo);
		serviced = new DayServiceImpl(repod);
		servicep = new PlayerServiceImpl(repop);
	}
	@Test(expected = NullPointerException.class)
	public void test_createGame_nullValue() {
		Game game = null;
		when(repo.save(game)).thenReturn(game);
		assertEquals(game,service.add(null));
	}
	@Test
	public void test_createGame_success() {
		Game game = new Game("Kabaddi", (byte)7);
		when(repo.save(game)).thenReturn(game);
		assertEquals(game, service.add(new Game("Kabaddi", (byte)7)));
	}

	@Test(expected=DuplicateEntriesException.class)
	public void test_createGame_sameName() {
		Game game = new Game("Kabaddi", (byte)7);
		Game game1 = new Game("Kabaddi", (byte)7);
		when(repo.findByName(game.getGameName())).thenReturn(game);
		service.add(game);
	
	}
	@Test(expected = IllegalArgumentException.class)
	public void test_createGame_throwsExceptionForIlllegalArguments() {
		//service.add(new Game("Kabaddi", (byte) 11));
		service.add(new Game(null, (byte) 11));
		service.add(new Game("Kabaddi", (byte) 0));
	}
	
	
	/*..........................................DAYService.......................................*/
	

	@Test(expected = NullPointerException.class)
	public void test_createDay_nullValue() {
		Day day = null;
		when(repod.save(day)).thenReturn(day);
		assertEquals(day,serviced.add(day));
	}
	@Test
	public void test_createDay_success() {
		Set<Game> set=new HashSet<Game>();
		set.add(new Game("Kabaddi", (byte)7));
		set.add(new Game("Cricket", (byte)11));
		set.add(new Game("KhoKho", (byte)7));
		Day day = new Day();
		day.setDayName("day1");
		day.setGames(set);
		when(repod.save(day)).thenReturn(day);
		serviced.add(day);
	}
	@Test(expected=DuplicateEntriesException.class)
	public void test_createDay_sameName() {
		Set<Game> set=new HashSet<Game>();
		set.add(new Game("Kabaddi", (byte)7));
		set.add(new Game("Cricket", (byte)7));
		set.add(new Game("KhoKho", (byte)7));
		Day day = new Day();
		day.setDayName("day1");
		day.setGames(set);
		when(repod.findByName(day.getDayName())).thenReturn(day);
		serviced.add(day);
	}
	@Test(expected = IllegalArgumentException.class)
	public void test_createDay_throwsExceptionForIlllegalArguments() {
		Set<Game> set=new HashSet<Game>();
		set.add(new Game("Kabaddi", (byte)7));
		set.add(new Game("Cricket", (byte)7));
		set.add(new Game("KhoKho", (byte)7));
		serviced.add(new Day(null,set));
		serviced.add(new Day("one",null));
	}
	
	
/*.................................Player Service......................*/
	
	@Test(expected = NullPointerException.class)
	public void test_createPlayer_nullValue() {
		Player player = null;
		when(repop.save(player)).thenReturn(player);
		assertEquals(player,servicep.add(player));
	}
	@Test
	public void test_createPlayer_success() {
		Set<Game> set=new HashSet<Game>();
		set.add(new Game("Kabaddi", (byte)7));
		set.add(new Game("Cricket", (byte)11));
		set.add(new Game("KhoKho", (byte)7));
		Player player = new Player();
		player.setPlayerName("ajay");
		player.setGames(set);
		when(repop.save(player)).thenReturn(player);
		servicep.add(player);
	}
	@Test(expected=DuplicateEntriesException.class)
	public void test_createPlayer_sameName() {
		Set<Game> set=new HashSet<Game>();
		set.add(new Game("Kabaddi", (byte)7));
		set.add(new Game("Cricket", (byte)7));
		set.add(new Game("KhoKho", (byte)7));
		Player player = new Player();
		player.setPlayerName("ajay");
		player.setGames(set);
		when(repop.findByName(player.getPlayerName())).thenReturn(player);
		servicep.add(player);
	}
	@Test(expected = NullPointerException.class)
	public void test_createPlayer_throwsNullPointerException() {
		Set<Game> set=new HashSet<Game>();
		set.add(new Game("Kabaddi", (byte)7));
		set.add(new Game("Cricket", (byte)7));
		set.add(new Game("KhoKho", (byte)7));
		servicep.add(new Player("ajay",null));
		servicep.add(new Player(null,set));
	}
} 