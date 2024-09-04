# Stock-Control
# Sistema de Controle de Estoque

Este projeto é um sistema de controle de estoque implementado em Java, que permite gerenciar produtos através de um conjunto de funções e procedimentos. Abaixo, você encontrará uma descrição detalhada de cada função e método utilizado no sistema.

## Estrutura do Sistema

O sistema armazena informações sobre os produtos em uma matriz de Strings chamada `matriz`, composta por 10 linhas e 4 colunas:

- **Coluna 0**: Código do Produto
- **Coluna 1**: Descrição do Produto
- **Coluna 2**: Quantidade em Estoque
- **Coluna 3**: Preço do Produto

## Funções e Procedimentos

### 1. `cadastrarProduto`

**Descrição**: Esta função é responsável por cadastrar novos produtos na matriz de estoque. Ela verifica se o código do produto já existe e se há espaço disponível na matriz para o cadastro.

**Retorno**:
- `1`: Se o produto foi cadastrado com sucesso.
- `0`: Se o produto já está cadastrado no sistema.
- `-1`: Se não há mais espaço disponível na matriz.

### 2. `excluirProduto`

**Descrição**: Esta função permite excluir um produto do sistema, liberando a linha correspondente na matriz para futuros cadastros.

**Retorno**:
- `1`: Se o produto foi excluído com sucesso.
- `-1`: Se o produto não está cadastrado no sistema.

### 3. `venderProdutos`

**Descrição**: Esta função gerencia a venda de produtos, descontando a quantidade vendida do estoque e lidando com diferentes casos como falta de estoque, produto não cadastrado, ou quantidade inválida.

**Retorno**:
- `1`: Se a venda foi realizada com sucesso.
- `-1`: Se não há estoque suficiente.
- `-2`: Se o produto não está cadastrado.
- `-3`: Se a quantidade vendida é inválida (zero ou negativa).

### 4. `imprimirProdutos`

**Descrição**: Este procedimento exibe todos os produtos cadastrados na matriz, mostrando o código, descrição, quantidade e preço de cada um.


### 5. `imprimirMensagem`

**Descrição**: Esta função imprime mensagens de sucesso ou erro com base na operação realizada (cadastrar, excluir, vender) e no resultado da operação.


## Fluxo do Programa

O programa principal (`main`) apresenta um menu para o usuário escolher entre as opções de cadastrar, excluir, imprimir ou vender produtos. Com base na escolha, a função ou procedimento correspondente é chamado.

## Como Executar o Programa

1. Compile o código:
    ```bash
    javac Estoque.java
    ```

2. Execute o programa:
    ```bash
    java Estoque
    ```

3. Siga as instruções do menu para interagir com o sistema.

## Conclusão

Este sistema de controle de estoque é um exemplo de aplicação de conceitos básicos de programação em Java, como manipulação de matrizes, estruturas de controle, e operações com Strings. Ele pode ser expandido para incluir mais funcionalidades conforme necessário.

## Autor

Douglas Schneider da Silva

