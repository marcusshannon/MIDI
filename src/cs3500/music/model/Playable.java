package cs3500.music.model;

/**
 * Interface to interact with playables, things that can make sounds in midi
 */
public interface Playable {

  /**
   * get start beat
   *
   * @return start beat
   */
  int getStartBeat();

  /**
   * get endbeat
   *
   * @return endbeat
   */
  int getEndBeat();

  /**
   * get pitch
   *
   * @return pitch
   */
  int getPitch();

  /**
   * get volume
   *
   * @return volume
   */
  int getVolume();

  int getChannel();
}
