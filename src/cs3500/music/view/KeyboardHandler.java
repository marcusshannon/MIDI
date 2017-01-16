package cs3500.music.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by marcusshannon on 11/19/15.
 */
public class KeyboardHandler implements KeyListener {

  private final Map<Integer, Runnable> typed;
  private final Map<Integer, Runnable> pressed;
  private final Map<Integer, Runnable> released;

  public KeyboardHandler() {
    this.typed = new HashMap<>();
    this.pressed = new HashMap<>();
    this.released = new HashMap<>();
  }

  @Override
  public void keyTyped(KeyEvent e) {
    if (this.typed.containsKey(e.getExtendedKeyCode())) {
      this.typed.get(e.getKeyCode()).run();
    }
  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (this.pressed.containsKey(e.getKeyCode())) {
      this.pressed.get(e.getKeyCode()).run();
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    if (this.released.containsKey(e.getKeyCode())) {
      this.released.get(e.getKeyCode()).run();
    }
  }

  public void installTyped(Integer e, Runnable runnable) {
    this.typed.put(e, runnable);
  }

  public void installPressed(Integer e, Runnable runnable) {
    this.pressed.put(e, runnable);
  }

  public void installReleased(Integer e, Runnable runnable) {
    this.released.put(e, runnable);
  }
}
