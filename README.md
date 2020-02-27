Simulador de Carrinho de Compras do Vaner
=========================================

Seja bem vindo ao simulador de carrinho de compras.

O carrinho foi arquitetado para provar conhecimento em:

-   Spring Boot - Backend
-   Angular 8 - FrontEnd
-   MongoDB - Banco de Dados utilizado
-   Docker - Um container para cada parte do sistema: Backend, Frontend
    e Database.
-   Maven - Builds e controle de dependências
-   Git - Controle de Versão

**Backend**

Utilizando o Spring Boot, foram criados os modelos de dados para o
usuário, item e carrinho de compras, sendo cada um desse um document do
MongoDB.

Também foi utilizada uma interface provida pelo Spring para lidar com os
dados no MongoDB (MongoRepository).

Por fim, foram criadas interfaces rest para fazer o CRUD dos modelos
citados acima.

**Frontend**

O frontend foi criado em Angular 8 sobre Node. Os modelos de dados do
backend foram replicados no Angular para serem utlizados nas
requisições. O layout foi feito utilizando-se bootstrap e jquery.

**Banco de Dados**

Foi utilizado o MongoDB para armazenar os dados gerados pelo sistema.

**Docker**

O módulo frontend possue um dockerfile para geração de uma imagem a ser
utilizada.

Já o container do mongoDB foi utilizado um dos mais tradicionais do
DockerHub.

**Maven**

O maven é responsável pelo gerenciamento dos artefatos que o projeto é
dependente e pela geração do war do backend. Além disso é possível
executar o backend pela linha de comando.

**Controle de Versão**

Para o controle de versão foi utilizado o Git e o repositório Git Hub:

[https://github.com/vanerjm/carrinho-compras](https://github.com/vanerjm/carrinho-compras)

Como executar o carrinho de Compras
-----------------------------------

Pre-requisitos:

-   Java 8
-   Docker
-   Maven
-   Git

**Iniciar o MongoDB**

Para não precisar instalar diretamente o mongoDb, foi utilizada uma
imagem provida pelo Docker Hub. Basta inicializar o docker e executar o
seguinte comando:

*docker run -d -p 27017:27017 -e AUTH=no tutum/mongodb*

Este comando fará o download mongodb e o inicializará na porta 27017 sem
nenhuma autenticação (usuário/senha).

Alternativamente ao docker, criei um cluster MongoDb no site
https://cloud.mongodb.com/ que também pode ser utilizado. A URI de
conexão é:

*mongodb+srv://admin:Wm2NSAcIDR1to0pj@cluster0-nghyh.mongodb.net/test?retryWrites=true&w=majority*

A escolha entre o MongoDB do docker ou a do cloudMongoDb é feita no
arquivo de recursos **application.properties** do backend.

**Compilando e Rodando a aplicação**

Para compilar o projeto, execute seguinte comando maven na pasta raiz do
projeto:

*mvn clean install*

Este comando fará a compilação do frontend e backend e gerará um WAR que
pode ser instalado em um servidor Tomcat.

Para compilar frontend, primeiramente será feito download do Node e NPM.

O resultado do frontend é copiado para dentro da pasta de resources do
backend. Desta forma temos um WAR contendo o backend e frontend.

Este fat WAR foi instalado no servidor web gratuito a seguir:

[http://carrinhodecompras-env.gqz6rg3cek.us-east-1.elasticbeanstalk.com](http://carrinhodecompras-env.gqz6rg3cek.us-east-1.elasticbeanstalk.com)

Para rodar o projeto localmente, basta acessar a pasta backend e
executar o seguinte comando:

*mvn spring-boot:run*

Um Tomcat provido pelo Spring Boot será inicializado com o WAR deployed.
Então, basta acessar a seguinte URL para testar:

<http://localhost:8080>

O CRUD dos usuários, itens e carrinho pode ser feito pelo menú no topo
da página!

**Separação de Backend e FrontEnd**

Podemos rodar o projeto do carrinho de compras em dois servidores (ou
portas): o frontend em um endpoint (url) e o backend em outro. A
separação de backend/frontend tem várias vantagens principalmente quando
se pensa em containerização (serviços).

**Iniciar o Backend standalone**

Para iniciar o backend, basta acessar a pasta backend do projeto e
executar o comando maven:

*mvn spring-boot:run*

Este comando rodará a aplicação backend.

**Iniciar o Frontend**

Para o frontend foi criado um arquivo dockerfile contendo as informações
necessárias para gerar um container com a aplicação feita em Angular e
rodando no Node.

Para criar a imagem do frontend, basta acessar a pasta carrinho-compras
no diretório frontend\\src\\main\\web\\carrinho-compras e executar o
comando para criação de imagem:

*docker build -f carrinho\_frontend.dockerfile -t
vanerjm/carrinho-frontend .*

onde carrinho\_frontend.dockerfile é o nome do arquivo, e
vanerjm/carrinho-frontend é o nome da tag escolhida. Pode ser alterada
para qualquer nome

Este comando fará o download de uma imagem do Node e copiará os do
frontend para dentro da pasta do Node.

Ao terminar, podemos verificar se a imagem criada está disponível
utilizando o comando:

*docker images*

Por fim, para executar a imagem gerada basta rodar o comando:

*docker run -d -p 4201:4200 vanerjm/carrinho-frontend*

Desta forma, um container na porta 4201 será criado com a imagem do
frontend.

Acessando o sistema
-------------------

Para acessar o sistema, basta acessar a url:

<http://localhost:4201>

Desta forma provamos que é possível que o backend esteja em um servidor,
o frontend em outro e o banco de dados em um outro.

### Outras URLs

A url acima é do frontend, onde o usuário irá interagir com o sistema.
Mas outras duas url estão disponíveis.

<http://localhost:8080> é a url do backend. É possível utilizá-la em
ferramentas como o Postman para enviar requisições para as interfaces
Rest expostas (CRUD dos modelos de dados), como por exemplo:

<http://localhost:8080/users> - Read (GET) dos usuários.

[http://localhost:8080/users/\<id\>](http://localhost:8080/users/<id>) -
Delete (DELETE) de um usuário.

Ainda existe a url do MongoDB, que pode ser utilizada em ferramentas
para exibição dos dados armazenados:

mongodb://localhost:27017@carrinho-compras

Conclusão
---------

Com o prazo de somente 1 semana, consegui mostrar que tenho conhecimento
de várias tecnologias desde banco de dados até UI, passando por devops e
infraestrutura.

Pela falta de tempo e de uma equipe de auxilio, não foi possível fazer
User Interfaces bonitas e responsivas, com efeitos e validações. A
arquitetura dos modelos do banco de dados foi criada de forma simples e
a dockerização foi feita somente do frontend.

O projeto maven também poderia ser mais automatizado e o controle de
versão poderia ter uma estratégia de branches e tags.

Decidi por não focar em uma única tecnologia (como por exemplo em um
belo frontend) pois engenheiros sênior devem ser capazes de ver o
sistema como um todo e ter um amplo conhecimento de toda a arquitetura
(fullstack) e suas tecnologias.

Obrigado pela oportunidade.

Contato
-------

**Vaner José Magalhães**

+55 35 999-4-2518

vanerjm@gmail.com

Skype: vaner.magalhaes
