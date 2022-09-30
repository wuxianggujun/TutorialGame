package com.wuxianggujun.tutorialgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class TutorialGame extends Game {
	
	public static TutorialGame INSTANCE;
	
	public TutorialGame() {
		INSTANCE = this;
	}

	@Override
	public void create() {
		setScreen(new GameScreen());
	}
	
}