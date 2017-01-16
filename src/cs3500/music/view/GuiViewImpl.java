package cs3500.music.view;


import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.*;

/**
 * The gui view to represent the composition
 */
public class GuiViewImpl extends JFrame implements GuiView {

  private final GuiViewModel vm;
  private final MusicViewPanel music;
  private final BeatMarkerPanel beats;
  private final PitchMarkerPanel pitches;

  /**
   * Creates new GuiView
   */
  public GuiViewImpl(GuiViewModel vm) {
    this.vm = vm;
    this.music = new MusicViewPanel(vm);
    this.beats = new BeatMarkerPanel(vm);
    this.pitches = new PitchMarkerPanel(vm);
    this.getContentPane().add(beats, BorderLayout.PAGE_START);
    this.getContentPane().add(pitches, BorderLayout.LINE_START);
    this.getContentPane().add(music, BorderLayout.CENTER);
    this.setFocusable(true);
    this.setResizable(false);
    this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    this.pack();
  }

  @Override
  public void refresh() {
    this.music.repaint();
    this.beats.repaint();
    this.pitches.repaint();
  }

  @Override
  public void refreshMusic() {
    this.music.repaint();
  }

  @Override
  public void refreshPitches() {
    this.pitches.repaint();
  }

  @Override
  public void refreshBeats() {
    this.beats.repaint();
  }

  @Override
  public void cursorToNextBeat() {
    int currentBeat = this.vm.getCurrentBeat();
    int newStart = currentBeat % 64 * 15;
    this.music.repaint((newStart - 15) - 1, 0, 2, 580);
    this.music.repaint(newStart, 0, 2, 580);
  }

  @Override
  public void setKeyListener(KeyListener l) {
    this.addKeyListener(l);
  }

  @Override
  public void setMouseListener(MouseListener l) {
    this.addMouseListener(l);
  }

  @Override
  public void initialize() {
    this.setVisible(true);
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(1000, 600);
  }
}