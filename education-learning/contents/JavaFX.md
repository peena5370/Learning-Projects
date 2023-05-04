# JavaFX Learning

## Setting a Simple Application

```java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class FXInterface extends Application {
  public static void main(String args[]){
    launch(args);     
  }
  
  @Override
  public void start(Stage primaryStage) throws Exception {
   //creating a Group object
   Group group = new Group();
   //Creating a Scene by passing the group object, setting window height and width   
   Scene scene = new Scene(group ,600, 300); 

   //setting color to the scene 
   scene.setFill(Color.WHITE);

   //Setting the title to Stage.
   primaryStage.setTitle("Sample Application");

   //Adding the scene to Stage 
   primaryStage.setScene(scene);

   //Displaying the contents of the stage 
   primaryStage.show(); 
  }
}
```

## Adding Text into Application

```java
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FXInterface extends Application {
  public static void main(String args[]){
    launch(args);     
  }
  
  @Override
  public void start(Stage primaryStage) throws Exception {
    //Setting the title to Stage.
    primaryStage.setTitle("Sample Application");
    
    //Creating a Text object 
    Text text = new Text(); 
      
    //Setting font to the text
    // format setFont(Font.font('font-family',font-weight,font-posture(regular/italic), font-size));
    text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
      
    //setting the position of the text (setX = toRight, setY toBottom)
    text.setX(50);
    text.setY(150);          
      
    //Setting the text to be added. 
    text.setText("Welcome to My Application"); 

    //underlining the text
    text.setUnderline(true);
    
    // strikethrough the text
    text.setStrikethrough(true); 
      
    //creating a Group object
    Group group = new Group();
      
    //Retrieving the observable list object 
    ObservableList list = group.getChildren();
      
    //Setting the text object as a node to the group object 
    list.add(text); 
      
    //Creating a Scene by passing the group object, setting window height and width   
    Scene scene = new Scene(group ,600, 300); 
    
    //setting color to the scene 
    scene.setFill(Color.WHITE);

    //Adding the scene to Stage 
    primaryStage.setScene(scene);

    //Displaying the contents of the stage 
    primaryStage.show(); 
  }
}
```

## Drawing Shapes with Path Class

```java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class FXInterface extends Application {
  @Override
  public void start(Stage stage) { 
    //Creating a Path 
    Path path = new Path(); 
      
    //Moving to the starting point 
    MoveTo moveTo = new MoveTo(108, 71); 
      
    //Creating 1st line 
    LineTo line1 = new LineTo(321, 161);  
      
    //Creating 2nd line 
    LineTo line2 = new LineTo(126,232);       
      
    //Creating 3rd line 
    LineTo line3 = new LineTo(232,52);  
      
    //Creating 4th line 
    LineTo line4 = new LineTo(269, 250);   
      
    //Creating 4th line 
    LineTo line5 = new LineTo(108, 71);  
      
    //Adding all the elements to the path 
    path.getElements().add(moveTo); 
    path.getElements().addAll(line1, line2, line3, line4, line5);        
        
    //Creating a Group object  
    Group group = new Group(path); 
        
    //Creating a scene object 
    Scene scene = new Scene(group, 600, 300);  
    
    //Setting title to the Stage 
    stage.setTitle("Drawing an arc through a path");
    
    //Adding scene to the stage 
    stage.setScene(scene);
    
    //Displaying the contents of the stage 
    stage.show();         
  } 
  public static void main(String args[]){ 
    launch(args); 
  } 
}
```

* The following table shows the list of various shapes (classes) provided by JavaFX.

| No | Shape & Description |
| :-: | :----------------- |
| 1 | __Line__  </br>A line is a geometrical structure joining two point. The Line class of the package javafx.scene.shape represents a line in the XY plane. |
| 2 | __Rectangle__  </br>In general, a rectangle is a four-sided polygon that has two pairs of parallel and concurrent sides with all interior angles as right angles. In JavaFX, a Rectangle is represented by a class named Rectangle. This class belongs to the package javafx.scene.shape. |
| 3 | __Rounded Rectangle__  </br>In JavaFX, you can draw a rectangle either with sharp edges or with arched edges and The one with arched edges is known as a rounded rectangle. |
| 4 | __Circle__  </br>A circle is a line forming a closed loop, every point on which is a fixed distance from a centre point. In JavaFX, a circle is represented by a class named Circle. This class belongs to the package javafx.scene.shape. |
| 5 | __Ellipse__  </br>An ellipse is defined by two points, each called a focus. If any point on the ellipse is taken, the sum of the distances to the focus points is constant. The size of the ellipse is determined by the sum of these two distances. In JavaFX, an ellipse is represented by a class named Ellipse. This class belongs to the package javafx.scene.shape. |
| 6 | __Polygon__  </br>A closed shape formed by a number of coplanar line segments connected end to end. In JavaFX, a polygon is represented by a class named Polygon. This class belongs to the package javafx.scene.shape. |
| 7 | __Polyline__  </br>A polyline is same a polygon except that a polyline is not closed in the end. Or, continuous line composed of one or more line segments. In JavaFX, a Polyline is represented by a class named Polygon. This class belongs to the package javafx.scene.shape. |
| 8 | __Cubic Curve__  </br>A cubic curve is a Bezier parametric curve in the XY plane is a curve of degree 3. In JavaFX, a Cubic Curve is represented by a class named CubicCurve. This class belongs to the package javafx.scene.shape. |
| 9 | __QuadCurve__  </br>A quadratic curve is a Bezier parametric curve in the XY plane is a curve of degree 2. In JavaFX, a QuadCurve is represented by a class named QuadCurve. This class belongs to the package javafx.scene.shape. |
| 10 | __Arc__  </br>An arc is part of a curve. In JavaFX, an arc is represented by a class named Arc. This class belongs to the package − javafx.scene.shape.</br>__Types Of Arc__</br>In addition to this we can draw three types of arc's Open, Chord, Round. |
| 11 | __SVGPath__  </br>In JavaFX, we can construct images by parsing SVG paths. Such shapes are represented by the class named SVGPath. This class belongs to the package javafx.scene.shape. This class has a property named content of String datatype. This represents the SVG Path encoded string, from which the image should be drawn. |

## Applying Effects to a Node

