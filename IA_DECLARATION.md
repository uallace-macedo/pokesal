<div>
  <h3>Pergunta 1:</h3>
  <code>

    boa pai! como vc ta?
    # Classe BATALHA

    HP: 300 a 500
    ATK: 30 e 50
    DEF: 30 a 50
    SPD: 15 a 150

    A classe batalha será responsável por:

    - Gerenciar:
        - turnos
        - ambiente
        - efeitos
        - uso de itens
        - status do pokesal

    - Abstrair:
        - `Treinador.Pokesal` -> `PokeDeBatalha`
        - mochila


    ## Definição de atributo das classes

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
    }
    ```

    ```java
    class Ambiente {
      private String nome;
      private TipoElemento tipoElemento;

      private double aumentaAtk;
      private double aumentaDef;
      private double aumentaSpd;
    }
    ```

    ## Sobre o ambiente

    Ao iniciar uma batalha:
    - Um ambiente deverá ser escolhido de forma randômica
    - Pokesal deverá ser abstraido para PokeDeBatalha
    - Os atributos de habilidades do PokeDeBatalha devem ser atualizados com base no ambiente
    - A classe deverá ter uma função para mostrar qual pokesal atacará primeiro

    ## Sobre o uso de itens

    A classe Item vai precisar de um método `.utilizar(PokeDeBatalha pdb)` para atualizar os status do pokesal

    A classe Batalha deverá conter 2 atributos para gerenciar os itens utilizados por cada treinador

    ## PokeDeBatalha

    A classe PokeDeBatalha deve ter um método de ataque:
    `.atacar(PokeDeBatalha atacante, PokeDeBatalha defensor)`

    que vai verificar questões como super efetivo, etc., e modificar os atributos do PokeDeBatalha

    consegue organizar pra mim esse .md?
    
  </code>

  <h3>Resposta 1:</h3>
  <code>
  
    Fala, meu querido! Tô suave por aqui, pronto pra rodar aquele par de olhos extra no código.Dei uma geral no seu Markdown para organizar a estrutura, ajustar a sintaxe dos blocos de código Java e deixar as regras de negócio bem nítidas.Aqui está o .md limpo e estruturado:
    
    # Classe Batalha

    ## Faixas de Atributos do PokeDeBatalha

    * **HP:** $300 \text{ a } 500$
    * **ATK:** $30 \text{ a } 50$
    * **DEF:** $30 \text{ a } 50$
    * **SPD:** $15 \text{ a } 150$

    ---

    ## Responsabilidades da Classe

    ### Gerenciamento
    * Turnos de combate
    * Condições do ambiente
    * Aplicação de efeitos
    * Uso de itens
    * Status gerais do Pokesal

    ### Abstração
    * Mapeamento de `Treinador.Pokesal` para `PokeDeBatalha`
    * Gerenciamento e acesso à mochila do treinador

    ---

    ## Definição das Classes

    ### `PokeDeBatalha`

    ```java
    public class PokeDeBatalha {
        private Treinador treinador;
        private String nome;
        private int hp;
        private int atk;
        private int spd;
        private int def;
        private Habilidade[] habilidades;
        private TipoElemento tipoElemento;
        private EfeitoAtk efeitoAtk; // Pode ser um EfeitoAtk ou null
    }
    ```

    ### `Ambiente`

    ```java
    public class Ambiente {
        private String nome;
        private TipoElemento tipoElemento;

        private double aumentaAtk;
        private double aumentaDef;
        private double aumentaSpd;
    }
    ```

    ---

    ## Regras de Negócio

    ### 1. Inicialização da Batalha
    * **Ambiente:** Selecionado de forma aleatória no início da batalha.
    * **Abstração:** Converte os objetos `Pokesal` para `PokeDeBatalha`.
    * **Modificadores:** Atualiza as habilidades do `PokeDeBatalha` com base nas condições do `Ambiente`.
    * **Iniciativa:** A classe deve conter um método para verificar e exibir qual `PokeDeBatalha` atacará primeiro (comparando a `SPD`).

    ### 2. Mecânica de Ataque
    A classe `PokeDeBatalha` deve possuir o método de ataque com a seguinte assinatura:

    ```java
    public void atacar(PokeDeBatalha atacante, PokeDeBatalha defensor)
    ```

    **Responsabilidades do método:**
    * Verificar fraquezas e vantagens de tipo (mecanismo de *super efetivo*, etc.).
    * Calcular o dano resultante com base no ataque do atacante e na defesa do defensor.
    * Modificar os status (HP, efeitos, etc.) do `PokeDeBatalha` defensor.

    ### 3. Uso de Itens
    * A classe `Item` precisa do método `utilizar(PokeDeBatalha pdb)` para atualizar os status do Pokesal afetado.
    * A classe `Batalha` deve conter 2 atributos específicos para gerenciar e controlar os itens utilizados por cada um dos treinadores.
  </code>
</div>

<hr />

<div>
  <h3>Pergunta 2:</h3>
  <code>

    package com.pokesal;

    import java.util.ArrayList;

    public class Treinador {

        private String treinadorNome;
        private Pokesal pokesal;
        private ArrayList <Item> mochila;
        private int itensUsados;

        public (String treinadorNome, Pokesal pokesal, ArrayList<Item> mochila){
            this.treinadorNome = treinadorNome;
            this.pokesal = pokesal;
            this.mochila = mochila;
            this.itensUsados = 0;

        }

      public int getItensUsados(){
        return itensUsados;
      }

      public boolean podeUsarIten(){
        return itensUsados <= 2;
      }

      public void usarItem(Item item){
        if(!podeUsarIten()){
            System.err.println("Erro");
        } else{
            itensUsados++;
            mochila.remove(item);
        }
      }
        

        public String getNome(){
            return Treinadornome;
        }

        public void setNome(String Treinadornome){
            this.Treinadornome = Treinadornome
        }

        public Pokesal getPokesal (){
            return pokesal;
        }

        public void setPokesal (Pokesal pokesal){
            this.pokesal = pokesal;
        }

        public ArrayList<Item> getMochila(){
            return mochila;
        }

        public void setMochila(ArrayList<Item> mochila){
            this.mochila = mochila;
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "Treinador{" +
                    "nome do treinador='" + treinadorNomenome + '\'' +
                    ", pokesal='" + pokesal + '\'' +
                    ", mochila=" + mochila +
                    ", itensUsados=" + itensUsados +
                    '}';
        }

    }

    está correto? Ou pode melhorar (sem mudar muito)?
    Encontrando variáveis inexistentes e erros de digitação nos métodos.
    Tem alguns erros que não compilam e um bug de lógica importante. Vou listar cada um antes de mostrar a correção.

  </code>

  <h3>Resposta 2:</h3>
  <code>

    Erros que impedem a compilação
    Construtor sem nome da classe — public (String treinadorNome, ...) precisa se chamar Treinador, senão o Java não reconhece como construtor.
    getNome() usa uma variável que não existe — return Treinadornome; (com T maiúsculo), mas o campo se chama treinadorNome (t minúsculo). Erro de compilação.
    setNome() tem dois problemas: atribui a this.Treinadornome (campo inexistente) e falta o ; no fim da linha.
    toString() usa treinadorNomenome — não existe essa variável em lugar nenhum, é um erro de digitação (junção de "treinadorNome" + "nome").
    Bug de lógica (compila, mas está errado)
    podeUsarIten() usa <= 2 em vez de < 2. Com isso, o treinador consegue usar 3 itens (0, 1 e 2 todos passam no <=2), não 2 como manda a regra.
    usarItem() não aplica mais o efeito do item no Pokesal — ele só remove da mochila e incrementa o contador, mas nunca cura HP, aumenta velocidade ou remove o status. O item é "gasto" sem fazer nada.
    Versão corrigida (mantendo sua estrutura)
    Executou 3 comandos, criou um arquivo, arquivos compartilhados
    O que mudei em relação ao seu código: corrigi os 4 erros de compilação (nome do construtor, as duas ocorrências de Treinadornome/treinadorNomenome, e o ; faltando), troquei <= 2 por < 2, e devolvi a aplicação do efeito do item no usarItem() — sem isso, o item não faz nada de útil ao ser usado. Também troquei o nome do método podeUsarIten para podeUsarItem (era só um erro de digitação, mas vale corrigir já que o nome errado pode confundir quem for ler o código na arguição).

    Mantive o System.err.println("Erro") como você tinha, mas vale saber o trade-off: quem chamar usarItem() de outro lugar do código não tem como saber que o item não foi usado — não tem exceção, não tem valor de retorno, só uma mensagem no console. Se algum dia vocês quiserem que o código "perceba" a falha (por exemplo, pra não deixar o sistema tentar usar o item mesmo assim), aí sim valeria voltar pra uma exceção como tínhamos antes.

    package com.pokesal;

    import java.util.ArrayList;

    public class Treinador {

        private String treinadorNome;
        private Pokesal pokesal;
        private ArrayList<Item> mochila;
        private int itensUsados;

        public Treinador(String treinadorNome, Pokesal pokesal, ArrayList<Item> mochila) {
            this.treinadorNome = treinadorNome;
            this.pokesal = pokesal;
            this.mochila = mochila;
            this.itensUsados = 0;
        }

        public int getItensUsados() {
            return itensUsados;
        }

        public boolean podeUsarItem() {
            return itensUsados < 2;
        }

        public void usarItem(Item item) {
            if (!podeUsarItem()) {
                System.err.println("Erro");
            } else {
                pokesal.setHp(pokesal.getHp() + item.getAdicionaHP());
                pokesal.setVelocidade(pokesal.getVelocidade() + item.getAumentaSpeed());
                if (item.isRemoveEfeito()) {
                    pokesal.setEfeitoAtivo(null);
                }
                itensUsados++;
                mochila.remove(item);
            }
        }

        public String getNome() {
            return treinadorNome;
        }

        public void setNome(String treinadorNome) {
            this.treinadorNome = treinadorNome;
        }

        public Pokesal getPokesal() {
            return pokesal;
        }

        public void setPokesal(Pokesal pokesal) {
            this.pokesal = pokesal;
        }

        public ArrayList<Item> getMochila() {
            return mochila;
        }

        public void setMochila(ArrayList<Item> mochila) {
            this.mochila = mochila;
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "Treinador{" +
                    "nome do treinador='" + treinadorNome + '\'' +
                    ", pokesal='" + pokesal + '\'' +
                    ", mochila=" + mochila +
                    ", itensUsados=" + itensUsados +
                    '}';
        }
    }
  
  </code>
</div>

<hr />

<div>
  <h3>Pergunta 3:</h3>
  <code></code>

  <h3>Resposta 3:</h3>
  <code></code>
</div>

<hr/>