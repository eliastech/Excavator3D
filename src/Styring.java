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

public class Styring
{
  // Transformasjonsgruppene som kan påvirkes

  TransformGroup tgGravtrans;
  TransformGroup tgGravrot;
  TransformGroup tgArm1rot;
  TransformGroup tgArm2rot;
  TransformGroup tgGrabbrot;


  public Styring(TransformGroup tgGravtrans, TransformGroup tgGravrot,
                 TransformGroup tgArm1rot,   TransformGroup tgArm2rot,
                 TransformGroup tgGrabbrot)
  {
    this.tgGravtrans = tgGravtrans;
    this.tgGravrot   = tgGravrot;
    this.tgArm1rot   = tgArm1rot;
    this.tgArm2rot   = tgArm2rot;
    this.tgGrabbrot  = tgGrabbrot;

    tgGravtrans.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
    tgGravtrans.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    tgGravrot.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
    tgGravrot.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    tgArm1rot.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    tgArm1rot.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
    tgArm2rot.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    tgArm2rot.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
    tgGrabbrot.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    tgGrabbrot.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

  }

  public void animer(char k)
  {

    Transform3D s=new Transform3D();
    Transform3D t=new Transform3D();
    /*Transform3D u=new Transform3D();
    Transform3D v=new Transform3D();
    Transform3D w=new Transform3D();
    Transform3D x=new Transform3D();  */

    switch (k)
    {
    case 'd':  tgGravrot.getTransform(s);
               t.rotY(-Math.PI/90);
               s.mul(t);
               tgGravrot.setTransform(s);
    break;
    case 'a':  tgGravrot.getTransform(s);
               t.rotY(Math.PI/90);
               s.mul(t);
               tgGravrot.setTransform(s);
    break;
    case 's':  tgArm1rot.getTransform(s);
               t.rotZ(-Math.PI/90);
               s.mul(t);
               tgArm1rot.setTransform(s);
    break;
    case 'w':  tgArm1rot.getTransform(s);
               t.rotZ(Math.PI/90);
               s.mul(t);
               tgArm1rot.setTransform(s);
    break;
    case 'r':  tgArm2rot.getTransform(s);
               t.rotZ(-Math.PI/90);
               s.mul(t);
               tgArm2rot.setTransform(s);
    break;
    case 't':  tgArm2rot.getTransform(s);
               t.rotZ(Math.PI/90);
               s.mul(t);
               tgArm2rot.setTransform(s);
    break;
    case 'q':  tgGrabbrot.getTransform(s);
               t.rotZ(-Math.PI/90);
               s.mul(t);
               tgGrabbrot.setTransform(s);
    break;
    case 'e':  tgGrabbrot.getTransform(s);
               t.rotZ(Math.PI/90);
               s.mul(t);
               tgGrabbrot.setTransform(s);
    break;
    } // End switch
  } // End animer
} // End Styring
