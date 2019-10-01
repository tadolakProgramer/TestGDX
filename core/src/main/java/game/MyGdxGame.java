package game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.I18NBundle;

import game.Screens.CreatNewGameScreen;
import game.Screens.StartGameScreen;;
import java.util.Locale;

public class MyGdxGame extends Game {

	private Preferences preferences;
	public final static  String GAME_NAME = "Star Trader";
	public final static  int GAME_WIDTH = 1920;
	public final static  int GAME_HEIGHT = 1080;

	//Files
	public final static String FILE_SPRITE_ATLAS = "data/planets.pack";
	public final static String FILE_CARGO_ATLAS = "data/cargo.atlas";
	public final static String FILE_SPACESHIP = "data/SpaceShip_Empty.png";
	public final static String FILE_SPACE_SHIP = "spaceship.xml";
	public final static String FILE_PLAYER = "player.xml";
	public final static String FILE_PLANETS = "data/cars.xml";
	public final static String FILE_SHIP_MODULES = "data/spacemodule.xml";

	@Override
	public void create() {

		FileHandle ProgressFileHandle = Gdx.files.local(FILE_PLAYER);
		ProgressFileHandle.file().delete();

		if (testGameFile()){
			this.setScreen(new StartGameScreen(this, true));
		}
		else {
			this.setScreen(new CreatNewGameScreen(this));
		}


/*
		boolean isLocAvailable = Gdx.files.isLocalStorageAvailable();
		System.out.println(isLocAvailable);
		String locRoot = Gdx.files.getLocalStoragePath();
		System.out.println(locRoot);
		boolean isFile = Gdx.files.local("mylocalcopy.txt").exists();
		System.out.println(isFile);
		FileHandle file = Gdx.files.local("mylocalcopy.txt");
		file.writeString("My god, it's full of stars", false);
		boolean isFile1 = Gdx.files.local("mylocalcopy.txt").exists();
		System.out.println(isFile1);

		FileHandle baseFileHandle = Gdx.files.internal("language/MyBundle");
		Locale locale = new Locale("pl", "PL");
		I18NBundle myBundle = I18NBundle.createBundle(baseFileHandle, locale);
		String game = myBundle.format("game");

		System.out.println(game);
		*/
	}

	private boolean testGameFile(){
		if (Gdx.files.local("player.xml").exists()){
			return true;
		}
		return false;
	}

}