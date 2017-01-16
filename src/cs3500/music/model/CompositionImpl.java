package cs3500.music.model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import cs3500.music.util.CompositionBuilder;

/**
 * Model to represent compositions, which are made up of different channels.
 */
public class CompositionImpl implements Composition {
  private int tempo;
  private final TreeMap<Integer, Channel> channels;

  private CompositionImpl(int tempo, TreeMap<Integer, Channel> channels) {
    this.tempo = tempo;
    this.channels = channels;
  }

  @Override
  public Playable getNote(int startBeat, int instrument, int pitch) {
    if (!this.channels.containsKey(instrument)) {
      throw new IllegalArgumentException("No note at that position");
    }
    return this.channels.get(instrument).getNote(startBeat, pitch);
  }

  public void deleteNote(int startBeat, int instrument, int pitch) {
    if (!this.channels.containsKey(instrument)) {
      throw new IllegalArgumentException("No note at this beat");
    }
    this.channels.get(instrument).deleteNote(startBeat, pitch);
    if (this.channels.get(instrument).isEmpty()) {
      this.channels.remove(instrument);
    }
  }

  @Override
  public void addNote(int startBeat, int endBeat, int instrument, int pitch, int volume) {
    if (startBeat < 0) {
      throw new IllegalArgumentException("Note can't start before 0");
    }
    if (endBeat <= startBeat) {
      throw new IllegalArgumentException("Note has to be at least 1 beat");
    }
    if (instrument < 0 || instrument > 127) {
      throw new IllegalArgumentException("Instrument has to be greater than 0");
    }
    if (pitch < 0 || pitch > 127) {
      throw new IllegalArgumentException("Pitch has to be between 0 and 127");
    }
    if (volume < 0 || volume > 127) {
      throw new IllegalArgumentException("Volume has to be between 0 and 127");
    }
    if (!this.channels.containsKey(instrument)) {
      this.channels.put(instrument, new ChannelImpl(instrument));
    }
    this.channels.get(instrument).addNote(startBeat, endBeat, instrument, pitch, volume);
  }

  @Override
  public void setTempo(int tempo) {
    if (tempo < 0) {
      throw new IllegalArgumentException("Tempo has to be greater than zero");
    }
    this.tempo = tempo;
  }

  public void deleteNote(int beat, int pitch) {
    for (Channel channel : this.channels.values()) {
      channel.deleteNote(beat, pitch);
    }
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public List<Channel> getChannels() {
    return new ArrayList<>(this.channels.values());
  }

  @Override
  public int getTempo() {
    return this.tempo;
  }

  public int getLowestPitch() {
    if (this.channels.isEmpty()) {
      throw new IllegalStateException("No notes");
    }
    int firstChannel = this.channels.firstKey();
    int lowestPitch = this.channels.get(firstChannel).getLowestPitch();
    for (Channel channel : this.channels.values()) {
      int channelLowestPitch = channel.getLowestPitch();
      if (channelLowestPitch < lowestPitch) {
        lowestPitch = channelLowestPitch;
      }
    }
    return lowestPitch;
  }

  @Override
  public int getHighestPitch() {
    if (this.channels.isEmpty()) {
      throw new IllegalStateException("No notes");
    }
    int firstChannel = this.channels.firstKey();
    int highestPitch = this.channels.get(firstChannel).getHighestPitch();
    for (Channel channel : this.channels.values()) {
      int channelHighestPitch = channel.getHighestPitch();
      if (channelHighestPitch > highestPitch) {
        highestPitch = channelHighestPitch;
      }
    }
    return highestPitch;
  }

  @Override
  public int getLastBeat() {
    int lastBeat = 0;
    for (Channel channel : this.channels.values()) {
      int channelLastBeat = channel.getLastBeat();
      if (channelLastBeat > lastBeat) {
        lastBeat = channelLastBeat;
      }
    }
    return lastBeat;
  }

  public List<Playable> getNotesAtBeat(int beat) {
    ArrayList<Playable> notes = new ArrayList<>();
    for (Channel channel : this.channels.values()) {
      notes.addAll(channel.getNotesAtBeat(beat, 0, 127));
    }
    return notes;
  }

  public List<Playable> getWindow(int startBeat, int lowestPitch) {
    List<Playable> notes = new ArrayList<>();
    for (Channel channel : this.channels.values()) {
      notes.addAll(channel.getNoteWindow(startBeat, startBeat + 64, lowestPitch, lowestPitch + 28));
    }
    return notes;
  }


  public static final class Builder implements CompositionBuilder<Composition> {

    private final TreeMap<Integer, Channel> channels = new TreeMap<>();
    private int tempo = 120000;


    @Override
    public CompositionImpl build() {
      return new CompositionImpl(this.tempo, this.channels);
    }

    @Override
    public CompositionBuilder<Composition> setTempo(int tempo) {
      this.tempo = tempo;
      return this;
    }

    @Override
    public CompositionBuilder<Composition> addNote(int start, int end, int instrument,
                                                   int pitch, int volume) {
      if (!this.channels.containsKey(instrument)) {
        this.channels.put(instrument, new ChannelImpl(instrument));
      }
      this.channels.get(instrument).addNote(start, end, instrument, pitch, volume);
      return this;
    }
  }
}
