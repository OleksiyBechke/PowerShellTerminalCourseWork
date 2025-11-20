package org.kpi.pattern.interpreter;

import javafx.scene.paint.Color;
import org.kpi.pattern.strategy.ColorTheme;
import org.kpi.pattern.strategy.ThemeManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас-клієнт патерну Interpreter.
 * Визначає колір тексту виводу, перевіряючи його на відповідність набору правил.
 */
public class SyntaxHighlighter {

    private final List<Expression> expressions = new ArrayList<>();

    public SyntaxHighlighter() {
        expressions.add(new ErrorExpression());
        expressions.add(new SuccessExpression());
    }

    public Color determineColor(String outputText) {
        ColorTheme theme = ThemeManager.getInstance().getTheme();
        for (Expression expr : expressions) {
            if (expr.interpret(outputText)) {
                // Як тільки правило спрацювало, повертаємо його колір
                return expr.getColor();
            }
        }
        // Якщо жодне правило не спрацювало, це звичайний текст
        return theme.getTextColor();
    }
}