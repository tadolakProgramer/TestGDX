package game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MyGdxGameTest {

    @Test
    public void create() {
    }

    @Test
    public void dispose() {
    }

    @Test
    public void render() {
    }

    @Test
    public void resize() {
    }

    @Test
    public void pause() {
    }

    @Test
    public void resume() {
    }

    @Test
    public void testGameFile() {
        boolean isFile = Gdx.files.local("mylocalcopy.txt").exists();
        assertThat(isFile, is(false));

    }
}