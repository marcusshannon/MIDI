package cs3500.music.view;

import java.util.List;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Synthesizer;

import cs3500.music.model.Playable;

/**
 * Class for Midi playback
 */
public class MidiViewImpl implements View {

  private final MidiViewModel vm;
  private Synthesizer synth;
  private Receiver receiver;

  /**
   * Creates a new Midi view instance
   */
  public MidiViewImpl(MidiViewModel vm) {
    this.vm = vm;
    try {
      this.synth = MidiSystem.getSynthesizer();
      this.synth.open();
      this.receiver = synth.getReceiver();
    } catch (MidiUnavailableException e) {
      e.printStackTrace();
    }
  }

  public void initialize() throws InvalidMidiDataException {
    if (!vm.isPlaying()) {
      return;
    }
    List<Playable> notes = this.vm.getCurrentNotes();
    int currentBeat = this.vm.getCurrentBeat();
    int tempo = this.vm.getTempo();
    for (Playable note : notes) {
      if (note.getStartBeat() == currentBeat) {
        int pitch = note.getPitch();
        int volume = note.getVolume();
        int instrument = note.getChannel() - 1;
        int duration = (note.getEndBeat() - currentBeat) * tempo;
        MidiMessage start = new ShortMessage(ShortMessage.NOTE_ON, instrument, pitch, volume);
        MidiMessage stop = new ShortMessage(ShortMessage.NOTE_OFF, instrument, pitch, volume);
        this.receiver.send(start, -1);
        this.receiver.send(stop, this.synth.getMicrosecondPosition() + duration);
      }
    }
  }
}
