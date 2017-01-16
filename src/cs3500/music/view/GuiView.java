package cs3500.music.view;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 * Interface for gui views
 */
public interface GuiView extends View {

  /**
   * repaints everything
   */
  void refresh();

  /**
   * repaints the pitch panel
   */
  void refreshPitches();

  /**
   * repaints the beat panel
   */
  void refreshBeats();

  /**
   * repaints the music panel
   */
  void refreshMusic();

  /**
   * moves the cursor over one beat to the right, more efficient than redrawing everything
   */
  void cursorToNextBeat();

  /**
   * Use to set the key listener for the gui view
   * @param l the keylistener
   */
  void setKeyListener(KeyListener l);

  /**
   * Use to to set the mouse listener for the gui view
   * @param l the mouse listener
   */
  void setMouseListener(MouseListener l);

}
