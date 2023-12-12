package claro.flex.steps;

import claro.flex.pages.HomePage;
import claro.flex.pages.LoginPage;
import claro.flex.utils.*;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.AfterClass;

public class LoginSteps {

    public LoginPage loginPage;
    public HomePage homePage;
    public AssertionHelper assertionHelper;
    private final GetExcel massa;
    public ScenarioContext scenarioContext;


    public LoginSteps() {
        scenarioContext = new ScenarioContext();
        loginPage = new LoginPage();
        homePage = new HomePage();
        assertionHelper = new AssertionHelper();
        ExcelReadWrite excelReader = new ExcelReadWrite();
        massa = excelReader.getExcel();
    }

    @Dado("que o usuário esta na pagina inicial do app")
    public void queOUsuárioEstaNaPaginaInicialDoApp() {
        loginPage.aceitarPermissao();
        loginPage.permitirAcesso();
    }

    @Quando("clica no botão que redireciona para o login")
    public void clicaNoBotãoQueRedirecionaParaOLogin() {
        loginPage.clickJaSouFlex();
    }

    @E("informa o usuário e senha")
    public void informaOUsuárioESenha() {
        loginPage.setIptCpfOuEmail(massa);
        loginPage.setIptSenha(massa);
    }

    @E("solicita o acesso")
    public void solicitoOAcesso() {
//        loginPage.clickBtnEntrar();
    }

    @Então("o sistema deve realizar o login")
    public void oSistemaDeveRealizarOLogin() {
        assertionHelper.assertTwoElementDisplayed(loginPage.getBtnFecharModal(), homePage.getDisplayConsumption());
    }

    @AfterClass
    public void quitDriver() {
        Hooks.quitDriver();
    }
}
