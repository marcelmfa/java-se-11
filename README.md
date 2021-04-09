# java-se-11

Exercícios para certificação Java 11

## Problema

Criar projeto para simular uma compra de produtos. Serão criadas *branches* de solução para cada subseção a seguir.

### 14. Organizar Produtos e Review em um HashMap

- Refatorar ProductManager: 
  - Remover as variáveis **product** e **reviews**;
  - Criar uma variável **products** do tipo *HashMap* que irá conter o Product e seus Review's associados;
  - Refatorar demais métodos impactados com esta mudança, mas mantendo as mesmas funcionalidades;
  - Refatorar o **printProductReport** informando o produto que deseja ter o relatório.