package gravemaskin;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

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


public class Gravemaskin extends Frame
{
  Tastaturtrykk tast;

  TransformGroup tgGravtrans  = new TransformGroup();
  TransformGroup tgGravrot    = new TransformGroup();
  TransformGroup tgArm1rot    = new TransformGroup();
  TransformGroup tgArm2rot    = new TransformGroup();
  TransformGroup tgGrabbrot   = new TransformGroup();

  public Gravemaskin()
  {
         addWindowListener(new WindowAdapter()
         {  public void windowClosing(WindowEvent e)
                 { System.exit(0); }
         } );

         setLayout(new BorderLayout());
         GraphicsConfigTemplate template = new GraphicsConfigTemplate3D();
         // Get the GraphicsConfiguration that best fits our needs.
         GraphicsConfiguration gcfg = GraphicsEnvironment.getLocalGraphicsEnvironment().
         getDefaultScreenDevice().getBestConfiguration(template);

         Canvas3D c = new Canvas3D(gcfg);
         add("Center", c);

         // Create a simple scene and attach it to the virtual
         // universe

         BranchGroup scene = createSceneGraph();
         UniverseBuilder u = new UniverseBuilder(c);
         u.addBranchGraph(scene);
  }

  public BranchGroup createSceneGraph()
  {

    // Definerer roten i BranchGraph

    BranchGroup objRoot = new BranchGroup();


    // Definerer TransformGroup nodene

    TransformGroup tgArm1trans  = new TransformGroup();
    TransformGroup tgArm2trans  = new TransformGroup();
    TransformGroup tgGrabbtrans = new TransformGroup();


    // Bygger opp strukturen i treet

    objRoot.addChild(tgGravtrans);
    tgGravtrans.addChild(tgGravrot);
    
    tgGravrot.addChild(tgArm1trans);
    tgArm1trans.addChild(tgArm1rot);
    
    tgArm1rot.addChild(tgArm2trans);
    tgArm2trans.addChild(tgArm2rot);
    
    tgArm2rot.addChild(tgGrabbtrans);
    tgGrabbtrans.addChild(tgGrabbrot);


         // Setter verdi på translasjonsgruppene

    Transform3D s=new Transform3D();
    Transform3D t=new Transform3D();
    Transform3D u=new Transform3D();

    s.setTranslation(new Vector3d(1.0,1.5,0.0)); // arm1 på hus
    t.setTranslation(new Vector3d(4.0,0.0,0.0)); // arm2 på arm1
    u.setTranslation(new Vector3d(4.0,0.0,0.0)); // Grabb på arm2

    tgArm1trans.setTransform(s);
    tgArm2trans.setTransform(t);
    tgGrabbtrans.setTransform(u);

    // Legger inn geometriobjektene

    tgGrabbrot.addChild(new Grabb().getShape());
    tgArm2rot.addChild(new Arm2().getShape());
    tgArm1rot.addChild(new Arm1().getShape());
    tgGravrot.addChild(new Hus().getShape());

    // Adder inn en Behavior som tar seg av tastaturtrykk og animasjon
    Tastaturtrykk tast = new Tastaturtrykk(tgGravtrans, tgGravrot,
                                        tgArm1rot, tgArm2rot,tgGrabbrot);
    objRoot.addChild(tast);
    return objRoot;
  }


  public static void main(String[] args)
  {
    Gravemaskin gravemaskin = new Gravemaskin();
    gravemaskin.setSize(500,500);
    gravemaskin.setVisible(true);
  }

} // End Gravemaskin
