import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class itens_carrinho {

    public static WebDriver driver;

    @Dado("eu estar na pagina home")
    public void eu_estar_na_pagina_home() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://marcelodebittencourt.com/demoprestashop/");
    }
    @Quando("já adicionei produtos no carrinho")
    public void já_adicionei_produtos_no_carrinho() {
        driver.findElement(By.cssSelector("#content > section > div > article:nth-child(1) > div > div.product-description > div > span.price")).click();

        driver.get("https://marcelodebittencourt.com/demoprestashop/men/1-1-hummingbird-printed-t-shirt.html#/1-size-s/8-color-white");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#add-to-cart-or-refresh > div.product-add-to-cart > div > div.add")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#blockcart-modal > div > div > div.modal-body > div > div.col-md-7 > div > div > a > i")).click();
        driver.findElement(By.cssSelector("#_desktop_logo > a > img")).click();
    }
    @Então("vou clicar no carrinho para visualizar os meus produtos")
    public void vou_clicar_no_carrinho_para_visualizar_os_meus_produtos() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#_desktop_cart > div > div > a > span.cart-products-count")).click();



    }

}
