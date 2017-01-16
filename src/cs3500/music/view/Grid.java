package cs3500.music.view;

import java.awt.*;

/**
 * Created by marcusshannon on 11/18/15.
 */
public class Grid {

  public void paint(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.BLACK);
    for (int i = 0; i <= 29; i = i + 1) {
      int x1 = 0;
      int x2 = 960;
      int y = i * 20;
      g2d.drawLine(x1, y, x2, y);
    }
  }
}
