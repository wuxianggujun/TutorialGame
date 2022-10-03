package com.wuxianggujun.tutorialgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

/**
 * 实现了一个简单的弹弹球实例
 * image/Snipaste_2022-10-01_00-05-40.png
 */
public class GameScreen extends ScreenAdapter {
    ShapeRenderer shapeRenderer;

    Vector2 paddlePosition;
    Vector2 ballPosition;
    Vector2 ballVelocity;

    float ballRadius = 16.0f;
    float maxVelocity = 500.0f;
    float paddleWidth = 100.0f;

    float paddleHeight = 32.0f;
    Random random;

    public GameScreen() {
        shapeRenderer = new ShapeRenderer();
        paddlePosition = new Vector2(Gdx.graphics.getWidth() / 2.0f - paddleWidth / 2, 32.0f);
        ballPosition = new Vector2(Gdx.graphics.getWidth() / 2.0f, Gdx.graphics.getHeight() / 2.0f);
        random = new Random();
        // x velocity between -100 to 100
        ballVelocity = new Vector2(random.nextFloat()*200.0f-100.0f, 100.0f);
      
        
    }

    @Override
    public void render(float delta) {

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            paddlePosition.x -= maxVelocity * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            paddlePosition.x += maxVelocity * delta;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }

        if (paddlePosition.x <= 0.0f) {
            paddlePosition.x = 0.0f;
        } else if (paddlePosition.x > Gdx.graphics.getWidth() - paddleWidth) {
            paddlePosition.x = Gdx.graphics.getWidth() - paddleWidth;
        }
        
        if (ballPosition.y >= Gdx.graphics.getHeight() - ballRadius){
            ballPosition.y = Gdx.graphics.getHeight() - ballRadius;
            ballVelocity.y = -ballVelocity.y;
        }
        if (ballPosition.x<=ballRadius){
            ballPosition.x = ballRadius;
            ballVelocity.x = -ballVelocity.x;
        }
        if (ballPosition.x >= Gdx.graphics.getWidth()-ballRadius){
            ballPosition.x = Gdx.graphics.getWidth()-ballRadius;
            ballVelocity.x *= -1.0f; 
        }

        if (ballPosition.y<= -ballRadius){
            ballPosition = new Vector2(Gdx.graphics.getWidth() / 2.0f, Gdx.graphics.getHeight() / 2.0f);
            // x velocity between -100 to 100
            ballVelocity = new Vector2(random.nextFloat()*200.0f-100.0f, 100.0f);

        }
        
        if (ballPosition.y -ballRadius<=paddlePosition.y+paddleHeight && ballPosition.y +ballRadius>paddlePosition.y){
            if (ballPosition.x>=paddlePosition.x&&ballPosition.x<= paddlePosition.x+paddleWidth){
             ballPosition.y = paddlePosition.y+paddleHeight+ballRadius;
             ballVelocity.y *= -1.2f;
            }
        }
        

        ballPosition.mulAdd(ballVelocity, delta);

        ScreenUtils.clear(Color.WHITE);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.rect(paddlePosition.x, paddlePosition.y, paddleWidth, paddleHeight);
        shapeRenderer.circle(ballPosition.x, ballPosition.y, ballRadius);
        shapeRenderer.end();

    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
