package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.managers.CrazyPuttingGame;


public class ModeScreen extends GolfScreen {
    private TextButton singlePlayerButton;
    private TextButton autoPlayerButton;
    private TextButton backButton;


    public ModeScreen(CrazyPuttingGame game){
        super(game);
    }


    @Override
    public void show(){
        super.show();

        this.singlePlayerButton = new TextButton("SINGLE PLAYER" , textButtonStyle);
        this.singlePlayerButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x,float y){
               game.showNameScreen();
            }
        });
        this.singlePlayerButton.pad(20);

        this.autoPlayerButton = new TextButton("AUTO" , textButtonStyle);
        this.autoPlayerButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x,float y){
                game.showLevelScreenAuto();
            }
        });
        this.autoPlayerButton.pad(20);


        this.backButton = new TextButton("BACK" , textButtonStyle);
        this.backButton.pad(20);
        this.backButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event ,float x,float y) {
                game.showMenuScreen();
            }
        });


        LabelStyle headingStyle = new Label.LabelStyle(this.headingFont, Color.BLACK);
        this.heading = new Label("MODE SETTINGS" , headingStyle);
        this.heading.setFontScale(2);


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
        this.stage.addActor(this.table);
        Gdx.input.setInputProcessor(stage);
    }
}

