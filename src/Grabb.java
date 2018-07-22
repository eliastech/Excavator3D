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

public class Grabb
{
  BranchGroup grabb = new BranchGroup();

  public Grabb()
  {
    Appearance app               = new Appearance();
    ColoringAttributes col       = new ColoringAttributes();

    TransformGroup flyttBoks     = new TransformGroup();
    TransformGroup flyttSylinder = new TransformGroup();

    Transform3D s                = new Transform3D();
    Transform3D t                = new Transform3D();

    col.setColor(1.0f,1.0f,0.0f);
    app.setColoringAttributes(col);

    Box boks = new Box(0.5f,0.5f,0.5f,app);
    Cylinder sylinder = new Cylinder(0.5f,1.0f,app);

    s.setTranslation(new Vector3d(0.5,0.0,0.0));
    flyttBoks.setTransform(s);
    flyttBoks.addChild(boks);

    t.rotX(Math.PI/2);
    flyttSylinder.setTransform(t);
    flyttSylinder.addChild(sylinder);

    grabb.addChild(flyttBoks);
    grabb.addChild(flyttSylinder);
  }

  public BranchGroup getShape()
  {
    return grabb;
  }
}
