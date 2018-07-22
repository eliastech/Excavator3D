package gravemaskin;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.media.j3d.*;
import javax.vecmath.*;

public class Tastaturtrykk extends Behavior
{

  WakeupCriterion[] keyEvents;
  WakeupOr keyCriterion;
  Styring s;


  public Tastaturtrykk(TransformGroup tgGravtrans, TransformGroup tgGravrot,
                       TransformGroup tgArm1rot,   TransformGroup tgArm2rot,
                       TransformGroup tgGrabbrot)
  {
    BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0), 200.0);
    this.setSchedulingBounds(bounds);
    s=new Styring(tgGravtrans, tgGravrot,tgArm1rot, tgArm2rot,tgGrabbrot);
  }

  public void initialize()
  {
    keyEvents = new WakeupCriterion[1];
    keyEvents[0]=new WakeupOnAWTEvent(KeyEvent.KEY_PRESSED);
    keyCriterion = new WakeupOr(keyEvents);
    wakeupOn (keyCriterion);
  }

  public void processStimulus (Enumeration criteria)
  {
    WakeupCriterion wakeup;
    AWTEvent[] event;
    int id;
    char k;

    while (criteria.hasMoreElements()) {
      wakeup = (WakeupCriterion) criteria.nextElement();
      if (wakeup instanceof WakeupOnAWTEvent) {
        event = ((WakeupOnAWTEvent)wakeup).getAWTEvent();
        for (int i=0; i<event.length; i++) {
          id = event[i].getID();
          if (id == KeyEvent.KEY_PRESSED)
          {
            k = ((KeyEvent)event[i]).getKeyChar();
            s.animer(k);
            System.out.println(k);
          } // End if
        } // End for
      } // End if
    } // End while
    wakeupOn(keyCriterion);
  } // End processStimulus
} // End class Tastaturtrykk}
