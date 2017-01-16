package cs3500.music.model;

import java.util.List;

/**
 * Interface to use full compositions
 */
public interface Composition {

  /**
   * get the channels in this composition
   *
   * @return a list of channels
   */
  List<Channel> getChannels();

  /**
   * Get the lowest pitch
   *
   * @return the lowest pitch in the composition
   */
  int getLowestPitch();

  /**
   * Get the highest pitch
   *
   * @return the highest pitch in the composition
   */
  int getHighestPitch();

  /**
   * Get the last beat in the channel
   *
   * @return the last beat in the comsposition
   */
  int getLastBeat();

  /**
   * Add a note to this composition
   *
   * @param startBeat  startbeat
   * @param endBeat    endbeat
   * @param pitch      the pitch in midi
   * @param instrument the channel/instrument of this note
   * @param volume     the volume
   */
  void addNote(int startBeat, int endBeat, int instrument, int pitch, int volume);

  /**
   * get a note from this compositions
   *
   * @param startBeat  the beat it starts on
   * @param instrument the channel/instrument it is
   * @param pitch      the pitch it is
   * @return the playable
   */
  Playable getNote(int startBeat, int instrument, int pitch);

  /**
   * Get all notes at a beat
   *
   * @param beat the beat to get notes at
   * @return list of playables that happen on the beat
   */
  List<Playable> getNotesAtBeat(int beat);

  /**
   * delete a note
   *
   * @param startBeat start beat
   * @param pitch     the pitch in midi
   */
  void deleteNote(int startBeat, int instrument, int pitch);

  void deleteNote(int beat, int pitch);

  /**
   * Gets all notes from start beat to start beat + 63, and lowest pitch to lowest pitch + 27
   * Example: getWindow(0, 60) will get all notes that happen on beats 0-63 and pitches 60-87
   *
   * @param startBeat   startbeat and startbeat + 63 along with
   * @param lowestPitch lowest pitch and lowest pitch + 27 is the range of notes to get
   * @return the list of playables that are relevant to that window
   */
  List<Playable> getWindow(int startBeat, int lowestPitch);

  /**
   * set the tempo
   *
   * @param tempo the tempo
   */
  void setTempo(int tempo);

  /**
   * get the tempo
   *
   * @return the tempo in microseconds
   */
  int getTempo();
}
