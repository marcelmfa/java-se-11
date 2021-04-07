# java-se-11

Exercícios para certificação Java 11

## Problema

Criar projeto para simular uma compra de produtos. Serão criadas *branches* de solução para cada subseção a seguir.

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