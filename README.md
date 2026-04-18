# modularizacao
Este repositório é destinado a solucionar um exercício da máteria de linguagem de programação II.

Buscamos separar as etapas da melhor maneira possível. Para isso, ValidateArguments.java verifica se
cada linha do arquivo está com parâmetros escritos corretamente. Se tiver algo diferente de "KEY", "METHOD"
ou "DATA", ele lança uma criptografiaException indicando formato inválido. Se tudo tiver correto, a 
RunningOptions guarda os três itens necessários para o programa funcionar.

Fora isso, a Criptografia.java, intuitivamente, faz as operações de codificar e decodificar. 
Por fim, para fins de organização, criamos uma Render.java para exibir um diagnóstico 
geral da entrada e saída dos dados.

Na Main.java, você pode alterar o arquivo lido a vontade para qualquer um dos *.txt que estão 
na pasta "arquivos", basta modificar o caminho dentro do método "ler" do objeto "leitor".
Exemplo:
... new ValidateArguments(leitor.ler("arquivos/nome_do_arquivo.txt"));

Como compilar e ver a mágica acontecer: 
❯ javac Main/Main.java leitor/*.java criptografia/**/*.java Exception/*.java
❯ java Main.Main


