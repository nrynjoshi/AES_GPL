package com.narayanjoshi.gplapplication.service.command.draw;

import com.narayanjoshi.gplapplication.util.Util;

import java.util.List;

/**
 * The {@code FillCommand} class represents validation of command and
 * performing draw operation of triangle based on defined instruction.
 * Triangle is draw based on pen position and by using base and adjacent.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
public class TriangleCommand extends DrawRootCommand {

    /**
     * {@inheritDoc}
     * This method will draw a triangle by taking user input command. 
     * This will read base and adjacent of the triangle from parameter of that particular command and draw a triangle. 
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
