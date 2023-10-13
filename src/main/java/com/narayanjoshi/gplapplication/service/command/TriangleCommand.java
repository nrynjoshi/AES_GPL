package com.narayanjoshi.gplapplication.service.command;

import com.narayanjoshi.gplapplication.Util;
import com.narayanjoshi.gplapplication.service.RootCommand;
import javafx.scene.paint.Color;

import java.util.List;

/**
 * The {@code FillCommand} class represents validation of command and
 * performing draw operation of triangle based on defined instruction.
 * Triangle is draw based on pen position and by using base and adjacent.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
public class TriangleCommand extends RootCommand {

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(String command) {

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
