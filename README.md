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