package cs3500.music.model;

/**
 * Class to represent a type of playable, a regular note
 */
public class NoteImpl implements Playable {

  private final int startBeat;

  private final int endBeat;

  private final int instrument;

  private final int pitch;

  private final int volume;

  public NoteImpl(int startBeat, int endBeat, int instrument, int pitch, int volume) {
    if (startBeat < 0) {
      throw new IllegalArgumentException("Note can't start before 0");
    }
    if (endBeat < startBeat) {
      throw new IllegalArgumentException("Note has to be at least 1 beat");
    }
    if (pitch > 127 || pitch < 0) {
      throw new IllegalArgumentException("Pitch has to be between 0 and 127");
    }
    if (volume > 127 || volume < 0) {
      throw new IllegalArgumentException("Volume has to be between 0 and 127");
    }
    this.startBeat = startBeat;
    this.endBeat = endBeat;
    this.pitch = pitch;
    this.volume = volume;
    this.instrument = instrument;
  }

  @Override
  public int getStartBeat() {
    return this.startBeat;
  }

  @Override
  public int getEndBeat() {
    return this.endBeat;
  }

  @Override
  public int getPitch() {
    return this.pitch;
  }

  @Override
  public int getVolume() {
    return this.volume;
  }

  @Override
  public int getChannel() {
    return this.instrument;
  }
}
