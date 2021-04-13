# java-se-11

Exercícios para certificação Java 11

## Problema

Criar projeto para simular uma compra de produtos. Serão criadas *branches* de solução para cada subseção a seguir.

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