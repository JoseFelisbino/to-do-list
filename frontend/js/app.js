const API = "https://to-do-list-1-5ou2.onrender.com/tarefas";

const lista = document.getElementById("lista-tarefas");

async function carregarTarefas() {
    try {
        const response = await fetch(API);
        const tarefas = await response.json();

        renderizarTarefas(tarefas);
    } catch (erro) {
        console.error("Erro ao carregar tarefas:", erro);
    }
}

function renderizarTarefas(tarefas) {
    lista.innerHTML = "";

    tarefas.forEach(tarefa => {
        const li = document.createElement("li");

        li.innerHTML = `
            <strong>${tarefa.titulo}</strong><br>
            <small>${tarefa.descricao || ""}</small><br>
            <small>${tarefa.dataPrevista}</small><br>
            <small>Status: ${tarefa.status}</small>
        `;

        lista.appendChild(li);
    });
}

carregarTarefas();