//package cs3500.music.view;
//
//import java.util.Timer;
//
///**
// * Created by marcusshannon on 11/25/15.
// */
//public class Play implements Runnable {
//
//  Controller controller;
//
//  public Play(Controller controller) {
//    this.controller = controller;
//  }
//
//  @Override
//  public void run() {
//    if (!controller.playing) {
//      controller.timer = new Timer();
//      controller.timer.schedule(new PlayNotesAtBeatTask(controller), 0,
//              controller.model.getTempo() / 1000);
//      controller.playing = true;
//      return;
//    }
//    if (controller.playing) {
//      controller.timer.cancel();
//      controller.playing = false;
//    }
//  }
//}
