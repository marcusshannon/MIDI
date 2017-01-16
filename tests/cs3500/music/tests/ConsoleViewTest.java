package cs3500.music.tests;

import org.junit.Test;

import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;

import cs3500.music.model.Composition;
import cs3500.music.model.CompositionImpl;
import cs3500.music.view.ConsoleView;
import cs3500.music.view.View;

import static org.junit.Assert.assertEquals;

/**
 * Class to test console view
 */
public class ConsoleViewTest {

  Appendable out = new StringBuilder();
  Composition composition = CompositionImpl.builder().addNote(0, 4, 0, 60, 127).build();
  View view = ConsoleView.builder().input(composition).output(out).build();


  @Test
  public void drawAsExpected() throws IOException, InvalidMidiDataException {
    view.initialize();
    assertEquals("  C4\n" +
            "0 X \n" +
            "1 | \n" +
            "2 | \n" +
            "3 | \n", out.toString());
  }
}