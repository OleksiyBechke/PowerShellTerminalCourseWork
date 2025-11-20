package org.kpi.pattern.interpreter;

import javafx.scene.paint.Color;

public interface Expression {
    boolean interpret(String context);

    Color getColor();
}