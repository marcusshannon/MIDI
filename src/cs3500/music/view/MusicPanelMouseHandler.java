//package cs3500.music.view;
//
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//
//import cs3500.music.model.Playable;
//
///**
// * Created by marcusshannon on 11/25/15.
// */
//public class MusicPanelMouseHandler implements MouseListener {
//
//  Controller controller;
//  int startBeat;
//  int endBeat;
//  int pitch;
//  Playable tempNote;
//  boolean moving;
//
//  MusicPanelMouseHandler(Controller controller) {
//    this.controller = controller;
//    this.startBeat = 0;
//    this.endBeat = 0;
//    this.pitch = 0;
//    this.tempNote = null;
//    this.moving = false;
//  }
//
//  @Override
//  public void mouseClicked(MouseEvent e) {
//    int beat = e.getX() / 15 + controller.startBeat;
//    int pitch = (controller.lowestPitch + 27) - e.getY() / 20;
//    if (e.getButton() == MouseEvent.BUTTON3) {
//      try {
//        controller.model.deleteNote(beat, pitch);
//      } catch (Exception ex) {
//
//      }
//      controller.refresh();
//    }
//  }
//
//  @Override
//  public void mousePressed(MouseEvent e) {
//    if (e.getButton() == MouseEvent.BUTTON3) {
//      return;
//    }
//    int beat = e.getX() / 15 + controller.startBeat;
//    int pitch = (controller.lowestPitch + 27) - e.getY() / 20;
//    try {
//      tempNote = controller.model.getNote(beat, 1, pitch);
//    } catch (Exception ex) {
//
//    }
//    if (tempNote == null) {
//      if (e.getButton() == MouseEvent.BUTTON1) {
//        this.startBeat = e.getX() / 15 + controller.startBeat;
//        this.pitch = (controller.lowestPitch + 27) - e.getY() / 20;
//      }
//    } else {
//      this.moving = true;
//      controller.model.deleteNote(beat, pitch);
//    }
//  }
//
//  @Override
//  public void mouseReleased(MouseEvent e) {
//    if (e.getButton() == MouseEvent.BUTTON3) {
//      return;
//    }
//    if (this.moving) {
//      int beat = e.getX() / 15 + controller.startBeat - 1;
//      int pitch = (controller.lowestPitch + 27) - e.getY() / 20;
//      int endbeat = beat + tempNote.getEndBeat() - tempNote.getStartBeat();
//      int instrument = tempNote.getChannel();
//      int volume = tempNote.getVolume();
//      try {
//        controller.model.addNote(beat, endbeat, instrument, pitch, volume);
//      } catch (Exception ex) {
//
//      }
//      this.controller.refresh();
//      this.tempNote = null;
//    }
//    if (e.getButton() == MouseEvent.BUTTON1 && !moving) {
//      this.endBeat = e.getX() / 15 + controller.startBeat + 1;
//      try {
//        this.controller.model.addNote(startBeat, endBeat, 1, pitch, 127);
//      } catch (Exception ex) {
//
//      }
//      controller.refresh();
//    }
//    this.moving = false;
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
