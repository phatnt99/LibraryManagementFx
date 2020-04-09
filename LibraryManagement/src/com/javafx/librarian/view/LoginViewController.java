package com.javafx.librarian.view;

import com.javafx.librarian.model.User;
import com.javafx.librarian.service.UserService;
import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginViewController implements Initializable {

    private double mousepX = 0;
    private double mousepY = 0;
    private Stage stage;

    //region khai báo biến controls
    @FXML
    public AnchorPane layoutParent;
    @FXML
    public AnchorPane layersignup;
    @FXML
    public AnchorPane layer1;

    @FXML
    public JFXButton btnClose;
    @FXML
    public Label lbCreateAccount;
    @FXML
    public Label lbSignIn;
    @FXML
    public TextField textUserCreate;
    @FXML
    public TextField textEmail;
    @FXML
    public TextField passCreate;
    @FXML
    public JFXButton btnSignup;
    @FXML
    public JFXButton btnSignin;
    @FXML
    public TextField textUserLogin;
    @FXML
    public Label lbForget;
    @FXML
    public PasswordField passUserLogin;
    @FXML
    public AnchorPane layer2;
    @FXML
    public Label lbCreate1;
    @FXML
    public Label lbCreate2;
    @FXML
    public Label lbCreate3;
    @FXML
    public JFXButton btnSignInMove;
    @FXML
    public JFXButton btnSignupMove;
    @FXML
    public Label lbLogin1;
    @FXML
    public Label lbLogin2;
    @FXML
    public Label lbLogin3;
    //endregion

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbCreateAccount.setVisible(false);
        textUserCreate.setVisible(false);
        textEmail.setVisible(false);
        passCreate.setVisible(false);
        btnSignup.setVisible(false);
        lbCreate1.setVisible(false);
        lbCreate2.setVisible(false);
        lbCreate3.setVisible(false);
        btnSignInMove.setVisible(false);
        textUserLogin.requestFocus();

        layer1.setOnMousePressed(mouseEvent -> {
            mousepX = mouseEvent.getSceneX();
            mousepY = mouseEvent.getSceneY();
        });

        layer1.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - mousepX);
            stage.setY(mouseEvent.getScreenY()- mousepY);
        });
    }

    @FXML
    public void btnSignIn_Click(ActionEvent event) {
        User user = UserService.getInstance().getUser(textUserLogin.getText(), passUserLogin.getText());
        if(user!=null){
            String tilte = "Sign In";
            String message = textUserLogin.getText();
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;

            tray.setAnimationType(type);
            tray.setTitle(tilte);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(2000));
        }
        else{
            String tilte = "Sign In";
            String message = "Error Username/Password Wrong";
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;

            tray.setAnimationType(type);
            tray.setTitle(tilte);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.ERROR);
            tray.showAndDismiss(Duration.millis(2000));
        }
