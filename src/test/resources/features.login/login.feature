#language: pt

Funcionalidade: Login on the mobile app

  @test
  Cenario: Successfully login
    Dado que o usuário esta na pagina inicial do app
    Quando clica no botão que redireciona para o login
    E informa o usuário e senha
    E solicita o acesso
    Então o sistema deve realizar o login

  @test
  Cenario: Cenario teste
    Dado que o usuário esta na pagina inicial do app
    Quando clica no botão que redireciona para o login