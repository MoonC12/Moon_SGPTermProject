package kr.ac.kpu.game.s2015180009.simplegame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Ball implements GameObject{
    private float imageWidth;
    private float imageHeight;
    private float x, y;
    private float dx, dy;
    private static Bitmap bitmap;

    public Ball(float x, float y, float dx, float dy)
    {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        if(bitmap == null)
        {
            Resources res = GameView.view.getResources();
            bitmap = BitmapFactory.decodeResource(res, R.mipmap.soccer_ball_240);
            imageWidth = bitmap.getWidth();
            imageHeight = bitmap.getHeight();
        }
    }

    public void update() {
        this.x += this.dx * GameView.frameTime;
        this.y += this.dy * GameView.frameTime;
        int w = GameView.view.getWidth();
        int h = GameView.view.getHeight();

        if(x < 0 || x > w - imageWidth)
        {
            dx = -dx;
        }
        if(y < 0 || y > h - imageHeight)
        {
            dy = -dy;
        }
    }

    public void draw(Canvas canvas) {
        float left = x - imageWidth/2;
        float top = y - imageHeight/2;
        canvas.drawBitmap(bitmap, left, top, null);
    }
}
