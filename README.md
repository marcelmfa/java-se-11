# java-se-11

Exercícios para certificação Java 11

## Problema

Criar projeto para simular uma compra de produtos. Serão criadas *branches* de solução para cada subseção a seguir.

### 5. Tornar objetos Product *immutable* (imutáveis)

- Remover métodos **set** das propriedades de Product;
- Criar método **applyRating** para criar um objeto clone de Product com o novo *rating* passado por parâmetro;
- Refatorar Shop e criar um novo objeto de Produtor a partir de um já criado com um novo rating.