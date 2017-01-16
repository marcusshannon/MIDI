package cs3500.music.view;

import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;

/**
 * Interface for views
 */
public interface View {
  /**
   * Call this method to run the view
   */
  void initialize() throws IOException, InvalidMidiDataException;

}
