package game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

import game.MyGdxGame;


public class StartGameScreen extends AbstractScreen {

    private boolean isNewGame;
    private Preferences preferences;

    public StartGameScreen(MyGdxGame game, boolean isNewGame) {
        super(game);
        isNewGame = isNewGame;
    }


    @Override
    public void render(float delta) {
        update(delta);
        super.render(delta);
    }

    private void update(float delta) {

    }


}
