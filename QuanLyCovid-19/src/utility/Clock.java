/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;

/**
 *
 * @author levietdung
 */
public class Clock {
    public void	activate(JLabel clockLabel) {
	Thread clock = new Thread() {
            public void run() {
                try {
                    for(;;) {
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E yyyy/MM/dd HH:mm:ss");
                        LocalDateTime now = LocalDateTime.now();

                        clockLabel.setText(dtf.format(now));
                        sleep(1000);
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        };
	clock.start();
    }
}
