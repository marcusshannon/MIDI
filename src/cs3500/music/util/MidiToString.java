package cs3500.music.util;

/**
 * Class to change midi numbers to note names
 */
public final class MidiToString {

  public static String midiToString(int midi) {
    int octave = midi / 12 - 1;
    int key = midi % 12;
    String result = "";
    switch (key) {
      case 0:
        result = "C";
        break;
      case 1:
        result = "C#";
        break;
      case 2:
        result = "D";
        break;
      case 3:
        result = "D#";
        break;
      case 4:
        result = "E";
        break;
      case 5:
        result = "F";
        break;
      case 6:
        result = "F#";
        break;
      case 7:
        result = "G";
        break;
      case 8:
        result = "G#";
        break;
      case 9:
        result = "A";
        break;
      case 10:
        result = "A#";
        break;
      case 11:
        result = "B";
        break;
    }
    return result + octave;
  }
}
