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

public class UniverseBuilder extends Object {

  // User-specified canvas

  Canvas3D canvas;

  // Scene graph elements to which the user may want access

  VirtualUniverse               universe;
  Locale                        locale;
  TransformGroup                vpTrans;
  View                          view;

  public UniverseBuilder(Canvas3D c)
  {
    this.canvas = c;


    // Establish a virtual universe that has a single
    // hi-res Locale

    universe = new VirtualUniverse();
    locale = new Locale(universe);


    // Create a PhysicalBody and PhysicalEnvironment object

    PhysicalBody body = new PhysicalBody();
    PhysicalEnvironment environment =
    new PhysicalEnvironment();


    // Create a View and attach the Canvas3D and the physical
    // body and environment to the view.

    view = new View();
    view.addCanvas3D(c);
    view.setPhysicalBody(body);
    view.setPhysicalEnvironment(environment);
    view.setBackClipDistance(500);


    // Create a BranchGroup node for the view platform

    BranchGroup vpRoot = new BranchGroup();


    // Create a ViewPlatform object, and its associated
    // TransformGroup object, and attach it to the root of the
    // subgraph. Attach the view to the view platform.

    Transform3D t = new Transform3D();
    Transform3D s = new Transform3D();

    t.rotY(0/*Math.PI/2*/);
    s.set(new Vector3f(0.0f, 0.0f, 25.0f));
    t.mul(s);

    ViewPlatform vp = new ViewPlatform();
    vpTrans = new TransformGroup(t);

    vpTrans.addChild(vp);
    vpRoot.addChild(vpTrans);

    view.attachViewPlatform(vp);


    // Attach the branch graph to the universe, via the
    // Locale. The scene graph is now live!

    locale.addBranchGraph(vpRoot);
  }

  public void addBranchGraph(BranchGroup bg)
  {
    locale.addBranchGraph(bg);
  }

}  // End UniverseBuilder
