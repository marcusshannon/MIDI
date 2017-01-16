//package cs3500.music.view;
//
///**
// * Created by marcusshannon on 11/24/15.
// */
//public class PlayNotesAtBeatTask extends java.util.TimerTask {
//
//  Controller controller;
//
//  public PlayNotesAtBeatTask(Controller controller) {
//    this.controller = controller;
//  }
//
//  @Override
//  public void run() {
//    controller.midi.beat = controller.currentBeat;
//    controller.midi.notes = controller.model.getNotesAtBeat(controller.currentBeat);
//    try {
//      controller.midi.play();
//    } catch (Exception e) {
//    }
//    controller.updateCursor();
//    controller.currentBeat = controller.currentBeat + 1;
//  }
//}
