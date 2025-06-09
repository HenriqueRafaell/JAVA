# Guardião Verde

## Visão Geral

O projeto **Guardião Verde** é uma solução desenvolvida como parte da Global Solution 2025, com o objetivo de monitorar, registrar e auxiliar na resposta a focos de queimadas em áreas de risco. Ele fornece uma API RESTful construída com Java 17 e Spring Boot, permitindo que moradores registrem ocorrências, agentes ambientais gerenciem alertas, e que sejam gerados relatórios úteis para prevenção e combate.

## Motivação

Com o aumento da frequência de queimadas devido a fatores climáticos e humanos, comunidades precisam de ferramentas acessíveis para reportar ocorrências e receber apoio rápido. Este sistema busca empoderar moradores e otimizar a atuação dos agentes ambientais, integrando dados de localização e status das ocorrências.

## Arquitetura

O projeto é estruturado seguindo princípios de **Domain Driven Design** e **boas práticas de arquitetura em camadas**, contendo:

- **Controller:** Interface REST que expõe os endpoints.
- **Service:** Camada intermediária com a lógica de negócio.
- **Repository:** Interface com o banco de dados via Spring Data JPA.
- **Domain:** Classes de entidade e DTOs que representam o modelo de negócio.
- **Security:** Configuração de autenticação e controle de acesso com Spring Security.

### Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- H2 Database (desenvolvimento)
- Maven

## Classes de Domínio

O sistema é composto pelas seguintes entidades principais:

- **Usuario:** Representa um morador ou agente ambiental.
- **Ocorrencia:** Registro de um foco de queimada.
- **Alerta:** Notificação gerada para agentes após validação.
- **Relatorio:** Resumo periódico das ocorrências e respostas.
- **Localizacao:** Informações geográficas associadas à ocorrência.
- **TipoUsuario:** Enumeração para diferenciar moradores e agentes.

## Padrões de Projeto Aplicados

- **DTO (Data Transfer Object):** Separação entre entidades de negócio e objetos de entrada/saída da API, melhorando a segurança e organização.
- **Repository Pattern:** Implementado via Spring Data JPA, facilita a abstração da camada de persistência.
- **Singleton (implícito no contexto do Spring):** Componentes `@Service` e `@Controller` são gerenciados como singletons pelo container do Spring.

Esses padrões promovem maior desacoplamento, reuso e clareza no código.

## Endpoints Principais

### Autenticação
- `POST /auth/login` - Realiza login com credenciais válidas.

### Usuário
- `POST /usuarios` - Cadastra novo usuário.
- `GET /usuarios/{id}` - Consulta um usuário.

### Ocorrência
- `POST /ocorrencias` - Registra nova ocorrência.
- `GET /ocorrencias` - Lista todas as ocorrências.
- `PUT /ocorrencias/{id}` - Atualiza status ou detalhes.

### Alerta
- `GET /alertas` - Lista alertas ativos.
- `POST /alertas` - Cria novo alerta após validação.

### Relatório
- `GET /relatorios/semana` - Gera relatório semanal.

## Como Executar

1. Clone o repositório:

2. Compile e execute:

3. Acesse a API:
- Base URL: `http://localhost:8080`

4. H2 Console (para testes locais):
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`

## Conclusão

Este projeto simula um cenário real de resposta a queimadas, promovendo cidadania ativa e uso de tecnologia de forma estratégica. Pode ser expandido futuramente com:
- Notificações em tempo real
- Integração com sensores IoT
- Interface web ou mobile

