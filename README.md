# JAVA

# 🌱 Guardião Verde – Sistema de Alerta Comunitário contra Queimadas

O **Guardião Verde** é uma API RESTful desenvolvida em Java com Spring Boot, com o objetivo de facilitar o registro de focos de incêndio por moradores e permitir o acompanhamento e resposta por agentes ambientais. Essa solução promove a participação da comunidade na prevenção de queimadas e agiliza a resposta de autoridades.

---

## 📌 Problema

Moradores de zonas rurais ou áreas próximas de vegetação enfrentam dificuldades para comunicar focos de incêndio. Muitos incidentes não são registrados a tempo, o que atrasa a resposta dos agentes ambientais e amplia os danos ambientais e à saúde.

---

## 🎯 Objetivo

Criar um sistema leve e acessível, onde a população possa registrar focos de incêndio e os agentes ambientais possam validar e agir com base em alertas confiáveis, promovendo a resposta rápida e a geração de relatórios estratégicos.

---

## 👥 Público-Alvo

- Moradores de regiões propensas a queimadas
- Agentes ambientais responsáveis pela resposta aos incêndios
- Administradores do sistema para gestão dos usuários e dados

---

## 👩 Persona Exemplo

> **Maria do Carmo**, 58 anos, agricultora que vive em uma zona rural com os netos. Quer proteger sua plantação e a saúde das crianças, mas se sente impotente diante das queimadas. Deseja receber alertas e poder registrar problemas facilmente.

---

## 🧩 Funcionalidades

- Cadastro de moradores e agentes
- Registro de focos de incêndio com foto e localização
- Geração de alertas
- Acompanhamento de status de ocorrências
- Geração de relatórios semanais
- Autenticação de usuários
- Exportação de dados em CSV

---

## 🏗️ Arquitetura da Aplicação

- **Camadas**
  - `Controller`: Gerencia as requisições da API
  - `Service`: Contém a lógica de negócio
  - `Repository`: Acesso ao banco de dados
  - `Domain/Model`: Classes de entidade
- **Banco de Dados**: H2 (desenvolvimento) / PostgreSQL (produção)
- **Segurança**: Spring Security (login com JWT opcional)
- **Documentação da API**: Swagger (via Springdoc/OpenAPI)

---

## 📚 Requisitos

- Java 17+
- Spring Boot 3.x
- Maven ou Gradle
- IDE (IntelliJ / VSCode / Eclipse)
- Docker (opcional)
- Postman (para testes de API)

---

## 🔐 Requisitos Funcionais

- RF01: Registrar ocorrência de foco de incêndio
- RF02: Emitir alerta para agentes ambientais
- RF03: Gerar relatórios estatísticos
- RF04: Consultar histórico de ocorrências
- RF05: Cadastrar usuários (moradores e agentes)
- RF06: Autenticar usuários
- RF07: Acompanhar status da ocorrência

---

## 🛡️ Requisitos Não-Funcionais

- Interface responsiva e simples (caso frontend seja implementado)
- Alta disponibilidade e baixo tempo de resposta
- Segurança dos dados
- Suporte mobile
- Backup semanal automático

---

## 📊 Regras de Negócio

- Cada morador pode registrar até **3 ocorrências por dia**
- Uma ocorrência só gera alerta após validação por agente
- Apenas agentes podem **encerrar** ocorrências
- Alertas expiram após **48 horas**
- Ocorrências inativas por **7 dias** são arquivadas
- Agentes são vinculados a **regiões específicas**

---

## 🔄 Endpoints RESTful (exemplo)

| Método | Endpoint                   | Descrição                          |
|--------|----------------------------|------------------------------------|
| POST   | `/api/ocorrencias`         | Registrar novo foco                |
| GET    | `/api/ocorrencias`         | Listar todas as ocorrências        |
| PUT    | `/api/ocorrencias/{id}`    | Atualizar status (agente)          |
| GET    | `/api/relatorios/semanais` | Gerar relatório semanal            |
| POST   | `/api/auth/login`          | Login de usuário                   |
| POST   | `/api/usuarios`            | Cadastro de morador ou agente      |

---

## 📦 Estrutura de Pacotes Sugerida

