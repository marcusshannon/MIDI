package cs3500.music.view;

import java.awt.*;

import javax.swing.*;

/**
 * Class to represent the a view panel with beats
 */
public class BeatMarkerPanel extends JPanel {

  private final GuiViewModel vm;

  BeatMarkerPanel(GuiViewModel vm) {
    this.vm = vm;
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(1000, 20);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    int startBeat = vm.getStartBeat();
    for (int i = startBeat; i < startBeat + 64; i = i + 1) {
      if (i % 16 == 0) {
        g.drawString(Integer.toString(i), 43 + (i - startBeat) * 15, 17);
        g.drawLine(40 + (i - startBeat) * 15, 5, 40 + (i - startBeat) * 15, 20);
      }
    }
  }
}
