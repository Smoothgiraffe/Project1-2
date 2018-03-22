package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.managers.CrazyPuttingGame;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.graphics.Color;


public class ModeScreen extends InputAdapter implements Screen{
    private CrazyPuttingGame game;
    private FitViewport viewport;
    private Stage stage;
    private TextureAtlas atlas;
    private Skin skin;
    private Table table;
    private TextButton singlePlayerButton;
    private TextButton autoPlayerButton;
    private TextButton backButton;
    private BitmapFont font;
    private Label heading;


    public ModeScreen(CrazyPuttingGame game){
        this.game = game;
    }

    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(0,1,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.stage.act(delta);
        this.stage.draw();
    }

    @Override
    public void show(){
        this.stage = new Stage();
        this.atlas = new TextureAtlas("C:\\Users\\matte.LAPTOP-FLG8V3QC\\Documents\\UM\\PROJECTS\\Project.Putting\\core\\assets\\button.pack");
        this.skin = new Skin(atlas);
        this.table = new Table(skin);
        this.font = new BitmapFont();
        table.setBounds(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        TextButtonStyle textButtonStyle = new TextButtonStyle();
        textButtonStyle.up = skin.getDrawable("button_up");
        textButtonStyle.down = skin.getDrawable("button_down");
        textButtonStyle.pressedOffsetX = 1;
        textButtonStyle.pressedOffsetY = -1;
        textButtonStyle.font = this.font;
        textButtonStyle.fontColor = Color.BLACK;

        this.singlePlayerButton = new TextButton("SINGLE PLAYER" , textButtonStyle);
        this.singlePlayerButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x,float y){
                game.showLevelScreen();
            }
        });
        this.singlePlayerButton.pad(20);

        this.autoPlayerButton = new TextButton("AUTO" , textButtonStyle);
        this.autoPlayerButton.pad(20);


        this.backButton = new TextButton("BACK" , textButtonStyle);
        this.backButton.pad(20);
        this.backButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event ,float x,float y) {
                game.showMenuScreen();
            }
        });


        LabelStyle headingStyle = new Label.LabelStyle(this.font, Color.BLACK);
        this.heading = new Label("MODE SETTINGS" , headingStyle);
        this.heading.setFontScale(4);


        this.table.add(heading);
        this.table.getCell(this.heading).spaceBottom(50);
        this.table.row();
        this.table.add(this.singlePlayerButton);
        this.table.getCell(this.singlePlayerButton).spaceBottom(50);
        this.table.row();
        this.table.add(this.autoPlayerButton);
        this.table.getCell(this.autoPlayerButton).spaceBottom(50);
        this.table.row();
        this.table.add(this.backButton);
        this.table.debug();
        this.stage.addActor(this.table);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return true;
    }
    @Override
    public void pause() {}
    @Override
    public void resume() {}
    @Override
    public void hide() {}
    @Override
    public void dispose () {}
    @Override
    public void resize(int width, int height) {}
}
