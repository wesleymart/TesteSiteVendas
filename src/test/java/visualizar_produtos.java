import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class visualizar_produtos {

    public static WebDriver driver;

    @Before
    public void inicializar() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Dado("que estou na pagina de produtos")
    public void que_estou_na_pagina_de_produtos() {
        driver.get("https://marcelodebittencourt.com/demoprestashop/");
    }

    @Quando("ainda não fiz o login")
    public void ainda_não_fiz_o_login() {

    }

    @Então("visualizo o primeiro ou unico produto disponivel na posição {string} com valor diferente de {string}")
    public void visualizo_o_primeiro_ou_unico_produto_disponivel_na_posição_com_valor_diferente_de(String posicao, String string2) {

        int posicaoRecebida = Integer.parseInt(posicao);
        int valorEsperado = Integer.parseInt(string2);

        WebElement valorEncontrado = driver.findElement(By.cssSelector("#content > section > div > article:nth-child(" + posicao + ") > div > div.product-description > div > span.price"));
        assertThat(valorEncontrado).isNotEqualTo(valorEsperado);


    }

    //adicionar_carrinho
    @Dado("que estou na pagina dos produtos")
    public void que_estou_na_pagina_dos_produtos() {
        driver.get("https://marcelodebittencourt.com/demoprestashop/");
    }

    @Quando("clico no produto {string} que quero adicionar no carrinho")
    public void clicoNoProdutoQueQueroAdicionarNoCarrinho(String produto) {

        int produtoRecebido = Integer.parseInt(produto);
        driver.findElement(By.cssSelector("#content > section > div > article:nth-child(" + produtoRecebido + ") > div > div.product-description > div > span.price")).click();


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
    //fim adicionar_carrinho

    //itens_carrinho
    @Dado("eu estar na pagina home")
    public void eu_estar_na_pagina_home() {
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

    //fim itens_carrinho

    //compra_completa
    @Dado("eu já estar logado")
    public void eu_já_estar_logado() {

    }

    @Quando("na pagina de carrinho de compras")
    public void na_pagina_de_carrinho_de_compras() {

    }

    @Então("vou finalizar a compra e efetuar o pagamento")
    public void vou_finalizar_a_compra_e_efetuar_o_pagamento() {
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

    //fim compra-completa

    @After
    public void fechar() {
        driver.quit();
    }

}
