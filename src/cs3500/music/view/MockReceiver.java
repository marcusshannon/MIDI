package cs3500.music.view;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;

/**
 * Class to represent a mock receiver
 */
public class MockReceiver implements Receiver {

  public StringBuilder log;

  MockReceiver(StringBuilder log) {
    this.log = log;
  }

  @Override
  public void send(MidiMessage message, long timeStamp) {
    byte[] categories = message.getMessage();
    int onoff = categories[0];
    if (onoff == -112) {
      log.append("Start @ " + timeStamp + ", ");
    } else {
      log.append("Stop  @ " + timeStamp + ", ");
    }
    int pitch = categories[1];
    log.append("Pitch: " + pitch + ", ");
    int volume = categories[2];
    log.append("Volume: " + volume + "\n");
  }

  @Override
  public void close() {

  }
}