```java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.Shadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class FXInterface extends Application {
  @Override
  public void start(Stage stage) {    
    //Creating a Text object
    Text text = new Text();    
    
    //Setting font to the text
    text.setFont(Font.font(null, FontWeight.BOLD, 40));  
    
    //setting the position of the text
    text.setX(60);
    text.setY(50);
    
    //Setting the text to be embedded. 
    text.setText("Welcome to My Application");       
    
    //Setting the color of the text 
    text.setFill(Color.DARKSEAGREEN);
    
    //Drawing a Circle 
    Circle circle = new Circle();         
    
    //Setting the center of the circle 
    circle.setCenterX(300.0f); 
    circle.setCenterY(160.0f); 
    
    //Setting the radius of the circle 
    circle.setRadius(100.0f); 
      
    //Instantiating the Shadow class 
    Shadow shadow = new Shadow(); 
    
    //setting the type of blur for the shadow 
    shadow.setBlurType(BlurType.GAUSSIAN); 
    
    //Setting color of the shadow 
    shadow.setColor(Color.ROSYBROWN); 
    
    //Setting the height of the shadow 
    shadow.setHeight(5); 
    
    //Setting the width of the shadow 
    shadow.setWidth(5); 
    
    //Setting the radius of the shadow 
    shadow.setRadius(5);  
    
    //Applying shadow effect to the text 
    text.setEffect(shadow);      
    
    //Applying shadow effect to the circle 
    circle.setEffect(shadow); 
        
    //Creating a Group object    
    Group root = new Group(circle, text);   
              
    //Creating a scene object 
    Scene scene = new Scene(root, 600, 300);  
    
    //Setting title to the Stage 
    stage.setTitle("Bloom effect example");
    
    //Adding scene to the stage 
    stage.setScene(scene); 
        
    //Displaying the contents of the stage 
    stage.show();         
  } 
  public static void main(String args[]){ 
    launch(args); 
  }
}
```

* The following table shows the list of various effects (classes) provided by JavaFX. These classes exist in the package called __javafx.scene.effect__.

| No | Shape and Description |
| :-: | :------------------- |
| 1 | __Color Adjust__ </br>You can adjust the color of an image by applying the color adjust effect to it. This includes the adjustment of the hue, saturation, brightness and contrast on each pixel. The class named ColorAdjust of the package javafx.scene.effect represents the color adjust effect. |
| 2 | __Color Input__ </br>Color Input Effect gives the same output as drawing a rectangle and filling it with color. Unlike other effects, if this effect is applied to any node, it displays only a rectangular box (not the node). This effect is mostly used to pass as an input for other effects. The class named ColorInput of the package javafx.scene.effect represents the color input effect. |
| 3 | __Image Input__ </br>Image input effect in JavaFX just embeds an image to the JavaFX screen. Just like Color Input effect (It is used to pass the specified colored rectangular region as input to other effect), Image Input effect is used to pass the specified image as an input to another effect. The class named ImageInput of the package javafx.scene.effect represents the Image Input effect. |
| 4 | __Blend__ </br>In general, blend means mixture of two or more different things or substances. If we apply this blend effect, it takes the pixels of two different inputs, at the same location and it produces a combined output based on the blend mode. The class named Blend of the package javafx.scene.effect represents the blend effect. |
| 5 | __Bloom__ </br>On applying bloom effect, pixels in some portions of the node are made to glow. The class named Bloom of the package javafx.scene.effect represents the bloom effect. |
| 6 | __Glow__ </br>Just like bloom, the Glow effect makes the given input image to glow, this effect makes the bright pixels of the input brighter. The class named Glow of the package javafx.scene.effect represents the glow effect. |
| 7 | __Box Blur__ </br>On applying this blur effect to a node, it is made unclear. Box blur is a kind of blur effect provided by JavaFX. In this effect, when we apply blur to a node, a simple box filter is used. The class named BoxBlur of the package javafx.scene.effect represents the boxblur effect. |
| 8 | __GaussianBlur__ </br>Just like Box Blur Gaussian is an effect to blur the nodes in JavaFX. The only difference in the Gaussian Blur effect is that a Gaussian convolution kernel is used to produce a blurring effect. The class named GaussianBlur of the package javafx.scene.effect represents the Gaussian Blur effect. |
| 9 | __MotionBlur__ </br>Just like Gaussian Effects, Motion Blur is an effect to blur the nodes in JavaFX. It also uses a Gaussian convolution kernel to produce a blurring effect, but the difference is in this effect the Gaussian convolution kernel is used with a specified angle. The class named MotionBlur of the package javafx.scene.effect represents the Motion Blur effect. |
| 10 | __Reflection__ </br>On applying the reflection effect to a node in JavaFX, a reflection of it is added at the bottom of the node. The class named Reflection of the package javafx.scene.effect represents the reflection effect. |
| 11 | __SepiaTone__ </br>On applying the Sepia tone effect to a node in JavaFX (image in general), it is toned with a reddish brown color. The class named SepiaTone of the package javafx.scene.effect represents the sepia tone effect. |
| 12 | __Shadow__ </br>This effect creates a duplicate of the specified node with blurry edges. The class named Shadow of the package javafx.scene.effect represents the sepia tone effect. |
| 13 | __DropShadow__ </br>On applying this effect to a node, a shadow will be created behind the specified node. The class named DropShadow of the package javafx.scene.effect represents the drop shadow effect. |
| 14 | __InnerShadow__ </br>On applying this effect to a node, a shadow will be created inside the edges of the node. The class named InnerShadow of the package javafx.scene.effect represents the inner shadow effect. |
| 15 | __Lighting__ </br>The lighting effect is used to simulate a light from a light source. There are different kinds of light sources namely point, distant and spot. The class named Lighting of the package javafx.scene.effect represents the lighting effect. |
| 16 | __Light.Distant__ </br>On applying this effect to a node, a light is simulated on it, as if it is being generated by a distant light source.</br>__Distant Light Source__ − A source which is at a far distance from the node. In here, the light is attenuated in one direction from the source. The class named Light. Distant of the package javafx.scene.effect represents the distant light source. |
| 17 | __Light.Spot__ </br>On applying this effect to a node, a light is simulated on it, as if it is being generated by a spot light.</br>__Spot light Source__ − The light from this source attenuates in all directions. The intensity of the light depends on the distance of the object from the source. The class named Light.Spot of the package javafx.scene.effect represents the distant light source. |
| 18 | __Point.Spot__ </br>On applying this effect to a node, a light is simulated on it, as if it is being generated by a point light source.</br>__Point Light Source__ − The light from this source attenuates in all directions from a single point. The intensity of the light depends on the distance of the object from the source. The class named Point.Spot of the package javafx.scene.effect represents the point light. |

## JavaFX Transformation

* Using JavaFX, we can apply transformations on nodes such as rotation, scaling and translation. All these transformations are represented by various classes and these belong to the package __javafx.scene.transform__.

| No | Transformation & Description |
| :-: | :-------------------------- |
| 1 | __Rotation__</br>In rotation, we rotate the object at a particular angle θ (theta) from its origin. |
| 2 | __Scaling__</br>To change the size of an object, scaling transformation is used. |
| 3 | __Translation__</br>Moves an object to a different position on the screen. |
| 4 | __Shearing__</br>A transformation that slants the shape of an object is called the Shear Transformation. |

