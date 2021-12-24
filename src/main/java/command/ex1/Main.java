package command.ex1;

import command.ex1.command.Command;
import command.ex1.command.MacroCommand;
import command.ex1.drawer.ColorCommand;
import command.ex1.drawer.DrawCanvas;
import command.ex1.drawer.DrawCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener, MouseMotionListener, WindowListener {
    // 绘制的历史记录
    private MacroCommand history = new MacroCommand();
    // 绘制区域
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    // 删除按钮
    private JButton clearButton = new JButton("clear");

    private JButton redButton = new JButton("red");

    private JButton greenButton = new JButton("green");

    private JButton blueButton = new JButton("blue");

    public Main(String title) {
        super(title);

        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);
        clearButton.addActionListener(this);
        redButton.addActionListener(this);
        greenButton.addActionListener(this);
        blueButton.addActionListener(this);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        buttonBox.add(redButton);
        buttonBox.add(greenButton);
        buttonBox.add(blueButton);

        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        show();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            history.clear();
            canvas.repaint();
        } else if (e.getSource() == redButton) {
            colorCommandRun(Color.red);
        } else if (e.getSource() == blueButton) {
            colorCommandRun(Color.blue);
        } else if (e.getSource() == greenButton) {
            colorCommandRun(Color.green);
        }
    }

    private void colorCommandRun(Color color) {
        ColorCommand colorCommand = new ColorCommand(canvas, color);
        history.append(colorCommand);
        colorCommand.execute();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Command drawCommand = new DrawCommand(canvas, e.getPoint());
        history.append(drawCommand);
        drawCommand.execute();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
