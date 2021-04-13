# java-se-11

Exercícios para certificação Java 11

## Problema

Criar projeto para simular uma compra de produtos. Serão criadas *branches* de solução para cada subseção a seguir.

### 1. Criar classes inciais

- Criar uma classe para representar um Produto (Product) com as seguintes propriedades: identificador, nome e preço e seus respectivos métodos **get** e **set**;
- Criar uma classe para representar um compra (Shop) onde serão criados vários objetos de Produto.

### 2. Ajustar classe Produto

- Em Produto:
  - ajustar as parametros dos métodos **set** para *final*, evitando uma manipulação indevida ou acidental do valor passado como parâmetro;
  - incluir valor constante para desconto do produto;
  - criar método **getDiscount** para retornar o preço do produto após aplicado o desconto.
- Em Shop:
  - criar um Produto e imprimir o preço e o valor após o desconto aplicado.

### 3. Ter avaliação para um produto

- Criar enumeração que represente a avaliação (Rating) de um produto;
  - Usar unicodes "\u2605" para estrela cheia e "\u2606" para estrela vazia;
  - Criar método **get** para obter a quantidade de estrelas que representa aquela avaliação;
- Criar uma propriedade avaliação (rating) que seja a avaliação do produto e o método **get** associado.

### 4. Criar construtores *customizados*

- Criar construtor de Product com todas as propriedades;
- Criar construtor de Product com todas as propriedades, exceto rating, e referenciando o construtor anterior;
- (Opcional) Alterar import's de enumerações para import static;
- Refatorar Shop para construir corretamente os objetos do tipo Product;
- (Opcional) Criar vários objetos Product e imprimir os valores de duas propriedades.

### 5. Tornar objetos Product *immutable* (imutáveis)

- Remover métodos **set** das propriedades de Product;
- Criar método **applyRating** para criar um objeto clone de Product com o novo *rating* passado por parâmetro;
- Refatorar Shop e criar um novo objeto de Produtor a partir de um já criado com um novo rating.

### 6. Especializações de Produto

- Criar classe Drink extendendo de Product;
  - Incluir propriedade data de valida (**bestBefore**) e o respectivo método **get**;
  - Criar construtor com todas as propriedades;
- Criar classe Food extendendo de Product;
  - Criar construtor com todas as propriedades;
- Criar objetos Food e Drink em Shop.

### 7. Sobrescrevendo (override) métodos e polimorfismo (polymorphism)

- Sobrescrever método toString em Product e Food;
- Refatorar Shop pra imprimir o objeto em si ao invés de construir uma String;
- Sobrescrever métodos equals e hashcode em Product baseado no id;
- Sobrescrever método **getDiscount**:
  - Em Drink para retornar o desconto da super classe caso seja horário de *happy-hour* (17:30 - 18:30), caso contrário zero;
  - Em Food para retornar o desconto da super classe caso esteja no dia da data de validade ou após, caso contrário zero;
- Sobrescrever método **applyRating** para criar clones dos objetos Food e Drink;
- (Opcional) Refatorar Shop e criar novos objetos Food e Drink e averiguar o uso do polimorfismo.

### 8. Classes abstratas e métodos abstratos

- Tornar Product uma classe abstrata;
- Tornar o método **applyRating** abstrato;
- Realizar as devidas correções;
- Criar método **getBestBefore** em Product e retornando data corrente;
- (Opcional) Criar mais objetos Drink e Product.

### 9. Criando objetos Fábrica (Factory)

- Criar classe ProductManager que será responsável por criar instâncias de Product;
- Criar um método para criar um objeto Drink;
- Criar um método para criar um objeto Food.
- Modificar os construtores de Food, Product e Drink de public para *default*;
- Refatorar a criação de objetos em Shop.

### 10. Desenhando Interfaces e refatorando o código

- Criar uma interface genérica Avaliavel (Rateable);
  - Criar constante para avaliação padrão (default rating) com valor não avaliado (NOT_RATED) da enumeração;
  - Criar método **applyRating** tendo Rating como parâmetro retornando o tipo genérico;
  - Criar método default - isto é, com implementação - **getRating** retornando o valor da avaliação padrão;
  - Criar método estático **convert** para obter uma enumeração a partir do número de estrelas informado;
  - Criar método default **applyRating** passando o número de estrelas de avaliação;
  - (Opcional) Colocar a anotação FunctionalInterface;
- Fazer a classe Product implementar Rateable;
  - (Opcional) Remover códigos desnecessários que já estão em Rateable.

### 11. Habilitando resenha de produtos e avaliação

- Criar classe Resenha (Review) com os atributos Review e comentários (comments) assim como seus respectivos *getters* e *setters*;
- Criar arquivo de propriedades para mensagens customizadas com nome **resouces.properties** com as seguintes mensagens:
  - {0}, Price: {1}, Rating: {2}, Best Before: {3}
  - Review: {0}\t{1}
  - Not reviewed
- Refatorar ProductManager:
  - Manter estado de Product e Review;
  - Criar método para criação de Review;
  - Criar propriedades para Locale, ResourceBundle, DateTimeFormatter e NumberFormat;
  - Criar construtor com Locale como parametro e inicializar as propriedades acima;
  - Criar construtor vazio reutilizando o construtor anterior e passando o Locale *default*;
  - Criar método **printProductReport** para imprimir as mensagens customizadas;

