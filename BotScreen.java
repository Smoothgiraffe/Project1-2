package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.managers.CrazyPuttingGame;


public class BotScreen extends InputAdapter implements Screen {
    private CrazyPuttingGame game;
    private FitViewport viewport;
    private Stage stage;
    private TextureAtlas atlas;
    private Skin skin;
    private Table table;
    private TextButton alg1;
    private TextButton alg2;
    private TextButton alg3;
    private TextButton back;
    private BitmapFont font;
    private BitmapFont headingFont;
    private Label heading;
    private Texture background;
    private int level;


    public BotScreen(CrazyPuttingGame game, int level) {
        this.level = level;
        this.game = game;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 1, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        background = new Texture("core/assets/golf.9.png");


        this.stage.act(delta);
        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0, 1500, 900);
        stage.getBatch().end();
        this.stage.draw();
    }

    @Override
    public void show() {
        this.stage = new Stage();
        this.atlas = new TextureAtlas("C:\\Users\\matte.LAPTOP-FLG8V3QC\\Documents\\University Maastricht\\PROJECTS\\Project.Putting\\core\\assets\\button.pack");
        this.skin = new Skin(atlas);
        this.table = new Table(skin);
        this.font = new BitmapFont();
        this.headingFont = new BitmapFont(Gdx.files.internal("core/assets/fonts/font.fnt"));
        table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        TextButtonStyle textButtonStyle = new TextButtonStyle();
        textButtonStyle.up = skin.getDrawable("button_up");
        textButtonStyle.down = skin.getDrawable("button_down");
        textButtonStyle.pressedOffsetX = 1;
        textButtonStyle.pressedOffsetY = -1;
        textButtonStyle.font = this.font;
        textButtonStyle.fontColor = Color.BLACK;

        this.alg1 = new TextButton("ALGORITHM 1", textButtonStyle);
        this.alg1.pad(20);
        this.alg1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.showGameScreenAuto(level, 1);


            }
        });

        this.alg2 = new TextButton("ALGORITHM 2", textButtonStyle);
        this.alg2.pad(20);
        this.alg2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.showGameScreenAuto(level, 2);

            }
        });

        this.alg3 = new TextButton("ALGORITHM 3", textButtonStyle);
        this.alg3.pad(20);
        this.alg3.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.showGameScreenAuto(level, 3);
            }
        });

        this.back = new TextButton("BACK", textButtonStyle);
        this.back.pad(20);
        this.back.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.showLevelScreenAuto();
            }
        });


        LabelStyle headingStyle = new Label.LabelStyle(this.headingFont, Color.BLACK);
        this.heading = new Label("CRAZY PUTTING", headingStyle);
        this.heading.setFontScale(2);


        this.table.add(heading);
        this.table.getCell(this.heading).spaceBottom(100);
        this.table.row();
        this.table.add(this.alg1);
        this.table.getCell(this.alg1).spaceBottom(50);
        this.table.row();
        this.table.add(this.alg2);
        this.table.getCell(this.alg2).spaceBottom(50);
        this.table.row();
        this.table.add(this.alg3);
        this.table.getCell(this.alg3).spaceBottom(50);
        this.table.row();
        this.table.add(this.back);
        this.stage.addActor(this.table);
        Gdx.input.setInputProcessor(stage);

    }


    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return true;
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }

    @Override
    public void resize(int width, int height) {
    }
}