```java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

public class FXInterface extends Application {
  @Override 
  public void start(Stage stage) { 
    //Drawing a Rectangle
    Rectangle rectangle = new Rectangle(50, 50, 100, 75); 
    
    //Setting the color of the rectangle 
    rectangle.setFill(Color.BURLYWOOD); 
    
    //Setting the stroke color of the rectangle 
    rectangle.setStroke(Color.BLACK); 
      
    //creating the rotation transformation 
    Rotate rotate = new Rotate(); 
    
    //Setting the angle for the rotation 
    rotate.setAngle(20); 
    
    //Setting pivot points for the rotation 
    rotate.setPivotX(150); 
    rotate.setPivotY(225); 
      
    //Creating the scale transformation 
    Scale scale = new Scale(); 
    
    //Setting the dimensions for the transformation 
    scale.setX(1.5); 
    scale.setY(1.5); 
    
    //Setting the pivot point for the transformation 
    scale.setPivotX(300); 
    scale.setPivotY(135); 
      
    //Creating the translation transformation 
    Translate translate = new Translate();       
    
    //Setting the X,Y,Z coordinates to apply the translation 
    translate.setX(250); 
    translate.setY(0); 
    translate.setZ(0); 
      
    //Adding all the transformations to the rectangle 
    rectangle.getTransforms().addAll(rotate, scale, translate); 
      
    //Creating a Group object  
    Group root = new Group(rectangle); 
    
    //Creating a scene object 
    Scene scene = new Scene(root, 600, 300);  
    
    //Setting title to the Stage 
    stage.setTitle("Multiple transformations"); 
        
    //Adding scene to the stage 
    stage.setScene(scene); 
        
    //Displaying the contents of the stage 
    stage.show(); 
  }      
  public static void main(String args[]){ 
    launch(args); 
  } 
}
```

## JavaFX Animations

* Rotate animation

```java
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class FXInterface extends Application {
  @Override 
  public void start(Stage stage) {      
    //Creating a hexagon 
    Polygon hexagon = new Polygon();        
    
    //Adding coordinates to the hexagon 
    hexagon.getPoints().addAll(new Double[]{        
        200.0, 50.0, 
        400.0, 50.0, 
        450.0, 150.0,          
        400.0, 250.0, 
        200.0, 250.0,                   
        150.0, 150.0, 
    }); 
    //Setting the fill color for the hexagon 
    hexagon.setFill(Color.BLUE); 
      
    //Creating a rotate transition    
    RotateTransition rotateTransition = new RotateTransition(); 
    
    //Setting the duration for the transition 
    rotateTransition.setDuration(Duration.millis(1000)); 
    
    //Setting the node for the transition 
    rotateTransition.setNode(hexagon);       
    
    //Setting the angle of the rotation 
    rotateTransition.setByAngle(360); 
    
    //Setting the cycle count for the transition 
    rotateTransition.setCycleCount(50); 
    
    //Setting auto reverse value to false 
    rotateTransition.setAutoReverse(false); 
    
    //Playing the animation 
    rotateTransition.play(); 
        
    //Creating a Group object   
    Group root = new Group(hexagon); 
        
    //Creating a scene object 
    Scene scene = new Scene(root, 600, 300);   
    
    //Setting title to the Stage 
    stage.setTitle("Rotate transition example "); 
        
    //Adding scene to the stage 
    stage.setScene(scene); 
        
    //Displaying the contents of the stage 
    stage.show(); 
  }      
  public static void main(String args[]){ 
    launch(args); 
  } 
}
```

* Scale transition animation

```java
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class FXInterface extends Application {
  @Override 
  public void start(Stage stage) {      
    //Drawing a Circle 
    Circle circle = new Circle(); 
    
    //Setting the position of the circle 
    circle.setCenterX(300.0f); 
    circle.setCenterY(135.0f); 
    
    //Setting the radius of the circle 
    circle.setRadius(50.0f); 
    
    //Setting the color of the circle 
    circle.setFill(Color.BROWN); 
    
    //Setting the stroke width of the circle 
    circle.setStrokeWidth(20); 
      
    //Creating scale Transition 
    ScaleTransition scaleTransition = new ScaleTransition(); 
    
    //Setting the duration for the transition 
    scaleTransition.setDuration(Duration.millis(1000)); 
    
    //Setting the node for the transition 
    scaleTransition.setNode(circle); 
    
    //Setting the dimensions for scaling 
    scaleTransition.setByY(1.5); 
    scaleTransition.setByX(1.5); 
    
    //Setting the cycle count for the translation 
    scaleTransition.setCycleCount(50); 
    
    //Setting auto reverse value to true 
    scaleTransition.setAutoReverse(false); 
    
    //Playing the animation 
    scaleTransition.play(); 
        
    //Creating a Group object  
    Group root = new Group(circle); 
        
    //Creating a scene object  
    Scene scene = new Scene(root, 600, 300); 
    
    //Setting title to the Stage 
    stage.setTitle("Scale transition example"); 
        
    //Adding scene to the stage 
    stage.setScene(scene); 
        
    //Displaying the contents of the stage 
    stage.show(); 
  }      
  public static void main(String args[]){ 
    launch(args); 
  } 
}
```

* Transition animation

```java
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class FXInterface extends Application {
  @Override 
  public void start(Stage stage) {  
    //Drawing a Circle 
    Circle circle = new Circle(); 
    
    //Setting the position of the circle 
    circle.setCenterX(150.0f); 
    circle.setCenterY(135.0f); 
    
    //Setting the radius of the circle 
    circle.setRadius(100.0f); 
    
    //Setting the color of the circle 
    circle.setFill(Color.BROWN); 
    
    //Setting the stroke width of the circle 
    circle.setStrokeWidth(20); 
      
    //Creating Translate Transition 
    TranslateTransition translateTransition = new TranslateTransition(); 
    
    //Setting the duration of the transition  
    translateTransition.setDuration(Duration.millis(1000)); 
    
    //Setting the node for the transition 
    translateTransition.setNode(circle); 
    
    //Setting the value of the transition along the x axis. 
    translateTransition.setByX(300); 
    
    //Setting the cycle count for the transition 
    translateTransition.setCycleCount(50); 
    
    //Setting auto reverse value to false 
    translateTransition.setAutoReverse(false); 
    
    //Playing the animation 
    translateTransition.play(); 
        
    //Creating a Group object  
    Group root = new Group(circle); 
        
    //Creating a scene object 
    Scene scene = new Scene(root, 600, 300);  
    
    //Setting title to the Stage 
    stage.setTitle("Translate transition example"); 
        
    //Adding scene to the stage 
    stage.setScene(scene); 
        
    //Displaying the contents of the stage 
    stage.show(); 
  }      
  public static void main(String args[]){ 
    launch(args); 
  } 
}
```

