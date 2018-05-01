package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.managers.CrazyPuttingGame;



public class ScoreScreen extends GolfScreen {
    private TextButton user1Button;
    private TextButton user2Button;
    private TextButton user3Button;
    private TextButton backButton;


    public ScoreScreen(CrazyPuttingGame game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();

        this.user1Button = new TextButton("USER 1" , textButtonStyle);
        this.user1Button.pad(20);
        this.user1Button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event ,float x,float y) {
                game.showUser1Screen();

            }
        });

        this.user2Button = new TextButton("USER 2" , textButtonStyle);
        this.user2Button.pad(20);
        this.user2Button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event ,float x,float y) {

            }
        });

        this.user3Button = new TextButton("USER 3" , textButtonStyle);
        this.user3Button.pad(20);
        this.user3Button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event ,float x,float y) {
            }
        });

        this.backButton = new TextButton("BACK" , textButtonStyle);
        this.backButton.pad(20);
        this.backButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event ,float x,float y) {
                game.showMenuScreen();
            }
        });


        LabelStyle headingStyle = new Label.LabelStyle(this.headingFont, Color.BLACK);
        this.heading = new Label("SCORE" , headingStyle);
        this.heading.setFontScale(2);


        this.table.add(heading);
        this.table.getCell(this.heading).spaceBottom(50);
        this.table.row();
        this.table.add(this.user1Button);
        this.table.getCell(this.user1Button).spaceBottom(25);
        this.table.row();
        this.table.add(this.user2Button);
        this.table.getCell(this.user2Button).spaceBottom(25);
        this.table.row();
        this.table.add(this.user3Button);
        this.table.getCell(this.user3Button).spaceBottom(25);
        this.table.row();
        this.table.add(this.backButton);
        this.stage.addActor(this.table);
        Gdx.input.setInputProcessor(stage);
    }
}

