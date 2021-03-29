# sistema-cadastro-animais
Este projeto é um sistema de cadastro de animais que utiliza uma API REST para realizar as operações CRUD.

### Começando
Para executar o projeto, serão necessárias as seguintes dependências:
* [JDK 8: Necessário para executar o projeto Java](https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html)
* [Maven 3.6.3: Necessário para realizar o build do projeto Java](https://maven.apache.org/download.cgi)
* [Eclipse para Java EE 2021-03: Para desenvolvimento do projeto](https://www.eclipse.org/downloads/packages/)
* [Lombok 1.18.18: Para desenvolvimento do projeto](https://projectlombok.org/download)

### Desenvolvimento
Para iniciar o desenvolvimento, é necessário clonar o projeto do GitHub num diretório de sua preferência:  
```shell
cd "diretorio de sua preferencia"  
git clone https://github.com/NatanLisboa/sistema-cadastro-animais.git
```
Para instalar o Lombok corretamente, basta seguir as instruções [deste site](https://dicasdejava.com.br/como-configurar-o-lombok-no-eclipse/#:~:text=6.,do%20seu%20pom.)
(EXCETO O PASSO 6, pois o Lombok já está adicionado como dependência no arquivo "pom.xml" do projeto).

### Construção
Para construir o projeto, basta executar o comando abaixo no diretório raiz (sistema-cadastro-animais) 
```shell
mvn install
````
O comando irá baixar todas as dependências do projeto e executar os testes unitários,
sendo que caso algum dos testes falhe, uma mensagem será exibida no console.  

### Configuração
Após a realização da etapa de construção, faz-se necessário  importar o projeto no Eclipse. Para tal, basta seguir o seguinte caminho
depois de abrir a IDE:  
```shell
File > Import > Maven > Existing Maven Projects > Browse > Selecionar o diretório raiz do projeto (sistema-cadastro-animais) > Finish
```
### Features
O projeto pode ser usado para simular a realização das operações de manipulação de uma base de dados de um sistema
de cadastro de animais, como criação, recuperação, atualização e deleção de dados.

### Testes
Para executar os testes, basta utilizar o comando abaixo no terminal:
```shell
 mvn test
```
Os testes também podem ser executados na IDE Eclipse. Basta abrir cada classe de teste e pressionar Alt+Shift+X e depois T para rodar os testes.  

### Links internos
Por padrão, a aplicação subirá na porta 8080 de localhost

Para execução da documentação interna dos métodos, basta acessar: http://localhost:8080/swagger-ui.html

Com relação aos links das operações de manipulação da base de dados, tem-se:
* GET http://localhost:8080: Exibe a tela de boas-vindas do sistema
* GET http://localhost:8080/animais: Exibe a tela com todos os animais cadastrados no banco de dados
* GET http://localhost:8080/animais/{id}: Exibe as informações de um animal em específico
* GET http://localhost:8080/animais?nome={nome}: Exibe as informações de um animal em específico, buscando pelo seu nome
* POST http://localhost:8080/animais: URI para cadastrar um animal no banco de dados do sistema
* PUT http://localhost:8080/animais/{id}: URI para atualizar os dados de um animal no banco de dados do sistema
* DELETE http://localhost:8080/animais/{id}: URI para deletar um animal no banco de dados do sistema

### Licença
MIT  

### Observações  
* O projeto pode demorar um pouco para começar a rodar
