package cs3500.music.model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Class to represent channels that contain playables
 */
public class ChannelImpl implements Channel {

  private final int channel;
  //Invariant: between 0 and 16

  private final TreeMap<Integer, TreeMap<Integer, Playable>> music;

  public ChannelImpl(int channel) {
    if (channel < 0 || channel > 15) {
      throw new IllegalArgumentException("Illegal Channel");
    }
    this.channel = channel;
    this.music = new TreeMap<>();
  }

  @Override
  public Playable getNote(int beat, int pitch) {
    if (!this.music.containsKey(beat)) {
      throw new IllegalArgumentException("No note at that position");
    }
    if (!this.music.get(beat).containsKey(pitch)) {
      throw new IllegalArgumentException("No note at that position");
    }
    return this.music.get(beat).get(pitch);
  }

  @Override
  public void addNote(int startBeat, int endBeat, int instrument, int pitch, int volume) {
    for (int i = startBeat; i < endBeat; i = i + 1) {
      if (this.music.containsKey(i)) {
        if (this.music.get(i).containsKey(pitch)) {
          throw new IllegalArgumentException("Occupied");
        }
      }
    }
    for (int i = startBeat; i < endBeat; i = i + 1) {
      if (!this.music.containsKey(i)) {
        this.music.put(i, new TreeMap<>());
      }
      this.music.get(i).put(pitch, new NoteImpl(startBeat, endBeat, instrument, pitch, volume));
    }
  }

  @Override
  public int getChannel() {
    return this.channel;
  }

  @Override
  public List<Playable> getNotes() {
    List<Playable> notes = new ArrayList<>();
    for (int key : this.music.keySet()) {
      notes.addAll(this.getNotesAtBeat(key, 0, 127));
    }
    return notes;
  }

  @Override
  public List<Playable> getNotesAtBeat(int beat, int pitchLow, int pitchHigh) {
    ArrayList<Playable> notes = new ArrayList<>();
    if (!this.music.containsKey(beat)) {
      return notes;
    }
    for (int i = pitchLow; i <= pitchHigh; i = i + 1) {
      if (this.music.get(beat).containsKey(i)) {
        notes.add(this.music.get(beat).get(i));
      }
    }
    return notes;
  }

  public List<Playable> getNoteWindow(int startBeat, int endBeat, int pitchLow, int pitchHigh) {
    ArrayList<Playable> notes = new ArrayList<>();
    for (int i = startBeat; i < endBeat; i = i + 1) {
      notes.addAll(this.getNotesAtBeat(i, pitchLow, pitchHigh));
    }
    return notes;
  }

  @Override
  public int getLowestPitch() {
    if (this.music.isEmpty()) {
      throw new IllegalStateException("No pitches");
    }
    int firstBeat = this.music.firstKey();
    int lowestPitch = music.get(firstBeat).firstKey();
    for (TreeMap<Integer, Playable> beat : this.music.values()) {
      int beatLowestPitch = beat.firstKey();
      if (beatLowestPitch < lowestPitch) {
        lowestPitch = beatLowestPitch;
      }
    }
    return lowestPitch;
  }

  @Override
  public int getHighestPitch() {
    if (this.music.isEmpty()) {
      throw new IllegalStateException("No pitches");
    }
    int firstBeat = this.music.firstKey();
    int highestPitch = music.get(firstBeat).lastKey();
    for (TreeMap<Integer, Playable> beat : this.music.values()) {
      int beatHighestPitch = beat.lastKey();
      if (beatHighestPitch > highestPitch) {
        highestPitch = beatHighestPitch;
      }
    }
    return highestPitch;
  }

  @Override
  public int getLastBeat() {
    return this.music.lastKey() + 1;
  }

  @Override
  public void deleteNote(int beat, int pitch) {
    if (!this.music.containsKey(beat)) {
      return;
    }
    if (!this.music.get(beat).containsKey(pitch)) {
      return;
    }
    int startBeat = this.music.get(beat).get(pitch).getStartBeat();
    int endBeat = this.music.get(beat).get(pitch).getEndBeat();
    for (int i = startBeat; i < endBeat; i = i + 1) {
      this.music.get(i).remove(pitch);
      if (this.music.get(i).isEmpty()) {
        this.music.remove(i);
      }
    }
  }

  public boolean isEmpty() {
    return this.music.isEmpty();
  }

}