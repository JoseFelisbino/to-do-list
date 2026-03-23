const API = "https://to-do-list-1-5ou2.onrender.com/tarefas";

const lista = document.getElementById("lista-tarefas");
const form = document.getElementById("form-tarefa");
const buscarInput = document.getElementById("buscar");

const titulo = document.getElementById("titulo");
const descricao = document.getElementById("descricao");
const dataPrevista = document.getElementById("dataPrevista");
const status = document.getElementById("status");

let tarefaEditandoId = null;
let listaTarefas = [];

function atualizarBotao() {
    const botao = form.querySelector("button");
    botao.textContent = tarefaEditandoId ? "Atualizar" : "Adicionar";
}

async function carregarTarefas() {
    try {
        const response = await fetch(API);
        const tarefas = await response.json();

        listaTarefas = tarefas;
        renderizarTarefas(tarefas);

    } catch (erro) {
        console.error("Erro ao carregar tarefas:", erro);
    }
}

buscarInput.addEventListener("input", async () => {
    const termo = buscarInput.value;

    if (termo === "") {
        carregarTarefas();
        return;
    }

    try {
        const response = await fetch(`${API}/search?titulo=${termo}`);
        const tarefas = await response.json();

        renderizarTarefas(tarefas);

    } catch (erro) {
        console.error("Erro na busca:", erro);
    }
});

form.addEventListener("submit", async (e) => {
    e.preventDefault();

    const tarefa = {
        titulo: titulo.value,
        descricao: descricao.value,
        dataPrevista: dataPrevista.value,
        status: status.value
    };

    try {
        if (tarefaEditandoId) {
            await fetch(`${API}/${tarefaEditandoId}`, {
                method: "PUT",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(tarefa)
            });

            tarefaEditandoId = null;

        } else {
            await fetch(API, {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(tarefa)
            });
        }

        form.reset();
        atualizarBotao();
        carregarTarefas();

    } catch (erro) {
        console.error("Erro:", erro);
    }
});

async function deletar(id) {
    try {
        await fetch(`${API}/${id}`, {
            method: "DELETE"
        });

        carregarTarefas();

    } catch (erro) {
        console.error("Erro ao deletar:", erro);
    }
}

function editar(id) {
    const tarefa = listaTarefas.find(t => t.id === id);

    titulo.value = tarefa.titulo;
    descricao.value = tarefa.descricao;
    dataPrevista.value = tarefa.dataPrevista;
    status.value = tarefa.status;

    tarefaEditandoId = id;
    atualizarBotao();
}

function renderizarTarefas(tarefas) {
    lista.innerHTML = "";

    tarefas.forEach(tarefa => {
        const li = document.createElement("li");

        li.innerHTML = `
            <strong>${tarefa.titulo}</strong><br>
            <small>${tarefa.descricao || ""}</small><br>
            <small>${tarefa.dataPrevista}</small><br>
            <small>Status: ${tarefa.status}</small><br>
            <button class="btn-delete" onclick="deletar(${tarefa.id})">
                Excluir
            </button>
            <button onclick="editar(${tarefa.id})">
            Editar
            </button>
        `;

        lista.appendChild(li);
    });
}

form.querySelector("button").textContent = tarefaEditandoId
    ? "Atualizar"
    : "Adicionar";

carregarTarefas();