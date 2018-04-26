package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
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


public class LevelScreenAuto extends InputAdapter implements Screen{
    private CrazyPuttingGame game;
    private FitViewport viewport;
    private Stage stage;
    private TextureAtlas atlas;
    private Skin skin;
    private Table table;
    private TextButton level1Button;
    private TextButton level2Button;
    private TextButton level3Button;
    private TextButton level4Button;
    private TextButton level5Button;
    private TextButton level6Button;
    private TextButton backButton;
    private BitmapFont font;
    private BitmapFont headingFont;
    private Label heading;
    private Texture background;


    public LevelScreenAuto(CrazyPuttingGame game){
        this.game = game;
    }

    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(0,1,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        background = new Texture("core/assets/golf.9.png");
        this.stage.act(delta);
        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0, 1500, 900);
        stage.getBatch().end();
        this.stage.draw();
    }

    @Override
    public void show(){
        this.stage = new Stage();
        this.atlas = new TextureAtlas("C:\\Users\\matte.LAPTOP-FLG8V3QC\\Documents\\UM\\PROJECTS\\Project.Putting\\core\\assets\\button.pack");
        this.skin = new Skin(atlas);
        this.table = new Table(skin);
        this.font = new BitmapFont();
        this.headingFont = new BitmapFont(Gdx.files.internal("core/assets/fonts/font.fnt"));
        table.setBounds(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        TextButtonStyle textButtonStyle = new TextButtonStyle();
        textButtonStyle.up = skin.getDrawable("button_up");
        textButtonStyle.down = skin.getDrawable("button_down");
        textButtonStyle.pressedOffsetX = 1;
        textButtonStyle.pressedOffsetY = -1;
        textButtonStyle.font = this.font;
        textButtonStyle.fontColor = Color.BLACK;

        this.level1Button = new TextButton("LEVEL 1" , textButtonStyle);
        this.level1Button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x,float y){
                game.showGameScreenAuto(1);
            }
        });
        this.level1Button.pad(20);

        this.level2Button = new TextButton("LEVEL 2" , textButtonStyle);
        this.level2Button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x,float y){
                game.showGameScreenAuto(2);
            }
        });
        this.level2Button.pad(20);

        this.level3Button = new TextButton("LEVEL 3" , textButtonStyle);
        this.level3Button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x,float y){
                game.showGameScreenAuto(3);
            }
        });
        this.level3Button.pad(20);

        this.level4Button = new TextButton("LEVEL 4" , textButtonStyle);
        this.level4Button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x,float y){
                game.showGameScreenAuto(4);
            }
        });
        this.level4Button.pad(20);

        this.level5Button = new TextButton("LEVEL 5" , textButtonStyle);
        this.level5Button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x,float y){
                game.showGameScreenAuto(5);
            }
        });
        this.level5Button.pad(20);

        this.level6Button = new TextButton("LEVEL 6" , textButtonStyle);
        this.level6Button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x,float y){
                game.showGameScreenAuto(6);
            }
        });
        this.level6Button.pad(20);


        this.backButton = new TextButton("BACK" , textButtonStyle);
        this.backButton.pad(20);
        this.backButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event ,float x,float y) {
                game.showModeScreen();
            }
        });


        LabelStyle headingStyle = new Label.LabelStyle(this.headingFont, Color.BLACK);
        this.heading = new Label("LEVELS" , headingStyle);
        this.heading.setFontScale(2);


        this.table.add(heading);
        this.table.getCell(this.heading).spaceBottom(50);
        this.table.row();
        this.table.add(this.level1Button);
        this.table.getCell(this.level1Button).spaceBottom(50);
        this.table.row();
        this.table.add(this.level2Button);
        this.table.getCell(this.level2Button).spaceBottom(50);
        this.table.row();
        this.table.add(this.level3Button);
        this.table.getCell(this.level3Button).spaceBottom(50);
        this.table.row();
        this.table.add(this.level4Button);
        this.table.getCell(this.level4Button).spaceBottom(50);
        this.table.row();
        this.table.add(this.level5Button);
        this.table.getCell(this.level5Button).spaceBottom(50);
        this.table.row();
        this.table.add(this.level6Button);
        this.table.getCell(this.level6Button).spaceBottom(50);
        this.table.row();
        this.table.add(this.backButton);
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


