package cs3500.music;

import java.io.FileReader;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import cs3500.music.model.Composition;
import cs3500.music.model.CompositionImpl;
import cs3500.music.util.CompositionBuilder;
import cs3500.music.util.MusicReader;
import cs3500.music.controller.Controller;
import cs3500.music.view.GuiViewModel;


public class Main {
  public static void main(String[] args) throws IOException, InvalidMidiDataException,
          MidiUnavailableException, InterruptedException {
    String filename = args[0];
    Readable file = new FileReader("resources/" + filename);
    CompositionBuilder<Composition> model = CompositionImpl.builder();
    Composition composition = MusicReader.parseFile(file, model);


    GuiViewModel vm = new GuiViewModel(composition);
    //GuiViewFrame gui = new GuiViewFrame(vm);
    //gui.initialize();
    Controller c = new Controller(composition);
    //c.initialize();
  }
}