## JavaFX Setting Colors

* Applying Image Pattern to the Nodes

```java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FXInterface extends Application {
  @Override 
  public void start(Stage stage) {           
    //Drawing a Circle 
    Circle circle = new Circle();    
    
    //Setting the properties of the circle 
    circle.setCenterX(300.0f); 
    circle.setCenterY(180.0f); 
    circle.setRadius(90.0f); 
      
    //Drawing a text 
    Text text = new Text("This is a colored circle"); 
    
    //Setting the font of the text 
    text.setFont(Font.font("Edwardian Script ITC", 50)); 
    
    //Setting the position of the text
    text.setX(155); 
    text.setY(50); 
      
    //Setting the image pattern 
    String link = "https://encrypted-tbn1.gstatic.com" 
        + "/images?q=tbn:ANd9GcRQub4GvEezKMsiIf67U" 
        + "rOxSzQuQ9zl5ysnjRn87VOC8tAdgmAJjcwZ2qM";       
    
    Image image = new Image(link); 
    ImagePattern radialGradient = new ImagePattern(image, 20, 20, 40, 40, false); 
      
    //Setting the linear gradient to the circle and text 
    circle.setFill(radialGradient); 
    text.setFill(radialGradient); 
        
    //Creating a Group object  
    Group root = new Group(circle, text); 
        
    //Creating a scene object 
    Scene scene = new Scene(root, 600, 300);  
    
    //Setting title to the Stage 
    stage.setTitle("Image pattern Example"); 
        
    //Adding scene to the stage 
    stage.setScene(scene); 
        
    //Displaying the contents of the stage 
    stage.show(); 
  } 
  public static void main(String args[]){ 
    launch(args); 
  } 
}
```

* Applying Linear Gradient Pattern

```java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FXInterface extends Application {
  @Override 
  public void start(Stage stage) {           
    //Drawing a Circle 
    Circle circle = new Circle();    
    
    //Setting the properties of the circle 
    circle.setCenterX(300.0f);  
    circle.setCenterY(180.0f); 
    circle.setRadius(90.0f); 
    
    //Drawing a text 
    Text text = new Text("This is a colored circle"); 
    
    //Setting the font of the text 
    text.setFont(Font.font("Edwardian Script ITC", 55)); 
    
    //Setting the position of the text 
    text.setX(140); 
    text.setY(50); 
      
    //Setting the linear gradient 
    Stop[] stops = new Stop[] { 
        new Stop(0, Color.DARKSLATEBLUE),  
        new Stop(1, Color.DARKRED)
    };  
    LinearGradient linearGradient = 
        new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops); 
      
    //Setting the linear gradient to the circle and text 
    circle.setFill(linearGradient); 
    text.setFill(linearGradient); 
        
    //Creating a Group object  
    Group root = new Group(circle, text); 
        
    //Creating a scene object 
    Scene scene = new Scene(root, 600, 300);  
    
    //Setting title to the Stage 
    stage.setTitle("Linear Gradient Example"); 
        
    //Adding scene to the stage 
    stage.setScene(scene); 
        
    //Displaying the contents of the stage 
    stage.show(); 
  }      
  public static void main(String args[]){ 
    launch(args); 
  } 
}
```

## JavaFX Images

* Multiple Views of an Image

```java
import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FXInterface extends Application {
  @Override 
  public void start(Stage stage) throws FileNotFoundException {         
    //Creating an image 
    Image image = new Image(new FileInputStream("D:\\Learning Projects\\Pictures\\markdown-logo.png"));  
    
    //Setting the image view 1 
    ImageView imageView1 = new ImageView(image); 
    
    //Setting the position of the image 
    imageView1.setX(50); 
    imageView1.setY(25); 
    
    //setting the fit height and width of the image view 
    imageView1.setFitHeight(300); 
    imageView1.setFitWidth(250);         
    
    //Setting the preserve ratio of the image view 
    imageView1.setPreserveRatio(true); 
        
    //Setting the image view 2 
    ImageView imageView2 = new ImageView(image);
    
    //Setting the position of the image 
    imageView2.setX(350); 
    imageView2.setY(25); 
    
    //setting the fit height and width of the image view 
    imageView2.setFitHeight(150); 
    imageView2.setFitWidth(250);          
    
    //Setting the preserve ratio of the image view 
    imageView2.setPreserveRatio(true); 
        
    //Setting the image view 3 
    ImageView imageView3 = new ImageView(image);  
    
    //Setting the position of the image 
    imageView3.setX(350); 
    imageView3.setY(200); 
    
    //setting the fit height and width of the image view 
    imageView3.setFitHeight(100); 
    imageView3.setFitWidth(100);         
    
    //Setting the preserve ratio of the image view 
    imageView3.setPreserveRatio(true);  
    
    //Creating a Group object  
    Group root = new Group(imageView1, imageView2, imageView3);  
    
    //Creating a scene object 
    Scene scene = new Scene(root, 600, 400);  
    
    //Setting title to the Stage 
    stage.setTitle("Multiple views of an image");  
    
    //Adding scene to the stage 
    stage.setScene(scene);  
    
    //Displaying the contents of the stage
    stage.show(); 
  }  
  public static void main(String args[]) { 
    launch(args); 
  } 
}
```

* Writing Pixels of the image

```java
import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class FXInterface extends Application {
  @Override 
  public void start(Stage stage) throws FileNotFoundException {         
    //Creating an image 
    Image image = new Image(new FileInputStream("D:\\Learning Projects\\Pictures\\markdown-logo.png"));
    int width = (int)image.getWidth(); 
    int height = (int)image.getHeight(); 
      
    //Creating a writable image 
    WritableImage wImage = new WritableImage(width, height); 
      
    //Reading color from the loaded image 
    PixelReader pixelReader = image.getPixelReader(); 
    
    //getting the pixel writer 
    PixelWriter writer = wImage.getPixelWriter();           
    
    //Reading the color of the image 
    for(int y = 0; y < height; y++) { 
      for(int x = 0; x < width; x++) { 
          //Retrieving the color of the pixel of the loaded image   
        Color color = pixelReader.getColor(x, y); 
          
        //Setting the color to the writable image 
        writer.setColor(x, y, color.darker());              
      }
    }
    //Setting the view for the writable image 
    ImageView imageView = new ImageView(wImage); 
            
    //Creating a Group object  
    Group root = new Group(imageView);  
          
    //Creating a scene object 
    Scene scene = new Scene(root, 600, 500);  
          
    //Setting title to the Stage 
    stage.setTitle("Writing pixels ");  
          
    //Adding scene to the stage 
    stage.setScene(scene);  
          
    //Displaying the contents of the stage 
    stage.show();  
  }
  public static void main(String args[]) { 
    launch(args); 
  } 
}
```

