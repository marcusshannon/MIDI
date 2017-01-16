//package cs3500.music.view;
//
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//
///**
// * Created by marcusshannon on 11/25/15.
// */
//public class BeatPanelMouseHandler implements MouseListener {
//
//  Controller controller;
//
//  public BeatPanelMouseHandler(Controller controller) {
//    this.controller = controller;
//  }
//
//  @Override
//  public void mouseClicked(MouseEvent e) {
//    if (e.getButton() == MouseEvent.BUTTON1) {
//      int newBeat = (e.getX() - 20) / 15 + controller.startBeat;
//      controller.currentBeat = newBeat - 1;
//    }
//    controller.updateCursor();
//    controller.view.repaint();
//  }
//
//  @Override
//  public void mousePressed(MouseEvent e) {
//
//  }
//
//  @Override
//  public void mouseReleased(MouseEvent e) {
//
//  }
//
//  @Override
//  public void mouseEntered(MouseEvent e) {
//
//  }
//
//  @Override
//  public void mouseExited(MouseEvent e) {
//
//  }
//}
