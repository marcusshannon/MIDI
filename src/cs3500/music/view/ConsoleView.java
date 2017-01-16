package cs3500.music.view;

import java.io.IOException;

import cs3500.music.model.Channel;
import cs3500.music.model.Composition;
import cs3500.music.model.CompositionImpl;
import cs3500.music.model.Playable;

import static cs3500.music.util.MidiToString.midiToString;

/**
 * Class to represent a console view.
 */
public class ConsoleView implements View {

  private final Composition model;
  private final Appendable out;

  private ConsoleView(Composition model, Appendable out) {
    this.model = model;
    this.out = out;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Appendable out = System.out;
    private Composition composition = new CompositionImpl.Builder().build();

    public Builder output(Appendable out) {
      this.out = out;
      return this;
    }

    public Builder input(Composition composition) {
      this.composition = composition;
      return this;
    }

    public View build() {
      return new ConsoleView(composition, out);
    }

  }

  private void append(CharSequence csq) throws IOException {
    out.append(csq);
  }

  @Override
  public void initialize() throws IOException {
    int lastBeat = model.getLastBeat();
    int lowestPitch = model.getLowestPitch();
    int highestPitch = model.getHighestPitch();
    int pitchCount = highestPitch - lowestPitch + 1;
    String[][] consoleArray = new String[lastBeat + 2][pitchCount + 1];
    for (int i = 0; i < pitchCount; i = i + 1) {
      consoleArray[0][i + 1] = midiToString(i + lowestPitch);
    }
    for (int i = 1; i < lastBeat + 1; i = i + 1) {
      consoleArray[i][0] = Integer.toString(i - 1);
    }
    for (Channel channel : model.getChannels()) {
      for (Playable playable : channel.getNotes()) {
        int startBeat = playable.getStartBeat();
        int endBeat = playable.getEndBeat();
        int pitch = playable.getPitch();
        consoleArray[startBeat + 1][pitch - lowestPitch + 1] = "X";
        for (int i = startBeat + 1; i < endBeat; i = i + 1) {
          consoleArray[i + 1][pitch - lowestPitch + 1] = "|";
        }
      }
    }
    for (int b = 0; b < lastBeat + 1; b = b + 1) {
      for (int p = 0; p < pitchCount + 1; p = p + 1) {
        if (p == 0) {
          if (consoleArray[b][0] == null) {
            append(String.format("%" + Integer.toString(lastBeat).length() + "s", ""));
          } else {
            append(String.format("%" + Integer.toString(lastBeat).length()
                    + "s", consoleArray[b][p]));
          }
        } else {
          int noteWidth = midiToString(p - 1 + lowestPitch).length();
          if (consoleArray[b][p] == null) {
            append(String.format("%" + Math.max(noteWidth, 3) + "s", ""));
          } else {
            switch (noteWidth) {
              case 2:
                if (b == 0) {
                  append(" " + consoleArray[b][p]);
                } else {
                  append(" " + consoleArray[b][p] + " ");
                }
                break;
              case 3:
                if (b == 0) {
                  append(consoleArray[b][p]);
                } else {
                  append(" " + consoleArray[b][p] + " ");
                }
                break;
              case 4:
                if (b == 0) {
                  append(consoleArray[b][p]);
                } else {
                  append("   " + consoleArray[b][p] + " ");
                }
                break;
            }
          }
        }
      }
      append("\n");
    }
  }
}
