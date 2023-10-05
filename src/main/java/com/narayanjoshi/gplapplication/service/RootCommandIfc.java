package com.narayanjoshi.gplapplication.service;

import com.narayanjoshi.gplapplication.CanvasUtil;

public interface RootCommandIfc {
    void init(CanvasUtil canvasUtil, String command, String param);
    void draw(String command);

    void validate(String inputCommand);

}
