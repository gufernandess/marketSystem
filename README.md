## 1. DESCRIÇÃO INICIAL
### 1.1 Contexto (Caracterização do produto)
<p align="justify"> O sistema de Gestão de Mercantil tem a proposta de auxiliar determinado estabelecimento em suas principais atividades do dia-a-dia, como a <b>venda de produtos para seus clientes</b>, por exemplo. Fora de ações mais primárias do cotidiano, o sistema também será capaz de lidar com <b>gestão de estoque e controle de funcionários da empresa</b>, além de lidar com a <b>gestão financeira do mercantil</b>, registrando todas as transações de venda e criando relatórios periódicos com os dados registrados. </p>

<p align="justify"> O sistema terá funcionalidades específicas para dois tipos de usuários: <b>Gerente e Funcionário Comum</b>. As funcionalidades reservadas para o primeiro seriam mais atreladas a gestão financeira e de funcionários, enquanto o segundo teria acesso a funcionalidades relacionadas a compra e venda de produtos. </p>

## 2. REQUISITOS DO SISTEMA
### 2.1 Cadastro e login
- Cadastrar(como gerente ou funcionário comum);
- Logar(como gerente ou funcionário comum).

## 2.2 Venda de produtos
- Vender produtos;
- Controlar estoque do mercado(CRUD do produto);
- Registrar vendas(Feito no relatório);
- Produzir nota fiscal.

## 2.3 Gestão Financeira
- Gerar relatório de finanças com opção de filtro;

## 2.4 Gestão de Funcionários
- CRUD do funcionário;

## 3. ENTIDADES
- Funcionário -> Gerente e Funcionário Comum;
- Cliente;
- Pedido; 
- Conta; 
- Produto;
- Item;
- Estoque;
- Relatório;
- Nota Fiscal;
- Lista -> Contas e funcionários.

## Diagrama de classe
O diagrama de classe pode ser acessado <a href="https://raw.githubusercontent.com/gufernandess/marketSystem/main/assets/Main.png" target="_blank">aqui.</a>
