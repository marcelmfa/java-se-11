# java-se-11

Exercícios para certificação Java 11

## Problema

Criar projeto para simular uma compra de produtos. Serão criadas *branches* de solução para cada subseção a seguir.

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