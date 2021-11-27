import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.*;

import java.util.concurrent.TimeUnit;


public class visualizar_produtos {

    public static WebDriver driver;


    @Dado("que estou na pagina de produtos")
    public void que_estou_na_pagina_de_produtos() {

    driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://marcelodebittencourt.com/demoprestashop/");

    }
    @Quando("ainda não fiz o login")
    public void ainda_não_fiz_o_login() {

    }
    @Então("visualizo o primeiro ou unico produto disponivel na posição {string} com valor diferente de {string}")
    public void visualizo_o_primeiro_ou_unico_produto_disponivel_na_posição_com_valor_diferente_de(String posicao, String string2) {

        int posicaoRecebida = Integer.parseInt(posicao);
        int valorEsperado = Integer.parseInt(string2);

        WebElement valorEncontrado = driver.findElement(By.cssSelector("#content > section > div > article:nth-child("+posicao+") > div > div.product-description > div > span.price"));
        assertThat(valorEncontrado).isNotEqualTo(valorEsperado);


    }


}
