package org.example.service;

import org.example.Coord;
import org.example.Figure;
import org.example.model.Mapable;
import org.example.ui.Config;
import org.example.ui.Window;

public class FlyFigure {
    private Figure figure;
    private Coord coord;
    private boolean landed;
    Mapable map;
    private int ticks;
    public Figure getFigure(){
        return figure;
    }
    public Coord getCoord(){
        return coord;
    }
    public FlyFigure(Mapable map){
        this.map = map;
        figure = Figure.getRandom();
        coord = new Coord(Config.WIDTH / 2 - 2, 0);
        landed = false;
        ticks = 2;
    }
    public boolean isLanded(){
        return landed;
    }
    public boolean canPlaceFigure(){
        return canMoveFigure(figure,0,0);
    }
    private boolean canMoveFigure(Figure figure,int sx, int sy){
        int left = coord.x + sx + figure.top.x;
        if(left < 0) return false;
        int right = coord.x + sx + figure.bot.x;
        if(right >= Config.WIDTH) return false;
        if(coord.y + sy + figure.top.y < 0) return false;
        if(coord.y + sy + figure.bot.y >= Config.HEIGHT) return false;
        for (Coord dot: figure.dots)
            if(map.getBoxColor(coord.x + dot.x + sx,coord.y + dot.y + sy) != 0)return false;
        return true;
    }
    public void moveFigure(int sx, int sy){
        if(canMoveFigure(figure,sx,sy)){
            coord = new Coord(coord.x + sx, coord.y + sy);
        }
        else if(sy == 1){
            if(ticks > 0) ticks--;
                else landed = true;
        }
    }
    public void turnFigure(int direction){
        Figure rotated = direction == 1? figure.turnRight() : figure.turnLeft();
        if(canMoveFigure(rotated,0,0)){
            figure = rotated;
            moveFigure(0,0);
        }else
        if(canMoveFigure(rotated,1,0)) {
            figure = rotated;
            moveFigure(1,0);
        }else
        if(canMoveFigure(rotated,-1,0)){
            figure = rotated;
            moveFigure(-1,0);
        }
    }
}