## JavaFX 3D Shapes

* Cull Face

```java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.Sphere;

public class FXInterface extends Application {
   @Override 
   public void start(Stage stage) { 
      //Drawing Sphere1 
      Sphere sphere1 = new Sphere();
      
      //Setting the radius of the Sphere 
      sphere1.setRadius(50.0);   
      
      //Setting the position of the sphere 
      sphere1.setTranslateX(100); 
      sphere1.setTranslateY(150); 
      
      //setting the cull face of the sphere to front 
      sphere1.setCullFace(CullFace.FRONT); 
       
      //Drawing Sphere2 
      Sphere sphere2 = new Sphere(); 
      
      //Setting the radius of the Sphere 
      sphere2.setRadius(50.0);   
      
      //Setting the position of the sphere 
      sphere2.setTranslateX(300);  
      sphere2.setTranslateY(150); 
      
      //Setting the cull face of the sphere to back 
      sphere2.setCullFace(CullFace.BACK); 
             
      //Drawing Sphere3 
      Sphere sphere3 = new Sphere(); 
      
      //Setting the radius of the Sphere 
      sphere3.setRadius(50.0);   
      
      //Setting the position of the sphere 
      sphere3.setTranslateX(500); 
      sphere3.setTranslateY(150); 
      
      //Setting the cull face of the sphere to none 
      sphere2.setCullFace(CullFace.NONE);          
       
      //Creating a Group object  
      Group root = new Group(sphere1, sphere2, sphere3); 
         
      //Creating a scene object 
      Scene scene = new Scene(root, 600, 300);  
      
      //Setting title to the Stage
      stage.setTitle("Drawing a Sphere"); 
         
      //Adding scene to the stage 
      stage.setScene(scene); 
         
      //Displaying the contents of the stage 
      stage.show(); 
   } 
   public static void main(String args[]){ 
      launch(args); 
   }
}
```

* Draw Mode

```java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;

public class FXInterface extends Application {
   @Override 
   public void start(Stage stage) { 
      //Drawing a Box 
      Box box1 = new Box(); 
      
      //Setting the properties of the Box 
      box1.setWidth(100.0); 
      box1.setHeight(100.0);   
      box1.setDepth(100.0); 
      
      //Setting the position of the box 
      box1.setTranslateX(200); 
      box1.setTranslateY(150); 
      box1.setTranslateZ(0);
      
      //Setting the drawing mode of the box 
      box1.setDrawMode(DrawMode.LINE); 
       
      //Drawing a Box 
      Box box2 = new Box(); 
      
      //Setting the properties of the Box 
      box2.setWidth(100.0); 
      box2.setHeight(100.0);   
      box2.setDepth(100.0); 
      
      //Setting the position of the box 
      box2.setTranslateX(450); //450 
      box2.setTranslateY(150);//150 
      box2.setTranslateZ(300); 
  
      //Setting the drawing mode of the box 
      box2.setDrawMode(DrawMode.FILL);     
         
      //Creating a Group object   
      Group root = new Group(box1, box2); 
         
      //Creating a scene object 
      Scene scene = new Scene(root, 600, 300); 
       
      //Setting camera 
      PerspectiveCamera camera = new PerspectiveCamera(false); 
      camera.setTranslateX(0); 
      camera.setTranslateY(0); 
      camera.setTranslateZ(0); 
      scene.setCamera(camera);  
      
      //Setting title to the Stage 
      stage.setTitle("Drawing a Box"); 
         
      //Adding scene to the stage 
      stage.setScene(scene);
      
      //Displaying the contents of the stage 
      stage.show(); 
   }      
   public static void main(String args[]){ 
      launch(args); 
   }
}
```

## JavaFX Event Handler

```java
import javafx.animation.PathTransition; 
import javafx.application.Application;
import javafx.event.EventHandler; 

import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.input.MouseEvent; 
import javafx.scene.paint.Color; 

import javafx.scene.shape.Circle; 
import javafx.scene.shape.LineTo; 
import javafx.scene.shape.MoveTo; 
import javafx.scene.shape.Path; 
import javafx.stage.Stage; 
import javafx.util.Duration; 

public class FXInterface extends Application {
   @Override 
   public void start(Stage stage) {      
      //Drawing a Circle 
      Circle circle = new Circle(); 
      
      //Setting the position of the circle 
      circle.setCenterX(300.0f); 
      circle.setCenterY(135.0f); 
      
      //Setting the radius of the circle 
      circle.setRadius(25.0f);  
      
      //Setting the color of the circle 
      circle.setFill(Color.BROWN); 
      
      //Setting the stroke width of the circle 
      circle.setStrokeWidth(20);      
       
      //Creating a Path 
      Path path = new Path(); 
      
      //Moving to the staring point 
      MoveTo moveTo = new MoveTo(208, 71);               
      
      //Creating 1st line 
      LineTo line1 = new LineTo(421, 161);        
      
      //Creating 2nd line 
      LineTo line2 = new LineTo(226,232); 
      
      //Creating 3rd line 
      LineTo line3 = new LineTo(332,52);        
      
      //Creating 4th line 
      LineTo line4 = new LineTo(369, 250);        
      
      //Creating 5th line 
      LineTo line5 = new LineTo(208, 71);       
      
      //Adding all the elements to the path 
      path.getElements().add(moveTo); 
      path.getElements().addAll(line1, line2, line3, line4, line5);     
      
      //Creating the path transition 
      PathTransition pathTransition = new PathTransition(); 
      
      //Setting the duration of the transition 
      pathTransition.setDuration(Duration.millis(1000));       
      
      //Setting the node for the transition 
      pathTransition.setNode(circle); 
      
      //Setting the path for the transition 
      pathTransition.setPath(path); 
      
      //Setting the orientation of the path 
      pathTransition.setOrientation(
         PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
      
      //Setting the cycle count for the transition 
      pathTransition.setCycleCount(50); 
      
      //Setting auto reverse value to true 
      pathTransition.setAutoReverse(false);
      
      //Creating play button 
      Button playButton = new Button("Play"); 
      playButton.setLayoutX(300); 
      playButton.setLayoutY(250); 
       
      circle.setOnMouseClicked (new EventHandler<javafx.scene.input.MouseEvent>() { 
         @Override 
         public void handle(javafx.scene.input.MouseEvent e) { 
            System.out.println("Hello World"); 
            circle.setFill(Color.DARKSLATEBLUE);             
         } 
      });   
      playButton.setOnMouseClicked((new EventHandler<MouseEvent>() { 
         public void handle(MouseEvent event) { 
            System.out.println("Hello World");  
            pathTransition.play(); 
         } 
      })); 
       
      //Creating stop button 
      Button stopButton = new Button("stop"); 
      stopButton.setLayoutX(250); 
      stopButton.setLayoutY(250); 
      
      stopButton.setOnMouseClicked((new EventHandler<MouseEvent>() { 
         public void handle(MouseEvent event) { 
            System.out.println("Hello World"); 
            pathTransition.stop(); 
         } 
      }));
      //Creating a Group object  
      Group root = new Group(circle, playButton, stopButton); 
         
      //Creating a scene object 
      Scene scene = new Scene(root, 600, 300); 
      scene.setFill(Color.LAVENDER);  
      
      //Setting title to the Stage 
      stage.setTitle("Convenience Methods Example");  
         
      //Adding scene to the stage 
      stage.setScene(scene); 
         
      //Displaying the contents of the stage 
      stage.show(); 
   } 
   public static void main(String args[]){ 
      launch(args); 
   } 
}
```

