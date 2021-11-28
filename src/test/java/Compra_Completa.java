import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Compra_Completa {

    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;



    @Dado("eu já estar logado")
    public void eu_já_estar_logado() {

    }
    @Quando("na pagina de carrinho de compras")
    public void na_pagina_de_carrinho_de_compras() {

    }
    @Então("vou finalizar a compra e efetuar o pagamento")
    public void vou_finalizar_a_compra_e_efetuar_o_pagamento() {

        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();

        driver.get("https://marcelodebittencourt.com/demoprestashop/");
        driver.manage().window().setSize(new Dimension(974, 1040));
        driver.findElement(By.cssSelector("a > .hidden-sm-down")).click();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("wesley.martins@gmail.com");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.id("submit-login")).click();
        driver.findElement(By.cssSelector(".logo")).click();
        driver.findElement(By.cssSelector(".product-miniature:nth-child(1) img")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".add-to-cart")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".cart-content-btn > .btn-primary")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".text-sm-center > .btn")).click();
        driver.findElement(By.name("company")).click();
        driver.findElement(By.name("company")).sendKeys("sisnema");
        driver.findElement(By.name("address1")).sendKeys("rua dona teresa espagiari");
        driver.findElement(By.name("city")).click();
        driver.findElement(By.name("id_state")).click();
        {
            WebElement dropdown = driver.findElement(By.name("id_state"));
            dropdown.findElement(By.xpath("//option[. = 'New York']")).click();
        }
        driver.findElement(By.name("postcode")).click();
        driver.findElement(By.name("city")).click();
        driver.findElement(By.name("city")).sendKeys("guaiba");
        driver.findElement(By.cssSelector(".form-group:nth-child(9) > .form-control-label")).click();
        driver.findElement(By.name("postcode")).sendKeys("10001");
        driver.findElement(By.name("id_country")).click();
        driver.findElement(By.name("confirm-addresses")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("confirmDeliveryOption")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("payment-option-1")).click();
        driver.findElement(By.id("payment-option-2")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("conditions_to_approve[terms-and-conditions]")).click();
        driver.findElement(By.cssSelector(".ps-shown-by-js > .btn")).click();
    }
}
