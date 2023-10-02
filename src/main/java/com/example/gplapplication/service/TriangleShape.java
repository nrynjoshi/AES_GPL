package com.example.gplapplication.service;

import com.example.gplapplication.CanvasUtil;
import com.example.gplapplication.CommandEnum;
import com.example.gplapplication.Util;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.util.List;

public class TriangleShape  extends DrawShape{

    public final static String COMMAND= CommandEnum.RECTANGLE.getCommand();//,<hypotenuse>

    public TriangleShape(CanvasUtil canvasUtil){
        super(canvasUtil);
    }


    @Override
    public void draw(String command) {

        Util.validateCommand(command, this.COMMAND);
        List<String> params = Util.getAllParameterFromCommand(command);

        System.out.println("Triangle shape draw area.");
        // Below lines are for shaping Triangle

        double moveX = canvasUtil.getMoveX();
        double moveY = canvasUtil.getMoveY();

        double base = Float.parseFloat(params.get(0))+ moveX;
        double adj = Float.parseFloat(params.get(1))+ moveY;
//        double hyp = Float.parseFloat(params.get(2))+ moveY;


        double[] x = { moveX, base, moveX };
        double[] y = { moveY, adj, adj };
        canvasUtil.getGraphicsContext().strokePolygon(x, y , 3);
    }
}
