package com.example.gplapplication.service;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;

public interface DrawShapeIfc {


    void draw(String command);

    void setCanvas(Canvas canvas);

//    void clear();

}
