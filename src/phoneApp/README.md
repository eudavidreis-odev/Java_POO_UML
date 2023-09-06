# Funcionalidade de Aparelho Telefônico

Esta funcionalidade do projeto é responsável por gerenciar chamadas telefônicas, incluindo fazer ligações, atender chamadas e iniciar correio de voz.

## Diagrama de Classes
Aqui temos a representação UML do projeto·

![Diagrama de Classes](https://raw.githubusercontent.com/EuDavidReis-ODev/Java_POO_UML/main/src/assets/Diagrama_de_classes-PhoneAppImg.png)


## Classes e Interfaces

### `Contact`

- A classe `Contact` representa os contatos telefônicos com seus atributos, como nome, número de telefone, etc.

### `Call` (Interface)

- A interface `Call` define as funcionalidades básicas de uma chamada telefônica, incluindo:
  - `start()`: Iniciar uma chamada.
  - `accept()`: Aceitar uma chamada.
  - `end()`: Encerrar uma chamada.

### `Callable`

- A classe `Callable` implementa a interface `Call` e mantém informações relevantes sobre a chamada, como contatos envolvidos, tipo de chamada (voz ou vídeo) e outros detalhes. Ela também fornece métodos para interagir com a chamada.

### `VoiceCall` e `VideoCall`

- As classes `VoiceCall` e `VideoCall` estendem a classe `Callable` e sobrescrevem os métodos para se adequar ao tipo específico de chamada (voz ou vídeo).

### `CallListener`

- A classe `CallListener` é responsável por receber e iniciar chamadas telefônicas. Ela também gerencia chamadas ativas e mensagens da caixa postal.

### `PhoneApp`

- A classe `PhoneApp` atua como o controlador principal de todas as funções do telefone, usando principalmente o `CallListener`. Ela também mantém o histórico de chamadas e a lista de contatos.

#### Para mais detalhes, confira o Java DOC do projeto.
