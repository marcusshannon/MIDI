package cs3500.music.view;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;

/**
 * Class to represent a a view with both a gui and midi representation
 */
public class CompositeView  implements View, GuiView {

  private final GuiView guiView;
  private final View midiView;

  public CompositeView(GuiViewModel gvm, MidiViewModel mvm) {
    this.guiView = new GuiViewImpl(gvm);
    this.midiView = new MidiViewImpl(mvm);
  }

  @Override
  public void refresh() {
    guiView.refresh();
  }

  @Override
  public void refreshPitches() {
    guiView.refreshPitches();
  }

  @Override
  public void refreshBeats() {
    guiView.refreshBeats();
  }

  @Override
  public void refreshMusic() {
    guiView.refreshMusic();
  }

  @Override
  public void cursorToNextBeat() {
    guiView.cursorToNextBeat();
  }

  @Override
  public void setKeyListener(KeyListener l) {
    this.guiView.setKeyListener(l);
  }

  @Override
  public void setMouseListener(MouseListener l) {
    this.guiView.setMouseListener(l);
  }

  @Override
  public void initialize() throws IOException, InvalidMidiDataException {
    this.guiView.initialize();
    this.midiView.initialize();
  }
}
