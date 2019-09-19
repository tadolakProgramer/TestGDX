package game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.GL30;

import game.MyGdxGame;


public class StartGameScreen extends AbstractScreen {

    private boolean isNewGame;
    private Preferences preferences;

    public StartGameScreen(MyGdxGame game) {
        super(game);
        getNumberOfGame();
        isNewGame();
    }

    private void getNumberOfGame(){
        int i;
        preferences = getPrefs();
        i = preferences.getInteger("NUMBER_OF_GAME");
        if (i<1){
            preferences.putInteger("NUMBER_OF_GAME", 0);
            isNewGame = true;
        }
    }

    protected Preferences getPrefs() {
        if (preferences == null)
            preferences = Gdx.app.getPreferences("Games");
        return preferences;
    }

    private boolean isNewGame(){
        //boolean isLocAvailable = Gdx.files.isLocalStorageAvailable();
        //String locRoot = Gdx.files.getLocalStoragePath();
        boolean isFile = Gdx.files.local("mylocalcopy.txt").exists();
        System.out.println(isFile);
        return isNewGame;
    }

    @Override
    public void render(float delta) {
        // clear the screen ready for next set of images to be drawn
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        // tell our stage to do actions and draw itself
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }


}
