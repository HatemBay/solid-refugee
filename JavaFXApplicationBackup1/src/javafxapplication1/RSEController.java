/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import com.donation.Entite.View;
import com.donation.Service.ServiceImage;
import com.donation.Service.ServiceUsers;
import static com.donation.Service.ServiceUsers.currentUser;
import com.donation.Service.ServiceView;
import com.donation.Utils.DataBase;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Path;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;

/**
 * FXML Controller class
 *
 * @author Hatem
 */
public class RSEController implements Initializable {

    @FXML
    private HBox imageDisplay;
    @FXML
    private TextArea postText;
    @FXML
    private VBox postArea;
    @FXML
    private ScrollPane scrollPic;
    @FXML
    private Button post;
    @FXML
    private AnchorPane anchor;
    
    Pane jesus = new Pane();
    
    Clipboard clipboard = Clipboard.getSystemClipboard();
    ClipboardContent content = new ClipboardContent();

    ServiceUsers serUsers = new ServiceUsers();
    ServiceView serView = new ServiceView();
    ServiceImage serImage = new ServiceImage();
    private final Connection con;
    private Statement ste;
    @FXML
    private Label gg;
    
    public RSEController() {
        con = DataBase.getInstance().getConnection();

        // initialize the Pattern object
        //pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int size = 0;

        try {
            ResultSet rsView = con.createStatement().executeQuery("select * from `view` order by Id_view desc;");
            while (rsView.next()){
                int j = 0;

                VBox vb1 = new VBox();

                FlowPane fp1 = new FlowPane();

                String text = rsView.getString("Text");
                
                ResultSet rsImage = con.createStatement().executeQuery("select * from `image` where Id_view = " 
                        + rsView.getInt("Id_view") + ";");
               ResultSet rsImage2 = con.createStatement().executeQuery("select count(*) from `image` where Id_view = '" 
                        + rsView.getInt("Id_view") + "';");
                while(rsImage2.next()){
                    size =  rsImage2.getInt(1);
                }
                while(rsImage.next()){
                    j++;
                    ImageView iv2 = new ImageView();
                    Blob b = rsImage.getBlob("Name");
                    InputStream is = b.getBinaryStream();  
                    BufferedImage imagen = ImageIO.read(is);
                    javafx.scene.image.Image imagef = SwingFXUtils.toFXImage(imagen, null);
                    //test on how many images the user posted
                    switch (size) {
                        case 1:
                            iv2.setFitHeight(270);
                            iv2.setFitWidth(570);
                            break;
                        case 2:
                            iv2.setFitHeight(270);
                            iv2.setFitWidth(285);
                            break;
                        case 3:
                            iv2.setFitHeight(150);
                            iv2.setFitWidth(285);
                            if(j == 3){
                                iv2.translateXProperty().set(142.5);
                            }   break;
                        case 4:
                            iv2.setFitHeight(150);
                            iv2.setFitWidth(285);
                            break;
                        default:
                            //Set<ImageView> ivs = new HashSet<>();
                            //ivs.add(iv);
                            iv2.autosize();
                            break;
                    }
                    iv2.setImage(imagef);
                    fp1.getChildren().add(iv2);
                }
                Label lab = new Label();
                
                fp1.setMinSize(572, 305);
                fp1.setMaxSize(572, 305);
                fp1.setStyle("-fx-border-color: #000000;" + "-fx-background-color: #ffffff;");
                lab.setText(text);    
                lab.setStyle("-fx-font-size: 15px;");
                lab.setStyle("-fx-font-weight: bold;");
                vb1.getChildren().add(lab);
                vb1.getChildren().add(fp1);
                vb1.setSpacing(5);
                postArea.getChildren().add(vb1);
                
            }
            jesus.setPrefHeight(50);
            postArea.getChildren().add(jesus);
            
            //joining image and view
            /*ResultSet rs = con.createStatement().executeQuery("SELECT v.Id_view, v.Text, i.Name " +
                                                            "FROM donation.view v, donation.image i" +
                                                            "where v.Id_view=i.Id_view " +
                                                            "order by Id_view desc;");
            Label l = new Label();
            int counter = 0;
            int id = 0;
            while(rs.next()){
                int idp = id;
                String text = rs.getString("Text");
                Image image = serImage.BTM(rs.getBlob("Name"));
                id = rs.getInt("Id_view");

                while(counter == 1 && idp == id){
                    iv2.setImage(image);
                    fp1.getChildren().add(iv2);
                }
                if(idp != id){
                    vb1.getChildren().add(l);
                    vb1.getChildren().add(fp1);
                    fp1.getChildren().clear();
                    iv2.setImage(image);
                    fp1.getChildren().add(iv2);
                }
                counter = 1;
                l.setText(text);
                if (counter == 0){
                    iv2.setImage(image);
                    fp1.getChildren().add(iv2);
                }
                    
            }*/

            } catch (SQLException |IOException ex) {
            Logger.getLogger(RSEController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    FileChooser fc = new FileChooser();
    List<File> f = new LinkedList<>();
    Set<File> s = new HashSet<>();
    Set<File> s2 = new HashSet<>();
    int i = 0;
    int idv = 0;

    //List<File> f2 = new LinkedList<>();
    //List<File> fr = new ArrayList<>();

    @FXML
    private void getImages(ActionEvent event) throws IOException {
        f = fc.showOpenMultipleDialog(null);
        s = f.stream().collect(Collectors.toCollection(()->new HashSet<>()));

        for (File file : f){
            if (s2.contains(file))
            s.remove(file);
        }

        s2.addAll(s);
        fc.getExtensionFilters().add(new ExtensionFilter("Images", "*.png", "*.jpg"));
        
        for (File file : s) {
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            ImageView iv = new ImageView();
            iv.setFitHeight(90);
            iv.setFitWidth(99);
            iv.setImage(image);
            scrollPic.setMinHeight(105);
            scrollPic.translateYProperty().set(-20);
            post.translateYProperty().set(80);
            imageDisplay.getChildren().add(0,iv);
            scrollPic.visibleProperty().set(true);
            iv.setOnMouseClicked(e -> {
                imageDisplay.getChildren().remove(iv);
                s2.remove(file);
                if (s2.isEmpty()){
                    scrollPic.setVisible(false);
                    post.translateYProperty().set(-30);
                }
            });
        }

    }

    @FXML
    private void postContent(ActionEvent event) throws IOException, SQLException {
        if (!s2.isEmpty()) {
            FlowPane fp1 = new FlowPane();
            VBox vb1 = new VBox();

            //*******zayed
            for (File file : s2) {
                BufferedImage bufferedImage = ImageIO.read(file);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                File ff = new File ("C:\\wamp64\\www\\PIimages\\" + file.getName());
                copy(file, ff, image);
            }
            //*******zayed
            imageDisplay.getChildren().clear();
            scrollPic.setVisible(false);
            post.translateYProperty().set(-30);
            
        
        
        //making view:
        View v = new View(currentUser.getId_user(), postText.getText());
        ResultSet rs = con.createStatement().executeQuery("select * from `view` where `Id_view` = (SELECT MAX(Id_view) FROM view);");
        while (rs.next())
            idv = rs.getInt("Id_view");
        
        //********************adding view to database:***************************
        serView.add(v);
        //*******************************************************
        for (File file : s2) {

                i++;
                BufferedImage bufferedImage = ImageIO.read(file);
                Image im = SwingFXUtils.toFXImage(bufferedImage, null);
                ImageView iv = new ImageView();
                //test on how many images the user posted
                switch (s2.size()) {
                    case 1:
                        iv.setFitHeight(270);
                        iv.setFitWidth(570);
                        break;
                    case 2:
                        iv.setFitHeight(270);
                        iv.setFitWidth(285);
                        break;
                    case 3:
                        iv.setFitHeight(150);
                        iv.setFitWidth(285);
                        if(i == 3){
                            iv.translateXProperty().set(142.5);
                        }   break;
                    case 4:
                        iv.setFitHeight(150);
                        iv.setFitWidth(285);
                        break;
                    default:
                        //Set<ImageView> ivs = new HashSet<>();
                        //ivs.add(iv);
                        iv.autosize();
                        break;
                }
                
                iv.setImage(im);
                fp1.getChildren().add(iv);
                
                
                //********************making images ***************************    
                //com.donation.Entite.Image im = new com.donation.Entite.Image(idv, file.getName());
                //serImage.add(im);
            }
                 for (File file2 : s2) {
                    BufferedImage bufferedImage2 = ImageIO.read(file2);
                    Image img = SwingFXUtils.toFXImage(bufferedImage2, null);
                    
                    File ff = new File ("C:\\wamp64\\www\\PIimages\\" + file2.getName());
                    PreparedStatement statement = null;
                    FileInputStream inputStream = null;
                    inputStream = new FileInputStream(ff);
                    ste = con.createStatement();
                    statement = con.prepareStatement("INSERT INTO `donation`.`image` (`Id_image`, `Id_view`, `Name`)"
                    + "VALUES (?, ?, ?);");
                    statement.setNull(1, java.sql.Types.INTEGER);
                    statement.setInt(2, idv+1);
                    //statement.setBinaryStream(3, (InputStream) inputStream, (int)(ff.length()));
                    statement.setBlob(3, new SerialBlob(serImage.ITB(img)));
                    statement.executeUpdate();
                }
                 //*********image stored in database
        Label lab2 = new Label();
        lab2.setText(postText.getText());    
        lab2.setStyle("-fx-font-size: 15px;");
        lab2.setStyle("-fx-font-weight: bold;");
        vb1.getChildren().add(lab2);
        fp1.setMinSize(572, 305);
        fp1.setMaxSize(572, 305);
        fp1.setStyle("-fx-border-color: #000000;" + "-fx-background-color: #ffffff;");
        vb1.getChildren().add(fp1);
        vb1.setSpacing(5);


        postArea.getChildren().add(0, vb1);
        //TextField tf = new TextField();
        //tf.setMinWidth(570);
        //tf.setMaxWidth(570);
        //postArea.getChildren().add(tf);
        s.clear();
        s2.clear();
        postText.clear();

        }
        i = 0;

    }

    private void copy(File src, File dest, Image image) {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);

            // buffer size 1K
            byte[] buf = new byte[1024];

            int bytesRead;
            while ((bytesRead = is.read(buf)) > 0) {
                os.write(buf, 0, bytesRead);
                is.close();
                os.close();
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }        
    }

}
