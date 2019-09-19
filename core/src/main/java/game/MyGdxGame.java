package game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.I18NBundle;
import game.Screens.StartGameScreen;;
import java.util.Locale;

public class MyGdxGame extends Game {

	public final static  String GAME_NAME = "Star Trader";
	public final static  int GAME_WIDTH = 1920;
	public final static  int GAME_HEIGHT = 1080;
	private SpriteBatch batch;
	private TextureAtlas textureAtlas;
	private Animation animation;
	private float elapsedTime = 0;

	@Override
	public void create() {

		this.setScreen(new StartGameScreen(this));

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

		Gdx.files.local("mylocalcopy.txt").delete();
		boolean isFile2 = Gdx.files.local("mylocalcopy.txt").exists();
		System.out.println(isFile2);

		batch = new SpriteBatch();
		textureAtlas = new TextureAtlas(Gdx.files.internal("01.atlas"));
		animation = new Animation(1/10f, textureAtlas.getRegions());
	}

	@Override
	public void dispose() {
		batch.dispose();
		textureAtlas.dispose();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		//sprite.draw(batch);
		elapsedTime += Gdx.graphics.getDeltaTime();
		batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime, true), 100, 100);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}