//        if ("admin".equals(textUserLogin.getText()) && "123456".equals(passUserLogin.getText())) {
//            String tilte = "Sign In";
//            String message = textUserLogin.getText();
//            TrayNotification tray = new TrayNotification();
//            AnimationType type = AnimationType.POPUP;
//
//            tray.setAnimationType(type);
//            tray.setTitle(tilte);
//            tray.setMessage(message);
//            tray.setNotificationType(NotificationType.SUCCESS);
//            tray.showAndDismiss(Duration.millis(3000));
//        }
//        if (!"admin".equals(textUserLogin.getText())) {
//            String tilte = "Sign In";
//            String message = "Error Username " + "'" + textUserLogin.getText() + "'" + " Wrong";
//            TrayNotification tray = new TrayNotification();
//            AnimationType type = AnimationType.POPUP;
//
//            tray.setAnimationType(type);
//            tray.setTitle(tilte);
//            tray.setMessage(message);
//            tray.setNotificationType(NotificationType.ERROR);
//            tray.showAndDismiss(Duration.millis(3000));
//        }
//        if (!"123456".equals(passUserLogin.getText())) {
//            String tilte = "Sign In";
//            String message = "Error Password " + "'" + passUserLogin.getText() + "'" + " Wrong";
//            TrayNotification tray = new TrayNotification();
//            AnimationType type = AnimationType.POPUP;
//
//            tray.setAnimationType(type);
//            tray.setTitle(tilte);
//            tray.setMessage(message);
//            tray.setNotificationType(NotificationType.ERROR);
//            tray.showAndDismiss(Duration.millis(3000));
//        }
//        if (!"admin".equals(textUserLogin.getText()) && !"123456".equals(passUserLogin.getText())) {
//            String tilte = "Sign In";
//            String message = "Error Username " + "'" + textUserLogin.getText() + "'" + ", and Password " + "'" + passUserLogin.getText() + "'" + " Wrong";
//            TrayNotification tray = new TrayNotification();
//            AnimationType type = AnimationType.POPUP;
//
//            tray.setAnimationType(type);
//            tray.setTitle(tilte);
//            tray.setMessage(message);
//            tray.setNotificationType(NotificationType.ERROR);
//            tray.showAndDismiss(Duration.millis(3000));
//        }
    }

    @FXML
    public void btnSignUpMove_Click(MouseEvent mouseEvent) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(layer2);

        slide.setToX(491);
        slide.play();

        layer1.setTranslateX(-309);
        btnSignin.setVisible(false);
        btnSignup.setVisible(true);

        lbCreateAccount.setVisible(true);
        textUserCreate.setVisible(true);
        textUserCreate.requestFocus();
        textEmail.setVisible(true);
        passCreate.setVisible(true);
        lbCreate1.setVisible(true);
        lbCreate2.setVisible(true);
        lbCreate3.setVisible(true);
        btnSignInMove.setVisible(true);

        lbSignIn.setVisible(false);
        textUserLogin.setVisible(false);
        passUserLogin.setVisible(false);
        lbLogin1.setVisible(false);
        lbLogin2.setVisible(false);
        lbLogin3.setVisible(false);
        btnSignupMove.setVisible(false);
        lbForget.setVisible(false);


        slide.setOnFinished((e -> {
            System.out.println("Finish Right!");
        }));
    }

    @FXML
    public void btnSignInMove_Click(MouseEvent mouseEvent) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.millis(700));
        slide.setNode(layer2);

        slide.setToX(0);
        slide.play();

        layer1.setTranslateX(0);
        btnSignup.setVisible(false);
        btnSignin.setVisible(true);

        lbCreateAccount.setVisible(false);
        textUserCreate.setVisible(false);
        textEmail.setVisible(false);
        passCreate.setVisible(false);
        lbCreate1.setVisible(false);
        lbCreate2.setVisible(false);
        lbCreate3.setVisible(false);
        btnSignInMove.setVisible(false);

        lbSignIn.setVisible(true);
        textUserLogin.setVisible(true);
        textUserLogin.requestFocus();
        passUserLogin.setVisible(true);
        lbLogin1.setVisible(true);
        lbLogin2.setVisible(true);
        lbLogin3.setVisible(true);
        btnSignupMove.setVisible(true);
        lbForget.setVisible(true);

        slide.setOnFinished(e -> System.out.println("Finish Left!"));
    }

    public void closeClick(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public void btnSignUp_Click(ActionEvent event) {
        boolean check = UserService.getInstance().checkCreateUser(textUserCreate.getText(), textEmail.getText());

        if(check){
            String tilte = "Sign Up";
            String message = "User: "+textUserCreate.getText() + " đã đăng kí thành công!!!";
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;

            tray.setAnimationType(type);
            tray.setTitle(tilte);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(2000));

            UserService.getInstance().addUser(new User(textUserCreate.getText(), passCreate.getText(), textEmail.getText()));
            textUserCreate.setText("");
            passCreate.setText("");
            textEmail.setText("");
            textUserCreate.requestFocus();
        }else{
            String tilte = "Sign Up";
            String message = "Lỗi trùng username/email. Xin vui lòng đăng ký lại!";
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;

            tray.setAnimationType(type);
            tray.setTitle(tilte);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.ERROR);
            tray.showAndDismiss(Duration.millis(2000));
        }
//        TranslateTransition slide = new TranslateTransition();
//        slide.setDuration(Duration.millis(700));
//        slide.setNode(layer2);
//
//        slide.setToX(0);
//        slide.play();
//
//        layer1.setTranslateX(0);
//        btnSignup.setVisible(false);
//        btnSignin.setVisible(true);
//
//        lbCreateAccount.setVisible(false);
//        textUserCreate.setVisible(false);
//        textEmail.setVisible(false);
//        passCreate.setVisible(false);
//        lbCreate1.setVisible(false);
//        lbCreate2.setVisible(false);
//        lbCreate3.setVisible(false);
//        btnSignInMove.setVisible(false);
//
//        lbSignIn.setVisible(true);
//        textUserLogin.setVisible(true);
//        textUserLogin.requestFocus();
//        passUserLogin.setVisible(true);
//        lbLogin1.setVisible(true);
//        lbLogin2.setVisible(true);
//        lbLogin3.setVisible(true);
//        btnSignupMove.setVisible(true);
//        lbForget.setVisible(true);
//
//        slide.setOnFinished(e -> System.out.println("Finish Left!"));
    }

    public void setMainStage(Stage stage){
        this.stage = stage;
    }
}
