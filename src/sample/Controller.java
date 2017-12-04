package sample;

import Admin.AdminController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    LoginModel loginModel = new LoginModel();

    @FXML
    private Label dbstatus;
    @FXML
    private TextField dbusername;
    @FXML
    private PasswordField dbpassword;
    @FXML
    private Button dblogin;
    @FXML
    private Label dbloginstatus;

    public void initialize(URL url, ResourceBundle rsBndl){
        if(this.loginModel.isDBcon()){
            this.dbstatus.setText("connected");
        } else {
            this.dbstatus.setText("disconnected");
        }
    }
    @FXML
    public void Login(ActionEvent event){
        try{
            if(this.loginModel.isDBlogin(this.dbusername.getText(),this.dbpassword.getText())){
                Stage stage = (Stage)this.dblogin.getScene().getWindow();
                stage.close();
                adminLogin();
            }else {
                this.dbloginstatus.setText("error: login failed");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public void guestLogin(){

    }
    public void adminLogin(){
        try{
            Stage adminStg = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/Admin/AdminFXML.fxml").openStream());

            AdminController adminCntrl = loader.getController();
            Scene scene = new Scene(root);
            adminStg.setScene(scene);
            adminStg.setTitle("Tournament: Server: Dashboard");
            adminStg.setResizable(false);
            adminStg.show();

        } catch(IOException e){
            e.printStackTrace();
        }
    }

}
