package cs3500.music.controller;

import cs3500.music.controller.Controller;

/**
 * Created by marcusshannon on 11/19/15.
 */
public class MoveWindowLeft implements Runnable {

  Controller controller;

  public MoveWindowLeft(Controller controller) {
    this.controller = controller;
  }

  @Override
  public void run() {
    this.controller.moveLeft();
  }
}