## JavaFX UI Controls

* Login Page

```java
import javafx.application.Application;
import javafx.stage.Stage; 
import javafx.scene.Scene; 

import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class FXInterface extends Application {
   @Override 
   public void start(Stage stage) {      
      //creating label email 
      Text text1 = new Text("Email");       
      
      //creating label password 
      Text text2 = new Text("Password"); 
       
      //Creating Text Filed for email        
      TextField textField1 = new TextField();       
      
      //Creating Text Filed for password        
      PasswordField textField2 = new PasswordField();  
       
      //Creating Buttons 
      Button button1 = new Button("Submit"); 
      Button button2 = new Button("Clear");  
      
      //Creating a Grid Pane 
      GridPane gridPane = new GridPane();    
      
      //Setting size for the pane 
      gridPane.setMinSize(400, 200); 
      
      //Setting the padding  
      gridPane.setPadding(new Insets(10, 10, 10, 10)); 
      
      //Setting the vertical and horizontal gaps between the columns 
      gridPane.setVgap(5); 
      gridPane.setHgap(5);       
      
      //Setting the Grid alignment 
      gridPane.setAlignment(Pos.CENTER); 
       
      //Arranging all the nodes in the grid 
      gridPane.add(text1, 0, 0); 
      gridPane.add(textField1, 1, 0); 
      gridPane.add(text2, 0, 1);       
      gridPane.add(textField2, 1, 1); 
      gridPane.add(button1, 0, 2); 
      gridPane.add(button2, 1, 2); 
       
      //Styling nodes  
      button1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
      button2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
       
      text1.setStyle("-fx-font: normal bold 20px 'serif' "); 
      text2.setStyle("-fx-font: normal bold 20px 'serif' ");  
      gridPane.setStyle("-fx-background-color: BEIGE;"); 
       
      //Creating a scene object 
      Scene scene = new Scene(gridPane); 
       
      //Setting title to the Stage 
      stage.setTitle("CSS Example"); 
         
      //Adding scene to the stage 
      stage.setScene(scene);
      
      //Displaying the contents of the stage 
      stage.show(); 
   }      
   public static void main(String args[]){ 
      launch(args); 
   } 
}
```

* Form Page

```java
import javafx.application.Application;
import javafx.stage.Stage; 
import javafx.scene.Scene; 

import javafx.scene.text.Text;
import javafx.collections.ObservableList;

import javafx.collections.FXCollections;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class FXInterface extends Application {
   @Override 
   public void start(Stage stage) {    
      //Label for name 
      Text nameLabel = new Text("Name"); 
      
      //Text field for name 
      TextField nameText = new TextField(); 
       
      //Label for date of birth 
      Text dobLabel = new Text("Date of birth"); 
      
      //date picker to choose date 
      DatePicker datePicker = new DatePicker(); 
       
      //Label for gender
      Text genderLabel = new Text("gender"); 
      
      //Toggle group of radio buttons       
      ToggleGroup groupGender = new ToggleGroup(); 
      RadioButton maleRadio = new RadioButton("male"); 
      maleRadio.setToggleGroup(groupGender); 
      RadioButton femaleRadio = new RadioButton("female"); 
      femaleRadio.setToggleGroup(groupGender); 
       
      //Label for reservation 
      Text reservationLabel = new Text("Reservation"); 
      
      //Toggle button for reservation 
      ToggleButton Reservation = new ToggleButton(); 
      ToggleButton yes = new ToggleButton("Yes"); 
      ToggleButton no = new ToggleButton("No"); 
      ToggleGroup groupReservation = new ToggleGroup(); 
      yes.setToggleGroup(groupReservation);   
      no.setToggleGroup(groupReservation); 
       
      //Label for technologies known 
      Text technologiesLabel = new Text("Technologies Known"); 
      
      //check box for education 
      CheckBox javaCheckBox = new CheckBox("Java"); 
      javaCheckBox.setIndeterminate(false); 
      
      //check box for education 
      CheckBox dotnetCheckBox = new CheckBox("DotNet"); 
      javaCheckBox.setIndeterminate(false); 
       
      //Label for education 
      Text educationLabel = new Text("Educational qualification"); 
      
      //list View for educational qualification 
      ObservableList<String> names = FXCollections.observableArrayList( 
         "Engineering", "MCA", "MBA", "Graduation", "MTECH", "Mphil", "Phd"); 
      ListView<String> educationListView = new ListView<String>(names); 
      
      //Label for location 
      Text locationLabel = new Text("location"); 
      
      //Choice box for location 
      ChoiceBox locationchoiceBox = new ChoiceBox(); 
      locationchoiceBox.getItems().addAll("Hyderabad", "Chennai", "Delhi", "Mumbai", "Vishakhapatnam"); 
       
      //Label for register 
      Button buttonRegister = new Button("Register");  
      
      //Creating a Grid Pane 
      GridPane gridPane = new GridPane();    
      
      //Setting size for the pane 
      gridPane.setMinSize(500, 500); 
       
      //Setting the padding    
      gridPane.setPadding(new Insets(10, 10, 10, 10));  
      
      //Setting the vertical and horizontal gaps between the columns 
      gridPane.setVgap(5); 
      gridPane.setHgap(5);       
      
      //Setting the Grid alignment 
      gridPane.setAlignment(Pos.CENTER); 
       
      //Arranging all the nodes in the grid 
      gridPane.add(nameLabel, 0, 0); 
      gridPane.add(nameText, 1, 0); 
       
      gridPane.add(dobLabel, 0, 1);       
      gridPane.add(datePicker, 1, 1); 
      
      gridPane.add(genderLabel, 0, 2); 
      gridPane.add(maleRadio, 1, 2);       
      gridPane.add(femaleRadio, 2, 2); 
      gridPane.add(reservationLabel, 0, 3); 
      gridPane.add(yes, 1, 3);       
      gridPane.add(no, 2, 3);  
       
      gridPane.add(technologiesLabel, 0, 4); 
      gridPane.add(javaCheckBox, 1, 4);       
      gridPane.add(dotnetCheckBox, 2, 4);  
       
      gridPane.add(educationLabel, 0, 5); 
      gridPane.add(educationListView, 1, 5);      
       
      gridPane.add(locationLabel, 0, 6); 
      gridPane.add(locationchoiceBox, 1, 6);    
       
      gridPane.add(buttonRegister, 2, 8);      
      
      //Styling nodes   
      buttonRegister.setStyle(
         "-fx-background-color: darkslateblue; -fx-textfill: white;"); 
       
      nameLabel.setStyle("-fx-font: normal bold 15px 'serif' "); 
      dobLabel.setStyle("-fx-font: normal bold 15px 'serif' "); 
      genderLabel.setStyle("-fx-font: normal bold 15px 'serif' "); 
      reservationLabel.setStyle("-fx-font: normal bold 15px 'serif' "); 
      technologiesLabel.setStyle("-fx-font: normal bold 15px 'serif' "); 
      educationLabel.setStyle("-fx-font: normal bold 15px 'serif' "); 
      locationLabel.setStyle("-fx-font: normal bold 15px 'serif' "); 
       
      //Setting the back ground color 
      gridPane.setStyle("-fx-background-color: BEIGE;");       
       
      //Creating a scene object 
      Scene scene = new Scene(gridPane); 
      
      //Setting title to the Stage 
      stage.setTitle("Registration Form"); 
         
      //Adding scene to the stage 
      stage.setScene(scene);  
      
      //Displaying the contents of the stage 
      stage.show(); 
   }      
   public static void main(String args[]){ 
      launch(args); 
   } 
}
```

