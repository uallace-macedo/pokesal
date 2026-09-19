# Classe BATALHA

## Faixas de Atributos do PokeDeBatalha

- **`HP`**: 300 a 500
- **`ATK`**: 30 e 50
- **`DEF`**: 30 a 50
- **`SPD`**: 15 a 150

## Responsabilidade da Classe

### Gerenciamento
- Turnos de combate
- Condições do ambiente
- Aplicação de efeitos
- Uso de itens
- Status gerais do Pokesal

### Abstração
- Mapeamento de `Treinador.Pokesal` para `PokeDeBatalha`
- Gerenciamento e acesso à mochila do treinador


## Definição de classes

### `PokeDeBatalha`
```java
class PokeDeBatalha {
  private Treinador treinador;
  private String nome;
  private int HP;
  private int Atk;
  private int Spd;
  private int Def;
  private Habilidades[] habilidades = [];

  private TipoElemento tipoElemento;
  private EfeitoAtk = null; // Pode ser EfeitoAtk ou nulo

  public void atacar(PokeDeBatalha alvo) {
    // verifica super efetivo e afins
    // calculo de dano e altera status do alvo
  }
}
```

### `Ambiente`
```java
class Ambiente {
  private String nome;
  private TipoElemento tipoElemento;

  private double aumentaAtk;
  private double aumentaDef;
  private double aumentaSpd;
}
```

## Regras de negócio e fluxos

### 1. Inicialização da Batalha
- **Ambiente**: Selecionado de forma aleatória no início da batalha.
- **Abstração**: Converte os objetos `Pokesal` para `PokeDeBatalha`.
- **Modificadores**: Atualiza os atributos/habilidades dos `PokeDeBatalha` com base nas condições do `Ambiente`.
- **Iniciativa**: A classe deve conter um método dedicado para calcular e exibir qual PokeDeBatalha atacará primeiro (baseado em spd).
    - Caso o spd seja igual entre o Treinador e o computador, a pessoa deve ser favorecida.


### 2. Mecânica de ataque

A classe `PokeDeBatalha` deve possuir o método de ataque com a seguinte assinatura:

```java
public void atacar(PokeDeBatalha alvo)
```

**Responsabilidades do método**
- Verificar fraquezas e vantagens (super efetivo, etc).
- Calcular dano total com base no ataque e defesa do alvo.
- Modificar os status do `PokeDeBatalha` alvo

### 3. Uso de itens

- A classe `Item` deve possuir o método `.utilizar(PokeDeBatalha pdb)` para aplicar modificações diretamente nos status do Pokesal.
- A classe `Batalha` deve manter 2 atributos específicos para gerenciar o histórico/quantidade de itens utilizados por cada treinador.