package com.narayanjoshi.gplapplication.service.command.draw;

/**
 * The {@code ClearCommand} class represents validation of command and
 * performing clearance of draw area without moving pen position.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
public class ClearCommand extends DrawRootCommand {

    /**
     * {@inheritDoc}
     * This method will clear the drawing area but does not move the pen position.
     */
    @Override
    public void draw(String command) {
        canvasUtil.getGraphicsContext().clearRect(0, 0, canvasUtil.getCanvasId().getWidth(), canvasUtil.getCanvasId().getHeight());
    }

}
