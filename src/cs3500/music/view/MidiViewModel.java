package cs3500.music.view;

import java.util.List;

import cs3500.music.model.Composition;
import cs3500.music.model.Playable;

/**
 * Class to represent a view model for midi view
 */
public class MidiViewModel {

  private int tempo;
  private int currentBeat;
  private boolean playing;
  private List<Playable> currentNotes;

  public MidiViewModel(Composition model) {
    this.tempo = model.getTempo();
    this.currentBeat = 0;
    this.playing = false;
    this.currentNotes = model.getNotesAtBeat(0);
  }

  public int getTempo() {
    return tempo;
  }

  public List<Playable> getCurrentNotes() {
    return currentNotes;
  }

  public void setTempo(int tempo) {
    if (tempo < 0) {
      throw new IllegalArgumentException("Tempo can't be negative");
    }
    this.tempo = tempo;
  }

  public void setCurrentNotes(List<Playable> currentNotes) {
    this.currentNotes = currentNotes;
  }

  public int getCurrentBeat() {
    return currentBeat;
  }

  /**
   * Set the current beat to remember where playback is
   * @param currentBeat the current beat
   */
  public void setCurrentBeat(int currentBeat) {
    if (currentBeat < 0) {
      throw new IllegalArgumentException("Current beat can't be negative");
    }
    this.currentBeat = currentBeat;
  }

  /**
   * Returns whether the midi is playing or not
   * @return whether the midi is playing or not
   */
  public boolean isPlaying() {
    return playing;
  }

  public void setPlaying(boolean playing) {
    this.playing = playing;
  }
}
