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

public class Arm2
{
BranchGroup arm2=new BranchGroup();

  public Arm2()
  {
    Appearance app              = new Appearance();
    ColoringAttributes col      = new ColoringAttributes();
    TransformGroup flyttBjelke  = new TransformGroup();
    TransformGroup flyttSyl1    = new TransformGroup();
    TransformGroup flyttSyl2    = new TransformGroup();
    Transform3D t               = new Transform3D();
    Transform3D s               = new Transform3D();
    Transform3D u               = new Transform3D();
    Transform3D v               = new Transform3D();

    col.setColor(0.5f,0.5f,0.5f);
    app.setColoringAttributes(col);

    Box bjelke    = new Box(2.0f,0.25f,0.2f,app);
    Cylinder syl1 = new Cylinder(0.25f,0.2f,app);
    Cylinder syl2 = new Cylinder(0.25f,0.2f,app);

    s.setTranslation(new Vector3d(2.0,0.0,0.0));
    flyttBjelke.setTransform(s);
    flyttBjelke.addChild(bjelke);

    t.rotX(Math.PI/2);
    u.setTranslation(new Vector3d(4.0,0.0,0.0));
    t.mul(u);
    flyttSyl1.setTransform(t);
    flyttSyl1.addChild(syl1);

    v.rotX(Math.PI/2);
    flyttSyl2.setTransform(v);
    flyttSyl2.addChild(syl2);

    arm2.addChild(flyttBjelke);
    arm2.addChild(flyttSyl1);
    arm2.addChild(flyttSyl2);

  }

  public BranchGroup getShape()
  {
    return arm2;
  }
}
