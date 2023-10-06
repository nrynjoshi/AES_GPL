package com.narayanjoshi.gplapplication.service.command;

import com.narayanjoshi.gplapplication.Util;
import com.narayanjoshi.gplapplication.service.RootCommand;
import javafx.scene.paint.Color;

import java.util.List;

public class TriangleCommand extends RootCommand {

    @Override
    public void draw(String command) {

        this.validate(command);

        List<String> params = Util.getAllParameterFromCommand(command);

        double moveX = canvasUtil.getMoveX();
        double moveY = canvasUtil.getMoveY();

        double base = Float.parseFloat(params.get(0))+ moveX;
        double adj = Float.parseFloat(params.get(1))+ moveY;
//        double hyp = Float.parseFloat(params.get(2))+ moveY;


        double[] x = { moveX, base, moveX };
        double[] y = { moveY, adj, adj };

        if(canvasUtil.isFillOn()){
            canvasUtil.getGraphicsContext().fillPolygon(x, y , 3);
        }else{
            canvasUtil.getGraphicsContext().strokePolygon(x, y , 3);
        }
    }
}
