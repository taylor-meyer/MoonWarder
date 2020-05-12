package main;

/* Found online:
    https://stackoverflow.com/questions/36850217/modifying-javafx-gui-from-different-thread-in-different-class
 */

import javafx.application.Platform;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class MonsterMovement implements Runnable {
    private MovementExample d;

    MonsterMovement(MovementExample dt){
        d=dt;
    }

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            int i = ThreadLocalRandom.current().nextInt(0, 3 + 1);

            //System.out.println(i);

            if(i == 0) {
                System.out.println("m right");


                Platform.runLater(() ->

                {
                    if (d.M_XPos != 9) {
                    StackPane sp = (StackPane) (d.ground.getChildren().get(d.M_XPos * 10 + d.M_YPos));
                    sp.getChildren().remove(d.monsterText);

                    StackPane new_sp = (StackPane) (d.ground.getChildren().get((d.M_XPos + 1) * 10 + d.M_YPos));
                    new_sp.getChildren().add(d.monsterText);

                        d.M_XPos += 1;
                    }
                }

                        );
            } else if (i == 1) {
                System.out.println("m left");

                Platform.runLater(() ->

                        {
                            if (d.M_XPos != 0) {
                                StackPane sp = (StackPane) (d.ground.getChildren().get(d.M_XPos * 10 + d.M_YPos));
                                sp.getChildren().remove(d.monsterText);

                                StackPane new_sp = (StackPane) (d.ground.getChildren().get((d.M_XPos - 1) * 10 + d.M_YPos));
                                new_sp.getChildren().add(d.monsterText);

                                d.M_XPos -= 1;
                            }
                        }

                );

            } else if (i == 2) {
                System.out.println("m up");

                Platform.runLater(() ->

                        {
                            if (d.M_YPos != 0) {
                                StackPane sp = (StackPane) (d.ground.getChildren().get(d.M_XPos * 10 + d.M_YPos));
                                sp.getChildren().remove(d.monsterText);

                                StackPane new_sp = (StackPane) (d.ground.getChildren().get(d.M_XPos * 10 + (d.M_YPos - 1)));
                                new_sp.getChildren().add(d.monsterText);

                                d.M_YPos -= 1;
                            }
                        }

                );

            } else if (i == 3) {
                System.out.println("m down");

                Platform.runLater(() ->

                        {
                            if (d.M_YPos != 9) {
                                StackPane sp = (StackPane) (d.ground.getChildren().get(d.M_XPos * 10 + d.M_YPos));
                                sp.getChildren().remove(d.monsterText);

                                StackPane new_sp = (StackPane) (d.ground.getChildren().get(d.M_XPos * 10 + (d.M_YPos + 1)));
                                new_sp.getChildren().add(d.monsterText);

                                d.M_YPos += 1;
                            }
                        }

                );
            }
        }
    }
}