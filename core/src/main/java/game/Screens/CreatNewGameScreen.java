package game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import game.HelperXML.MakeXML;
import game.MyGdxGame;

public class CreatNewGameScreen extends AbstractScreen {


    protected Skin skin;
    private static float padSize =25;
    private Table tablePlayer;
    private TextField tfName;

    private String CorporationName;
    private MyGdxGame game;
    private double money;
    private String locRoot;

    public CreatNewGameScreen(final MyGdxGame game) {
        super(game);
        this.game = game;
        Gdx.input.setInputProcessor(stage);
        init();
    }

    private void init(){
        locRoot = Gdx.files.getLocalStoragePath();
        skin = new Skin(Gdx.files.internal("data/skin/flat-earth-ui.json"));
        createTablePlayer();
    }

    private void createTablePlayer() {

        tablePlayer = new Table();

        tablePlayer.top().center().pad(padSize);
        tablePlayer.debug();
        tablePlayer.setFillParent(true);

        tablePlayer.row();
        tablePlayer.add(new Label("Your Corporation name:", skin)).pad(padSize);
        TextField tfName = new TextField("Space Trading", skin);
        CorporationName = tfName.getText();
        tablePlayer.add(tfName).minWidth(400).pad(padSize);

        TextButton textButtonClose = new TextButton("Next", skin);

        /** Group Button**/
        tablePlayer.row();
        ButtonGroup buttonGroup = new ButtonGroup();
        ImageTextButton imageTextButton = new ImageTextButton("Male", skin, "radio");
        buttonGroup.add(imageTextButton);
        tablePlayer.add(imageTextButton).pad(padSize);

        imageTextButton = new ImageTextButton("Female", skin, "radio");
        buttonGroup.add(imageTextButton);
        tablePlayer.add(imageTextButton).pad(padSize);

        tablePlayer.row();
        tablePlayer.row().colspan(2);
        tablePlayer.add(textButtonClose.center().pad(padSize));


        textButtonClose.addListener(new ClickListener() {

            @Override
            public void  touchUp(InputEvent event, float x, float y, int pointer, int button) {
                tablePlayer.remove();

                    String filePath = locRoot;
                    MakeXML.createPlayerFile(CorporationName);
                    MakeXML.createSpaceship();
                }
                //game.setScreen(new SpalshScreen(game));

        });

        stage.addActor(tablePlayer);
    }

    @Override
    public void render(float delta) {

        super.render(delta);
        update();
        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }

    private void update() {
        stage.act();
    }


}
