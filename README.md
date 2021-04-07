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

- 9. Criando objetos Fábrica (Factory)

- Criar classe ProductManager que será responsável por criar instâncias de Product;
- Criar um método para criar um objeto Drink;
- Criar um método para criar um objeto Food.
- Modificar os construtores de Food, Product de public para *default*;
- Refatorar a criação de objetos em Shop.