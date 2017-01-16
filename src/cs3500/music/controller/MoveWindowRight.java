package cs3500.music.controller;

import cs3500.music.controller.Controller;

/**
 * Created by marcusshannon on 11/19/15.
 */
public class MoveWindowRight implements Runnable {

  Controller controller;

  public MoveWindowRight(Controller controller) {
    this.controller = controller;
  }

  @Override
  public void run() {
    controller.moveRight();
  }
}
