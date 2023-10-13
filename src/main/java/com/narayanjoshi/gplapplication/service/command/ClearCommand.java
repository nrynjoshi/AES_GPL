package com.narayanjoshi.gplapplication.service.command;

import com.narayanjoshi.gplapplication.Util;
import com.narayanjoshi.gplapplication.service.RootCommand;

/**
 * The {@code ClearCommand} class represents validation of command and
 * performing clearance of draw area without moving pen position.
 *
 * @author Narayan Joshi
 * @since v1.0
 * */
public class ClearCommand extends RootCommand {

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(String command) {
        canvasUtil.getGraphicsContext().clearRect(0, 0, canvasUtil.getCanvasId().getWidth(), canvasUtil.getCanvasId().getHeight());
    }

}
