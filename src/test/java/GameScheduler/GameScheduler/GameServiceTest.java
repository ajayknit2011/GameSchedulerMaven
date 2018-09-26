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
	private DayRepo  repod;
	private PlayerRepo repop;

	@Before
	public void init() {

		MockitoAnnotations.initMocks(this);
		service = new GameServiceImpl(repo);
		serviced = new DayServiceImpl(repod);
		servicep = new PlayerServiceImpl(repop);
		
	}
	
		@Test
	public void test_createGame_nullValue() {
		Game game = null;
            
		when(repo.save(game)).thenReturn(null);
		
		assertEquals(game,null);
		
	}
	
	@Test
	public void test_createGame_success() {
		Game game = new Game("Kabaddi", (byte)7);
            
		when(repo.save(game)).thenReturn(game);
		
		assertEquals(game, service.add(new Game("Kabaddi", (byte)7)));
	
	}
	
	@Test
	public void test_createGame_sameName() {
		Game g1=new Game("Kabaddi",(byte)7);
		Game g2=new Game("Kabaddi",(byte)7);
		assertNotSame(g1, g2);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void test_createGame_throwsExceptionForIlllegalArguments() {

		//service.add(new Game("Kabaddi", (byte) 11));
		service.add(new Game(null, (byte) 11));
		service.add(new Game("Kabaddi", (byte) 0));

	}

	
	
	
	
	
	
	
	@Test
	public void test_createDay_nullValue() {
		Day day = null;
            
		when(repod.save(day)).thenReturn(null);
		
		assertEquals(day,null);
		
	}
	
	@Test
	public void test_createDay_success() {
		Set<Game> set=new HashSet<Game>();
		set.add(new Game("Kabaddi", (byte)7));
	//	set.add(new Game("Cricket", (byte)7));
	//	set.add(new Game("KhoKho", (byte)7));
		
		Day day = new Day("one",set );
            
		when(repod.save(day)).thenReturn(day);
		
		assertEquals(day, serviced.add(new Day("one",set)));
	
	}
	
	@Test
	public void test_createDay_sameName() {
		Set<Game> set=new HashSet<Game>();
		set.add(new Game("Kabaddi", (byte)7));
		Set<Game> set2=new HashSet<Game>();
		set2.add(new Game("Kabaddi", (byte)7));
	//	set.add(new Game("Cricket", (byte)7));
	//	set.add(new Game("KhoKho", (byte)7));
	//	Game g1=new Game("Kabaddi",(byte)7);
	//	Game g2=new Game("Kabaddi",(byte)7);
		Day d1=new Day("one",set );
		Day d2=new Day("one",set );
		assertNotSame(d1, d2);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void test_createDay_throwsExceptionForIlllegalArguments() {

		Set<Game> set=new HashSet<Game>();
		set.add(new Game("Kabaddi", (byte)7));
	//	set.add(new Game("Cricket", (byte)7));
	//	set.add(new Game("KhoKho", (byte)7));
		//service.add(new Game("Kabaddi", (byte) 11));
		serviced.add(new Day(null,set));
		serviced.add(new Day("one",null));

	}

	
	
	
	
} 