## JavaFX Charts

* To create a chart,
  1. Define the axis of the chart
  2. Instantiate the respective class
  3. Prepare and pass data to the chart

* Bar chart

* Table barchart

| Car | Speed | User Rating | Millage | Safety |
| :-- | :---- | :---------- | :------ | :----- |
| Fiat | 1.0 | 3.0 | 5.0 | 5.0 |
| Audi | 5.0 | 6.0 | 10.0 | 4.0 |
| Ford | 4.0 | 2.0 | 3.0 | 6.0 |

```java
import java.util.Arrays;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class FXInterface extends Application {
   @Override
   public void start(Stage stage) {    
      //Defining the axes              
      CategoryAxis xAxis = new CategoryAxis();  
      xAxis.setCategories(FXCollections.<String>
      observableArrayList(Arrays.asList("Speed", "User rating", "Milage", "Safety")));
      xAxis.setLabel("category");
       
      NumberAxis yAxis = new NumberAxis();
      yAxis.setLabel("score");
     
      //Creating the Bar chart
      BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis); 
      barChart.setTitle("Comparison between various cars");
        
      //Prepare XYChart.Series objects by setting data       
      XYChart.Series<String, Number> series1 = new XYChart.Series<>();
      series1.setName("Fiat");
      series1.getData().add(new XYChart.Data<>("Speed", 1.0));
      series1.getData().add(new XYChart.Data<>("User rating", 3.0));
      series1.getData().add(new XYChart.Data<>("Milage", 5.0));
      series1.getData().add(new XYChart.Data<>("Safety", 5.0));
        
      XYChart.Series<String, Number> series2 = new XYChart.Series<>();
      series2.setName("Audi");
      series2.getData().add(new XYChart.Data<>("Speed", 5.0));
      series2.getData().add(new XYChart.Data<>("User rating", 6.0));
      series2.getData().add(new XYChart.Data<>("Milage", 10.0));
      series2.getData().add(new XYChart.Data<>("Safety", 4.0));

      XYChart.Series<String, Number> series3 = new XYChart.Series<>();
      series3.setName("Ford");
      series3.getData().add(new XYChart.Data<>("Speed", 4.0));
      series3.getData().add(new XYChart.Data<>("User rating", 2.0));
      series3.getData().add(new XYChart.Data<>("Milage", 3.0));
      series3.getData().add(new XYChart.Data<>("Safety", 6.0));
              
      //Setting the data to bar chart       
      barChart.getData().addAll(series1, series2, series3);
        
      //Creating a Group object 
      Group root = new Group(barChart);
        
      //Creating a scene object
      Scene scene = new Scene(root, 600, 400);

      //Setting title to the Stage
      stage.setTitle("Bar Chart");
        
      //Adding scene to the stage
      stage.setScene(scene);
        
      //Displaying the contents of the stage
      stage.show();        
   }
   public static void main(String args[]){
      launch(args);
   }
}
```

* Pie chart

```java
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;

public class FXInterface extends Application {
   @Override 
   public void start(Stage stage) { 
      //Preparing ObservbleList object         
      ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
         new PieChart.Data("Iphone 5S", 13), 
         new PieChart.Data("Samsung Grand", 25), 
         new PieChart.Data("MOTO G", 10), 
         new PieChart.Data("Nokia Lumia", 22)); 
       
      //Creating a Pie chart 
      PieChart pieChart = new PieChart(pieChartData); 
              
      //Setting the title of the Pie chart 
      pieChart.setTitle("Mobile Sales"); 
       
      //setting the direction to arrange the data 
      pieChart.setClockwise(true); 
       
      //Setting the length of the label line 
      pieChart.setLabelLineLength(50); 

      //Setting the labels of the pie chart visible  
      pieChart.setLabelsVisible(true); 
       
      //Setting the start angle of the pie chart  
      pieChart.setStartAngle(180);     
         
      //Creating a Group object  
      Group root = new Group(pieChart); 
         
      //Creating a scene object 
      Scene scene = new Scene(root, 600, 400);  
      
      //Setting title to the Stage 
      stage.setTitle("Pie chart"); 
         
      //Adding scene to the stage 
      stage.setScene(scene); 
         
      //Displaying the contents of the stage 
      stage.show();         
   }     
   public static void main(String args[]){ 
      launch(args); 
   }
}
```

## JavaFX - Layout Panes(Containers)

* Following are the various Layout panes (classes) provided by JavaFX. These classes exist in the package __javafx.scene.layout__.

