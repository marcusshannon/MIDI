package cs3500.music.view;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import cs3500.music.model.Playable;

/**
 * A class to represent the composition in the gui view
 */
public class MusicViewPanel extends JPanel {

  private final GuiViewModel vm;

  MusicViewPanel(GuiViewModel vm) {
    this.vm = vm;
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(960, 580);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    int startBeat = this.vm.getStartBeat();
    int lowestPitch = this.vm.getLowestPitch();
    int currentBeat = this.vm.getCurrentBeat();
    List<Playable> notes = this.vm.getCurrentNotes();
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.BLACK);
    for (int i = 0; i <= 29; i = i + 1) {
      int x1 = 0;
      int x2 = 960;
      int y = i * 20;
      g2d.drawLine(x1, y, x2, y);
    }
    g2d.drawLine(0, 0, 0, 560);
    for (int i = startBeat; i < startBeat + 64; i = i + 1) {
      if (i % 4 == 0) {
        g.drawLine((i - startBeat) * 15, 0, (i - startBeat) * 15, 560);
      }
    }
    for (Playable note : notes) {
      int noteStart = note.getStartBeat();
      int noteEnd = note.getEndBeat();
      int notePitch = note.getPitch();
      int noteLength = noteEnd - noteStart;
      g2d.setPaint(Color.RED);
      g2d.fillRect((noteStart - startBeat) * 15, 540 - (notePitch - lowestPitch) * 20,
              noteLength * 15, 20);
      g2d.setPaint(Color.BLACK);
      g2d.fillRect((noteStart - startBeat) * 15, 540 - (notePitch - lowestPitch) * 20,
              15, 20);
    }
    g.setColor(Color.RED);
    int cursorLocation = currentBeat * 15 - startBeat * 15;
    if (cursorLocation > -5 || cursorLocation < 1500) {
      g.drawLine(cursorLocation, 0, cursorLocation, 580);
    }
  }
}