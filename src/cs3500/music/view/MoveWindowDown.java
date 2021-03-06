//package cs3500.music.view;
//
//import java.util.ArrayList;
//
//import cs3500.music.model.Channel;
//import cs3500.music.model.Playable;
//
///**
// * Created by marcusshannon on 11/19/15.
// */
//public class MoveWindowDown implements Runnable {
//
//  Controller controller;
//
//  public MoveWindowDown(Controller controller) {
//    this.controller = controller;
//  }
//
//  @Override
//  public void run() {
//    if (controller.lowestPitch == 0) {
//      return;
//    }
//    ArrayList<Playable> notes = new ArrayList<>();
//
//    for (Channel channel : controller.model.getChannels()) {
//      notes.addAll(channel.getNoteWindow(controller.startBeat, controller.startBeat + 64,
//              controller.lowestPitch - 1, controller.lowestPitch + 28));
//    }
//    this.controller.moveWindow(notes, controller.lowestPitch - 1, controller.startBeat);
//    this.controller.lowestPitch = this.controller.lowestPitch - 1;
//  }
//}
