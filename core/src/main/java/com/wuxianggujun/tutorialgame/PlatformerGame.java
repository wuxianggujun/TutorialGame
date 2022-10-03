package com.wuxianggujun.tutorialgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class PlatformerGame extends ApplicationAdapter {
    private static PlatformerGame INSTANCE;
    
    public static final boolean DEBUG = true;
    SpriteBatch batch;
    protected OrthographicCamera camera;
    protected Viewport viewport;

    public PlatformerGame(){
        INSTANCE = this;
    }
    
    @Override
    public void create() {
        batch = new SpriteBatch();
         camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
         camera.setToOrtho(false);
         viewport = new FillViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
         
         
    }

    @Override
    public void render() {
        ScreenUtils.clear(Color.BLACK);
        batch.begin();
        batch.draw(new Texture("assets/libgdx.png"),0,0);
        
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
    
    
    public PlatformerGame getInstance() {
        return INSTANCE;
    }
    
}
