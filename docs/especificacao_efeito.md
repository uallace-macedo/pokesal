# Implementação da feature de Efeito dos ataques

As habilidades podem aplicar efeitos temporários ao pokesal adversário alterando seus atributos/causando dano durante X rodadas.

## Tasks

Sequencia de tasks para chegar ao resultado desejado

### 1. Fazer efeito ser aplicado ao pokesal

- Adicionar/usar método como `aplicarEfeito(EfeitoAtk efeito)` em `PokeDeBatalha`
- No fluxo do ataque, verificar se a habilidade possui um efeito e aplicar ao alvo
- Implementar chance de ativação do efeito (deve acontecer durante o ataque)
- Não implementar ainda consequências do efeito, só garantir que o `EfeitoAtk` do Pokesal adversário deixou de ser `null`

**IMPORTANTE:** o `EfeitoAtk` que esta em `Habilidade` não deve ter seu estado alterado, pois as habilidade são reutilizadas entre os pokesal.

Por isso, o `PokeDeBatalha` não deverá mais armazenar o `EfeitoAtk` como estado do efeito ativo e sim uma nova instância de `EfeitoAtivo` que será responsável por representar o efeito aplicado ao Pokesal

Exemplo:
```text
Habilidade
- EfeitoAtk
- - rodadas = 3

PokeDeBatalha
- EfeitoAtivo
- - rodadasRestantes = 3
```

### 2. Fazer o efeito modificar velocidade/defesa

Os valores `redSpeed` e `redDef` devem afetar os atributos do pokesal enquanto o efeito estiver ativo.

**IMPORTANTE:** não alterar os atributos base do `PokeDeBatalha` e sim a `velocidadeEfetiva`

Exemplo:
```bash
Velocidade/Defesa base = 60
Efeito: redSpeed/redVelocidade = 10

Velocidade/Defesa efetiva = 50
```

Basta seguir a mesma lógica usada para o bônus de `Ambiente` calculando valores "efetivos" sem modificar o original

### 3. Implementar duração e dano periódico

O efeito deve permanecer ativo durante a quantiadde de rodadas definida em `EfeitoAtivo.rodadasRestantes`

Exemplo:
```
dano = 5
rodadasRestantes = 3

Rodada 1 -> -5 HP
Rodada 2 -> -5 HP
Rodada 3 -> -5 HP
```

O `Item.SegundaChamada` deve remover o `EfeitoAtivo`.
