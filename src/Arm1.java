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
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Cone;
import com.sun.j3d.utils.geometry.Box;

public class Arm1
{
  BranchGroup arm1=new BranchGroup();

  public Arm1()
  {
    Appearance app              = new Appearance();
    ColoringAttributes col      = new ColoringAttributes();
    TransformGroup flyttBjelke1 = new TransformGroup();
    TransformGroup flyttSyl1    = new TransformGroup();
    TransformGroup flyttBjelke2 = new TransformGroup();
    TransformGroup flyttSyl2    = new TransformGroup();
    Transform3D s               = new Transform3D();
    Transform3D t               = new Transform3D();
    Transform3D u               = new Transform3D();
    Transform3D v               = new Transform3D();
    Transform3D w               = new Transform3D();
    Transform3D x               = new Transform3D();

    col.setColor(0.5f,0.5f,0.5f);
    app.setColoringAttributes(col);

    Box bjelke1 = new Box(2.0f,0.25f,0.1f,app);
    Cylinder cyl1 = new Cylinder(0.25f,0.1f,app);
    Box bjelke2 = new Box(2.0f,0.25f,0.1f,app);
    Cylinder cyl2 = new Cylinder(0.25f,0.1f,app);

    s.setTranslation(new Vector3d(2,0,0.15));
    flyttBjelke1.setTransform(s);
    flyttBjelke1.addChild(bjelke1);

    t.setTranslation(new Vector3d(2,0,-0.15));
    flyttBjelke2.setTransform(t);
    flyttBjelke2.addChild(bjelke2);


    u.rotX(Math.PI/2);
    v.setTranslation(new Vector3d(4,0,0.15));
    v.mul(u);
    flyttSyl1.setTransform(v);
    flyttSyl1.addChild(cyl1);

    w.rotX(Math.PI/2);
    x.setTranslation(new Vector3d(4,0,-0.15));
    x.mul(w);
    flyttSyl2.setTransform(x);
    flyttSyl2.addChild(cyl2);

    arm1.addChild(flyttBjelke1);
    arm1.addChild(flyttSyl1);
    arm1.addChild(flyttBjelke2);
    arm1.addChild(flyttSyl2);

  }

  public BranchGroup getShape()
  {
    return arm1;
  }
}