| No | Shape & Description |
| :- | :------------------ |
| 1 | __HBox__</br>The HBox layout arranges all the nodes in our application in a single horizontal row. The class named HBox of the package javafx.scene.layout represents the text horizontal box layout. |
| 2 | __VBox__</br>The VBox layout arranges all the nodes in our application in a single vertical column. The class named VBox of the package javafx.scene.layout represents the text Vertical box layout. |
| 3 | __BorderPane__</br> The Border Pane layout arranges the nodes in our application in top, left, right, bottom and center positions. The class named BorderPane of the package javafx.scene.layout represents the border pane layout. |
| 4 | __StackPane__</br> The stack pane layout arranges the nodes in our application on top of another just like in a stack. The node added first is placed at the bottom of the stack and the next node is placed on top of it. The class named StackPane of the package javafx.scene. layout represents the stack pane layout. |
| 5 | __TextFlow__</br>The Text Flow layout arranges multiple text nodes in a single flow. The class named TextFlow of the package javafx.scene.layout represents the text flow layout. |
| 6 | __AnchorPane__</br>The Anchor pane layout anchors the nodes in our application at a particular distance from the pane. The class named AnchorPane of the package javafx.scene.layout represents the Anchor Pane layout. |
| 7 | __TilePane__</br>The Tile Pane layout adds all the nodes of our application in the form of uniformly sized tiles. The class named TilePane of the package javafx.scene.layout represents the TilePane layout. |
| 8 | __GridPane__</br>The Grid Pane layout arranges the nodes in our application as a grid of rows and columns. This layout comes handy while creating forms using JavaFX. The class named GridPane of the package javafx.scene.layout represents the GridPane layout. |
| 9 | __FlowPane__</br>The flow pane layout wraps all the nodes in a flow. A horizontal flow pane wraps the elements of the pane at its height, while a vertical flow pane wraps the elements at its width. The class named FlowPane of the package javafx.scene.layout represents the Flow Pane layout. |

* JavaFX - Layout GridPane

```java
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class FXInterface extends Application {
   @Override 
   public void start(Stage stage) {      
      //creating label email 
      Text text1 = new Text("Email");       
      
      //creating label password 
      Text text2 = new Text("Password"); 
	  
      //Creating Text Filed for email        
      TextField textField1 = new TextField();       
      
      //Creating Text Filed for password        
      TextField textField2 = new TextField();  
       
      //Creating Buttons 
      Button button1 = new Button("Submit"); 
      Button button2 = new Button("Clear");  
      
      //Creating a Grid Pane 
      GridPane gridPane = new GridPane();    
      
      //Setting size for the pane  
      gridPane.setMinSize(400, 200); 
       
      //Setting the padding  
      gridPane.setPadding(new Insets(10, 10, 10, 10)); 
      
      //Setting the vertical and horizontal gaps between the columns 
      gridPane.setVgap(5); 
      gridPane.setHgap(5);       
      
      //Setting the Grid alignment 
      gridPane.setAlignment(Pos.CENTER); 
       
      //Arranging all the nodes in the grid 
      gridPane.add(text1, 0, 0); 
      gridPane.add(textField1, 1, 0); 
      gridPane.add(text2, 0, 1);       
      gridPane.add(textField2, 1, 1); 
      gridPane.add(button1, 0, 2); 
      gridPane.add(button2, 1, 2);  
      
      //Creating a scene object 
      Scene scene = new Scene(gridPane);  
      
      //Setting title to the Stage 
      stage.setTitle("Grid Pane Example"); 
         
      //Adding scene to the stage 
      stage.setScene(scene); 
         
      //Displaying the contents of the stage 
      stage.show(); 
   } 
   public static void main(String args[]){ 
      launch(args); 
   }
}
```

* JavaFX - FlowPane

```java
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

public class FXInterface extends Application {
   @Override 
   public void start(Stage stage) {      
      //Creating button1 
      Button button1 = new Button("Button1");       
      
      //Creating button2 
      Button button2 = new Button("Button2");       
      
      //Creating button3
      Button button3 = new Button("Button3");       
      
      //Creating button4 
      Button button4 = new Button("Button4");       
      
      //Creating a Flow Pane 
      FlowPane flowPane = new FlowPane();    
       
      //Setting the horizontal gap between the nodes 
      flowPane.setHgap(25); 
       
      //Setting the margin of the pane  
      flowPane.setMargin(button1, new Insets(20, 0, 20, 20)); 
       
      //Retrieving the observable list of the flow Pane 
      ObservableList list = flowPane.getChildren(); 
      
      //Adding all the nodes to the flow pane 
      list.addAll(button1, button2, button3, button4); 
        
      //Creating a scene object 
      Scene scene = new Scene(flowPane);  
      
      //Setting title to the Stage 
      stage.setTitle("Flow Pane Example"); 
         
      //Adding scene to the stage 
      stage.setScene(scene); 
         
      //Displaying the contents of the stage 
      stage.show(); 
   } 
   public static void main(String args[]){
      launch(args); 
   }
}
```

## JavaFX CSS

* CSS Style Rule Syntax

```shell
selector { property: value }
```

```java
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class FXInterface extends Application {
   @Override 
   public void start(Stage stage) {      
      //creating label email 
      Text text1 = new Text("Email");       
      
      //creating label password 
      Text text2 = new Text("Password"); 
       
      //Creating Text Filed for email        
      TextField textField1 = new TextField();       
      
      //Creating Text Filed for password        
      PasswordField textField2 = new PasswordField();  
       
      //Creating Buttons 
      Button button1 = new Button("Submit"); 
      Button button2 = new Button("Clear");  
      
      //Creating a Grid Pane 
      GridPane gridPane = new GridPane();    
      
      //Setting size for the pane 
      gridPane.setMinSize(400, 200);
      
      //Setting the padding  
      gridPane.setPadding(new Insets(10, 10, 10, 10)); 
      
      //Setting the vertical and horizontal gaps between the columns 
      gridPane.setVgap(5); 
      gridPane.setHgap(5);       
      
      //Setting the Grid alignment 
      gridPane.setAlignment(Pos.CENTER); 
       
      //Arranging all the nodes in the grid 
      gridPane.add(text1, 0, 0); 
      gridPane.add(textField1, 1, 0); 
      gridPane.add(text2, 0, 1);       
      gridPane.add(textField2, 1, 1); 
      gridPane.add(button1, 0, 2); 
      gridPane.add(button2, 1, 2); 
       
      //Styling nodes  
      button1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
      button2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
       
      text1.setStyle("-fx-font: normal bold 20px 'serif' "); 
      text2.setStyle("-fx-font: normal bold 20px 'serif' ");  
      gridPane.setStyle("-fx-background-color: BEIGE;"); 
       
      // Creating a scene object 
      Scene scene = new Scene(gridPane); 
       
      // Setting title to the Stage   
      stage.setTitle("CSS Example"); 
         
      // Adding scene to the stage 
      stage.setScene(scene);
      
      //Displaying the contents of the stage 
      stage.show(); 
   } 
   public static void main(String args[]){ 
      launch(args); 
   }
}
```
