package cs3500.music.view;

import java.awt.*;

import javax.swing.*;

import static cs3500.music.util.MidiToString.midiToString;

/**
 * A class to represent the pitches in the gui view
 */
public class PitchMarkerPanel extends JPanel {

  private final GuiViewModel vm;

  PitchMarkerPanel(GuiViewModel vm) {
    this.vm = vm;
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(40, 580);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    int lowestPitch = this.vm.getLowestPitch();
    for (int i = lowestPitch; i < lowestPitch + 28; i = i + 1) {
      int y = 555 - (i - lowestPitch) * 20;
      g.drawString(midiToString(i), 0, y);
    }
  }
}
