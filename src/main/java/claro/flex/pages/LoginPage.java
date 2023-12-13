package claro.flex.pages;

import claro.flex.utils.Comandos;
import claro.flex.utils.DriverManager;
import claro.flex.utils.GetExcel;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

@Getter
public class LoginPage {
    public Comandos comandosUtils;


    public LoginPage() {
        AppiumDriver driver = DriverManager.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        comandosUtils = new Comandos(driver);
    }

    @AndroidFindBy(id = "br.com.claro.flex.stg:id/btConfirm")
    @iOSXCUITFindBy(id = "")
    private WebElement btnPermissao;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    @iOSXCUITFindBy(id = "")
    private WebElement btnPermitir;

    @AndroidFindBy(id = "br.com.claro.flex.stg:id/ButtonBeFlex")
    @iOSXCUITFindBy(id = "")
    private WebElement btnSejaFlex;

    @AndroidFindBy(id = "br.com.claro.flex.stg:id/ibSend")
    @iOSXCUITFindBy(id = "")
    private WebElement btnJaSouFlex;

    @AndroidFindBy(id = "br.com.claro.flex.stg:id/etUser")
    @iOSXCUITFindBy(id = "")
    private WebElement iptCpfOuEmail;

    @AndroidFindBy(id = "br.com.claro.flex.stg:id/etPassword")
    @iOSXCUITFindBy(id = "")
    private WebElement iptSenha;

    @AndroidFindBy(id = "br.com.claro.flex.stg:id/btEnter")
    @iOSXCUITFindBy(id = "")
    private WebElement btnEntrar;

    @AndroidFindBy(id = "br.com.claro.flex.stg:id/btFirstAccess")
    @iOSXCUITFindBy(id = "")
    private WebElement btnPrimeiroAcesso;

    @AndroidFindBy(id = "br.com.claro.flex.stg:id/bt_action")
    @iOSXCUITFindBy(id = "")
    private WebElement btnFecharModal;

    public void aceitarPermissao() {
        comandosUtils.waitClick(btnPermissao);
    }

    public void permitirAcesso() {
        comandosUtils.whileElementFound(btnPermitir);
    }

    public void clickSejaFlex() {
        comandosUtils.waitClick(btnSejaFlex);
    }

    public void clickJaSouFlex() {
        comandosUtils.waitClick(btnJaSouFlex);
    }

    public void setIptCpfOuEmail(GetExcel massa) {
        comandosUtils.waitSendKeys(iptCpfOuEmail, massa.getUsuario());
    }

    public void setIptSenha(GetExcel massa) {
        iptSenha.sendKeys(massa.getSenha());
    }

    public void clickBtnEntrar() {
        comandosUtils.waitClick(btnEntrar);
    }

    public void clickBtnPrimieroAcesso() {
        btnPrimeiroAcesso.click();
    }

}
