# Bot adversário

A ideia é que o computador jogue normalmente sem que pareça que está clicando em botões aleatórios

## Decisões principais

`escolherAcao(...)`
- precisa curar?
- precisa remover efeito?
- vale usar aumento de velocidade?
- qual ataque vai causar mais dano?

## Principais "pensamentos"

1. HP está muito baixo?
   - SIM: curar
   - NÃO: verifica 2  
2. Tem feito ativo relevante?
   - SIM: remover efeito
   - NÃO: verifica 3
3. Está mais lento que o inimigo?
   - SIM: aumento de velocidade
   - NÃO: escolher ataque

## O Bot deve levar em consideração para cada ataque:

- tipo
- ambiente
- ataque
- defesa
- dano da habilidade
- efeito da habilidade
- não escolher sempre o maior dano

## Uso de itens

Não deve ser obrigatório sempre usar itens
Exemplo:

Caso haja efeito ativo com muita duração, pode valer a pena remover. Caso contrário, pode valer mais a pena atacar
