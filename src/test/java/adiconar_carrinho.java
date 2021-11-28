import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.sl.In;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.*;

import java.util.concurrent.TimeUnit;

public class adiconar_carrinho {

    public static WebDriver driver;

    @Dado("que estou na pagina dos produtos")
    public void que_estou_na_pagina_dos_produtos() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://marcelodebittencourt.com/demoprestashop/");
    }

    @Quando("clico no produto {string} que quero adicionar no carrinho")
    public void clicoNoProdutoQueQueroAdicionarNoCarrinho(String produto) {

        int produtoRecebido = Integer.parseInt(produto);
        driver.findElement(By.cssSelector("#content > section > div > article:nth-child("+produtoRecebido+") > div > div.product-description > div > span.price")).click();


    }

    @Então("abre a pagina do produto com o botão para adicionar ao carrinho que ao clicar adicionar {string} produto no carrinho")
    public void abreAPaginaDoProdutoComOBotãoParaAdicionarAoCarrinhoQueAoClicarAdicionarProdutoNoCarrinho(String valorEsperado) {




        driver.get("https://marcelodebittencourt.com/demoprestashop/men/1-1-hummingbird-printed-t-shirt.html#/1-size-s/8-color-white");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#add-to-cart-or-refresh > div.product-add-to-cart > div > div.add")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#blockcart-modal > div > div > div.modal-body > div > div.col-md-7 > div > div > a > i")).click();


        String valorEncontrado = driver.findElement(By.cssSelector("#_desktop_cart > div > div > a > span.cart-products-count")).getText();
        assertThat(valorEsperado).isEqualTo(valorEncontrado);

    }

    @After
    public void fechar(){
        driver.quit();
    }



}
