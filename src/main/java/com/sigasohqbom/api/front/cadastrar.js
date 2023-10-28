function cadastrar() {

	const dados = {
		ra: document.getElementById("ra").value,
		cpf: document.getElementById("cpf").value,
		nome: document.getElementById("nome").value,
		nomesocial: document.getElementById("nomesocial").value,
		nascimento: document.getElementById("nascimento").value,
		email: document.getElementById("email").value,
		instituicao: document.getElementById("instituicao").value,
		conclusao: document.getElementById("conclusao").value,
		pontuacao: document.getElementById("pontuacao").value,
		posicao: document.getElementById("posicao").value,
		curso: document.getElementById("curso").value
	};

	fetch('http://localhost:8080/alunos/' + dados.ra, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(dados)
	})
		.then(response => response.json())
		.then(data => {
			console.log(data);
		})
		.catch(error => {
			console.error('Erro ao fazer a solicitação:', error);
		});


	alert(`RA: ${dados.ra} | CPF: ${dados.cpf} | Nome: ${dados.nome}\nNome Social: ${dados.nomesocial} | Data de Nascimento: ${dados.nascimento}\nE-mail: ${dados.email} | Instituição: ${dados.instituicao} | Conclusão: ${dados.conclusao}\nPontuação: ${dados.pontuacao}\nPosição: ${dados.posicao}\nCurso: ${dados.curso}`);

}