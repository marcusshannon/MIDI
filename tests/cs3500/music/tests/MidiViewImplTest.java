//package cs3500.music.tests;
//
//import org.junit.Test;
//
//import javax.sound.midi.InvalidMidiDataException;
//
//import cs3500.music.model.Composition;
//import cs3500.music.model.CompositionImpl;
//import cs3500.music.view.MidiViewImpl;
//
//import static org.junit.Assert.assertEquals;
//
///**
// * Created by marcusshannon on 11/14/15.
// */
//public class MidiViewImplTest {
//
//  Composition composition = CompositionImpl.builder().addNote(0, 4, 1, 60, 127).build();
//  MidiViewImpl m = new MidiViewImpl(composition, true);
//
//  @Test
//  public void logAsExpected() throws InvalidMidiDataException {
//    m.initialize();
//    assertEquals("Start @ 0, Pitch: 60, Volume: 127\n" +
//            "Stop  @ 480000, Pitch: 60, Volume: 127\n", m.log.toString());
//  }
//
//}