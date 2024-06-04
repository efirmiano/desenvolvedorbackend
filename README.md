# desenvolvedor Java BackEnd
1) Fazer o Download do arquivo desenvolvedorbackendjava-0.0.1-SNAPSHOT.jar
2) Abrir o prompt de comando
3) Navegar até a pasta onde foi salvo o programa "Ex: C:\user\Downloads"
4) Executar o seguinte comando "java -jar desenvolvedorbackendjava-0.0.1-SNAPSHOT.jar", minimizar o CMD
5) Abrir o Postman e realizar as requisições de POST/GET/UPDATE/DELETE conforme descrito a seguir:
	Cadastrar um novo beneficiario URL: http://localhost:8080/cadastrarbeneficiarios
	Atualizar beneficiario cadastrado URL: http: //localhost:8080/atualizarbeneficiarios
	Consultar beneficiario cadastrado URL: http://localhost:8080/buscarbeneficiarios
	Consultar documento cadastrado URL: http://localhost:8080/buscardocumento
	Deletar beneficiario cadastrado URL: http://localhost:8080/deletebeneficiarios
6) Para cadastrar um novo usuario precisa enviar(nome,telefone,dataNascimento,tipoDocumento e descricao)
7) Para atualizar um cadastro precisa enviar (id ,nome,telefone,dataNascimento)
8) Para Consultar um beneficiario cadastrado precisa enviar (id)
9) Para consultar o documento de um beneficiario cadastrado precisa enviar (id)	
10) Para Deletar um beneficiario precisa enviar (id)

Para qualquer duvida estou a disposição, segue junto algumas imagens para ilustrar o uso da aplicação com o Postman.

Ponto de atenção: Aplicação está parametrizada para receber form-data no corpo de requisições. Caso utilize Params vai apresentar erro.

