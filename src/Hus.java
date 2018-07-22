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

public class Hus
{
  BranchGroup hus = new BranchGroup();

  public Hus()
  {
    Appearance appFundament         = new Appearance();
    Appearance appHus               = new Appearance();
    ColoringAttributes colFundament = new ColoringAttributes();
    ColoringAttributes colHus       = new ColoringAttributes();
    TransformGroup flyttHus1        = new TransformGroup();
    TransformGroup flyttHus2        = new TransformGroup();
    TransformGroup flyttHus3        = new TransformGroup();
    Transform3D s                   = new Transform3D();
    Transform3D t                   = new Transform3D();
    Transform3D u                   = new Transform3D();
    Transform3D v                   = new Transform3D();

    colFundament.setColor(0.5f,0.5f,0.5f);
    appFundament.setColoringAttributes(colFundament);
    colHus.setColor(1.5f,0.0f,0.0f);
    appHus.setColoringAttributes(colHus);

    Box fundament = new Box(0.5f,0.25f,0.5f,appFundament);
    Box hus1      = new Box(1.0f,0.875f,1.0f,appHus);
    Box hus2      = new Box(0.25f,0.625f,1.0f,appHus);
    Cylinder hus3 = new Cylinder(0.5f,2.0f,appHus);

    s.setTranslation(new Vector3d(0,1.125,0));
    flyttHus1.setTransform(s);
    flyttHus1.addChild(hus1);

    t.setTranslation(new Vector3d(1.25,0.875,0));
    flyttHus2.setTransform(t);
    flyttHus2.addChild(hus2);

    u.rotX(Math.PI/2);
    v.setTranslation(new Vector3d(1.0,1.5,0.0));
    v.mul(u);
    flyttHus3.setTransform(v);
    flyttHus3.addChild(hus3);

    hus.addChild(flyttHus1);
    hus.addChild(flyttHus2);
    hus.addChild(flyttHus3);
    hus.addChild(fundament);

  }

  public BranchGroup getShape()
  {
    return hus;
  }
}
