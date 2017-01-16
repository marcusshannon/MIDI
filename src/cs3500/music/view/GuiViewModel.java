package cs3500.music.view;

import java.util.List;

import cs3500.music.model.Composition;
import cs3500.music.model.Playable;

/**
 * View model for the gui view
 */
public class GuiViewModel {

  private int lowestPitch;
  private int startBeat;
  private int currentBeat;
  private List<Playable> currentNotes;

  public GuiViewModel(Composition model) {
    this.lowestPitch = model.getLowestPitch();
    this.startBeat = 0;
    this.currentBeat = 0;
    this.currentNotes = model.getWindow(startBeat, lowestPitch);
  }

  public void setLowestPitch(int pitch) {
    this.lowestPitch = pitch;
  }

  public void setStartBeat(int startBeat) {
    this.startBeat = startBeat;
  }

  /**
   * Set the current notes for the model
   * @param notes the notes that will be drawn
   */
  public void setNotes(List<Playable> notes) {
    this.currentNotes = notes;
  }

  public int getLowestPitch() {
    return this.lowestPitch;
  }

  /**
   * Get the current notes for the model
   */
  public List<Playable> getCurrentNotes() {
    return this.currentNotes;
  }

  /**
   * The beat is where the red line cursor is
   * @param currentBeat the beat where the cursor is drawn
   */
  public void setCurrentBeat(int currentBeat) {
    this.currentBeat = currentBeat;
  }

  /**
   * The first beat that is drawn, then the next 63 are drawn
   */
  public int getCurrentBeat() {
    return this.currentBeat;
  }

  /**
   * The first beat that is drawn, then the next 63 are drawn
   */
  public int getStartBeat() {
    return this.startBeat;
  }

  public void setCurrentNotes(List<Playable> currentNotes) {
    this.currentNotes = currentNotes;
  }
}
