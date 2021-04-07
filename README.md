# java-se-11

Exercícios para certificação Java 11

## Problema

Criar projeto para simular uma compra de produtos. Serão criadas *branches* de solução para cada subseção a seguir.

### 7. Sobrescrevendo (override) métodos e polimorfismo (polymorphism)

- Sobrescrever método toString em Product e Food;
- Refatorar Shop pra imprimir o objeto em si ao invés de construir uma String;
- Sobrescrever métodos equals e hashcode em Product baseado no id;
- Sobrescrever método **getDiscount**:
  - Em Drink para retornar o desconto da super classe caso seja horário de *happy-hour* (17:30 - 18:30), caso contrário zero;
  - Em Food para retornar o desconto da super classe caso esteja no dia da data de validade ou após, caso contrário zero;
- Sobrescrever método **applyRating** para criar clones dos objetos Food e Drink;
- (Opcional) Refatorar Shop e criar novos objetos Food e Drink e averiguar o uso do polimorfismo.