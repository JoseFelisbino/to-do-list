const API = "https://to-do-list-1-5ou2.onrender.com/tarefas";

const lista = document.getElementById("lista-tarefas");
const form = document.getElementById("form-tarefa");
const buscarInput = document.getElementById("buscar");

async function carregarTarefas() {
    try {
        const response = await fetch(API);
        const tarefas = await response.json();

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
        titulo: document.getElementById("titulo").value,
        descricao: document.getElementById("descricao").value,
        dataPrevista: document.getElementById("dataPrevista").value,
        status: document.getElementById("status").value
    };

    try {
        await fetch(API, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(tarefa)
        });

        form.reset();
        carregarTarefas();

    } catch (erro) {
        console.error("Erro ao criar tarefa:", erro);
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
        `;

        lista.appendChild(li);
    });
}

carregarTarefas();