### 12. Refatorar Shop (Opcional)

- Criar vários objetos ProductManagers com diferentes Locale;
- Criar vários objetos Product e Review's;
- Imprimir os relatórios (report) de cada ProductManager.

### 13. Permitindo múltiplas resenhas para um produto

- Modificar em ProductManager a propriedade **review** de objeto para array;
- Refatorar o método **reviewProduct** para incluir os reviews no array e com funcionalidade de autoscaling deste array;
- Refatorar para aplicar a média das avaliações como avaliação final em Product;
- Refatorar **printProductReport** já que é um array de Review's.

### 14. Organizar Produtos e Review em um HashMap

- Refatorar ProductManager: 
  - Remover as variáveis **product** e **reviews**;
  - Criar uma variável **products** do tipo *HashMap* que irá conter o Product e seus Review's associados;
  - Refatorar demais métodos impactados com esta mudança, mas mantendo as mesmas funcionalidades;
  - Refatorar o **printProductReport** informando o produto que deseja ter o relatório.

### 15. Implementação ordenação e busca

- Alterar Review para implementar a interface **Comparable**;
  - Implementar comparação considerando os ratings em ordem decrescente;
- Alterar **printProductReport** com os review's ordenados;
- Implementar método **findProduct** passando o id como parametro;
- Sobrecarregar os métodos **reviewProduct** e **printProductReport** passando o id de Product ao invés do objeto Product;
- Refatorar Shop passando os id's ao invés de objetos.

### 16. Encapsulando funcionalidades de formatação em classe aninhanda (nested class)

- Criar classe estática ResourceFormater dentro de ProductManager;
  - Mover de ProductManager as propriedades dos tipos **Locale**, **ResourceBundle**, **DateTimeFormatter** e **NumberFormat** para esta nova classe;
  - Criar um construtor semelhante ao de ProductManager;
  - Criar métodos para formatar as mensagens que antes que eram geradas em ProductManager;
- Em ProductManager:
  - Criar várias instâncias de classe de ResourceFormatter para vários **Locale**;
  - Criar variável para ResourceFormatter;
  - Criar método **changeLocale** permitindo alterar o objeto ResourceFormatter a partir do novo Locale informado;
  - Criar método **getSupportedLocales** retornando os Locale's suportados;
  - Recriar os construtores com parametros Locale e String e usando o método changeLocale para selecionar o ResourceFormatter adequado;
    - O parametro String é tag de linguagem (languageTag) que tem como convenção ser formada por idioma e país, como "pt-BR";
  - Refatorar método **printProductReport** para usar a classe nova;
- Refatorar Shop permitindo uso de unico ProductManager e modificando o Locale.

### 17. Relatórios customizados

- Criar método **printProducts** que recebe como parâmetro **Comparator<Product>**;
  - Usar o Comparator para ordenar a lista de produtos;
- Refatorar Shop para usar novo método de relatório customizado usando Lamba Expression.
  - (Opcional) Aglutinar multiplos Comparator's para obter a ordenação desejada.

### 18. Migrando de Loops para Streams

- Refatorar em ProductManager os métodos **findProduct**, **reviewProduct**, **printProductReport** e **printProducts**;
- (Opcional) Sobrecarregar método **printProducts** passando um **Predicate** além do **Comparator** para filtrar os produtos;
- (Opcional) Refatorar Shop usando o método acima.

### 19. Mais Streams (part 2)

- Criar método **getDiscounts** que irá agrupar os descontos por rating e somá-los;
- Refatorar Shop para usar o método criado.

### 20. Utilizando controle de exceções

- Criar exceção **ProductManagerException**;
- Refatorar **findProduct** para lançar a exceção acima caso o produto não seja encontrado;
- Tratar as excecões em **reviewProduct** e **printProductReport**;
- Criar uma variável de classe do tipo **Logger** para utilizar nos *catches*;
- (Opcional) Executar em Shop os método **reviewProduct** e **printProductReport** de ProductManager e verificar o comportamento.

### 21. Adicionando operações de *parsing* textual (Opcional)

- Criar novo arquivo de propriedades **config.properties** que desta vez não irá depender do *Locale* e com propriedades:
  - **product.data.format** com valor {0},{1},{2},{3},{4},{5}
  - **review.data.format** com valor {0},{1},{2}
- Criar variavel referenciando o novo **ResourceBundle**;
- Criar variaveis do tipo **MessageFormat** referenciando as mensagens;
- Criar o método **parseReview** tendo uma String como parâmetro, fazendo o parsing da mesma e reutilizando o outro método de **reviewProduct**;
- Realizar tratamento de exceção de **ParseException** exigido.

### 22. Adicionando mais funcionalidades de *parsing* textual (Opcional)

- Realizar tratamento de exceção em **parseReview** para **NumberFormatException**;
- Refatorar Shop e fazer vários *review's* via String;
- Criar funcionalidade semelhante para Product, isto é, criar método **parseProduct** com parametro String;
- Realizar tratamento de exceção considerando **ParseException**, **NumberFormatException** e **DateTimeParseException**;
- Refatorar Shop e criar vários produtos via String.