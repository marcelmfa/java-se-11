# java-se-11

Exercícios para certificação Java 11

## Problema

Criar projeto para simular uma compra de produtos. Serão criadas *branches* de solução para cada subseção a seguir.

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