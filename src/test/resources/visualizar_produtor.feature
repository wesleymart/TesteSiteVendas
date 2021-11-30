# language: pt
  Funcionalidade: Visualizar produtos
    Como cliente entro no site
    Eu quero visualizar os produtos disponiveis
    Para poder escolher qual produto quero comprar

  Cenário: Mostrar proutos
   Dado que estou na pagina de produtos
   Quando ainda não fiz o login
   Então visualizo o primeiro ou unico produto disponivel na posição "1" com valor diferente de "0"

   Cenário: Adicionar produto no carrinho
     Dado que estou na pagina dos produtos
     Quando clico no produto "1" que quero adicionar no carrinho
     Então abre a pagina do produto com o botão para adicionar ao carrinho que ao clicar adicionar "(1)" produto no carrinho

   Cenário: Listar produtos no carrinho
     Dado eu estar na pagina home
     Quando já adicionei produtos no carrinho
     Então vou clicar no carrinho para visualizar os meus produtos

    Cenário: finalizar compra
      Dado eu já estar logado
      Quando na pagina de carrinho de compras
      Então vou finalizar a compra e efetuar o pagamento