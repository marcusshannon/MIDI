package cs3500.music.controller;

import cs3500.music.model.Composition;
import cs3500.music.view.CompositeView;
import cs3500.music.view.GuiViewModel;
import cs3500.music.view.KeyboardHandler;
import cs3500.music.view.MidiViewModel;

/**
 * Created by marcusshannon on 11/18/15.
 */
public class Controller {


  //private final View midi;
  private final GuiViewModel guiViewModel;
  private final MidiViewModel mvm;
  private final CompositeView compositeView;
  private final KeyboardHandler kbh;
  private final Composition model;
  //private final GuiView guiView;
  //public PlayNotesAtBeatTask play;
  //Boolean playing;
  //Timer timer;


  public Controller(Composition model) {
    this.model = model;
    this.guiViewModel = new GuiViewModel(model);
    //this.guiView = new GuiViewImpl(this.guiViewModel);
    this.mvm = new MidiViewModel(model);
    //this.midi = new MidiViewImpl(mvm);
    this.compositeView = new CompositeView(guiViewModel, mvm);
    this.kbh = new KeyboardHandler();
//    this.kbh.installPressed(38, new MoveWindowUp(this));
//    this.kbh.installPressed(40, new MoveWindowDown(this));
    this.kbh.installPressed(39, new MoveWindowRight(this));
    this.kbh.installPressed(37, new MoveWindowLeft(this));
//    this.kbh.installPressed(36, new Home(this));
//    this.kbh.installPressed(32, new Play(this));
//    this.kbh.installPressed(35, new End(this));
    this.compositeView.setKeyListener(this.kbh);
//    this.view.music.addMouseListener(new MusicPanelMouseHandler(this));
//    this.view.beats.addMouseListener(new BeatPanelMouseHandler(this));
    //this.playing = false;
    //this.currentBeat = 0;
    try {
      this.compositeView.initialize();
    } catch (Exception e) {

    }
  }

//  public void refresh() {
//    ArrayList<Playable> notes = new ArrayList<>();
//    for (Channel channel : this.model.getChannels()) {
//      notes.addAll(channel.getNoteWindow(startBeat, startBeat + 63, lowestPitch, lowestPitch + 27));
//    }
//  }
  public void moveRight() {
    int newStartBeat = this.guiViewModel.getStartBeat() + 1;
    this.guiViewModel.setStartBeat(newStartBeat);
    this.guiViewModel.setNotes(model.getWindow(newStartBeat, this.guiViewModel.getLowestPitch()));
    this.compositeView.refreshMusic();
    this.compositeView.refreshBeats();
  }

  public void moveLeft() {
    if (guiViewModel.getStartBeat() == 0) {
      return;
    }
    int newStartBeat = this.guiViewModel.getStartBeat() - 1;
    this.guiViewModel.setStartBeat(newStartBeat);
    this.guiViewModel.setNotes(model.getWindow(newStartBeat, this.guiViewModel.getLowestPitch()));
    this.compositeView.refreshMusic();
    this.compositeView.refreshBeats();
  }

//  public void updateCursor() {
//    int newStart = this.currentBeat / 64 * 64;
//    if (newStart != startBeat) {
//      this.startBeat = newStart;
//      this.refresh();
//    }
//    this.view.drawCursor(this.currentBeat);
//  }
}
