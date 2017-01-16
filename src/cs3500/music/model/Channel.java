package cs3500.music.model;

import java.util.List;

/**
 * Interface to use channels to be played by midi
 */
public interface Channel {

  /**
   * Get the channel number of this channel
   *
   * @return the channel number of this channel
   */
  int getChannel();

  /**
   * Get a list of playables
   *
   * @return a list of playable
   */
  List<Playable> getNotes();

  /**
   * Get the lowest pitch
   *
   * @return the lowest pitch in the channel
   */
  int getLowestPitch();

  /**
   * Get the highest pitch
   *
   * @return the highest pitch in the channel
   */
  int getHighestPitch();

  /**
   * Get the last beat in the channel
   *
   * @return the last beat in the channel
   */
  int getLastBeat();

  /**
   * Add a note to this channel
   *
   * @param start  startbeat
   * @param end    endbeat
   * @param pitch  the pitch in midi
   * @param volume the volume
   */
  void addNote(int start, int end, int instrument, int pitch, int volume);

  /**
   * Get the playable at:
   *
   * @param beat  the start
   * @param pitch the pitch in midi
   * @return the playable at that position
   */
  Playable getNote(int beat, int pitch);

  /**
   * Get the notes at a certain beat and pitch range
   * @param beat the beat the notes are at
   * @param pitchLow the lowest pitch to include
   * @param pitchHigh the highest pitch to include
   * @return a list of playables that occur on the beat and pitch range
   */
  List<Playable> getNotesAtBeat(int beat, int pitchLow, int pitchHigh);

  /**
   * Gets all notes from start beat to start beat + 63, and lowest pitch to lowest pitch + 27
   * Example: getWindow(0, 60) will get all notes that happen on beats 0-63 and pitches 60-87
   * @param start startbeat and startbeat + 63 along with
   * @param pitchLow lowest pitch and lowest pitch + 27 is the range of notes to get
   * @return the list of playables that are relevant to that window
   */
  List<Playable> getNoteWindow(int start, int end, int pitchLow, int pitchHigh);

  /**
   * delete a note
   *
   * @param startBeat start beat
   * @param pitch     the pitch in midi
   */
  void deleteNote(int startBeat, int pitch);

  /**
   * Checks if the channel is empty
   * @return if the channel has any music or not
   */
  boolean isEmpty();
}
