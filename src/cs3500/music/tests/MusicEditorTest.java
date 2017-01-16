//package cs3500.music.tests;
//
//import org.junit.Test;
//
//import cs3500.music.model.MusicEditor;
//import cs3500.music.model.MusicEditorImpl;
//
//import static org.junit.Assert.assertEquals;
//
///**
// * Created by marcusshannon on 11/6/15.
// */
//public class MusicEditorTest {
//
//    MusicEditor m = new MusicEditorImpl.Builder().build();
//
//    @Test
//    public void randomTests() {
//        m.addNote(0, 3, 0, 0, 100);
//        assertEquals("00", m.getNote(0, 0, 0));
//
//        m.addNote(0, 12, 1, 55, 100);
//        m.addNote(2, 10, 1, 57, 100);
//        m.addNote(4, 15, 1, 58, 100);
//        m.consoleOut(1);
//    }
//
//}